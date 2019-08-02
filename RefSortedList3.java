package list;

import list.LinkedListNode;
public class RefSortedList3 extends RefUnsortedList implements ListInterface
{
	public RefSortedList3()
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
			LinkedListNode previousOfPrev = new LinkedListNode(null);
			
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
					if (previousOfPrev != null)
					{
						refChanges = refChanges + 1;
						previousOfPrev.setLink(newNode);
					}
					
					newNode.setLink(previous);
					if (previousOfPrev.getInfo() == null)
					{
						refChanges = refChanges + 1;
						list = newNode;
					}
					
					break;
					}
				}
				
				else
				{
					if (previous != null)
					{
						previousOfPrev = previous;
					}
					previous = location;
					location = location.getLink();
				}
				
			}
		}
		
		else
		{
			
			LinkedListNode newNode = new LinkedListNode(element);
			refChanges = refChanges + 1;
			newNode.setLink(list);
			list = newNode;

		}
				


	}
}