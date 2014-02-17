import java.util.*;
import java.lang.*;

public class Linkedlist
{
	public static void main(String[] args) {
		/*
		Linkedlist test1 = new Linkedlist("Word", "a");
		Linkedlist test2 = new Linkedlist("Woord", "a");
		Linkedlist test3 = new Linkedlist("Node", "a");
		test1.setNext(test2);
		test2.setNext(test3);
		System.out.println("Printing the key of test 1!");
		System.out.println(test1.getKey());
		System.out.println("Printing the next value of test 1!");
		System.out.println(test1.getNext().getKey());
		*/
		/*
		Linkedlist[] testarray = new Linkedlist[5];
		for(int i = 0; i < testarray.length; i++) {
			System.out.println(testarray[i]);
		}
		*/
	}
	// Linked list that will function as entry for hashtable
	private Linkedlist next = null;

	// The key of the hashtable that will be passed to the constructor
	private String key = null;

	// The value corresponding to the key that will be passed to the constructor
	private String value = null;

	// The constructor for creating the linked list
	public Linkedlist(String key, String value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
	}

	//Returns the value 
	public String getValue()
	{
		if(value == null) {
			System.out.println("No value has been found");
			return null;
		} else {
			return value;
		}
	}

	//Sets the value 
	public void setValue(String value)
	{
		this.value = value;
	}

	//returns the key
	public String getKey()
	{
		if(key == null) {
			System.out.println("No key has been found");
			return null;
		} else {
			return this.key;
		}
	}

	//returns the next element
	public Linkedlist getNext()
	{
		return next;
	}

	//sets the next value
	public void setNext(Linkedlist next)
	{
		this.next = next;
	}
}