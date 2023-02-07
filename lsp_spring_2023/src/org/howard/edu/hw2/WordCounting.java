package org.howard.edu.hw2;

import java.io.FileNotFoundException;
import org.howard.lsp.utils.FileReader;
import java.util.HashMap;

public class WordCounting {

	public static void main(String[] args) {
		String file = drive("main/java/resources/words.txt");
		
		//converting all letters to lower case so it does not count the same word as a
		//different word because of capitalization 
		file = file.toLowerCase();
		HashMap<String, Integer> product = count(file);
		
		//printing each word and how many times it occurs from the hashmap
		product.forEach((k, v) -> System.out.println(k + " : " + v));
		
	}
	
	
	public static String drive(String filePath) {
		FileReader fr = new FileReader();
		String file = null;
		
		try {
			file = fr.readToString(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}
		//returning file, which is a string
		return file;
	}
	
	  public static boolean isNumeric(final CharSequence cs) {
		          if (cs.length() == 0) {
		              return false;
		          }
		          final int sz = cs.length();
		          for (int i = 0; i < sz; i++) {
		              if (!Character.isDigit(cs.charAt(i))) {
		                  return false;
		              }
		          }
		          return true;
		     }
	
	
	public static HashMap<String, Integer> count(String file) {
		
		HashMap<String, Integer> product = new HashMap<String, Integer>();
		
		//splitting the sentences to an array of words 
		String[] wordsArr = file.split(" ", 0);
		
		
		
		//checking whether each word is longer than 3 characters, then adding it to the hashmap
		for (int i = 0; i < wordsArr.length; i++) {
			
			//check if the word is a number
			if (!isNumeric(wordsArr[i])) {
			
				if (wordsArr[i].length() > 3) {
					
					//if the word is already in the hasmap, then increment the value of the key
					if(product.containsKey(wordsArr[i])) {
						product.put(wordsArr[i], product.get(wordsArr[i])+1);
					}
					//if the word is not already in the hashmap, then add it to the hashmap
					else {
						product.put(wordsArr[i], 1);
					}
				}
			}
		
		}
		//returning product, which is a hashmap with words as keys and number as values
		return product;
	}

}
