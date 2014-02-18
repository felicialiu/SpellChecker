import java.util.*;
import java.lang.*;

public class Linkedlist
{
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

	// Returns the key
	public String getKey()
	{
		if(key == null) {
			System.out.println("No key has been found");
			return null;
		} else {
			return this.key;
		}
	}

	// Returns the next element
	public Linkedlist getNext()
	{
		if(next == null){
			return null;
		} else {
			return next;
		}
	}

	// Sets the next value
	public void setNext(Linkedlist next)
	{
		this.next = next;
	}
}