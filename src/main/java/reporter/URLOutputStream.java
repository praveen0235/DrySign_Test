

package reporter;

import gherkin.deps.com.google.gson.Gson;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.util.Iterator;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Map;
import java.io.IOException;
import java.util.Collections;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

class URLOutputStream extends OutputStream
{
    private final URL url;
    private final String method;
    private final int expectedResponseCode;
    private final OutputStream out;
    private final HttpURLConnection urlConnection;
    
    URLOutputStream(final URL url) throws IOException {
        this(url, "PUT", Collections.emptyMap(), 200);
    }
    
    private URLOutputStream(final URL url, final String method, final Map<String, String> headers, final int expectedResponseCode) throws IOException {
        this.url = url;
        this.method = method;
        this.expectedResponseCode = expectedResponseCode;
        if (url.getProtocol().equals("file")) {
            final File file = new File(url.getFile());
            this.ensureParentDirExists(file);
            this.out = new FileOutputStream(file);
            this.urlConnection = null;
        }
        else {
            if (!url.getProtocol().startsWith("http")) {
                throw new IllegalArgumentException("URL Scheme must be one of file,http,https. " + url.toExternalForm());
            }
            (this.urlConnection = (HttpURLConnection)url.openConnection()).setRequestMethod(method);
            this.urlConnection.setDoOutput(true);
            for (final Map.Entry<String, String> header : headers.entrySet()) {
                this.urlConnection.setRequestProperty(header.getKey(), header.getValue());
            }
            this.out = this.urlConnection.getOutputStream();
        }
    }
    
    private void ensureParentDirExists(final File file) throws IOException {
        if (file.getParentFile() != null && !file.getParentFile().isDirectory()) {
            final boolean ok = file.getParentFile().mkdirs() || file.getParentFile().isDirectory();
            if (!ok) {
                throw new IOException("Failed to create directory " + file.getParentFile().getAbsolutePath());
            }
        }
    }
    
    @Override
    public void write(final byte[] buffer, final int offset, final int count) throws IOException {
        this.out.write(buffer, offset, count);
    }
    
    @Override
    public void write(final byte[] buffer) throws IOException {
        this.out.write(buffer);
    }
    
    @Override
    public void write(final int b) throws IOException {
        this.out.write(b);
    }
    
    @Override
    public void flush() throws IOException {
        this.out.flush();
    }
    
    @Override
    public void close() throws IOException {
        try {
            if (this.urlConnection == null) {
                return;
            }
            final int responseCode = this.urlConnection.getResponseCode();
            if (responseCode == this.expectedResponseCode) {
                return;
            }
            try {
                this.urlConnection.getInputStream().close();
                throw new IOException(String.format("Expected response code: %d. Got: %d", this.expectedResponseCode, responseCode));
            }
            catch (IOException expected) {
                final InputStream errorStream = this.urlConnection.getErrorStream();
                if (errorStream != null) {
                    throw this.createResponseException(responseCode, expected, errorStream);
                }
                throw expected;
            }
        }
        finally {
            this.out.close();
        }
    }
    
    private ResponseException createResponseException(final int responseCode, final IOException expected, final InputStream errorStream) throws IOException {
        Throwable t = null;
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(errorStream, StandardCharsets.UTF_8));
            try {
                final String responseBody = br.lines().collect(Collectors.joining(System.lineSeparator()));
                String contentType = this.urlConnection.getHeaderField("Content-Type");
                if (contentType == null) {
                    contentType = "text/plain";
                }
                return new ResponseException(responseBody, expected, responseCode, contentType);
            }
            finally {
                if (br != null) {
                    br.close();
                }
            }
        }
        finally {
            if (t == null) {
                final Throwable exception = null;
                t = exception;
            }
            else {
                final Throwable exception = null;
                if (t != exception) {
                    t.addSuppressed(exception);
                }
            }
        }
    }
    
    class ResponseException extends IOException
    {
        private static final long serialVersionUID = 7564052957642239835L;
        private final Gson gson;
        private final int responseCode;
        private final String contentType;
        
        public ResponseException(final String responseBody, final IOException cause, final int responseCode, final String contentType) {
            super(responseBody, cause);
            this.gson = new Gson();
            this.responseCode = responseCode;
            this.contentType = contentType;
        }
        
        @Override
        public String getMessage() {
            if (!this.contentType.equals("application/json")) {
                return this.getMessage0(super.getMessage());
            }
            final Map map = (Map)this.gson.fromJson(super.getMessage(), (Class)Map.class);
            if (map.containsKey("error")) {
                return this.getMessage0(map.get("error").toString());
            }
            return this.getMessage0(super.getMessage());
        }
        
        private String getMessage0(final String message) {
            return String.format("%s %s\nHTTP %d\n%s", URLOutputStream.this.method, URLOutputStream.this.url, this.responseCode, message);
        }
    }
}
