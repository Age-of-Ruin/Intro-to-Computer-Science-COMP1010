import java.util.Scanner;
import java.util.Date;
import javax.swing.JOptionPane;
/*
 * Richard ConstantineA3Q2
 * 
 * COMP 1010
 * Instructor: Mike Domaratzki
 * Assignment: 3, Question: 2
 * @author     Richard Constantine
 * @version    2012/11/14
 * 
 * Purpose:    Input a  date of the form yyyy:mm:dd and validdate the date using methods as the key approach.
 *             Output an error message if the date is not valid.
 *             If the date is valid output the number of second since new year of that specific year.
 */

public class RichardConstantineA3Q2
{
    public static void main(String[] args)
    {  
        Scanner scannerDate;
        Scanner scannerTime; 
        String promptDate = "";
        String promptTime = "";
        String inputDate = "";
        String inputTime = "";
        int userHours = 0;
        int userMinutes = 0;
        int userSeconds = 0;
        int userYear = 0;
        int userMonth = 0;
        int userDay = 0;
        int secondsSinceMidnight = 0;
        int daysSinceNewYear = 0;
        int secondsSinceNewYear = 0;
        final int MIN_HOURS = 0;     // the minimum value allowed for hours
        final int MAX_HOURS = 23;    // the maximum value allowed for hours
        final int MIN_MINUTES = 0;   // the minimum value for minutes
        final int MAX_MINUTES = 59;  // the maximum value for minutes
        final int MIN_SECONDS = 0;   // the minimum value for seconds
        final int MAX_SECONDS = 59;  // the maximum value for seconds
        final int MIN_YEARS = 0;     // the minumum value for years
        final int MAX_YEARS = 10000; // the maximum value for years
        final int MIN_MONTHS = 1;    // the minimum value for months
        final int MAX_MONTHS = 12;   // the maximum value for months
        final int MIN_DAYS = 1;      // the minimum value for days
        final int MAX_DAYS = 31;     // the maximum value for days
        
        while (inputDate != null && !inputDate.trim().equals (""));  // prompt for date
        {
          promptDate = "Enter the date as yyyy/mm/dd ";
          inputDate = JOptionPane.showInputDialog(null, promptDate);
          System.out.println("\nPROMPT:\n" + promptDate);
          System.out.println("RESPONSE:\n" + inputDate);
          
          scannerDate = new Scanner (inputDate);
          scannerDate.useDelimiter("/"); 
          
          if (inputDate != null && !inputDate.trim().equals (""))  // prompt for time
          {   
            promptTime = "Enter the time as hh:mm:ss ";
            inputTime = JOptionPane.showInputDialog(null, promptTime);
            System.out.println("\nPROMPT:\n" + promptTime);
            System.out.println("RESPONSE:\n" + inputTime);
          }
          scannerTime = new Scanner (inputTime);
          scannerTime.useDelimiter(":"); 
        }
          
          userYear = getInRange (scannerDate, MIN_YEARS, MAX_YEARS);
          userMonth = getInRange (scannerDate, MIN_MONTHS, MAX_MONTHS);
          userDay = getInRange (scannerDate, MIN_DAYS, MAX_DAYS);
                                                                           // checks if values are in range
          userHours = getInRange (scannerTime, MIN_HOURS, MAX_HOURS);
          userMinutes = getInRange (scannerTime, MIN_MINUTES, MAX_MINUTES);
          userSeconds = getInRange (scannerTime, MIN_SECONDS, MAX_SECONDS);
        
        if (userHours != -1 && userMinutes != -1 && userSeconds != -1 && userYear != -1 && userMonth != 0 && userDay !=
            0)
        {
          secondsSinceNewYear = secondsSinceNewYear (userYear, userMonth, userDay, userHours, userMinutes, userSeconds);
          System.out.println ("\nThe number of seconds since the new year is "+ secondsSinceNewYear + ".");
        // if within range, calcute and display seconds since new years
          
        } else {
        
        JOptionPane.showMessageDialog (null, "Invalid or no Input Entered.");  
        System.out.println("\nInvalid input or none found.");
        // show error message and end program
        }
        
    terminationMethod ();
   
    }

    public static int getInRange (Scanner check, int lowerLimit, int upperLimit)
    {
      int token = 0;
      
      if (check.hasNextInt())
      {
        token = check.nextInt();
        
        if (token < lowerLimit || token > upperLimit)
        {
          token = lowerLimit -1;
        }     
      } else {
        
        token = lowerLimit -1;
      }
         return token;
    }      
    
