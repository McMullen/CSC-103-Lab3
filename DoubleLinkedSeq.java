//----------------------------------------------------------------------------------
//Author:      Jason McMullen and Adam Reese
//Due Date:    10/30/13
//
//Program:     DoubleLinkedSeq
//Description: This class handles all the manipulations to the Link Lists. It can
//             create, delete, modify, and show the amount and current elements. 
//             This class also implements Cloneable to allow for cloning of objects
//             of this class. This class also includes a list copy method that will
//             produce a copy of the individual nodes to fully produce a replica 
//             of the origional object that will allow the user to modify it without
//             affecting the origional.
//----------------------------------------------------------------------------------

// File: DoubleLinkedSeq.java from the package edu.colorado.collections

// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.collections:
//package edu.colorado.collections;

/******************************************************************************
* This class is a homework assignment;
* A DoubleLinkedSeq</CODE> is a collection of double</CODE> numbers.
* The sequence can have a special "current element," which is specified and 
* accessed through four methods that are not available in the sequence class 
* (start, getCurrent, advance and isCurrent).
*
* <dl><dt><b>Limitations:</b>
*   Beyond Int.MAX_VALUE</CODE> elements, the size</CODE> method
*   does not work.
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/DoubleLinkedSeq.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/DoubleLinkedSeq.java
*   </A>
*   </dl>
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class DoubleLinkedSeq implements Cloneable
{
   
   //objects of class Node that will allow us to traverse the list and call for
   //specific information from each node without disturbing the list
	private Node head, tail, cursor;
   
   //variable to keep track of the amount of nodes in the link list
	private int manyNodes;  	
	
   /**
   * Initialize an empty sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This sequence is empty.
   **/   
   public DoubleLinkedSeq()
   {
      
		head = null;
		tail = null;
		cursor = null;
		
		manyNodes = 0;
		
   }//end default constructor
     
   /**
   * Add a new element to this sequence, after the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addAfter(double element)
   {
     
		  Node aNode = new Node();
        aNode.setLink(cursor.getLink());
        aNode.setData(element);
        
        cursor.setLink(aNode);
        
        cursor = aNode;
		  
		  //check to see if new node is at the end of the list, if so then have tail
		  //be equal to cursor
		  if(cursor.getLink() == null)
		  {
		  
		  		tail = cursor;
		  
		  }//end if
		  
		  manyNodes++;
	  
   }//end addAfter method

   /**
   * Add a new element to this sequence, before the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addBefore(double element)
   {	
		
		//check to see if adding with an empty list
      if(cursor == head)
		{
		
			addFront(element);
			
		}//end first if
		else
		{
			
			Node aNode = new Node();
         aNode.setData(cursor.getData());
         aNode.setLink(cursor.getLink());
         
			cursor.setLink(aNode);
			cursor.setData(element);
         			
			if(tail == cursor)
			{
			
				tail = aNode;
			
			}//end second if
         
         manyNodes++;
		
		}//end first else
		
   }//end addBefore method
     
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend</CODE>
   *   a sequence whose contents will be placed at the end of this sequence
   * <dt><b>Precondition:</b><dd>
   *   The parameter, addend</CODE>, is not null. 
   * <dt><b>Postcondition:</b><dd>
   *   The elements from addend</CODE> have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the addend</CODE> is also unchanged.
   * @exception NullPointerException
   *   Indicates that addend</CODE> is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   **/
   public void addAll(DoubleLinkedSeq addend)
   {
   
      if(addend == null)
      {
      
         throw new NullPointerException("The addend is null.");
      
      }//end if statement
      else
      {
         
   		tail.setLink(addend.head);
         tail = addend.tail;
         manyNodes += addend.manyNodes;
         
      }//end else statement
		
   }//end addAll method    
   
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true. 
   * <dt><b>Postcondition:</b><dd>
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   advance</CODE> may not be called.
   **/
   public void advance()
   {
      
      if(isCurrent() == true)
      {
      
		   cursor = cursor.getLink();
         
      }//end if statement
      else
      {
      
         //throw new IllegalStateException("There is no current element");
         
      }//end else statement
         	  
   }//end advance method
     
   /**
   * Generate a copy of this sequence.
   * @param - none
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to a DoubleLinkedSeq</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public Object clone()
   {  
	
		DoubleLinkedSeq clone;
		
		try
		{
		
			clone = (DoubleLinkedSeq)super.clone();
		
		}//end try
		catch(CloneNotSupportedException e)
		{
		
			throw new RuntimeException("This class does not support Cloneable");
		
		}//end catch
      
      clone.head = listCopy(head);
	
      return clone;
 
   }//end clone method
   
   //This method will return the head of the newly "cloned" linked list. It
   //will be an exact copy of the origional list while having its own unique
   //memory location.
   public static Node listCopy(Node source)
   {
   
      Node copyHead = null;
      Node copyTail = null;
      Node copyCursor = null;
      Node aNode;
      
      //check to see if the source is an empty list
      if(source == null)
      {
      
         return null;
      
      }//end if statement
      
      //first and only element in the list atm
      copyHead = new Node(source.getData(), null);
      copyTail = copyHead;
      copyCursor = copyHead;
      
      //for loop will add in the rest of the elements to the list. copyTail
      //will act like cursor and set the link of the current node to the 
      //following node before moving to the new node
      for(source = source.getLink(); source != null; source = source.getLink())
      {
      
         aNode = new Node(source.getData(), null);
         copyTail.setLink(aNode);
         copyTail = aNode;
         copyCursor = copyTail;
      
      }//end for loop
      
      return copyHead;
   
   }//end listCopy method 
   
   //This method creates a copy of each node in the list. This method is needed to
   //work with the clone method because the clone method does not create indepent
   //nodes from the origional. We need independent copies so if we manipulate the
   //data from the clone it will not affect the origional source
   public static Node[] listCopy(Node source, Node cursor, Node head, Node tail)
   {
   
      Node copyHead = null;
      Node copyTail = null;
      Node copyCursor = null;
      Node[] info = new Node[3];
      
      //if the link list is empty
      if(source == null)
      {
      
         info[0] = null;
         info[1] = null;
         info[2] = null;
         
         return info;
               
      }//end if
      
      //if there are nodes in the link list
      copyHead = new Node(source.getData(), null);
      copyTail = copyHead;
      
      if(cursor == head)
      {
      
         copyCursor = head;
      
      }//end if statement
      
      //create a new node for as long as there are more nodes coming in from
      //source. Each node will then be added to the newly made copy of the
      //list
      for(source = source.getLink(); source != null; source = source.getLink())
      {
      
         Node aNode = new Node(source.getData(), null);
         copyTail.setLink(aNode);
         copyTail = aNode;
         
         //when we come across the node that is the same as cursor, set 
         //the new cursor equal to the copied node
         if(source == cursor)
         {
         
            copyCursor = aNode;
         
         }//end if statement
         
         info[0] = copyHead;
         info[1] = copyTail; 
         info[2] = copyCursor;
               
      }//end for loop
      
      return info;
   
   }//end listCopy method

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1</CODE>
   *   the first of two sequences
   * @param s2</CODE>
   *   the second of two sequences
   * <dt><b>Precondition:</b><dd>
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of s1</CODE> followed by the
   *   elements of s2</CODE> (with no current element)
   * @exception NullPointerException.
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   **/   
   public static DoubleLinkedSeq catenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
   {
      
      DoubleLinkedSeq seq = new DoubleLinkedSeq();
      
		if((s1 == null)||(s2 == null))
      {
      
         throw new NullPointerException("Can not have an empty list.");
      
      }//end if statement
      else
      {
      
         s1.tail.setLink(s2.head.getLink());
                           
         seq.head = s1.head;
         seq.tail = s2.tail;
         seq.cursor = s1.cursor;
      
      }//end else statement
		
      return seq;

   }//end catenation method

   /**
   * Accessor method to get the current element of this sequence. 
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true.
   * @return
   *   the current capacity of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   getCurrent</CODE> may not be called.
   **/
   public double getCurrent()
   {
      
		double currentElement = 0.0;
      
		if(isCurrent() == true)
		{
		
			currentElement = cursor.getData();
		
		}//end if
		else
		{
		
			throw new IllegalStateException ("There is no current element.");

		
		}//end else
		
      return currentElement;
		
   }//end getCurrent method

   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * getCurrent</CODE> method. 
   * @param - none
   * @return
   *   true (there is a current element) or false (there is no current element
   *   at the moment)
   **/
   public boolean isCurrent()
   {
      
		boolean answer;
		
		if(cursor != null)
		{
		
			answer = true;
		
		}//end if statement
      else
      {
      
         answer = false;
      
      }//end else statement
		
      return answer;
		
   }//end isCurrent method
              
   /**
   * Remove the current element from this sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   isCurrent()</CODE> returns true.
   * <dt><b>Postcondition:</b><dd>
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   removeCurrent</CODE> may not be called. 
   **/
   public void removeCurrent()
   {
      if(cursor == null)
      {
      
         throw new IllegalStateException("No current Node to be removed.");
      
      }//end if statement
      else
      {
      
   		if(cursor == tail)
         {
            
            Node preCursor;
            
            for(preCursor = head; preCursor.getLink() != tail; 
                              preCursor = preCursor.getLink());
            
            preCursor.setLink(null);
            
            tail = preCursor;
            
            manyNodes--;
         
         }//end if statement
         else
         {
         
            Node next = cursor.getLink();
            
            cursor.setLink(next.getLink());
            cursor.setData(next.getData());
            
            cursor = next;
            
            manyNodes--;
         
         }//end else statement
   
      }//end else statement		
		
   }//end removeCurrent method
                    
   /**
   * Determine the number of elements in this sequence.
   * @param - none
   * @return
   *   the number of elements in this sequence
   **/ 
   public int size()
   {
      
		return manyNodes;
		
   }//end size method
   
   /**
   * Set the current element at the front of this sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start()
   {
      
		cursor = head;
		
   }//end start method
   
   //this method will effectively add a new node after the head. It will do this
   //by making the data in the new node to hold what we wanted to add and then
   //set head   
   public void addFront(double element)
   {
   
      if(head == null)
      {
      
         Node aNode = new Node();
         aNode.setData(element);
   		
         head = aNode;		
   		tail = aNode;
   		cursor = aNode;
         
      }//end if statement
      else
      {
      
         Node aNode = new Node();
         aNode.setData(element);
         aNode.setLink(head.getLink());
         
         head = aNode;
         cursor = aNode;
      
      }//end else statement
      
      manyNodes++;
   
   }//end addFront method
   
   //This method sets cursor to tail, the last element in the list. If the
   //list is empty, it will throw a NullPointerException.
   public void currentLast()
   {
   
      if(head == null)
      {
      
         throw new NullPointerException("The list is empty.");
      
      }//end if statement
      else
      {
      
         cursor = tail;
         
      }//end else statement
   
   }//end currentLast method
   
   //This method adds a new Node to the end of the list. After the add, the
   //cursor points to the new Node.
   public void addEnd(double element)
   {
   
      cursor = tail;
      
      Node aNode = new Node(element, null);
      cursor.setLink(aNode);
      
      tail = aNode;
      cursor = aNode;
      
      manyNodes++;
   
   }//end addEnd method
   
   //This method places the incoming data into the current Node cursor
   //is pointing to. If cursor is pointing to nothing, the list being
   //empty, the method throws a NullPointerException
   public void setCurrent(int i)
   {
      
      if(head != null)
      {
      
         start();
         
         for(int j = 1; j < i; j++)
         {
         
            advance();
         
         }//end for loop
   
      }//end if statement
      else
      {
      
         throw new NullPointerException("The list is empty.");
      
      }//end else statement
      
   }//end setCurrent method
   
   public void replaceNodeData(double element)
   {
   
      cursor.setData(element);
   
   }//end replaceNodeData method
	
}//end DoubleLinkedSeq class
