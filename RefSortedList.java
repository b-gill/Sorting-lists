package list;

import list.LinkedListNode;

public class RefSortedList extends RefUnsortedList implements ListInterface
{
	
	public RefSortedList()
	{
		super();
	}
	
	public void add(WordAndCount element)
	//adds elements to list
	{
		if (element.contains(",")) //remove inevitable first token when using string split.
		{
			return;
		}
		if (contains(element)) //if element is already in list, increment count on respective node.
    	{
			lastFoundLocation = location;
    		get(element).incrementCount();
    		return;
    	}
			LinkedListNode prevLoc; //trailer
			LinkedListNode location; //traveler
			WordAndCount listElement; //current element in list being compared
			
			//set up search for insertion point
			location = list;
			prevLoc = null;
			
			//search for insertion point
			while (location != null)
			{
				listElement = location.getInfo();
				if (listElement.compareTo(element) < 0)
				{
					prevLoc = location;
					location = location.getLink();
				}
				else
				{
					break;
				}
				

			}
			//prepare for insertion
			LinkedListNode newNode = new LinkedListNode(element);
			
			
			//insert node
			if (prevLoc == null)
			{
				//insert as first node
				refChanges = refChanges + 1;
				newNode.setLink(list);
				list = newNode;
				lastFoundLocation = list;
			}
			
			else
			{
				refChanges = refChanges + 1;
				newNode.setLink(location);
				refChanges = refChanges + 1;
				prevLoc.setLink(newNode);
				lastFoundLocation = list;
			}
	}

	protected void find(WordAndCount target)
	//searches list for element e through .equals(). If successful sets instance
	//variables found to true. Location to node containing e. and previous to the node
	//that links to location. If not successful sets found to false
	{
		location = list;
		if (lastFoundLocation != null)
			{
				if (target.getWord().compareTo(lastFoundLocation.getInfo().getWord()) < 0)
				{
					location = lastFoundLocation;
				}
			}
		
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
			if(location.getInfo().getCount() > 1) //if there is more than one occurence of the word...
			{
				location.getInfo().decrementCount(); //just decrease the count
				return;
			}
			else
			{
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
			
			
		}
		return;
	}
}
