/**
 * Babylonian Method of Calculating Squares
 * 
 * Comp 1010 SECTION A02
 * INSTRUCTOR: Mike Domaratzki
 * Assignment: A.1, Q.2
 * @author Richard Constantine
 * @version Oct. 5
 * PURPOSE: To calculate the square root of a number inputted by the user through using 
 * the user's best guess at the root (Babylonian Method).

 */

import java.util.Scanner;

public class ConstantineRichardA1Q2 {
  
  public static void main (String[] args) {
     
   Scanner kbd = new Scanner (System.in);
   
   System.out.println ("Enter the value to find the square of: "); // ask the user for neccecary value being squared
     double valueBeingSquared = kbd.nextDouble(); // save that value to var valueBeingSquared
    System.out.println ("The number whose square root must be solved: "+ valueBeingSquared); // print that value
    System.out.println (""); // insert a space
    
    System.out.println ("Enter the best guess of the square root: "); // ask the user for their best guess of the root
     double userBestGuess = kbd.nextDouble(); // save that value to var userBestGuess
    System.out.println ("Your guess was: "+ userBestGuess); // print the recently saved value
    System.out.println (""); // insert a space
   
     double x1, x2, x3, x4, x5, x6; // results or steps (intermediate values)
    
    System.out.println ("Step: \tValue:"); // printed title for values
    
    // 1st iteration
     x1 = .5 * (userBestGuess + valueBeingSquared / userBestGuess); 
    System.out.println ("Step 1 \t" + x1);
    
    // 2nd iteration
     x2 = .5 * (x1 + valueBeingSquared / x1);
    System.out.println ("Step 2 \t" + x2);
    
    // 3rd iteration
     x3 = .5 * (x2 + valueBeingSquared / x2);
    System.out.println ("Step 3 \t" + x3);
    
    // 4th iteration
     x4 = .5 * (x3 + valueBeingSquared / x3);
    System.out.println ("Step 4 \t" + x4);
    
    // 5th iteration
     x5 = .5 * (x4 + valueBeingSquared / x4);
    System.out.println ("Step 5 \t" + x5);
    
    // 6th iteration
     x6 = .5 * (x5 + valueBeingSquared / x5);
    System.out.println ("Step 6 \t" + x6);
    
    System.out.println (""); // insert space
    
    System.out.println ("The approximiate square root of " + valueBeingSquared + " is " + x6); // display iterated value
    
    System.out.println (""); // insert space
    
     double actualValueOfRoot = Math.sqrt (valueBeingSquared); // calculate actual square root
     double absoluteOfDifference = Math.abs (x6 - actualValueOfRoot); // calculate the difference between the proposed roots
    System.out.println ("The actual square root is: " + actualValueOfRoot); // display actual root value
    
    System.out.println (""); // insert space
    
    System.out.print ("The difference between the actual value and the approximated value is: " +  absoluteOfDifference); // display difference in solutions
    
    
      System.out.println (""); // insert space
      System.out.println (""); // insert space
      
    System.out.println ("***Program Terminated***"); // End Program
 
  }

  
}
