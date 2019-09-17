/**
 * Time Since Midnight
 * 
 * Comp 1010 SECTION A02
 * INSTRUCTOR: Mike Domaratzki
 * Assignment: A.2, Q.2
 * @author Richard Constantine
 * @version Oct. 22
 * PURPOSE: To calculate the time difference between midnight (00:00:00 am) and the time they enter
 * in 24 hour clock format.
 * 
 */

import javax.swing.*;
import java.util.Scanner;
import java.util.Date;

public class ConstantineRichardA2Q2 {

  public static void main (String[] args) {


  int midnight = 0; 
  String userInputTime = JOptionPane.showInputDialog (null, "Please enter the time as hh:mm:ss."); // Save user input as string 
  if (userInputTime != null) {
    System.out.println ("Prompt: Please enter the time as hh:mm:ss."); // Output


    Scanner timeScanner = new Scanner (userInputTime); //Set scanner as user input
    timeScanner.useDelimiter (":"); 

    String hourToken, minuteToken, secondToken; //Declare tokens of input

    if (timeScanner.hasNextInt()) { 
      hourToken = timeScanner.next();

      minuteToken = timeScanner.next();  // Seperating and saving parts of input as integers    

      secondToken = timeScanner.next();     

      timeScanner.close();

      if (hourToken.length() >= 3 || hourToken.length() <= 0) {
        JOptionPane.showMessageDialog (null, "The number of hours was either missing or not an integer.");
        System.out.println ("The number of hours was either missing or not an integer.");
        userInputTime = JOptionPane.showInputDialog (null,"Please enter the time as hh:mm:ss."); 
        
      } else if (minuteToken.length() >= 3 || minuteToken.length() <= 0) {
        JOptionPane.showMessageDialog (null, "The number of minutes was either missing or not an integer.");
        System.out.println ("The number of hours was either missing or not an integer.");
        userInputTime = JOptionPane.showInputDialog (null, "Please enter the time as hh:mm:ss.");
        
      } else if (secondToken.length() >= 3 || secondToken.length() <= 0) {
        JOptionPane.showMessageDialog (null, "The number of seconds was either missing or not an integer.");
        System.out.println ("The number of seocn was either missing or not an integer.");
        userInputTime = JOptionPane.showInputDialog (null, "Please enter the time as hh:mm:ss.");

      } else {
            
        int hourInteger = Integer.parseInt (hourToken);
        int minuteInteger = Integer.parseInt (minuteToken);   
        int secondInteger = Integer.parseInt (secondToken);

        int hourConverted = hourInteger * 3600; // Convert user hour input to seconds
        int minuteConverted = minuteInteger * 60; // Convert user minute input to seconds
            
        int timeAsSeconds = (hourConverted + minuteConverted + secondInteger); // user's time in seconds
          
        int timeSinceMidnight = timeAsSeconds - midnight; // time since midinight

        System.out.println ("Output: There are " +timeSinceMidnight + " seconds since midnight for a time of " 
                                      +hourToken+":"+minuteToken+":"+secondToken);
        JOptionPane.showMessageDialog (null, "There are " +timeSinceMidnight + " seconds since midnight for a time of " 
                                      +hourToken+":"+minuteToken+":"+secondToken);
                                    // Output Results


        System.out.println ("Response: " +userInputTime); // Output   
        Date newDate = new Date();
        System.out.println ("");
        System.out.println ("Date: " +newDate);                                    
        System.out.println ("Programmed by Richard Constantine");  // Terminate program
        System.out.println ("*** Program Terminated ***");

      }
    } else {
      System.out.println ("Response: " +userInputTime); // Output
      Date newDate = new Date();
      System.out.println ("");
      System.out.println ("Date: " +newDate);                                    
      System.out.println ("Programmed by Richard Constantine");  // Terminate program
      System.out.println ("*** Program Terminated ***"); 
    }
  } else {
    System.out.println ("Response: " +userInputTime); // Output
    Date newDate = new Date();
    System.out.println ("");
    System.out.println ("Date: " +newDate);                                    
    System.out.println ("Programmed by Richard Constantine");  // Terminate program
    System.out.println ("*** Program Terminated ***");   
    }
  }
}

    
     
     


