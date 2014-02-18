/*
 * Assignment 2 - Datastructuren
 * Names: Felicia Liu & Jonas van Oenen
 * Student numbers: 6385842 & 10670947
 * Date: 18 February 2014
 */

import java.util.*;
import java.io.*;
/*
 * This class uses the datastructure of a hash table using open addressing with
 * linear probing. It uses the class HashtableLinear.
 */
class SpellLinearProbing {
    public static void main(String[] args) {
        int hash_size;
        int words = 0;
        int count = 0, typo = 0;
        long start = 0, end = 0;
        String wordfile, textfile;
        HashtabelLinear table;

        /* Shared token to store for every word in the hash table. */
        String placeholder = "a";

        if (!(args.length == 3) ) {
            System.out.println("Usage: java SpellChecker <wordfile> <text> <size>");
            System.exit(0);
        }
        wordfile = args[0];
        textfile = args[1];
        hash_size = Integer.parseInt(args[2]);
        Compressable function = new Division(hash_size);
        System.out.printf("Selected table size: %d\n", hash_size);
        table = new HashtabelLinear(hash_size, function); // table = new Hashtable<String, String>(hash_size);
       
        /* Read wordfile, and insert every word into the hash table. */
        try {
            BufferedReader in = new BufferedReader(new FileReader(wordfile));
            start = System.currentTimeMillis();
            String str, copy;
            while ((str = in.readLine()) != null) {
                copy = str.toLowerCase();
                table.put(copy, placeholder);
                words++;
            }
            end = System.currentTimeMillis();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("java opbouwen Hashtable in " + (end - start) + " ms");

        // Read text file, and lookup every word in the hash table.
        try {
            BufferedReader src = new BufferedReader(new FileReader(textfile));
            start = System.currentTimeMillis();
            String str = src.readLine();
            while (str != null) {
                String copy = str.toLowerCase();

                StringTokenizer st = new StringTokenizer(copy, " ,.:;\"-_(){}[]?!*^&'\n\t");
                while(st.hasMoreTokens()) {
                    String word = st.nextToken();
                    if (!contains_numbers(word) && table.get(word) == null) {
                        //System.out.printf("Not found: [%s]\n", word);
                        typo++;
                    }
                    count++;
                }
                str = src.readLine();
            }
            end = System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // System.out.printf("Hash table contains %d entries\n", table.size());
        System.out.printf("Hash table contains %d words\n", words);
        System.out.printf("Hash table load factor %f\n",
               (double)table.size()/hash_size);

        System.out.printf("Text contains %d words\n", count);
        System.out.printf("typo's %d\n", typo);

        System.out.println("zoeken woorden in " + (end - start) + " ms");
    }
    /* Checks is word contains digits. So it can be ignored for spell
     * checking. */
    static boolean contains_numbers(String str) {
        for (int i = 0 ; i < str.length() ; i++) 
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') 
                return true;

        return false;
    }
}