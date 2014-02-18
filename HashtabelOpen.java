import java.util.*;
import java.io.*;

// import java.long.*;

public class HashtabelOpen {
	// The actual Hashtabel is an Array of Linkedlists
	String[][] hashArray;

	// Load factor of the hash table, automatically on 0.75 since it's a
	// good load_factor
	private double load_factor = 0.75;

	// Initial size of the hash table
	private int hash_size;

	private Compressable function;

	// Constructor that creates the Hashtabel object
	public HashtabelOpen(int size, Compressable hashfunc) {
		hash_size = size;
		System.out.println("constructor yeah: "+hash_size);
		hashArray = new String[hash_size][2];
		function = hashfunc;
	}

	// Returns the hashArray
	public String[][] getHashtabel() {
		return hashArray;
	}

	// Maps the specified key to the specified value in the hashtable
	public void put(String key, String value) {
		int index = function.calcIndex(key);

		if(hashArray[index] == null){
			hashArray[index][0] = key;
			hashArray[index][1] = value;
		}else{
			while(hashArray[index] != null){
				index++;
			}
			hashArray[index][0] = key;
			hashArray[index][1] = value;
		}
		
	}

	// Returns the value to which the specified key is mapped, or null
	// if the map contains no mapping for the key.
	public String get(String key) {
		int index = function.calcIndex(key); 
        
        if(hashArray[index] == null){
        	return null;
        }else{
        	while(hashArray[index] != null&& !hashArray[index][0].equals(key)){
        		index++;
        	}
        	if(hashArray[index][0].equals(key)){
        		return hashArray[index][1];
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

	public void resize(){
			System.out.println("Resize that shit!");
			String[][] hashArrayTemp = new String[hashArray.length*2][2];
			for (int i = 0; i < hashArray.length; i++) {
				if(hashArray[i] != null){
					hashArrayTemp[i] = hashArray[i];
				}
			}
			hashArray = hashArrayTemp;
	}
}