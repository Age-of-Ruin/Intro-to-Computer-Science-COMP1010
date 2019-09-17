/**
 * RichardConstantineA4Q3
 * 
 * COMP 1010
 * Instructor: Mike Domaratzki
 * Assignment: 4, Question: 3
 * @author     Richard Constantine
 * @version    2012/11/28
 * 
 * Purpose:    To create a white canvas using the image library.jar with given methods and draw 
 *             different(2-3) images with different scales and at different positions on the canvas.
 */

import java.util.Date;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class RichardConstantineA4Q3
{
  public static void main(String[] args)
  {
  
    File pic1 = getFile();
    File pic2 = getFile();
    File pic3 = getFile();
    int canvasWidth = 600;
    int canvasHeight = 600;  
    int[] canvasX = new int[3]; 
    int[] canvasY = new int[3];
    int[] scaledX = new int [3];
    int[] scaledY = new int [3];
    double[] picRaster1;
    double[] picRaster2;
    double[] picRaster3;
    double[] canvasRaster;
    int[] imageWidth = new int[3];
    int[] imageHeight = new int[3];
    
     if (ImageLibrary.loadImage(pic1))
     {  
       
       imageWidth[0] = ImageLibrary.getImageWidth();
       imageHeight[0] = ImageLibrary.getImageHeight();
       picRaster1 = ImageLibrary.getImageRaster();
       
       if (ImageLibrary.loadImage(pic2));
       {
         
         imageWidth[1] = ImageLibrary.getImageWidth();
         imageHeight[1] = ImageLibrary.getImageHeight();  // load all 3 images
         picRaster2 = ImageLibrary.getImageRaster();
         
         if (ImageLibrary.loadImage(pic3));
         {
           
           imageWidth[2] = ImageLibrary.getImageWidth();
           imageHeight[2] = ImageLibrary.getImageHeight(); 
           picRaster3 = ImageLibrary.getImageRaster();
           
           System.out.println("");
           System.out.println("");
           
           {
            /* Apologies on the buggy input system, but scanner seemed to get buggy when around the image
             * loading messages, so JOptionPane seemed the way to go, aside from giving them boring, hare-
             * coded values. So please... ALL INTEGERS 
            */
            
          JOptionPane.showMessageDialog(null, "Please enter desired translation and dimension of images on the " +
                                        "canvas. \n*ALL INTS*");
          
          canvasX[0] = Integer.parseInt (JOptionPane.showInputDialog("Please enter x translation of first image."));
          
          canvasY[0] = Integer.parseInt (JOptionPane.showInputDialog("Please enter y translation of first image."));
         
          scaledX[0] = Integer.parseInt (JOptionPane.showInputDialog("Please enter the width of the 1st image in pixels"));
         
          scaledY[0] = Integer.parseInt (JOptionPane.showInputDialog("Please enter the height of the 1st image in pixels"));
          
          
          canvasX[1] = Integer.parseInt (JOptionPane.showInputDialog("Please enter x translation of second image."));
          
          canvasY[1] = Integer.parseInt (JOptionPane.showInputDialog("Please enter y translation of second image."));
                                                                                         
          scaledX[1] = Integer.parseInt (JOptionPane.showInputDialog("Please enter the width of the 2nd image in pixels"));   
         
          scaledY[1] =  Integer.parseInt (JOptionPane.showInputDialog("Please enter the length of the 2nd image in pixels"));

          
         
          canvasX[2] = Integer.parseInt (JOptionPane.showInputDialog("Please enter x translation of third image."));
         
          canvasY[2] = Integer.parseInt (JOptionPane.showInputDialog("Please enter y translation of third image."));
          
          scaledX[2] = Integer.parseInt (JOptionPane.showInputDialog("Please enter the width of the 3rd image in pixels"));
         
          scaledY[2] = Integer.parseInt (JOptionPane.showInputDialog("Please enter the length of the 3rd image in pixels"));
          
             // values of translations and dimensions
            
          ImageLibrary.createNewImage(canvasWidth, canvasHeight); // draw canvas
          
          
          canvasRaster = ImageLibrary.getImageRaster();
          for (int i = 0; i < canvasRaster.length; i++)
          {
            
            canvasRaster[i] = 1;  // set canvas raster
            
          }
          
          if (pic1 != null && pic2 != null && pic3 != null &&canvasX != null && canvasY != null && scaledX != null 
                && scaledY != null)
          {
            resampleDraw (canvasRaster, canvasWidth, canvasHeight, picRaster3, imageWidth[2], // Draw Image 1
                          imageHeight[2], canvasX[2], canvasY[2], scaledX[2], scaledY[2]); 
            
            resampleDraw (canvasRaster, canvasWidth, canvasHeight, picRaster2, imageWidth[1], // Draw Image 2
                          imageHeight[1], canvasX[1], canvasY[1], scaledX[1], scaledY[1]);
            
            resampleDraw (canvasRaster, canvasWidth, canvasHeight, picRaster1, imageWidth[0], // Draw Image 3
                          imageHeight[0], canvasX[0], canvasY[0], scaledX[0], scaledY[0]);
            
            
            ImageLibrary.setImageRaster(canvasRaster);  // set canvas raster
            
            ImageLibrary.drawImage(); // draws the image
            
          }}}}}
     
     terminationMethod();
     
  }
   
                        
public static void draw (double[] canvas, int canvasWidth, int canvasHeight, double[] image, int scaledWidth, 
                         int scaledHeight, int canvasX, int canvasY)
{
    int canvasLength = canvas.length;
    int picLength = image.length;
    int picWidth = scaledWidth;
    int picHeigth = scaledHeight;
    int canWidth = canvasWidth;
    int canHeight = canvasHeight;
    int xTranslated = 0;
    int yTranslated = 0;
    int canvasCoordinate = 0;
    
      for (int i = 0; i < picLength; i++)
    {
      
      int xCoordinate = (i % picWidth);
      int yCoordinate = (i / picWidth);
    
      xTranslated = xCoordinate + canvasX;
      yTranslated = yCoordinate + canvasY;
      canvasCoordinate = (yTranslated * canvasWidth + xTranslated );
      
      
      if (xTranslated < (canWidth - 1) && yTranslated < (canHeight - 1) )
      canvas[canvasCoordinate] = image[i];
      
      }

}
 

  /* 
     * [draw takes an image and translates its postion as well as draw on a canvas created in main]
     * [Recieves input from main as picture information in the form of a cavas raster and dimensions and 
     * picture raster and dimensions]
     * [Ouputs the user input back if within perameters or lower/upper limit (depending on infraction)]
     * 
     * @param [firstParam: raster array of the canvas representing pixel number]
     * @param [secondParam: canvas' subsequent width dimension (600 pixels))
     * @param [thirdParam: canvas' height dimension (600 pixels)]
     * @param [forthParam: raster array of the image being drawn on the canvas]
     * @param [fifthParam: the images subsequent width as an int value]
     * @param [sixthParam: the images height as an int] 
     * @param [seventhParam: variable represent the x translation (>600 pixels to be seen)]
     * @param [eigthParam: variable representing the y translation (>600 pixels to be seen)]
     * @return [void]
   */

public static double[] resample (double[] source, int srcWidth, int srcHeight, int newWidth, int newHeight)
{

   double[] sourceRaster = source;
   int sourceWidth = srcWidth;
   int sourceHeight = srcHeight;
   int changedWidth = newWidth;
   int changedHeight  = newHeight;
   double[] changedRaster = new double [changedHeight*changedWidth];


   double scaleX = (double) changedWidth / (double) sourceWidth;
   double scaleY = (double) changedHeight / (double) sourceHeight;


       for (int i = 0; i < changedHeight; i++)
       {

         for (int x = 0; x < changedWidth; x++)
         {

           int xCoordinate = x;
           int yCoordinate = i;

           int srcX = (int) (xCoordinate / scaleX);
           int srcY = (int) (yCoordinate / scaleY);

           changedRaster[(i * changedWidth) + x] = sourceRaster[(srcY * sourceWidth) + srcX];
           
         }

       }

   return changedRaster;

}
 /* 
     * [resample scales an image being drawn on the canvas by scaling the source image]
     * [Recieves input from main containing infromation about the source and scale quantites]
     * [Ouputs the the modified raster of the scaled image]
     * 
     * @param [firstParam: raster array of the source image being scaled]
     * @param [secondParam: the source images current width(in pixels)))
     * @param [thirdParam:  the sources height dimension(in pixels)]
     * @param [forthParam: the change in the image width (x direction scaling)]
     * @param [fifthParam: the change in the image length(y "  ")]
     * @return [the rescaled raster]
   */



public static double[] resampleDraw (double[] canvas, int canvasWidth,int canvasHeight, double[] image, int imageWidth,
                      int imageHeight, int canvasX, int canvasY, int newWidth, int newHeight)
{
  double[] scaledRaster = resample (image, imageWidth, imageHeight, newWidth, newHeight);
  
  draw(canvas, canvasWidth, canvasHeight, scaledRaster, newWidth, newHeight, canvasX, canvasY);
  
 return scaledRaster; 

}


 /* 
     * [resampleDraw combines the resample and draw methods the create canvas with differnt sized 
     * and positioned images]
     * [Recieves input from main as the parameters needed for the draw and resample methods]
     * [Ouputs the final raster of the image being displayed on the canvas)]
     * 
     * @param [firstParam: raster array of the canvas representing pixel number]
     * @param [secondParam: canvas' subsequent width dimension (600 pixels))
     * @param [thirdParam: canvas' height dimension (600 pixels)]
     * @param [forthParam: raster array of the image being drawn on the canvas]
     * @param [fifthParam: the images subsequent width as an int value]
     * @param [sixthParam: the images height as an int] 
     * @param [seventhParam: variable represent the x translation (>600 pixels to be seen)]
     * @param [eigthParam: variable representing the y translation (>600 pixels to be seen)]
     * @param [forthParam: the change in the image width (x direction scaling)]
     * @param [fifthParam: the change in the image length(y "  ")]
     * @return [the rescaled and drawable raster]
   */


public static File getFile() 
{
  
  JFileChooser chooser = new JFileChooser();
  
  try {
    
    String currentDir = System.getProperty("user.dir");
    chooser.setCurrentDirectory(new File(currentDir));
    
  } catch (Exception e) {
    
    System.out.println("Warning: Error setting current folder: "+e.getMessage());
    
  }
  
  File file = null;
  int returnValue;
  
// show the open file dialog
  returnValue = chooser.showOpenDialog(null);
  
// check to see that the user clicked the OK button
  if (returnValue == JFileChooser.APPROVE_OPTION) {
    
// get the selected file
    file = chooser.getSelectedFile();
  }
  return file;
}

public static void terminationMethod()
{
  
  System.out.println("\nProgrammed by Richard Constantine") ;
  System.out.println("Date: " + new Date() ) ;
  System.out.println("** End of processing. **") ;
  
}
// Displays termination message
}
