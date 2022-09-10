package imageMagick;


import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.dom4j.DocumentException;
import org.im4java.core.IM4JavaException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.CaptureElement;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.github.fge.jsonschema.examples.Utils;

import framework.GenericActions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class TestXML {
	
	ImageMagicComparision imageMagicComparision = new ImageMagicComparision();

	GenericActions genericactions = new GenericActions();
	
	public  void visualTest(WebDriver driver,String ScreenShotName,String screenshottype,String envi)   throws  DocumentException, IOException, InterruptedException, IM4JavaException  {
		
		genericactions.pageLoad(driver);
		
		String baseImage = System.getProperty("user.dir")+"\\VisualShots\\BaseImage\\"+envi+"\\"+ScreenShotName+".jpg";
		String comparisionImage = System.getProperty("user.dir")+"\\VisualShots\\ComparisionImage\\"+envi+"\\"+ScreenShotName+".jpg";
		
		
		//boolean imageCheck = new File(baseImage).exists();
	  //  if(!imageCheck) {
	    	
	    	imageCreation(driver,ScreenShotName,"BaseImage\\"+envi+"\\",screenshottype);
	   // }
		/*
		 * else { imageCreation(driver,ScreenShotName,"ComparisionImage\\"+envi+"\\",
		 * screenshottype); Thread.sleep(2000);
		 * 
		 * final File theDir = new File(String.valueOf(System.getProperty("user.dir")) +
		 * "\\VisualShots\\OutPutImage\\"+envi); if (!theDir.exists()) { theDir.mkdir();
		 * final File theDirdiff = new
		 * File(String.valueOf(System.getProperty("user.dir")) +
		 * "\\VisualShots\\OutPutImage\\"+envi+ "\\DiffImages"); theDirdiff.mkdir();
		 * final File theDirpassed = new
		 * File(String.valueOf(System.getProperty("user.dir")) +
		 * "\\VisualShots\\OutPutImage\\"+envi+ "\\PassedImages"); theDirpassed.mkdir();
		 * }
		 * 
		 * String outPutImage =
		 * System.getProperty("user.dir")+"\\VisualShots\\OutPutImage\\"+envi+"\\
		 * PassedImages\\"+ScreenShotName+".jpg";
		 * 
		 * imageMagicComparision.compareImages(baseImage,comparisionImage,outPutImage,
		 * envi,ScreenShotName); }
		 */
}
	
	public  void imageCreation(WebDriver driver,String ScreenShotName,String folderName,String screenshottype) throws IOException {

		try
		{
		JavascriptExecutor jexec = (JavascriptExecutor)driver;
		 jexec.executeScript("window.scrollTo(0,0)"); // will scroll to (0,0) position 
		    boolean isScrollBarPresent = (Boolean) jexec.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
		    long scrollHeight = (Long)jexec.executeScript("return document.documentElement.scrollHeight");
		    long clientHeight = (Long)jexec.executeScript("return document.documentElement.clientHeight");
	    int fileIndex = 0;int fileIndex1 = 101;
	    Set<String> tempImages = new TreeSet<String>();
	        if(isScrollBarPresent && screenshottype.toUpperCase().equalsIgnoreCase("FULLPAGE")){
	           
	            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\VisualShots\\"+folderName+"\\"+ fileIndex+".jpg"));
	            tempImages.add(System.getProperty("user.dir")+"\\VisualShots\\"+folderName+"\\"+ fileIndex+".jpg");
	            
	        	while(scrollHeight > 0){
	        		 //jexec.executeScript("window.focus()");
	        		 
	        		 jexec.executeScript("window.scrollTo(0,"+clientHeight*fileIndex++ +")");
	        		 
	                 File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                FileUtils.copyFile(srcFile2, new File(System.getProperty("user.dir")+"\\VisualShots\\"+folderName+"\\"+ fileIndex1 +".jpg"));
	                tempImages.add(System.getProperty("user.dir")+"\\VisualShots\\"+folderName+"\\"+ fileIndex1 +".jpg");
	                scrollHeight =  scrollHeight-clientHeight;
	                fileIndex1++;
	                //clientHeight = clientHeight+clientHeight;
	            }
	           
	        	BandMergeTest.imageMerge(tempImages,ScreenShotName,folderName);
	             
	             for(String images:tempImages)
	             {
	            	 File deleteimage = new File(images);
	            	 deleteimage.delete();
	             }
	             
	            System.out.println("Successfully mergerd and deleted the temp images");
	        }else{
	      File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            org.apache.commons.io.FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\VisualShots\\"+folderName+"\\"+ ScreenShotName+".jpg"));
	        	
	        }
	        
	}catch(Exception e)
	{
		try
		{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        org.apache.commons.io.FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\VisualShots\\"+folderName+"\\"+ ScreenShotName+".jpg"));
		}catch(Exception e1)
		{
			
		}
	    }
	}}

