

package reporter;

import com.aventstack.extentreports.reporter.ExtentTabularReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import java.io.IOException;
import com.aventstack.extentreports.reporter.ExtentReporter;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.io.File;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentEmailReporter;
import com.aventstack.extentreports.reporter.ExtentCardsReporter;
import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import com.aventstack.extentreports.reporter.ConfigurableReporter;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import java.util.Optional;
import java.io.InputStream;
import java.util.Arrays;
import com.aventstack.extentreports.ExtentReports;
import java.util.Properties;

import org.testng.Reporter;

import java.io.Serializable;

public class ExtentService implements Serializable
{
    private static final long serialVersionUID = -5008231199972325650L;
    private static Properties properties;
    
    public static synchronized ExtentReports getInstance() {
        return ExtentReportsLoader.INSTANCE;
    }
    
    public static Object getProperty(final String key) {
        final String sys = System.getProperty(key);
        return (sys == null) ? ((ExtentService.properties == null) ? null : ExtentService.properties.get(key)) : sys;
    }
    
    private ExtentReports readResolve() {
        return ExtentReportsLoader.INSTANCE;
    }
    
    static /* synthetic */ void access$1(final Properties properties) {
        ExtentService.properties = properties;
    }
    
    private static class ExtentReportsLoader
    {
        private static final ExtentReports INSTANCE;
        private static final String[] DEFAULT_SETUP_PATH;
        private static final String OUTPUT_PATH = "test-output/";
        private static final String EXTENT_REPORTER = "extent.reporter";
        private static final String START = "start";
        private static final String CONFIG = "config";
        private static final String OUT = "out";
        private static final String DELIM = ".";
        private static final String AVENT = "avent";
        private static final String BDD = "bdd";
        private static final String CARDS = "cards";
        private static final String EMAIL = "email";
        private static final String HTML = "html";
        private static final String KLOV = "klov";
        private static final String LOGGER = "logger";
        private static final String SPARK = "spark";
        private static final String TABULAR = "tabular";
        private static final String INIT_AVENT_KEY = "extent.reporter.avent.start";
        private static final String INIT_BDD_KEY = "extent.reporter.bdd.start";
        private static final String INIT_CARDS_KEY = "extent.reporter.cards.start";
        private static final String INIT_EMAIL_KEY = "extent.reporter.email.start";
        private static final String INIT_HTML_KEY = "extent.reporter.html.start";
        private static final String INIT_KLOV_KEY = "extent.reporter.klov.start";
        private static final String INIT_LOGGER_KEY = "extent.reporter.logger.start";
        private static final String INIT_SPARK_KEY = "extent.reporter.spark.start";
        private static final String INIT_TABULAR_KEY = "extent.reporter.tabular.start";
        private static final String CONFIG_AVENT_KEY = "extent.reporter.avent.config";
        private static final String CONFIG_BDD_KEY = "extent.reporter.bdd.config";
        private static final String CONFIG_CARDS_KEY = "extent.reporter.cards.config";
        private static final String CONFIG_EMAIL_KEY = "extent.reporter.email.config";
        private static final String CONFIG_HTML_KEY = "extent.reporter.html.config";
        private static final String CONFIG_KLOV_KEY = "extent.reporter.klov.config";
        private static final String CONFIG_LOGGER_KEY = "extent.reporter.logger.config";
        private static final String CONFIG_SPARK_KEY = "extent.reporter.spark.config";
        private static final String CONFIG_TABULAR_KEY = "extent.reporter.tabular.config";
        private static final String OUT_AVENT_KEY = "extent.reporter.avent.out";
        private static final String OUT_BDD_KEY = "extent.reporter.bdd.out";
        private static final String OUT_CARDS_KEY = "extent.reporter.cards.out";
        private static final String OUT_EMAIL_KEY = "extent.reporter.email.out";
        private static final String OUT_HTML_KEY = "extent.reporter.html.out";
        private static final String OUT_LOGGER_KEY = "extent.reporter.logger.out";
        private static final String OUT_SPARK_KEY = "extent.reporter.spark.out";
        private static final String OUT_TABULAR_KEY = "extent.reporter.tabular.out";
        
        static {
            INSTANCE = new ExtentReports();
            DEFAULT_SETUP_PATH = new String[] { "extent.properties", "com/aventstack/adapter/extent.properties" };
            if (ExtentReportsLoader.INSTANCE.getStartedReporters().isEmpty()) {
                createViaProperties();
                createViaSystem();
            }
        }
        
