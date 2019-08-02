package list;

public class WordAndCount implements Comparable<WordAndCount>
{
	protected String word;
	protected int count = 1;
	
	public WordAndCount(String word) //constructor
	{
		this.word = word;
	}
	public void setWord(String s) //set word to a string
	{
		word = s;
	}
	public String getWord() //return word as string
	{
		return word;
	}
	
	public Boolean contains(String s) //boolean of whether WordAndCount contains a word.
	{
		boolean container;
		container = (word.equals(s));
		return container;
	}
	
	public int getCount() //gets count of object
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
	
	public void setCount(int count1) //set the count to a specific int
	{
		count = count1;
	}
	
	public int compareTo(WordAndCount other) //compare wordandcount objects based on word
	{
		int comparison = this.word.compareTo(other.word);
		if (comparison < 0)
			return 1;
		else if (comparison == 0)
			return 0;
		else 
			return -1;
	}
	
	public String toString() //return word and count
	{
		return (word + ": " + count);
	}
	
	
	
	public Boolean equals(WordAndCount other)
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
