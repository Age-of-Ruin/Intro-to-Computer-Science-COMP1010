/**
 * RichardConstantineA2Q3
 * 
 * COMP 1010
 * Instructor: Mike Domaratzki
 * Assignment: 4, Question: 2
 * @author     Richard Constantine
 * @version    2012/11/28
 * 
 * Purpose:    To create different filters for pictures via rasterizing the image as
 *             an array of pixels that can be modified accordingly to accomplish
 *             the desired effect.
 */

import java.util.Date;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class RichardConstantineA4Q2
{
  public static void main(String[] args)
  {
    
    File userFile = getFile();
    int imageWidth = 0;
    int imageHeight = 0;
    
    System.out.println("PROMPT: Please enter desired filter: Film [G]rain, [P]osterize, [G]host, [E]dge Fllter.");
    // prompt user
    
    String input = JOptionPane.showInputDialog("Please enter desired filter: [F]ilm Grain, [P]osterize, [G]host, " + 
                                                 "[E]dge Filter. \n *No correct input will draw original image* "); 
                                                                     // recieve input
    
    if (ImageLibrary.loadImage(userFile)) 
    {
      
      imageWidth = ImageLibrary.getImageWidth();
      imageHeight = ImageLibrary.getImageHeight();
      double[] imageRaster = ImageLibrary.getImageRaster();
      
      if (input != null)
      {
        input = input.toUpperCase();
        
        if (input.equals ("F"))
        {
          
          JOptionPane.showMessageDialog(null,"Film Grain selected.");  
          imageRaster = setFilmGrain(imageRaster);
          
        }
        
        if (input.equals ("P"))
        {
          
          JOptionPane.showMessageDialog(null,"Posterize selected.");  
          imageRaster = setPosterize(imageRaster);
          
        }
        
        if (input.equals ("G"))
        {
          
          JOptionPane.showMessageDialog(null, "Ghost: Must select another image for ghosting.");  
          imageRaster = setGhost(imageRaster);
          
        }
        
        if (input.equals ("E"))
        {
          
          JOptionPane.showMessageDialog(null, "Edge Filter Selected.");  
          imageRaster = setEdgeFilter(imageRaster, imageWidth, imageHeight);
          
        }
        
        ImageLibrary.setImageRaster(imageRaster);
        ImageLibrary.drawImage();
        
      }
    }
    terminationMethod();
    
  }
  
  
  
  public static double clamp(double pixelNumber, double minimum, double maximum)
  {
    
    double output = pixelNumber;
    double input = pixelNumber;
    
    if (input > maximum)
    {
      
      output = maximum;
      
    } else if (input < minimum) {
      
      output = minimum;
      
    }
    
    return output;
    
  }
  
  /* 
     * [clamp checks whether a user input is withn the range of a max or min, returning output if valid, and limits
     * if not]
     * [Recieves input from whatever method or user input needs to be checked]
     * [Ouputs the user input back if within perameters or lower/upper limit (depending on infraction)]
     * 
     * @param [firstParam: double value of the number is being checked]
     * @param [secondParam; double value of the lower limit being check against)
     * @param [thirdParam; double value of upper limit being checked]
     * @return [returns the first perameter if check is valid, or returns upper or lower limit based on infraction]
   */
  
  public static double[] setFilmGrain (double [] raster)
  {
    
    int rasterLength = raster.length;
    double pixel = 0;
    double changeInR = .1;
    double r = 0;
    
    for (int i = 0; i < rasterLength; i++)
    {
      
      r = (-changeInR/2 + (int)(Math.random() * ((changeInR/2 - -changeInR/2) + 1))); // random # between -change/2 and change/2
      pixel = (raster[i] + r);
      pixel = clamp(pixel, 0, 1);
      raster[i] = pixel;
      
    }
    
    return raster;
  }
  
   /* 
     * [setFilmGrain adds noise to a photo by slightly deviated each pixel intensity]
     * [Recieves input as a raster array for the desired picture]
     * [Ouputs the changed photo raster with film grain effects added]
     * 
     * @param [firstParam: recieves the raster of the photo wishing to recieve the filter grain effect]
     * @return [returns the newly modified array with noise changes added]
   */
  
  
  public static double[] setPosterize (double raster[])
  {
    int rasterLength = raster.length;
    int greyLevels = 3;
    double pixel = 0;
    
    
    for (int i = 0; i < rasterLength; i++)
    {
      
      pixel = (Math.floor( raster[i] * greyLevels) / (greyLevels - 1));
      pixel = clamp(pixel, 0, 1);
      raster[i] =  pixel;
      
    }
    
    return raster;
  } 
  
   /* 
     * [setPosterize limits the intensity of the pixels to a certain number of levels adding a poster like effect to a 
     * picture]
     * [Recieves input as a photo(.jpeg) queued for the desired effect]
     * [Ouputs the modified raster with pixel intensitys changed into levels]
     * 
     * @param [firstParam: double value of the array raster of the image being modified]
     * @return [returns the modifyed array raster set the posterize effect]
   */
  
  public static double[] setGhost (double raster[])
  {
    
    File userFile2 = getFile();
    int rasterLength = raster.length;
    double[] combinedRaster = new double[rasterLength];
    double pixel = 0;
    
    ImageLibrary.loadImage(userFile2);
    double[] raster2 = ImageLibrary.getImageRaster();
    
    for (int i = 0; i < rasterLength; i++)
    {
      
      pixel = ((raster[i] + raster2[i]) / 2);
      pixel = clamp(pixel, 0, 1);
      combinedRaster[i] =  pixel;
      
    }
    
    return combinedRaster;
  } 
  
   /* 
     * [setGhost averages the intensity of 2 pixels in 2 different pictures and produces a ghost like effect between 
     * the two photos]
     * [Recieves input as a raster image in the form of an array of doubles]
     * [Ouputs the changed raster with averaged pixels from another file(photo)]
     * 
     * @param [firstParam: the array of pixel numbers in the raster being changed]
     * @return [the newly created combinedRaster that implements the ghost effect stated prior]
   */
  
  public static double[] setEdgeFilter(double[] raster, int imageWidth, int imageLength)
  {
    int rasterLength = raster.length;
    double pixelP = 0;
    double pixelA = 0;
    double pixelB = 0;
    double change = 0;
    int width = imageWidth;
    int length = imageLength;
    
    for (int i = 0; i < rasterLength; i++)
    {
      
      double queryPixel = raster[i];
      int x = (i % width);
      int y = (i / width);
      
      int xA = x + 1 ;
      int yA = y;
      
      xA = (int) (clamp(xA, 0, (width - 1)));
      yA = (int) (clamp(yA, 0, (length-  1)));
      
      pixelA = raster[yA * width + xA];
      
      double changeA = (pixelA - queryPixel);
      
      int xB = x;
      int yB = y + 1;
      
      xB = (int) (clamp(xB, 0, width - 1));
      yB = (int) (clamp(yB, 0, length-  1));
      
      
      pixelB = raster[yB * width + xB];
      
      double changeB = (pixelB - queryPixel);
      
      change = (changeA + changeB);
      change += 2;
      change = (change/4);
      
      raster[i] = change;
      
    }
    
    return raster;
    
  }
  
   /* 
     * [setEdgeFilter uses the position of the pixels to test 2 subsequent pixels around the 'query' pixel
     * and see if an edge exists by scaling the difference of intensitys of the query and the tests]
     * [Recieves input from a raster image as an array to index pixels individually as well as the dimensions of the
     * picture]
     * [Ouputs the modified raster with changed pixel intensitys and effect]
     * 
     * @param [firstParam: array of raster image being changed]
     * @param [the width of the image being changed
     * @param [thirdParam; the height of the picture being modified]
     * @return [returns the newly modified raster array with subsequent changes]
   */
  
  public static File getFile() 
  {
    
    JFileChooser chooser = new JFileChooser();
    
    try {
      
      String currentDir = (System.getProperty("user.dir"));
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
    
  }   // Displays termination message
}