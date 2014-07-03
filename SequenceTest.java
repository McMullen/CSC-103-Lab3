//----------------------------------------------------------------------------------
//Author:      Jason McMullen and Adam Reese
//Due Date:    10/30/13
//
//Program:     SequenceTest
//Description: This program inturprets the menu selection read in from a txt file
//             and executes those selections. The selections are: create a sequence,
//             delete a number, delete the first number in the sequence, add a
//             number before another number, add a number after another number, add
//             a number to the end of the sequence, display a number at a certain
//             index, display the last element in the sequence, replace a number
//             with another number, append another sequence to the first sequence,
//             create a clone sequence, print the sequence, and create a clone.
//             After all of these changes have been perfromed, each method called
//             will print out the changes to the array along with all of its
//             details.
//----------------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import java.text.*;

public class SequenceTest
{
   
   //variable to hold the user selected option for the menu   
   private int option;
   
   //variable to hold the amount of elements in the current string
   private int manyElements;
   
   //objects of class DoubleLinkedSeq
   private DoubleLinkedSeq sq1, sq2;
   private DoubleLinkedSeq sq3 = new DoubleLinkedSeq();
   
   //format the double variablers to like int type
   DecimalFormat pattern = new DecimalFormat("0.##");

   //This method will interpret the desired selection from the user and execute the
   //commands by calling on various smaller methods to manipulate the array.         
   public void menu(String line)throws IOException
   {
      
      //objects needed to print to an outside txt file. The "true" in the parameter
      //is needed to add onto a txt file without erasing the contents inside
      //everytime the program trys to write to it
      FileWriter fileOut = new FileWriter("Output.txt", true);
      PrintWriter pw = new PrintWriter(fileOut);
      
      StringTokenizer tokenizer = new StringTokenizer(line, "\b\n\t,- ");
      
      pw.println("Input line: " + line);
      
      option = Integer.parseInt(tokenizer.nextToken());
 
      switch(option)
      {
            
         //Create a new sequence
         case 1:
            
            pw.println("Create a squence");
            
            manyElements = tokenizer.countTokens();
            
            if(manyElements == 0)                 
            {   
            
               pw.println("--------------------");
               pw.println("Exception - no data was created");
               pw.println("");
               pw.println(""); 
              
               pw.close();
                             
            }//end if
            else
            {
               
               if(sq1 == null)
               {
                          
                  sq1 = createSequence(tokenizer, line, pw);
                                                                         
               }//end if                  
               else       
               {
       
                  sq2 = createSequence(tokenizer, line, pw);
                              
               }//end else
            
            }//end else
                          
         break;
         
         //----------------------------------------------------------
         //Delete a number
         case 2:
         
            pw.println("Delete a number");
            
            deleteNumber(tokenizer, line, pw);            
                  
         break;
         
         //----------------------------------------------------------
         //Delete the first number from the sequence
         case 3:
         
            pw.println("Delete the first number from the sequence");
            
            deleteFirst(pw);

         break;
         
         //----------------------------------------------------------
         //Add a number before another number
         case 4:
         
            pw.println("Add a number before another number");
            
            addBefore(tokenizer, line, pw);

         break;
         
         //----------------------------------------------------------
         //Add a number after a number
         case 5:
         
            pw.println("Add a number after a number");
            
            addAfter(tokenizer, line, pw);

         break;
         
         //-----------------------------------------------------------
         //Add a number to the end of the sequence
         case 6:
         
            pw.println("Add a number to the end of the sequence");
            
            addEnd(tokenizer, line, pw);

         break;
         
         //-----------------------------------------------------------
         //Display a number at a certain index
         case 7:
         
            pw.println("Display a number at a certain index");
            
            displayIndex(tokenizer, line, pw);

         break;
         
         //-----------------------------------------------------------
         //Display the last element in the sequence
         case 8:
         
            pw.println("Display the last element in the sequence");
            
            displayLast(pw);

         break;
         
         //-----------------------------------------------------------
         //Replace a number with another number
         case 9:
         
            pw.println("Replace a number with another number");
            
            replaceNumber(tokenizer, line, pw);

         break;
         
         //-----------------------------------------------------------
         //Append another sequence to the first sequence
         case 10:
         
            pw.println("Append another sequence to the first sequence");
            
            appendSequence(pw);

         break;
         
         //-----------------------------------------------------------
         //Create a clone sequence
         case 11:
         
            pw.println("Create a clone sequence");
            
            createClone(pw);

         break;
         
         //-----------------------------------------------------------
         //Print the sequence
         case 12:
         
            pw.println("Print the sequence");
            
            printTheSequence(tokenizer, line, pw);

         break;
         
         //----------------------------------------------------------
         //Quit
         case 13:
         
            pw.println("Quit");
            
            pw.close();
            
            //exit out of the program
            System.exit(0);

         break;
         
         //----------------------------------------------------------
      
      }//end switch statement 
                  
   }//end menu method
  
