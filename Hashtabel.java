/*
 * Assignment 2 - Datastructuren
 * Names: Felicia Liu & Jonas van Oenen
 * Student numbers: 6385842 & 10670947
 * Date: 18 February 2014
 */

import java.util.*;
import java.io.*;
/*
 * This class implements the datastructure of a hash table using collision
 * chaining. A seperate class named Linkedlist is used in the Array that 
 * represents the hash table and enables the chaining functionality.
 */
public class Hashtabel {
	// The actual Hashtabel is an Array of Linkedlists
	Linkedlist[] hashArray;

	// Load factor of the hash table, automatically on 0.75 
	private double load_factor = 0.75;

	// Initial size of the hash table
	private int hash_size;

	//dunction is a compressable interface variable
	private Compressable function;

	// Constructor that creates the Hashtabel object
	public Hashtabel(int size, Compressable hashfunc) {
		hash_size = size;
		hashArray = new Linkedlist[hash_size];
		function = hashfunc;
	}

	// Returns the hashtable
	public Linkedlist[] getHashtabel() {
		return hashArray;
	}

	// Maps the specified key to the specified value in the hashtable
	public void put(String key, String value) {
		int index = function.calcIndex(key);
		
		// If the returned index is null, we can create a new Linkedlist
		// object there, containing the key and value
		if (hashArray[index] == null) {
			hashArray[index] = new Linkedlist(key, value);
		} else {
			Linkedlist currentNode = hashArray[index];
			// Else we will search for the next available Linkedlist node whose
			// key matches our key OR whose value is null
			while(currentNode.getKey() != key && currentNode.getNext() != null ) {
				currentNode = currentNode.getNext();
			} if(currentNode.getKey() == key) {
				currentNode.setValue(value);
			} else{
				currentNode.setNext(new Linkedlist(key, value));
			}
		}
	}

	// Returns the value to which the specified key is mapped, or null
	// if the map contains no mapping for the key.
	public String get(String key) {
		int index = function.calcIndex(key); 
        if (hashArray[index] == null) {
              return null;
        } else {
        	Linkedlist currentNode = hashArray[index];
        	while (currentNode != null && !currentNode.getKey().equals(key)) {
                currentNode = currentNode.getNext();
        	}
          	if (currentNode == null){
                return null;
        	} else {
                return currentNode.getValue();
            }
    	}
    }

    // Returns the number of filled hashArray elements
	public int size() {
		int counter = 0;
		for(int i = 0; i < hashArray.length; i++) {
			if(hashArray[i] != null) {
				counter++;
			}
		}
		return counter;
	}
}