    /* 
     * [getInRange checks whether a user input is withn the range of coded values or returns the lowerLimit value - 1.]
     * [Recieves input from user as scanner as well as from main.]
     * [Ouputs the user input back if within perameters.]
     * 
     * @param [firstParam: scanner value with piece of string attained from user, any value]
     * @param [secondParam; int value of lower limit being checked, 0 or 1 depending on case)
     * @param [thirdParam; int value of upper limit being checked, depends on maximum allowable integer of time or date]
     * @return [returns validated token as an int]
     */
     
    public static int secondsSinceMidnight (int hours, int minutes, int seconds)
     {
       int secondsSinceMidnight = ((hours * 3600) + (minutes * 60) + seconds);
       
       return secondsSinceMidnight;
    }
    
    /* 
     * [secondsSinceMidnight calculates the seconds since midnight from the validated user input for time.]
     * [Recieves input from main(user), checked by method getInRange.]
     * [Ouputs the seconds as an integer.]
     * 
     * @param [firstParam: int value user inputted hours, values 0-12]
     * @param [secondParam; int value of user inputted minutes, values 1-59)
     * @param (thirdParam; int valueof user inputted seconds, values 1-59]
     * @return [returns number of seconds since midnight(0:0:0) and an int value]
     */
    
    public static int daysSinceNewYear (int year, int month, int day)
    {
      boolean leapYear = false;
      int daysSinceNewYear = 0;
      int[] daysSincePrevMonths = new int[13];
      
        // number of days since new year for start each month (at 12:00:00 midnight)
      
        daysSincePrevMonths[1] = 0; // january 
        daysSincePrevMonths[2] = (daysSincePrevMonths[1] + 31); // february
        daysSincePrevMonths[3] = (daysSincePrevMonths[2] + 28); // march
        daysSincePrevMonths[4] = (daysSincePrevMonths[3] + 31); // april
        daysSincePrevMonths[5] = (daysSincePrevMonths[4] + 30); // may
        daysSincePrevMonths[6] = (daysSincePrevMonths[5] + 31); // jume
        daysSincePrevMonths[7] = (daysSincePrevMonths[6] + 30); // july
        daysSincePrevMonths[8] = (daysSincePrevMonths[7] + 31);// august 
        daysSincePrevMonths[9] = (daysSincePrevMonths[8] + 31); // september
        daysSincePrevMonths[10] = (daysSincePrevMonths[9] + 30); // october
        daysSincePrevMonths[11] = (daysSincePrevMonths[10] + 31); // november
        daysSincePrevMonths[12] = (daysSincePrevMonths[11] + 30); // december
         
         if (year%4 == 0)
      {
        leapYear = true;
      
      } else if ( year%100 == 0 && year %400 != 0)
      {
        leapYear  = false;
      }
      
      if (leapYear = true)
      {
        daysSincePrevMonths[3] += 1;
          
        daysSinceNewYear = (daysSincePrevMonths[month] + day); 
      
      } else {
        
        daysSinceNewYear = (daysSincePrevMonths[month] + day);
          
        }
      
      return daysSinceNewYear;
    
    }
    
    /* 
     * [daysSinceNewYear calculates the number days since new years that specfic year (accounting for leap years).]
     * [Recieves input from main(user), check by getInRange.]
     * [Ouputs the number of days as an integer.]
     * 
     * @param [firstParam: int value user inputted year, values 0-10000]
     * @param [secondParam; int value of user inputted month, values 1-12)
     * @param [thirdParam; int value of user inputted day, values, 1-31]
     * @return [the number of days since new year that given year as an integer]
     */
    
    public static int secondsSinceNewYear (int year, int month, int day, int hours, int minutes, int seconds)
    {
      int secondsTillDate = (daysSinceNewYear (year, month, day)) * 86400;
      
      int secondsSinceNewYear = secondsTillDate + secondsSinceMidnight (hours, minutes, seconds);
      
      return secondsSinceNewYear;
                                                   
    }                                            
   
    /* 
     * [secondsSinceNewYear calculates the number of seconds since new year from the date and time entered by the user.]
     * [Recieves input from main(user), as well as calls methods daysSinceNewYear and secondsSinceMidnight]
     * [Ouputs the number of seconds as an integer.]
     * 
     * @param [firstParam: int value user inputted year]
     * @param [secondParam; int value of user inputted month)
     * @param (thirdParam; int valueof user inputted day]
     * @param [fourthParam: int value user inputted hours]
     * @param [fifthParam; int value of user inputted minutes)
     * @param (sixthParam; int valueof user inputted seconds]
     * @return [the number of seconds since new year of that year as an int value]
     */
    
    public static void terminationMethod ()
    {
        
        System.out.println("\nProgrammed by Richard Constantine") ;
        System.out.println("Date: " + new Date() ) ;
        System.out.println("** End of processing. **") ;
                                                   
    }
    // Displays termination message
}



