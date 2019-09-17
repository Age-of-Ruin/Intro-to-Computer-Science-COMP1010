/*
 * RichardConstantineA2Q3
 * 
 * COMP 1010
 * Instructor: Mike Domaratzki
 * Assignment: 3, Question: 3
 * @author     Richard Constantine
 * @version    2012/11/14
 * 
 * Purpose:    To create a program that can interpret large amounts of data 
 *             and provide the time when maximum cross-currency arbitrage occurs,
 *             using an external file and methods to accomplish this.
 */

import java.util.Scanner;
import java.util.Date;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
public class RichardConstantineA3Q3
{
  public static void main(String[] args)
  { 
    File aFile = getFile(); // save file to language type
    Scanner fileReader; // read the file
    String time = ""; // save the first line of file (time)
    String timeOfMax = ""; // track time of max profit
    String[] exchangeInfo = new String [3]; // 3 lines of currency with exchange rates
    double percentGained = 0; // profit of time specified
    double maxProfit = 0; // track largest profit margin
    
    try 
    {
      
      fileReader = new Scanner(aFile);

      while (fileReader.hasNextLine())
      {
         time = fileReader.nextLine();
       
      exchangeInfo[0] = fileReader.nextLine();
      exchangeInfo[1] = fileReader.nextLine();  // save lines with currencys to strings
      exchangeInfo[2] = fileReader.nextLine(); 
      
      percentGained = processTime(exchangeInfo[0], exchangeInfo[1], exchangeInfo[2]); // calculate profit at cede time
     
      if (percentGained > maxProfit) // tracks maximum instance
      {

        timeOfMax = time;
        maxProfit = percentGained;  

      }
      }
      
  } catch (FileNotFoundException e) {
    
    e.printStackTrace();
      
  }
  
    if (maxProfit > 0) // whether profit exists or not
    {
      
    System.out.println ("\nA profit of " + maxProfit + "% can be obtained on " +  timeOfMax + ".");   
    
    } else {
      
    System.out.println("No obtainable Profit"); 
      
    }
    
    terminationMethod(); // end main
  }
 
  /*
   * Prompt the user to select a file using JFileChooser and return
   * the File object that the user selected.
   *
   * @return the file selected by the user
   */
 
  public static File getFile() {
    JFileChooser chooser = new JFileChooser();
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
  
  public static double findRate (String query, String exchangeInfo)
  {
    double exchangeRate = 0;

    Scanner rateFinder = new Scanner (exchangeInfo);
    rateFinder.useDelimiter(",");
    
    String currency1 = rateFinder.next();
    String currency2 = rateFinder.next();
    
    double rateOnLine = rateFinder.nextDouble(); 
    
      if (query.equals(currency1))
    {
     
      exchangeRate = rateOnLine;
    
    } else if (query.equals(currency2)) {
      
      exchangeRate = (1.0/(rateOnLine)) ;
        
    } else {
      
      exchangeRate = -1;
    
    }
    
    return exchangeRate;

  }
  
   /* 
     * [findRate obtains the correct exchange rate between a query currency and another on a line.]
     * [Recieves input as string identifying the query currency and the line which the query exists on.]
     * [Ouputs the correct exchange rate or -1 if no query can be found.]
     * 
     * @param [firstParam: string containing a 3 letter query currency abbr., takes value of 
     * 1 of 3 currencys in the arbitrage considered]
     * @param [secondParam; the line containing the query as to find it in terms of the second, line of info 
     * detailing query, trade currencys and exchange rate]
     * @return [returns proper exchange rate according to query as a double]
     */
  
  public static String otherCurr (String query, String exchangeInfo)
  {                                  
    Scanner currencyFinder = new Scanner (exchangeInfo);
    currencyFinder.useDelimiter(",");
    
    String otherCurrency = "";
    
    String currency1 = currencyFinder.next();
    String currency2 = currencyFinder.next();
    
    if(query.equals(currency1))
    {
     
      otherCurrency = currency2;
    
    } else {
        
      otherCurrency = currency1;  
      
    }
    
    return otherCurrency;
    
  }
       
   /* 
     * [getOtherCurr finds the currency being traded for from the query currency.]
     * [Recieves input as string identifying the query (and subsequent) currency and the line which the 
     * query and other currency rest.]
     * [Ouputs the currency not being queryed as a string.]
     * 
     * @param [firstParam: query currency being traded in terms of the next currency(which this method finds)]
     * @param [secondParam; line of exchange info on which the query currency and other currency exist]
     * @return [returns currency abbr. other than query as a string type]
     */
 
  public static double calculateArbitrageProfit (double rate1, double rate2, double rate3)
  {
    double profitPercent = 0;
      
    profitPercent = (((rate1 * rate2 * rate3) - 1) * 100);
    
    return profitPercent;  
  }
  
   /* 
     * [calculateArbitrageProfit calculates the percent gained or lost through trading the currency.]
     * [Recieves input 3 exchange rates that can be multiplyed to find the difference from initial.]
     * [Ouputs the profit profit percent]
     * 
     * @param [firstParam: exchange rate between query and otherCurr in first exchange]
     * @param [secondParam: exchange rate between query and otherCurr in second exchange]
     * @param [thirdParam: exchange rate between query and otherCurr in third exchange]
     * @return [returns percentage of profit attained through trading currencies as a double]
     */
  
  public static double processTime (String exchangeInfo1, String exchangeInfo2, String exchangeInfo3)
  {
    double profit = 0;
    double rate1 = 0;
    double rate2 = 0;
    double rate3 = 0;
    String otherCurrency1; 
    String otherCurrency2;
    String query;

       Scanner queryFinder = new Scanner (exchangeInfo1);
       queryFinder.useDelimiter(",");
       query = queryFinder.next();

       rate1 = findRate (query, exchangeInfo1); 
       otherCurrency1 = otherCurr (query, exchangeInfo1);

       rate2 = findRate (otherCurrency1, exchangeInfo2);
       otherCurrency2 = otherCurr (otherCurrency1, exchangeInfo2);
 
       rate3 = findRate (otherCurrency2, exchangeInfo3);
       
      profit = calculateArbitrageProfit(rate1, rate2, rate3);
  
    return profit;
  }                              
 
  /* 
     * [processTime compiles the order of the currency and exchange rate to return the profit (either + or - in
     * the arbitrage triangle.]
     * [Recieves input as the 3 lines of exchange info containging all the 3 currencys with their exchange rates,
     * as well as calls methods calculateArbitrageProfit, findRate, and getOtherCurr.]
     * [Ouputs the profit obtained in the instance of time.]
     * 
     * @param [firstParam: line of exchange info (currency1, currency2, exchange rate1)]
     * @param [firstParam: line of exchange info (currency2, currency3, exchange rate2)]
     * @param [firstParam: line of exchange info (currency3, currency1, exchange rate3)]
     * @return [returns profit attained through arbitrage triangle]
     */
  
    public static void terminationMethod ()
    {
        
        System.out.println("\nProgrammed by Richard Constantine") ;
        System.out.println("Date: " + new Date() ) ;
        System.out.println("** End of processing. **") ;
                                                   
    }
    // Displays termination message
}
