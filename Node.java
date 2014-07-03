class Node 
{
   private double data;
   private Node link; 

  //constructors
  public Node()
  {
  
      data = 0.0;
      link = null;
		
  }

  public Node(double d, Node l)
  {
  
      data = d;
      link = l;
		
  }
  void setData(double newElement)
  {
  
     data = newElement;
	  
  }
  void setLink(Node newLink)
  {
  
     link = newLink;
	  
  }
  double getData()
  {
  
     return data;
	  
  }
  Node getLink()
  {
  
     return  link;
	  
  }

}
