CSC-103-Lab3
============

Double Linked Sequence

CSC103 Fall 2013
Sara Wexler

Assignment #3

Objective: Create the sequence ADT with linked list.

This assignment is to be done by a group of two persons 
1.	Do programming project 9 from chapter 4 on page 249
•	Your class should make use of  Node class that I provided
The private instance variables should be ONLY: 
Node head, cursor, tail ; //  no precursor!
and,
 int ManyNodes;
•	Provide the additional methods as stated in the book with the following names. Create appropriate exceptions in those methods.
1.	addFront ( double num)
A method to add a new element at the front of the sequence
And make it the current element

2.	removeFront() 
A method to remove the element at the front of the sequence
Throw an exception if the sequence is empty
Make the next element the current element, if there is one

3.	addEnd  ( double num)
A method to add a new element at the end of the sequence
And make that element the current element 

4.	currentLast
A method that makes the last element of the sequence the current 
Element
Throw an exception if the sequence is empty

5.	retrieveElement ( int i)
a method that returns the ith element of the sequence
make current element to the ith element 
Throw an exception if the sequence is empty

6.	setCurrent ( int i)
a method that makes the ith element become the current element
Throw an exception if the sequence is empty

      Throw exceptions if necessary in those methods.


•	Outline of Java Source Code for this class can be found on the web page:
http://www.cs.colorado.edu/~main/edu/colorado/collections/DoubleLinkedSeq.java
    
   This file contains only blank implementations ("stubs").

2.	Test your program:
Run the same test program you wrote in lab2, Test.java, and SequenceTest.java using the DoubleLinkedSeq


Due Date: at the beginning of class on  Wednesday Oct 30.  ( week 9). 

Use this guideline for checking your program over before handing it in:
Grading criteria
5	- if the project  is working good, get correct output, and there are sufficient comments
4	- if the  project is working good, but there are some problems with the   
       code, or some of the output is incorrect
       or the comments are not sufficient
2 - if the code compile but does not run
1 - if the does not compile