   //Create a new DoubleLinkedSeq object and use the non-default constructor need to 
   //send in the amount of elements that will be added to the seq
   public DoubleLinkedSeq createSequence(StringTokenizer tokenizer, String line,
                  PrintWriter pw)
   {
           
      DoubleLinkedSeq sq = new DoubleLinkedSeq();
      
      double element = Double.parseDouble(tokenizer.nextToken());
      
      sq.addFront(element);                          
                           
      //create new nodes for each new piece of data that will become part of the 
      //link list                     
      for(int i = 1; i < manyElements; i++)
      {
                  
         element = Double.parseDouble(tokenizer.nextToken());
         sq.addAfter(element);
                                   
      }//end for loop
      
      //print the results of this method
      printSequence(sq, pw);
      
      return sq;         
         
   }//end createSequence method

   //This method searches through the entire link list looking for a specific 
   //number, cursor is set equal to the node that holds that number. If there
   //is more instances of the number in the link list, cursor will be set
   //equal only to the first instance of the number.  
   public void find(DoubleLinkedSeq sq, double num)
   {
      
      //set curosr to the start of the list so we can see every element in the
      //list starting from the begining
      sq.start();
      
      for(int i = 0; i < sq.size(); i++)
      {
      
         //if the number is found, we dont do anything, cursor is already pointing
         //to the node that is holding the desired value
         if(num == sq.getCurrent())
         {
         
         
         
         }//end if
         else
         {
         
            //move to the next location to check that element
            sq.advance();
         
         }//end else
      
      }//end for loop
   
   }//end find method

   //This method will delete a number from the link list. After the number has been
   //deleted, cursor will be pointing to the one after it.
   public void deleteNumber(StringTokenizer tokenizer, String line, PrintWriter pw)
   {
   
      double delete = Double.parseDouble(tokenizer.nextToken());
      
      find(sq1, delete);     
      sq1.removeCurrent();
      
      printSequence(sq1, pw);
   
   }//end deleteNumber method

   //This method will delete the first element in the link list. After that element 
   //has been deleted, head and cursor will point to the node following it
   public void deleteFirst(PrintWriter pw)
   {
   
      sq1.start();
      sq1.removeCurrent();     
      printSequence(sq1, pw);
   
   }//end deleteFirst method

   //This method adds an element before the desired element. It does this by 
   //determining the position of the element and setting cursor to the node that 
   //holds the element. It then creates a new Node and adds it to the list
   //follwing the newly found Node.
   public void addBefore(StringTokenizer tokenizer, String line, PrintWriter pw)
   {
   
      double addThis = Double.parseDouble(tokenizer.nextToken());      
      double beforeThis = Double.parseDouble(tokenizer.nextToken());
      
      find(sq1, beforeThis);      
      sq1.addBefore(addThis);
      
      printSequence(sq1, pw);
         
   }//end addBefore method

