import java.util.*;
import java.io.*;

public class HashtabelOpenEntry {
	// The actual Hashtabel is an Array of HashEntry objects
	HashEntry[] hashArray;

	// Load factor of the hash table, automatically on 0.75 since it's a
	// good load_factor
	private float load_factor;

	// Initial size of the hash table
	private int hash_size;

	private Compressable function;

	// Constructor that creates the HashtabelOpenEntry object
	public HashtabelOpenEntry(int size, Compressable hashfunc) {
		hash_size = size;
		hashArray = new HashEntry[hash_size];
		function = hashfunc;
	}

	// Returns the hashArray
	public HashEntry[] getHashtabel() {
		return hashArray;
	}

	// Maps the specified key to the specified value in the hashtable
	public void put(String key, String value) {
		int index = function.calcIndex(key);
		
		if(calculateLoadFactor() > 0.75) {
			System.out.println("yo resize 1");
			resize();
		}

		if(hashArray[index] == null){
			hashArray[index] = new HashEntry(key, value);
		} else {
			if(calculateLoadFactor() > 0.75) {
				System.out.println("yo resize 2");
				resize();
			}
			while(hashArray[index] != null && hashArray[index].getKey() != key) {
				if(calculateLoadFactor() > 0.75) {
					System.out.println("yo resize 3");
					resize();
				}
				index = (index + 1) % hash_size;
			}
			hashArray[index] = new HashEntry(key, value);
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

	public float calculateLoadFactor() {
		return size()/hash_size;
	} 

	public void resize(){
		System.out.println("Resize that shit!");
		hash_size = hash_size*2;
		HashEntry[] hashArrayTemp = new HashEntry[hash_size];
		for (int i = 0; i < hashArray.length; i++) {
			if(hashArray[i] != null){
				hashArrayTemp[i] = hashArray[i];
			}
		}
		hashArray = hashArrayTemp;
		function = new Division(hash_size);
	}
}