package list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class textToList
{

		//first run through is initial parse
	
		static String textFileString = ","; //to be removed when using add method
		static String textFileString2 = ","; //to be removed when using add method
		public static void main(String[] args) throws FileNotFoundException
		{	
			File text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
			long start = System.currentTimeMillis(); //initial parse time start
		    Scanner fileRead = new Scanner(text);
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		    long finish = System.currentTimeMillis(); //initial parse time end
		    double elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed Time for initial parse: " + (elapsedTime) + " seconds \n "); //print initial parse time
		   
		    
		    //create lists
		    //declare all lists
		    RefSortedList List2 = new RefSortedList();
		    RefSortedList2 List3 = new RefSortedList2();

		    SkipList List5 = new SkipList();
		    WordAndCount word; //WordAndCount object 
		    
		    //list 2 run
		    textFileString = ","; //to be removed when using add method
		    textFileString2 = ","; //to be removed when using add method
		    start = System.currentTimeMillis();
		    
		    text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
		    fileRead = new Scanner(text);
		    
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		
		    for (String token: textFileString2.split("\\s+"))  //create list 1 from file
		    { 
		    	word = new WordAndCount(token);
		    	List2.add(word);
		    	
		    }
		    finish = System.currentTimeMillis(); //initial parse time end
		    elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed Time for list 2: " + (elapsedTime) + " seconds \n "); //print list parse time
		    
		    
		    //list 3 run
		    textFileString = ","; //to be removed when using add method
		    textFileString2 = ","; //to be removed when using add method
		    start = System.currentTimeMillis();
		    text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
		    fileRead = new Scanner(text);
		    
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		
		    for (String token: textFileString2.split("\\s+"))  //create list 1 from file
		    { 
		    	word = new WordAndCount(token);
		    	List3.add(word);
		    	
		    }
		    finish = System.currentTimeMillis(); //initial parse time end
		    elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed Time for list 3: " + (elapsedTime) + " seconds \n "); //print list parse time

		    
		    //list 5 run
		    textFileString = ","; //to be removed when using add method
		    textFileString2 = ","; //to be removed when using add method
		    start = System.currentTimeMillis();
		    text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
		    fileRead = new Scanner(text);
		    
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		
		    for (String token: textFileString2.split("\\s+"))  //create list 1 from file
		    { 
		    	List5.insert(token);
		    	
		    }
		    finish = System.currentTimeMillis(); //initial parse time end
		    elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed Time for SkipList: " + (elapsedTime) + " seconds \n "); //print list parse time
		    
		    //print list metrics
		    System.out.print("List 2: " + List2.metrics());
		    System.out.print("List 3: " + List3.metrics());
		    System.out.print("List 5: "); List5.metrics();
		    System.out.print("\n");
		    
		    //separate remove methods for list 3
		    RefSortedList2 List3a = List3;
		    RefSortedList2 List3b = List3;
		     
		    //list 2 remove
		    textFileString = ","; //to be removed when using add method
		    textFileString2 = ","; //to be removed when using add method
		    start = System.currentTimeMillis();
		    
		    text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
		    fileRead = new Scanner(text);
		    
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		
		    for (String token: textFileString2.split("\\s+"))  //create list 1 from file
		    { 
		    	word = new WordAndCount(token);
		    	List2.remove(word);
		    	
		    }
		    finish = System.currentTimeMillis(); //initial parse time end
		    elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed removal Time for list 2: " + (elapsedTime) + " seconds \n "); //print list parse time
		    
		    //list 3a remove
		    textFileString = ","; //to be removed when using add method
		    textFileString2 = ","; //to be removed when using add method
		    start = System.currentTimeMillis();
		    text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
		    fileRead = new Scanner(text);
		    
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		
		    for (String token: textFileString2.split("\\s+"))  //create list 1 from file
		    { 
		    	word = new WordAndCount(token);
		    	List3a.remove(word);
		    	
		    }
		    finish = System.currentTimeMillis(); //initial parse time end
		    elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed removal Time for list 3a: " + (elapsedTime) + " seconds \n "); //print list parse time

		    //list 3b remove
		    textFileString = ","; //to be removed when using add method
		    textFileString2 = ","; //to be removed when using add method
		    start = System.currentTimeMillis();
		    text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
		    fileRead = new Scanner(text);
		    
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		
		    for (String token: textFileString2.split("\\s+"))  //create list 1 from file
		    { 
		    	word = new WordAndCount(token);
		    	List3b.remove(word);
		    	
		    }
		    finish = System.currentTimeMillis(); //initial parse time end
		    elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed removal Time for list 3b: " + (elapsedTime) + " seconds \n "); //print list parse time

		    //list 5 remove
		    textFileString = ","; //to be removed when using add method
		    textFileString2 = ","; //to be removed when using add method
		    start = System.currentTimeMillis();
		    text = new File("C:\\Users\\Balihaar Gill\\Desktop\\FILE_NAME.txt"); //text file to be evaluated
		    fileRead = new Scanner(text);
		    
		    fileRead.useDelimiter(" "); //tokenizes based on spaces
		    
		    while (fileRead.hasNext()) //while there is a data value in the tokenizer...
		    {
		    	
		    	textFileString = textFileString + " " + fileRead.next().toLowerCase(); //make everything lowercase
		    }
		    for (String token: textFileString.split("\\s+")) //split with white space demliter
		    {
		         textFileString2 = textFileString2 + " " + token.replaceAll("\\p{Punct}","");; //remove punctuation
		         
		    }
		
		    for (String token: textFileString2.split("\\s+"))  //create list 1 from file
		    { 
		    	List5.remove(token);
		    	
		    }
		    finish = System.currentTimeMillis(); //initial parse time end
		    elapsedTime = ((finish - start) / 1000.0); //convert parse time to seconds
		    System.out.print("Elapsed removal Time for SkipList: " + (elapsedTime) + " seconds \n "); //print list parse time
		
		    //print remove metrics
		    System.out.print("List 2: " + List2.metrics());
		    System.out.print("List 3a: " + List3a.metrics());
		    System.out.print("List 3b: " + List3b.metrics());
		    System.out.print("List 5: "); List5.metrics();
		}
	

	

}
