/**
 * Julian Date
 * 
 * Comp 1010 SECTION A02
 * INSTRUCTOR: Mike Domaratzki
 * Assignment: A.1, Q.3
 * @author Richard Constantine
 * @version Oct. 9
 * 
 * PURPOSE: To convert the users input of the date in year, month, day, hour, minutes, and second form (24 hour clock)
 * as integer values to the Julian Date consisting of a large integer that symbolizes the time since January 1, 4713 BC
 * (usful for astronomers and calculation of astral situations).
 * 

 */

import javax.swing.*;


public class ConstantineRichardA1Q3 {
  
  public static void main (String[] args) {
    
   System.out.println ("Please input all values as integers.");
   
  // declare intermediate string variables to gain user input
      String userYearString, userMonthString, userDayString, userHourString, userMinuteString, userSecondString; 
    
  // declare running variables with user saved integers for values  
      int userSecond, userMinute, userHour, userDay, userMonth, userYear; 
    
  // Store all neccessary values from the user in their respective variables
    
     userYearString = JOptionPane.showInputDialog("Please enter the cnter the current year: ");
      userYear = Integer.parseInt (userYearString); 
       System.out.println ("Year:");
       System.out.println (userYear);
       
     userMonthString = JOptionPane.showInputDialog("Please enter the cnter the current month (Jan =1, Dec = 12): ");
      userMonth = Integer.parseInt (userMonthString);
  
    while (userMonth >12 || userMonth < 1) {
     userMonthString = JOptionPane.showInputDialog("Please enter the cnter the current month (Jan =1, Dec = 12): ");
      userMonth = Integer.parseInt (userMonthString); 
    }
       System.out.println ("Month: ");
       System.out.println (userMonth);
         
     userDayString = JOptionPane.showInputDialog("Please enter the cnter the current day: ");
      userDay = Integer.parseInt (userDayString);
    
    while (userDay > 31 || userDay <1) {  
     userDayString = JOptionPane.showInputDialog("Please enter the cnter the current day: ");
      userDay = Integer.parseInt (userDayString); 
    }    
       System.out.println ("Day:");
       System.out.println (userDay);
  
     userHourString = JOptionPane.showInputDialog("Please enter the cnter the current hour (24 hour clock): ");
      userHour = Integer.parseInt (userHourString);
  
    while (userHour < 0 || userHour > 24) {
      userHourString = JOptionPane.showInputDialog("Please enter the cnter the current hour (24 hour clock): ");
      userHour = Integer.parseInt (userHourString);    
    }    
       System.out.println ("Hour:");
       System.out.println (userHour);
         
     userMinuteString = JOptionPane.showInputDialog("Please enter the cnter the current minute: ");
      userMinute = Integer.parseInt (userMinuteString);
       
    while (userMinute >= 60 || userMinute < 0) {  
     userMinuteString = JOptionPane.showInputDialog("Please enter the cnter the current minute: ");
      userMinute = Integer.parseInt (userMinuteString); 
    }   
       System.out.println ("Minute:");
       System.out.println (userMinute);
       
  
     userSecondString = JOptionPane.showInputDialog("Please enter the cnter the current second: ");
      userSecond = Integer.parseInt (userSecondString);
      
    while (userSecond < 0 || userSecond >= 60) {   
     userSecondString = JOptionPane.showInputDialog("Please enter the cnter the current second: ");
      userSecond = Integer.parseInt (userSecondString); 
    }  
       System.out.println ("Second:");
       System.out.println (userSecond);
  
  // Equation Variables
      double earlyMonthCorrection; // variable used to calculate the leap day in a year
      double intermediateYear; // value that shifts the year to aid finding the number of leap years
      double intermediateMonth; // corrects the month value
      double leapYears; 
       /* used to calculate the number of leap years since starting point (January 1, 4713 BC) 
        * using the fact that every year 4 years, or year divisible by 100 or not  by 400 is a 
        * consequent leap year */
      double intermediateDay; // used to calculate the days preceeding the user given month in a NON-leap year
      double julianDayNumber; 
       /* adds the day of the month and the number of years, and subtracts by the constant 
        * January 1, 4713 BC (day 0 of the Julian Date) giving the Juian Day Number */
      double finalHour, finalMinute, finalSecond; // variables for the time in deciaml form 
      double julianDate; 
       /* combines the Julian Day Number (date) along with the time in decimal form to give the
        * Julian Date */
 
// Runing Equations
 
earlyMonthCorrection = Math.floor (14.0 - userMonth / 12.0);      
 
intermediateYear =  userYear + 4800.0 - earlyMonthCorrection;

intermediateMonth = userMonth + 12.0 * earlyMonthCorrection - 3.0;
  
leapYears = (Math.floor (intermediateYear / 4.0)) - (Math.floor (intermediateYear / 100.0)) + (Math.floor (intermediateYear / 400.0));
  
intermediateDay = Math.floor ((153.0 * intermediateMonth + 2.0) / 5.0);

julianDayNumber = userDay + 365.0 * intermediateYear + intermediateDay + leapYears - 32045.0;

finalHour = (userHour - 12.0) / 24.0;
  
finalMinute = userMinute / 1440.0;
  
finalSecond = userSecond / 86400.0;
  
julianDate = julianDayNumber + finalHour + finalMinute + finalSecond;
  
  // Print solutions in interactions pane and JOptionPane     
       System.out.println ("The Julian Date of your time (" + userYear + "/" + userMonth + "/" + userDay + ")"); 
       System.out.println ("at " + userHour + ":" + userMinute + ":" + userSecond + " is " + julianDate + ".");
         
       JOptionPane.showMessageDialog (null, "The Julian Date of your time (" + userYear + "/" + userMonth + "/" + userDay + 
                                      ")" + " at " + userHour + ":" + userMinute + ":" + userSecond + " is " + julianDate 
                                       + ".");
      
       System.out.println ("");
       System.out.println ("*** Program Terminated ***"); // End Program
         
  }

}

     
