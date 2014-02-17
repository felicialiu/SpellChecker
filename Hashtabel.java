import java.util.*;
import java.io.*;

// import java.long.*;

public class Hashtabel {
	public static void main(String[] args) {
		Compressable func = new Division(100);
		Hashtabel test = new Hashtabel(100, func);
		System.out.println(test.size());
		String key = "hallo";
		System.out.println(func.calcIndex(key));
		test.put(key, "a");
		test.put(key, "value1");
		test.put(key, "value2");
		/*
		for(int i = 0; i < test.size(); i++) {
			if(test.getHashtabel()[i] == null) {
				System.out.println("Empty! In index " + i);
			} else {
				System.out.print("Index " + i + " contains key " + test.getHashtabel()[i].getKey());
			}
		}
		System.out.println("done");
		*/
		System.out.println(test.get(key));
		System.out.println(test.get("aap"));
	}
	// Hashtabel actual array // liever linked-list gebruiken
	Linkedlist[] hashArray;

	// Load factor of the hash table, automatically on 0.75 since it's a
	// good load_factor
	private double load_factor = 0.75;

	// intitial size of the hash table
	private int hash_size;

	private Compressable function;

	// Constructor that creates the hash table object
	public Hashtabel(int size, Compressable hashfunc) {
		hash_size = size;
		hashArray = new Linkedlist[hash_size]; //new Linkedlist(key, value);
		function = hashfunc;
	}

	public Linkedlist[] getHashtabel() {
		return hashArray;
	}

	// Maps the specified key to the specified value in the hashtable
	public void put(String key, String value) {
		// System.out.println("Entering put function Hashtabel");
		int index = function.calcIndex(key);// function(key);// .calcIndex(key);
		// System.out.println("Put at index " + index);
		
		// System.out.println("Before entering if loop " + hashArray[index].getKey());
		if (hashArray[index] == null) {
			hashArray[index] = new Linkedlist(key, value);
			// System.out.println("If loop value " + hashArray[index].getKey());
		} else {
			Linkedlist currentNode = hashArray[index];
			while(currentNode.getKey() != key && currentNode.getNext() != null ) {
				currentNode = currentNode.getNext();
			}
			if(currentNode.getKey() == key){
				currentNode.setValue(value);
			} else{
				currentNode.setNext(new Linkedlist(key, value));
			}
			// System.out.println("While loop value " + hashArray[index].getKey());
		}
	}

	// Returns the value to which the specified key is mapped, or null
	// if the map contains no mapping for the key.
	public String get(String key) {//throws NullPointerException {
		// System.out.println("Entering get function");
		int index = function.calcIndex(key); //function(key); //.calcIndex(key);
		//int corrIndex = index;

		//try {
			//Linkedlist currentNode = hashArray[index];
			//do {
				/*if(currentNode.getKey().equals(key)) {
					return currentNode.getValue();
				} else {
					currentNode = currentNode.getNext();
				}
			}while(currentNode != null);
			return null;*/
			/*
			if (currentNode == null) {
				return null;
			} else if (currentNode.getKey().equals(key)) {
				return currentNode.getValue();
			} else {
				while(currentNode != null ){
					if (!currentNode.getKey().equals(key)) {
						currentNode = currentNode.getNext();
						corrIndex = function.calcIndex(key);
					}else{
						corrIndex = function.calcIndex(key);
						return currentNode.getValue();
					}
				}
				/*if(currentNode == null){
					return null; 
				}*/

            if (hashArray[index] == null)
                  return null;
            else {
                  Linkedlist currentNode = hashArray[index];
                  while (currentNode != null && !currentNode.getKey().equals(key))
                        currentNode = currentNode.getNext();
                  if (currentNode == null)
                        return null;
                  else
                        return currentNode.getValue();
            }
      }
	/*
		} //else if(currentNode != null) {
			//System.out.println("1e else if statement");
			if(!currentNode.getKey().equals(key)){
			System.out.println("2e if statement");
				while(!currentNode.getKey().equals(key)) {
					System.out.println("1e while statement");

					System.out.println(currentNode.getKey());
					System.out.println(key);
					Linkedlist check = currentNode.getNext();
					if(check != null){
						//corrIndex = function.calcIndex(currentNode.getNext().getKey());
						System.out.println(corrIndex);
						currentNode = currentNode.getNext();
					}else{
						return null;
					}
					//if(currentNode == null){
					//	return null;
					//}
					//corrIndex = function.calcIndex(currentNode.getkey);
				}
			//}

			return hashArray[corrIndex].getValue();
		} else {
			return null;
		}
		//return null;
					//return hashArray[corrIndex].getValue();
				
				//}
			}
			
		/*} catch (NullPointerException ex) {
			System.err.println("Caught UnsupportedOperationException: "
                           +  ex.getMessage());
			System.out.println("Index is " + index);
			System.out.println("Key is " + key);
		}*/


		/*
		if (currentNode.getKey().equals(key)) {
			return currentNode.getValue();
		} else if(!currentNode.getKey().equals(key)) {
			while(!currentNode.getKey().equals(key)) {
				currentNode = currentNode.getNext();
			}
			return currentNode.getValue();
		} else {
			return null;
		}
		*/
		//return "";
	//}

	public int size() {
		return hashArray.length;
	}
}