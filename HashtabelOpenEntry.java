import java.util.*;
import java.io.*;
/*
 * This class implements the datastructure of a hash table using linear probing
 * a seperate class named HashEntry is used in the Array that represents the
 * hash table.
 */
public class HashtabelOpenEntry {
	// The actual Hashtabel is an Array of HashEntry objects
	HashEntry[] hashArray;

	// Load factor of the hash table, automatically on 0.75 since it's a
	// good load_factor
	private double load_factor = 0.75;

	// Initial size of the hash table
	private int hash_size;

	private Compressable function;

	private int size = 0;

	// Constructor that creates the HashtabelOpenEntry object
	public HashtabelOpenEntry(int size, Compressable hashfunc) {
		hash_size = size;
		hashArray = new HashEntry[hash_size];
		function = hashfunc;
	}

	// Constructor that allows setting the load factor
	public HashtabelOpenEntry(int size, Compressable hashfunc, double factor) {
		hash_size = size;
		hashArray = new HashEntry[hash_size];
		function = hashfunc;
		load_factor = factor;
	}

	// Returns the hashArray
	public HashEntry[] getHashtabel() {
		return hashArray;
	}

	// Maps the specified key to the specified value in the hash table
	public void put(String key, String value) {
		int index = function.calcIndex(key);

		// Resizes the hash table if load factor exceeds maximum
		if(((double) size/hash_size) > load_factor) {
			System.out.print("Resizing the hash table at load factor ");
			System.out.println((double) size/hash_size);
			resize();
		}

		if(hashArray[index] == null){
			hashArray[index] = new HashEntry(key, value);
			size++;
		} else {
			while(hashArray[index] != null && hashArray[index].getKey() != key) {
				index = (index + 1) % hash_size;
			}
			hashArray[index] = new HashEntry(key, value);
			size++;
		}
		
	}

	// Returns the value to which the specified key is mapped, or null
	// if the map contains no mapping for the key.
	public String get(String key) {
		int index = function.calcIndex(key); 
        
        if(hashArray[index] == null){
        	return null;
        }else{
        	while(hashArray[index] != null && !hashArray[index].getKey().equals(key)){
        		index = (index + 1) % hash_size;
        	}
        	if(hashArray[index] != null && hashArray[index].getKey().equals(key)){
        		return hashArray[index].getKey();
        	}else{
        		return null;
        	}
        }
    }

	public void resize(){
		System.out.println("Resize that shit!");
		hash_size = hash_size*2;
		function = new Division(hash_size);
		HashtabelOpenEntry hashArrayTemp = new HashtabelOpenEntry(hash_size, function);
		for (int i = 0; i < hash_size/2; i++) {
			if(hashArray[i] != null){
				hashArrayTemp.put(hashArray[i].getKey(), hashArray[i].getValue());
			}
		}
		hashArray = hashArrayTemp.getHashtabel();
		System.out.print("Resized at hash size of " + hash_size);
		System.out.println(" at load factor " + (double)size/hash_size);
	}

	public int size() {
		return size;
	}
}