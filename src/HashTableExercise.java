/* Created by: Weng Lam Sio
 * Date: 10/18/2016
 */

import java.util.Hashtable;
import java.util.Map;

/////////////////////Reverse Counter///////////////// 
//Group the characters by frequency

/*
INPUT :
    "aabbccddddef"

OUTPUT:
    //Order doesn't matter
    {
        1: ['e', 'f'],          //Order doesn't matter
        2: ['a', 'b', 'c'],
        4: ['d']
    }
*/
public class HashTableExercise {
    public static void main(String[] args) {
    	// count how many times each letter appears
    	Map<Character,Integer> output = reverseCounter("aabbccddddef");
    	// group the letters with the same counter together
    	Map<Integer,String> newOutput = counterAsKey(output);
    	// print out the hash table
    	printHashTable(newOutput);
    }
    
	public static Map<Character,Integer> reverseCounter(String input) {		
		// create a hash table with letter as key and counter as value
		Map<Character,Integer> output = new Hashtable<Character,Integer>();  
	    
	    // counter
	    int count = 0;
	    
	    // check every single letter in the string
	    for(int i = 0; i < input.length() ; i++){
	    	// the i letter of the string
	        char c = input.charAt(i);
        	
	        // if the hash table contains the letter
	        if(output.containsKey(c)){
	        	// add 1 to the counter
	            count = output.get(c) + 1;
	            // associate the counter with the letter
	            output.put(c, count);
	        }       
	        // else if the hash table do not contains the letter
	        else{
	        	// this is the first time the letter appears
	        	count = 1;
	        	// associate the counter 1 with the letter
	        	output.put(c, count);
	        }
	    }
	    return output;
	}
	
	public static Map<Integer,String> counterAsKey(Map<Character,Integer> output) {
		// create a hash table with counter as key and combined letters as value
    	Map<Integer,String> newOutput = new Hashtable<Integer,String>(); 
    	
    	// for every entry in the previous hash table
    	for(Map.Entry oldTableEntry : output.entrySet()){
    		// the counter of the letter
    		int count = (int) oldTableEntry.getValue();    		
    		// the letter
    		char letter = (char) oldTableEntry.getKey();
    		
    		// stores the current value for the counter in the new hash table
    		String combinedLetters = null;
    		combinedLetters = newOutput.get(count);
    		
    		// if this is the first time adding value into that entry
    		if(combinedLetters == null){
    			// add a single letter
    			newOutput.put(count, "'" + letter + "'");
    		}
    		// else if this is not the first time adding value into that entry
    		else{
    			// combine the current value and the new add-on letter
    			newOutput.put(count, combinedLetters + ", '" + letter + "'");    			
    		}
    	}  
    	return newOutput;
	}
	
	public static void printHashTable(Map<Integer,String> newOutput) {
		// counter for for loop iteration
    	int iteration = 1;
    	
    	// for every entry in the new hash table
    	for(Map.Entry newTableEntry : newOutput.entrySet()){
    		// the counter of the letter
    		int count = (int) newTableEntry.getKey(); 		
    		// the letters
    		String letters = (String) newTableEntry.getValue();   

    		// print out each key with its value
    		System.out.print(count + ": [" + letters + "]");
    		
    		// if there's next iteration
    		if(iteration < newOutput.size()){
    			System.out.println(",");    
    		}
    		iteration++;
    	}    	
	}
}
 