   //This method adds an element behind the desired element in the link list. It 
   //does this by determining the location of the element and setting cursor equal
   //to the Node holding the element.
   public void addAfter(StringTokenizer tokenizer, String line, PrintWriter pw)
   {
   
      double addThis = Double.parseDouble(tokenizer.nextToken());     
      double afterThis = Double.parseDouble(tokenizer.nextToken());
      
      find(sq1, afterThis);      
      sq1.addAfter(addThis);
      
      printSequence(sq1, pw);
   
   }//end addAfter method

   //This method adds a new element to the end of the array. It does this by setting
   // the currentIndex equal to the amount of items in the array and then expanding
   //the size of the array to make room for the new element.
   public void addEnd(StringTokenizer tokenizer, String line, PrintWriter pw)
   {
   
      double addThis = Double.parseDouble(tokenizer.nextToken());
      
      sq1.addEnd(addThis);
            
      printSequence(sq1, pw);
   
   }//end addEnd

   //This method display the element residing in the desired Node in the link list.
   //This method uses a loop to advance cusror to the appropriate node to retrieve
   //the data it constains.
   public void displayIndex(StringTokenizer tokenizer, String line, PrintWriter pw)
   {
   
      int index = Integer.parseInt(tokenizer.nextToken());
      
      sq1.setCurrent(index);
      
      printSequence(sq1, pw);
   
   }//end displayIndex method

   //This method displays the last element in the array. It does this by setting
   //currentIndex equal to the last space in the array.
   public void displayLast(PrintWriter pw)
   {
   
      sq1.currentLast();      
      printSequence(sq1, pw);      
   
   }//end displayLast method

   //This method replaces a number with another selected number. It does this by 
   //finding the Node that is storing the desired number and then deleting that
   //Node. A new Node is created before the following Node replacing the old Node
   //with the new one.
   public void replaceNumber(StringTokenizer tokenizer, String line, PrintWriter pw)
   {
   
      double replaceWhat = Double.parseDouble(tokenizer.nextToken());      
      
      find(sq1, replaceWhat);
                  
      double replaceWith = Double.parseDouble(tokenizer.nextToken());
      
      //remove the old Node and then add the new Node before the following
      //Node
      sq1.replaceNodeData(replaceWith);
      //sq1.removeCurrent();
      //sq1.addBefore(replaceWith);
            
      printSequence(sq1, pw);     
   
   }//end replaceNumber method

   //This method creates a new list and then places the origional and then new 
   //list after it into it.
   public void appendSequence(PrintWriter pw)
   {
   
      sq1.addAll(sq2);      
      printSequence(sq1, pw);
   
   }//end appendSequence method
   
   //This method creates a clone of sq1
   public void createClone(PrintWriter pw)
   {
   
      sq3 = (DoubleLinkedSeq)sq1.clone();      
      printSequence(sq3, pw);
   
   }//end createClone method

   //This method prints out the details of the listss. It does this by figuring 
   //out the selected option from the txt file.
   public void printTheSequence(StringTokenizer tokenizer, String line,
                     PrintWriter pw)
   {
   
      int whichSequence = Integer.parseInt(tokenizer.nextToken());
      
      if(whichSequence == 1)
      {
      
         printSequence(sq1, pw);
      
      }//end if
      else
      {
      
         printSequence(sq2, pw);
      
      }//end else
   
   }//end printTheSequence method

   //This method prints out all the details of every action taken. It will show the
   //entire list, the current element,and the amount of elements that are located in 
   //the list.
   public void printSequence(DoubleLinkedSeq sq, PrintWriter pw)
   {
      
      double answer = 0;
      double current = sq.getCurrent();
      pw.println("--------------------");
      pw.print("The sequence: ");
      
      sq.start();
      for(int i = 0; i < sq.size(); i++)
      {
      
         answer = sq.getCurrent();
         pw.print(pattern.format(answer) + " ");
         
         if(i < (sq.size() - 1))
         {
         
            sq.advance();
         
         }//end if statement
         
      }//end for loop
      pw.println("");
      
      pw.println("Number of elements: " + sq.size());
      pw.println("The current element: " + pattern.format(current));
      pw.println("");
      pw.println("");
      
      pw.close();
   
   }//end printSequence method

}//end class
