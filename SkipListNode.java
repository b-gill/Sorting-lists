package list;

public class SkipListNode
{
    public SkipListNode up;       // up link
    public SkipListNode down;     // down link
    public SkipListNode left;     // left link
    public SkipListNode right;    // right link 
    public static String negInf = "-oo";  // -inf key value
    public static String posInf = "+oo";  // +inf key value
	protected String word;
	protected int count = 1;
	
	public SkipListNode(String word)
	{
		
		this.word = word;
		up = down = left = right = null;
	}
	public void setWord(String s)
	{
		word = s;
	}
	public String getWord()
	{
		return word;
	}
	
	public Boolean contains(String s)
	{
		boolean container;
		container = (word.equals(s));
		return container;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void incrementCount()
	{
		count++;
	}
	
	public void decrementCount()
	{
		count--;
	}
	
	public void setCount(int count1)
	{
		count = count1;
	}
	
	public int compareTo(SkipListNode other) //compares word of one node to another.
	{
		int comparison = this.word.compareTo(other.word);
		if (comparison < 0)
			return 1;
		else if (comparison == 0)
			return 0;
		else 
			return -1;
	}
	
	public String toString() //returns word and count of node.
	{
		return (word + ": " + count);
	}

	public Boolean equals(SkipListNode other) //returns boolean based on whether nodes are equal.
	{
		if (this.word == other.word)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
