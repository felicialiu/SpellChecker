import java.util.*;
import java.io.*;
// import java.long.*;

public class Hashtabel {
	public static void main(String[] args) {

	}
	// Hashtabel actual array // liever linked-list gebruiken
	Linkedlist[][] hashArray;

	// Load factor of the hash table, automatically on 0.75 since it's a
	// good load_factor
	private double load_factor = 0.75;

	// intitial size of the hash table
	private int hash_size;

	// Constructor that creates the hash table object
	public Hashtabel(int size) {
		hash_size = size;
		hashArray = new Linkedlist[hash_size][1]; //new Linkedlist(key, value);
	}

	Compressable func = new Division();

	// Maps the specified key to the specified value in the hashtable
	public void put(String key, String value) {
		int index = func.calcIndex(key);
		Linkedlist currentNode = hashArray[index];
		if (currentNode == null) {
			currentNode = new Linkedlist(key, value);
		} else {
			while(currentNode != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new Linkedlist(key, value));
		}
	}

	// Returns the value to which the specified key is mapped, or null
	// if the map contains no mapping for the key.
	public String get(String key) {
		int index = func.calcIndex(key);
		Linkedlist currentNode = hashArray[index];
		if (currentNode.getKey().equals(key)) {
			currentNode.getValue();
		} else {
			while(!currentNode.getKey().equals(key)) {
				currentNode = currentNode.getNext();
			}
			currentNode.getValue();
		}
		return null;
	}

	public int size() {
		return hashArray.length;
	}
}