package imageMagick;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.im4java.core.CommandException;
import org.im4java.core.CompareCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;
import org.im4java.core.ImageCommand ;
public class ImageMagicComparision {
	
	CompareCmd compare;
	
	public  void compareImages (String expectedImage,String currentimage,String outPutImageFolder,String envi,String ScreenShotName) throws IOException, InterruptedException, IM4JavaException {

		try
		{
		 compare = new CompareCmd();

		  // For metric-output
		  compare.setErrorConsumer(StandardStream.STDERR);
	
		  IMOperation compareOperation = new IMOperation();
		  // Set the compare metric
		  compareOperation.metric("AE").fuzz(8.0);

		  // Add the expected image
		  compareOperation.addImage(expectedImage);

		  // Add the current image
		  compareOperation.addImage(currentimage);

		  // This stores the difference
		 compareOperation.addImage(outPutImageFolder);
		  
		  compare.run(compareOperation);
			
		}
		catch(Exception e)
		{
			
			FileUtils.copyFile(new File(outPutImageFolder),
					  Paths.get(System.getProperty("user.dir")+"\\VisualShots\\OutPutImage\\"+envi+"\\DiffImages\\"+ScreenShotName+".jpg").toFile());
			
			File deleteImage = new File(outPutImageFolder);
			deleteImage.delete();
		}
		}

}
