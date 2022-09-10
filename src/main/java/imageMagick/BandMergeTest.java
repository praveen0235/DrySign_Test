package imageMagick;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import javax.imageio.ImageIO;

public class BandMergeTest {
	
    public static void imageMerge(Set<String> images,String ScreenShotName,String folderName) {

        if(images.size() == 0) {
            System.out.println("Need one or more inputs");
            System.exit(0);
        }
 
        try {
             BandMergeImage(images,ScreenShotName,folderName);
        } catch (IOException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    static void  BandMergeImage (Set<String> fileNames,String ScreenShotName,String folderName) throws IOException {
        int rows = fileNames.size();   //we assume the no. of rows and cols are known and each chunk has equal width and height   
        int cols = 1;   
        int chunks = rows * cols;   
   
        int chunkWidth, chunkHeight;   
        int type,Imgcount=0;   
        //fetching image files   
        File[] imgFiles = new File[chunks];   
        for (String img:fileNames) {   
            imgFiles[Imgcount] = new File(img);  
            Imgcount++;
        }   
   
       //creating a bufferd image array from image files   
        BufferedImage[] buffImages = new BufferedImage[chunks];   
        for (int i = chunks-1; i>=0 ; i--) {   
            buffImages[i] = ImageIO.read(imgFiles[i]);   
        }   
        type = buffImages[0].getType();   
        chunkWidth = buffImages[0].getWidth(null);   
        chunkHeight = buffImages[0].getHeight(null);   
         
      
        // Creating destination buffered image
        BufferedImage buffImg = new BufferedImage(
                chunkWidth, 
          // twice as tall as 1st image
                chunkHeight*2, 
          type);
        Graphics2D gbi = buffImg.createGraphics();
     
        gbi.drawImage(buffImages[0], null, 0, 0);
      
        gbi.drawImage(buffImages[1], null, 0, buffImages[1].getHeight(null)); 
                 
        BufferedImage img=mergeImages(buffImages);
         
        ImageIO.write(img, "jpeg", new File(System.getProperty("user.dir")+"\\VisualShots\\"+folderName+"\\"+ScreenShotName+".jpg"));  
    
    }
     
    public static BufferedImage mergeImages(BufferedImage[] imageList) {
      
        int resizeHeight=0;
        int resizeWidth=0;
         
    for(int j=0;j<imageList.length-1;j++) {
        BufferedImage image = (BufferedImage)imageList[j];
        Graphics g = image.getGraphics();
        resizeHeight=resizeHeight+image.getHeight();
        resizeWidth=Math.max(resizeWidth, image.getWidth());
        }
     
    BufferedImage image = new BufferedImage(resizeWidth, resizeHeight, BufferedImage.TYPE_INT_RGB);
    int height=0;
    int imageListSize=imageList.length;
    for(int i=1;i<imageListSize;i++) {
        BufferedImage newImage=(BufferedImage)imageList[i];
        image.createGraphics().drawImage(newImage, 0, height, null);
        height=height+newImage.getHeight();
    }
    
        return image;
    }
}