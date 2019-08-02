package list;

import list.LinkedListNode;

public class RefUnsortedList
{
	protected long comparison = 0; //counted through find method
	protected long refChanges = 0; //counted through an pointer changes
	protected LinkedListNode currentPos; //current position of iteration
	protected boolean found; //true if element found
	protected LinkedListNode location; //node containing element
	protected LinkedListNode lastFoundLocation; //node containing element
	protected LinkedListNode previous; //node preceding location
	protected LinkedListNode list; //first node on list
	public RefUnsortedList()
	{
		list = null;
		currentPos = null;
	}
	
	public void add(WordAndCount element) //adds elements to the list
	{
		if (element.contains(",")) //remove inevitable first token when using string split.
		{

			return;
		}
		
		if (contains(element))
	    	{
				lastFoundLocation = location;
	    		get(element).incrementCount();
	    	}
		else
			{
			lastFoundLocation = list;
			LinkedListNode newNode = new LinkedListNode(element);
			newNode.setLink(list);
			list = newNode;
			refChanges = refChanges + 1;
			}
	}
	
	protected void find(WordAndCount target)
	//searches list for element e through .equals(). If successful sets instance
	//variables found to true. Location to node containing e. and previous to the node
	//that links to location. If not successful sets found to false
	{
		location = list;
		found = false;
		previous = null;
		
		while (location != null)
		{
			if (location.getInfo().getWord().equals(target.getWord())) //if they match...
			{
				comparison = comparison + 1; //counts as one comparison
				found = true;
				return;
			}
			
			else
			{
				previous = location;
				location = location.getLink();
			}
			
		}
	}
		
	public boolean contains (WordAndCount element)
	//returns true if list contains an element e such that e.equals(element)
	//otherwise false.
	{
		find(element);
		return found;
	}
	
	public void remove(WordAndCount element)
	//removing element e from list such that e.equals(element)
	//and returns true if no element exists
	{
		find(element);
	
		
		if (found)
		{
			if(location.getInfo().getCount() > 0) //if there is more than one occurence of the word...
			{
				location.getInfo().decrementCount(); //just decrease the count
				return;
			}
			
			if(list == location)
			{
				refChanges = refChanges + 1;
				list = list.getLink(); //remove first node
			}	
			else
			{
				refChanges = refChanges + 1;
				previous.setLink(location.getLink()); //remove node @ location
			}	
			
		}
		return;
	}
	
	public WordAndCount get(WordAndCount element)
	//returns element e from list such that e.equals(element)
	//else return null
	{
		find(element);
		if (found)
			return location.getInfo();
		else
			return null;
	}
	
	public String toString()
	//returns nicely formatted string that represents the list
	{
		LinkedListNode currNode = list;
		String listString = "List:\n";
		while (currNode != null)
		{
			listString = listString + " " + currNode.getInfo() + "\n";
			currNode = currNode.getLink();
		}
		listString = listString + " occurences: " + wordOccurenceTotal() + "\n";
		return listString;
	}
	
	public String metrics()
	{
		
		//prints multiple required metrics for
		String metrics = new String();
		metrics =   "\n occurences: " + wordOccurenceTotal() + "\n"
				+ "word total: " + wordTotal() + "\n comparisons: " + comparison + "\n reference changes: " + refChanges + "\n";
		return metrics;
		
		
		
	}
	
	public void reset()
	//initializes current position for iteration through list to first element of list
	{
		currentPos = list;
	}
	
	public int wordOccurenceTotal()
	{
		//goes through each node and adds count to running total.
		location = list;
		int occurences = 0;
		while (location != null)
		{
			occurences = occurences + location.getInfo().getCount();
			location = location.getLink();
		}
		return occurences;
	}
	
	public int wordTotal()
	{
		//goes through every node and increase count until no more nodes.
		location = list;
		int wordTotal = 0;
		while (location != null)
		{
			wordTotal = wordTotal + 1;
			location = location.getLink();
		}
		return wordTotal;
	}
	
	public WordAndCount getNext()
	//precondition: list is not empty,list is reset,list has not been modified since reset.
    //returns element at current position on list.
    //if current position is last, advance the value of current position to first element
    //else advance value of current position to next element
	{
		WordAndCount next = currentPos.getInfo();
		if (currentPos.getLink() == null)
			currentPos = list;
		else
			currentPos = currentPos.getLink();
		return next;
	}
}
