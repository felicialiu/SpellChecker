import java.util.*;
import java.io.*;
import java.long.*;


public class Hashtabel {
	// Hashtabel actual array // liever linked-list gebruiken
	Linkedlisthashentry[][] hashArray;

	// Load factor of the hash table, automatically on 0.75 since it's a
	// good load_factor
	private float load_factor = 0.75;

	// intitial size of the hash table
	private int hash_size;

	// Constructor that creates the hash table object
	public Hashtabel<K,Y>(int size) {
		hash_size = size;
		hashArray = new Linkedlisthashentry(K key, V value);
	}

	// Maps the specified key to the specified value in the hashtable
	private void put(K key, V value) {
		int index = calcIndex(key);
		//hashArray
	}

	// Returns the value to which the specified key is mapped, or null
	// if the map contains no mapping for the key.
	private V get(K key) {
		return null;
	}
}