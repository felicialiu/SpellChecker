import java.util.*;
import java.io.*;

// import java.long.*;

public class HashtabelOpen {
	// The actual Hashtabel is an Array of Linkedlists
	String[][] hashArray;

	// Load factor of the hash table, automatically on 0.75 since it's a
	// good load_factor
	private double load_factor = 0.75;

	private int size = 0;

	// Initial size of the hash table
	private int hash_size;

	private Compressable function;

	// Constructor that creates the Hashtabel object
	public HashtabelOpen(int size, Compressable hashfunc) {
		hash_size = size;
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

		//System.out.println(counter);
		//System.out.println(counter/hash_size );
		//System.out.println((double)counter/hash_size);
		if(((double)size/hash_size) > load_factor){
			resize();
		}

		if(hashArray[index] == null){
			hashArray[index][0] = key;
			hashArray[index][1] = value;
		}else{
			while(hashArray[index][0] != null){
				index = (index + 1) % hash_size;
				// index++;
			}
			hashArray[index][0] = key;
			hashArray[index][1] = value;
		}
		size++;
		
	}

	// Returns the value to which the specified key is mapped, or null
	// if the map contains no mapping for the key.
	public String get(String key) {
		int index = function.calcIndex(key);
		//System.out.println(index);
        
        if(hashArray[index] == null){
        	return null;
        }else{
        	while(hashArray[index][0] != null&& !hashArray[index][0].equals(key)){
        		if(index >= hashArray.length){
        			return null;
        		}
        		index++;
        	}
        	if(hashArray[index][0] != null && hashArray[index][0].equals(key)){
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
			if(hashArray[i][0] != null) {
				counter++;
			}
		}
		return counter;
	}

	public void resize() throws NullPointerException {
		String key = "";
		String value = "";
		hash_size = hash_size*2;
		function = new Division(hash_size); 
		HashtabelOpen temp = new HashtabelOpen(hash_size, function);
		System.out.println("Resize that shit!");
		// String[][] hashArrayTemp = new String[hashArray.length*2][2];
		
		for (int i = 0; i < hash_size/2; i++) {
			if(hashArray[i] != null){
				try {
				key = hashArray[i][0];
				value = hashArray[i][1];
				
					temp.put(key, value);
				} catch (NullPointerException ex) {
					System.out.println("Index is " + i);
					System.out.println("Key is " + key);
					System.err.println("NullPointerException: " + ex.getMessage());
				}
			}
		}

		hashArray = temp.getHashtabel();
		//hashArray = hashArrayTemp;
		//hash_size = hashArray.length;
		System.out.println("einde resize!");
	}
}