/**
 * Slot Machine With Symbols
 * 
 * Comp 1010 SECTION A02
 * INSTRUCTOR: Mike Domaratzki
 * Assignment: A.2, Q.3
 * @author Richard Constantine
 * @version Oct. 24
 * PURPOSE: To take a user inputted number of symbols and display all possible combinations along
 * with the subsequent 'winners' according to a 3 wheel slot machine.
 * 
 */

import javax.swing.*;
import java.util.Scanner;
import java.util.Date;

public class ConstantineRichardA2Q3 {
  
  public static void main (String[] args) {
    
    String userSymbolString = JOptionPane.showInputDialog ("Please enter symbols on wheel."); // recieve input
    int inputLength = userSymbolString.length ();
    
    char currChar1 = 0;
    char currChar2 = 0; // indicate different characters/wheels
    char currChar3 = 0;
    char currChar4 = 0;

   
   int total = 0; // number total possibilities
   int winner = 0; // nubmer of winning possibilities
    
   if (inputLength < 4 ) {
   
    for (int posn4 = 0; posn4 < userSymbolString.length(); posn4++) {
    currChar4 = userSymbolString.charAt(posn4);
  
        for (int posn3 = 0; posn3 < userSymbolString.length(); posn3++) {  // display all possible solutions
      currChar3 = userSymbolString.charAt(posn3); 
 
          for (int posn2 = 0; posn2 < userSymbolString.length(); posn2++) { 
        currChar2 = userSymbolString.charAt(posn2); 
   
          if (currChar1 == currChar2 && currChar2 == currChar3 && currChar3 == currChar4) { // test if a winner
          total++;
          winner++;                                                                         // if so, tally winner
          System.out.println (currChar2 + ""+ currChar3 + "" + currChar4 + "is a winner!"); // print winning statement
          
          }else {
          total++;
          System.out.println (currChar2+""+currChar4+""+currChar4);
          }
   
          }}}}else{
     for (int posn4 = 0; posn4 < userSymbolString.length(); posn4++) {
    currChar4 = userSymbolString.charAt(posn4);
  
        for (int posn3 = 0; posn3 < userSymbolString.length(); posn3++) {  // display all possible solutions
      currChar3 = userSymbolString.charAt(posn3); 
 
          for (int posn2 = 0; posn2 < userSymbolString.length(); posn2++) { 
        currChar2 = userSymbolString.charAt(posn2); 
         
           for(int posn1 = 0; posn1 < userSymbolString.length(); posn1++) {
         currChar1 = userSymbolString.charAt(posn1); 
          
          if (currChar1 == currChar2 && currChar2 == currChar3 && currChar3 == currChar4) { // test if a winner
          total++;
          winner++;                                                                         // if so, tally winner
          System.out.println (currChar2 + ""+ currChar3 + "" + currChar4 + "is a winner!"); // print winning statement
          
          }else {
          total++;
          System.out.println (currChar2+""+currChar4+""+currChar4);
          }
   
     }
        }
          }
        }
  }
          
   System.out.println (winner + " out of " + total + " are winners");
            
   System.out.println ("");
   
   Date newDate = new Date();
   System.out.println ("");
   System.out.println ("Date: " +newDate);                                    
   System.out.println ("Programmed by Richard Constantine");  // Terminate program
   System.out.println ("*** Program Terminated ***");
          
        
     }
  }
       

          
          
          
          