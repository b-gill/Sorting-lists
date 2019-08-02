package list;


public class LinkedListNode 
{
	private LinkedListNode link;
	public WordAndCount info;
	
	public LinkedListNode(WordAndCount info)
	{
		this.info = info;
		link = null;
	}
	
	public void setInfo (WordAndCount info) //method used to set info of the linked list node.
	{
		this.info = info;
	}
	
	public WordAndCount getInfo()  //method used to return info of the linked list node.
	{
		return info;
	}
	
	public void setLink(LinkedListNode link) //method used to set link of the linked list node.
	{
		this.link = link;
	}
	
	public LinkedListNode getLink()
	{
		return link;
	}
}
