package list;

public interface ListInterface
{

	
	void add(WordAndCount element); //adds elements to list
	
	boolean contains (WordAndCount element); //returns true if element e exists in list
	
	void remove (WordAndCount element); //removes element from list
	
	WordAndCount get( WordAndCount element); //returns specified element e if found in list
	
	String toString(); //returns formatted string that represents list
	
	void reset(); //initializes current position for iteration through list to first element of list
	
	WordAndCount getNext(); //precondition: list is not empty,list is reset,list has not been modified since reset.
			     //returns element at current position on list.
			     //if current position is last, advance the value of current position to first element
			     //else advance value of current position to next element
}
