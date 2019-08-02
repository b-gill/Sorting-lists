package list;

import java.util.Random;

public class SkipList
{
	protected long comparison = 0; //counted through search method
	protected long refChanges = 0; //counted through a ref change
	public SkipListNode head;    // First element of the top level
    public SkipListNode tail;    // Last element of the top level
   
   
    public int n;                 // number of entries in the Skip List   
   
    public int h;       // Height
    public Random r;    // Coin toss
    
    public SkipList()     // Constructor...
    {
       SkipListNode p1, p2;

       //Create an -inf and an +inf object
       p1 = new SkipListNode(SkipListNode.negInf);
       p2 = new SkipListNode(SkipListNode.posInf);

       //Link the -inf and +inf object together
       p1.right = p2;
       p2.left = p1;

       //Initialize head and tail
       head = p1;
       tail = p2;

       //Other initializations
       n = 0;             // No entries in Skip List
       h = 0;		      // Height is 0

       r = new Random();  // Make random object to simulate coin toss
    }
                 


 public SkipListNode search(String k)
 {
    SkipListNode p;

    //Starting at the head...
    p = head;

    while (true)
    {
          
       while ( (p.right.word) != SkipListNode.posInf && (p.right.word).compareTo(k) <= 0 )
       {
    	   comparison = comparison + 1;
          p = p.right;         // Move to right
       }


       //Go down a level if possible...

       if ( p.down != null )
       {  
          p = p.down;          // Go downwards
       }
       else //If you can't go down a level...
       {
          break;       // We reached the lowest level, BREAK.
       }
    }

    return(p); //return the found word.
 }

 public void insert(String k)
 {
		if (k.contains(",")) //remove inevitable first token when using string split.
		{
			return;
		}
    SkipListNode p, q;
    int       i;

    p = search(k);                  // Try find the entry


    //Check if key is found

    if ( k.equals(p.word) )  // If key found, update the value and we are done...
    {
       p.count++; // Update value
       return; //end method
    }

    //Key k is not found, then p = floorEntry(k)

    q = new SkipListNode(k);       // Create a new entry with k  

    //Insert q into the lowest level after SkipListEntry p

    q.left = p; refChanges = refChanges + 1;
    q.right = p.right; refChanges = refChanges + 1;
    p.right.left = q; refChanges = refChanges + 1;
    p.right = q; refChanges = refChanges + 1;


    //Make a "tower" of the entry e or a random height

    i = 0;   // Current level = 0

    while ( r.nextDouble() < 0.5) //coin toss
    {
       // If coin toss is a success,build one more level


	   //Check if we need to increase the height of the -inf and +inf "pillars

       if ( i >= h )   // We reached the top level
       {
           SkipListNode p1, p2;

    	   h = h + 1;

               p1 = new SkipListNode(SkipListNode.negInf);
               p2 = new SkipListNode(SkipListNode.posInf);
       
    	   p1.right = p2; refChanges = refChanges + 1;
    	   p1.down  = head; refChanges = refChanges + 1;

    	   p2.left = p1; refChanges = refChanges + 1;
    	   p2.down = tail; refChanges = refChanges + 1;

    	   head.up = p1; refChanges = refChanges + 1; 
    	   tail.up = p2; refChanges = refChanges + 1;

    	   head = p1; refChanges = refChanges + 1;
    	   tail = p2; refChanges = refChanges + 1;
       }


       //Find first element with an up link
       while ( p.up == null )
       {
          p = p.left;
       }


	  //Make p point to this up element

       p = p.up; refChanges = refChanges + 1;


    //Add one more (k,*) to the column

  	SkipListNode e;
  		 
  	e = new SkipListNode(k);  // Don't need the value...
  		 

  	//Initialize links of e

  	e.left = p; refChanges = refChanges + 1;
  	e.right = p.right; refChanges = refChanges + 1;
  	e.down = q; refChanges = refChanges + 1;
  		 

  	//Change the neighboring links..

  	p.right.left = e; refChanges = refChanges + 1;
  	p.right = e; refChanges = refChanges + 1;
  	q.up = e; refChanges = refChanges + 1;

       q = e;       // Set q up for next iteration (if there is one)
                    // See here for more detail: click here

       i = i + 1;   // Current level increases by one
    }

    n = n + 1;      // One more entry in the Skip List
 }

 public void remove(String k)
 {
	 if (k == ",")
	 {
		 return;
	 }
	 SkipListNode p;
	  p = search(k);
	  if (p.getCount() > 1)
	  {
			p.decrementCount(); //just decrease the count
			return;
	  }
	   while ( p != null )
	   {
		  if (p.left != null)
			  p.left.right = p.right;
		  if (p.right != null)
			  p.right.left = p.left;
	      p = p.up;
	   }
	   while (head.right == tail)
	   {
		   head.right = null;
		   tail.left = null;
		   head = head.down;
		   tail = tail.down;
		   head.up.down = null;
		   tail.up.down = null;
		   head.up = null;
		   tail.up = null;
	   }
 }
 
 public void printVertical()
 {
    String s = "";

    SkipListNode p;

    p = head;

    while ( p.down != null )
       p = p.down;

    while ( p != null )
    {
       s = getOneColumn( p );
	System.out.println(s);

       p = p.right;
    }
 }

 public String getOneColumn( SkipListNode p )
 {
    String s = "";

    while ( p != null )
    {
       s = s + " " + p.word;

       p = p.up;
    }

    return(s);
 }

	public int wordOccurenceTotal()
	{
		SkipListNode p;
		int counter = -2; //to cancel the head and tail
	    p = head;

	    while ( p.down != null )
	       p = p.down;

	    while ( p != null )
	    {
	       counter = counter + p.count;
	       p = p.right;
	    }
	    return counter;
	}
	
	public int wordTotal()
	{
		SkipListNode p;
		int counter = -2; //-2 to cancel out head and tail nodes.
	    p = head;

	    while ( p.down != null )
	       p = p.down;

	    while ( p != null )
	    {
	       counter++;
	       p = p.right;
	    }
	    return counter;
	}
	
	public void metrics()
	{
		
		//prints multiple required metrics for
		String metrics = new String();
		metrics =   "\n occurences: " + wordOccurenceTotal() + "\n"
				+ "word total: " + wordTotal() + "\n" + "comparisons: " + comparison
				+ "\n" + "reference changes: " + refChanges;
		System.out.print(metrics);
	}
}