        private static void createViaProperties() {
            final ClassLoader loader = ExtentReportsLoader.class.getClassLoader();
            final Optional<InputStream> is = Arrays.stream(ExtentReportsLoader.DEFAULT_SETUP_PATH).map(x -> loader.getResourceAsStream(x)).filter(x -> x != null).findFirst();
            if (is.isPresent()) {
                final Properties properties = new Properties();
                try {
                    properties.load(is.get());
                    ExtentService.access$1(properties);
                    if (properties.containsKey("extent.reporter.avent.start") && "true".equals(String.valueOf(properties.get("extent.reporter.avent.start")))) {
                        initAvent(properties);
                    }
                    if (properties.containsKey("extent.reporter.bdd.start") && "true".equals(String.valueOf(properties.get("extent.reporter.bdd.start")))) {
                        initBdd(properties);
                    }
                    if (properties.containsKey("extent.reporter.cards.start") && "true".equals(String.valueOf(properties.get("extent.reporter.cards.start")))) {
                        initCards(properties);
                    }
                    if (properties.containsKey("extent.reporter.email.start") && "true".equals(String.valueOf(properties.get("extent.reporter.email.start")))) {
                        initEmail(properties);
                    }
                    if (properties.containsKey("extent.reporter.html.start") && "true".equals(String.valueOf(properties.get("extent.reporter.html.start")))) {
                        initHtml(properties);
                    }
                    if (properties.containsKey("extent.reporter.klov.start") && "true".equals(String.valueOf(properties.get("extent.reporter.klov.start")))) {
                        initKlov(properties);
                    }
                    if (properties.containsKey("extent.reporter.logger.start") && "true".equals(String.valueOf(properties.get("extent.reporter.logger.start")))) {
                        initLogger(properties);
                    }
                    if (properties.containsKey("extent.reporter.spark.start") && "true".equals(String.valueOf(properties.get("extent.reporter.spark.start")))) {
                    	//properties.setProperty("extent.reporter.spark.out", "test-output/Spark/"+Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("environment")+".html");
                        initSpark(properties);
                    }
                    if (properties.containsKey("extent.reporter.tabular.start") && "true".equals(String.valueOf(properties.get("extent.reporter.tabular.start")))) {
                        initTabular(properties);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        private static void createViaSystem() {
            if ("true".equals(System.getProperty("extent.reporter.avent.start"))) {
                initAvent(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.bdd.start"))) {
                initBdd(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.cards.start"))) {
                initCards(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.email.start"))) {
                initEmail(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.html.start"))) {
                initHtml(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.klov.start"))) {
                initKlov(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.logger.start"))) {
                initLogger(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.spark.start"))) {
                initSpark(null);
            }
            if ("true".equals(System.getProperty("extent.reporter.tabular.start"))) {
                initTabular(null);
            }
        }
        
        private static void initAvent(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.avent.out");
            final ExtentAventReporter avent = new ExtentAventReporter(out);
            attach((ConfigurableReporter)avent, properties, "extent.reporter.avent.config");
        }
        
        private static String getOutputPath(final Properties properties, final String key) {
            String out;
            if (properties != null && properties.get(key) != null) {
                out = String.valueOf(properties.get(key));
            }
            else {
                out = System.getProperty(key);
            }
            out = ((out == null || out.equals("null") || out.isEmpty()) ? ("test-output/" + key.split("\\.")[2] + "/") : out);
            return out;
        }
        
        private static void initBdd(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.bdd.out");
            final ExtentBDDReporter bdd = new ExtentBDDReporter(out);
            attach((ConfigurableReporter)bdd, properties, "extent.reporter.bdd.config");
        }
        
        private static void initCards(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.cards.out");
            final ExtentCardsReporter cards = new ExtentCardsReporter(out);
            attach((ConfigurableReporter)cards, properties, "extent.reporter.cards.config");
        }
        
        private static void initEmail(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.email.out");
            final ExtentEmailReporter email = new ExtentEmailReporter(out);
            attach((ConfigurableReporter)email, properties, "extent.reporter.email.config");
        }
        
        private static void initHtml(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.html.out");
            final ExtentHtmlReporter html = new ExtentHtmlReporter(out);
            attach((ConfigurableReporter)html, properties, "extent.reporter.html.config");
        }
        
        private static void initKlov(final Properties properties) {
            final ExtentKlovReporter klov = new ExtentKlovReporter("Default");
            final String configPath = (properties == null) ? System.getProperty("extent.reporter.klov.config") : String.valueOf(properties.get("extent.reporter.klov.config"));
            final File f = new File(configPath);
            if (configPath != null && !configPath.isEmpty() && f.exists()) {
                final Object prop = ExtentService.getProperty("screenshot.dir");
                final String screenshotDir = (prop == null) ? "test-output/" : String.valueOf(prop);
                final String url = Paths.get(screenshotDir, new String[0]).toString();
                ExtentService.getInstance().tryResolveMediaPath(new String[] { url });
                try {
                    final InputStream is = new FileInputStream(f);
                    klov.loadInitializationParams(is);
                    ExtentReportsLoader.INSTANCE.attachReporter(new ExtentReporter[] { (ExtentReporter)klov });
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        private static void initLogger(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.logger.out");
            final ExtentLoggerReporter logger = new ExtentLoggerReporter(out);
            attach((ConfigurableReporter)logger, properties, "extent.reporter.logger.config");
        }
        
        private static void initSpark(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.spark.out");
            final ExtentSparkReporter spark = new ExtentSparkReporter(out);
            attach((ConfigurableReporter)spark, properties, "extent.reporter.spark.config");
        }
        
        private static void initTabular(final Properties properties) {
            final String out = getOutputPath(properties, "extent.reporter.tabular.out");
            final ExtentTabularReporter tabular = new ExtentTabularReporter(out);
            attach((ConfigurableReporter)tabular, properties, "extent.reporter.tabular.config");
        }
        
        private static void attach(final ConfigurableReporter r, final Properties properties, final String configKey) {
            final Object configPath = (properties == null) ? System.getProperty(configKey) : properties.get(configKey);
            if (configPath != null && !String.valueOf(configPath).isEmpty()) {
                r.loadXMLConfig(String.valueOf(configPath));
            }
            ExtentReportsLoader.INSTANCE.attachReporter(new ExtentReporter[] { (ExtentReporter)r });
        }
    }
}
