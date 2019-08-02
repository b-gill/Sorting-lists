package list;

import list.LinkedListNode;
public class RefSortedList2 extends RefUnsortedList implements ListInterface
{
	public RefSortedList2()
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
			location = list;
			previous = null;
			
			while (location != null)
			{
				if (location.getInfo().getWord().equals(element.getWord())) //if they match...
				{
					element.setCount(location.getInfo().getCount());
					element.incrementCount();
					if (location == list)
					{
						LinkedListNode newNode = new LinkedListNode(element);
						refChanges = refChanges + 1;
						newNode.setLink(location.getLink());
						list = newNode;
						break;
					}
					else
					{
	
					previous.setLink(location.getLink());
					LinkedListNode newNode = new LinkedListNode(element);
					refChanges = refChanges + 1;
					newNode.setLink(list);
					list = newNode;
					break;
					}
				}
				
				else
				{
					previous = location;
					location = location.getLink();
				}
				
			}
		}
		
		else
		{
			
			LinkedListNode newNode = new LinkedListNode(element);
			newNode.setLink(list);
			refChanges = refChanges + 1;
			list = newNode;

		}
				


	}

	public void remove2(WordAndCount element)
	//removing element e from list such that e.equals(element)
	//if a removed word is not completely removed, it is moved to the front of the list.
	{
		find(element);

		
		if (found)
		{
			if(location.getInfo().getCount() > 0) //if there is more than one occurence of the word...
			{
				location.getInfo().decrementCount(); //just decrease the count
				//then move the word to the front.
				if (location == list)
				{
					LinkedListNode newNode = new LinkedListNode(element);
					refChanges = refChanges + 1;
					newNode.setLink(location.getLink());
					list = newNode;
					return;
	
				}
				else
				{
	
					previous.setLink(location.getLink());
					LinkedListNode newNode = new LinkedListNode(element);
					refChanges = refChanges + 1;
					newNode.setLink(list);
					list = newNode;
					return;
				}
	
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
	
}
