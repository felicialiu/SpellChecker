public class Linkedlisthashentry
{
	
	//Linked list that will function as entry for hashtable
	private Linkedlisthashentry next;

	//The key that will be passed to the constructor
	private int key;

	//The value that will be passed to the constructor
	private int value;

	//The constructor for creating the linked list
	public Linkedlisthashentry(int key, int value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
	}

	//Returns the value 
	public int getValue()
	{
		return value;
	}

	//Sets the value 
	public void setValue(int value)
	{
		this.value = value;
	}

	//returns the key
	public int getKey()
	{
		return key;
	}

	//returns the next element
	public Linkedlisthashentry getNext()
	{
		return next;
	}

	//sets the next value
	public void setNext(Linkedlisthashentry next)
	{
		this.next = next;
	}


}