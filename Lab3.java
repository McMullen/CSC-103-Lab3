//----------------------------------------------------------------------------------
//Author:     Jason McMullen and Adam Reese
//Due Date:    10/30/13
//
//Program:     Lab3
//Description: This program reads in, from a file, a list of 
//             numbers along with their menu options. Depending on the options a 
//             new link list can be created, elements can be added or taken away in
//             the deisred position in the link lists and two different link lists 
//             can be combined into one while maintaining the proper sequence of 
//             elements as specified.
//----------------------------------------------------------------------------------

import java.text.*;
import java.io.*;

//this class contains the main method that will run the program
public class Lab3
{

   //The main method will be responsible for reading the attached txt document and 
   //sending line per line to the parse method in SequenceTest
   public static void main(String[] args)
   {
   
      SequenceTest seqTest = new SequenceTest();
      
      try
      {
             
         //fr is an object of the FileReader class
         FileReader fr = new FileReader("input.txt");
                             
         //fileIn is an object of the BufferedReader class
         BufferedReader fileIn = new BufferedReader(fr);        
         
         //inital read to start the loop
         String line = fileIn.readLine();
            
         while(line != null)
         {
            
            //send line to menu to determine what information the line
            //contains
            seqTest.menu(line);
            
            //read the next line
            line = fileIn.readLine();
                           
         }//end while
                     
      }//end try
      catch(IOException e)
      {
         
         System.out.println("The file was not found.");
         
      }//end catch

   }//end main method

}//end Lab3 class
