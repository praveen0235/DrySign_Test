package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class ZipDirectory extends SimpleFileVisitor<Path> {
	 
    private static ZipOutputStream zos;
 
    private Path sourceDir;
 
    public ZipDirectory(Path sourceDir) {
        this.sourceDir = sourceDir;
    }
 
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attributes) {
 
        try {
            Path targetFile = sourceDir.relativize(file);
 
            zos.putNextEntry(new ZipEntry(targetFile.toString()));
            
            byte[] bytes = Files.readAllBytes(file);
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
 
        } catch (IOException ex) {
            System.err.println(ex);
        }
 
        return FileVisitResult.CONTINUE;
    }
 
    public static void ZipDirectoryMaker(String dirPath) throws Exception {
        //String dirPath = "C:\\Users\\praveenrajn\\Desktop\\Source";
       // Path sourceDir = Paths.get(dirPath);
        
 
        try {
			/*
			 * String zipFileName = dirPath.concat(".zip"); zos = new ZipOutputStream(new
			 * FileOutputStream(zipFileName));
			 * 
			 * Files.walkFileTree(sourceDir, new ZipDirectory(sourceDir));
			 * 
			 * zos.close();
			 */
        	
        	zipFolder(dirPath,dirPath+".zip");
        } catch (IOException ex) {
            System.err.println("I/O Error: " + ex);
        }
    }
    
    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;
        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);
        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
      }
      static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFile);
        if (folder.isDirectory()) {
          addFolderToZip(path, srcFile, zip);
        } else {
          byte[] buf = new byte[1024];
          int len;
          FileInputStream in = new FileInputStream(srcFile);
          zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
          while ((len = in.read(buf)) > 0) {
            zip.write(buf, 0, len);
          }
        }
      }

      static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
          if (path.equals("")) {
            addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
          } else {
            addFileToZip(path + "/" + folder.getName(), srcFolder + "/" +   fileName, zip);
          }
        }
      }
}