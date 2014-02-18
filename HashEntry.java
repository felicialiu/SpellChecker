/*
 * Assignment 2 - Datastructuren
 * Names: Felicia Liu & Jonas van Oenen
 * Student numbers: 6385842 & 10670947
 * Date: 18 February 2014
 */

public class HashEntry {
	private String key;
	private String value;

	HashEntry(String key, String value) {
	      this.key = key;
	      this.value = value;
	}     

	public String getKey() {
	      return key;
	}

	public String getValue() {
	      return value;
	}
}