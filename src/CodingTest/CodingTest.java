package CodingTest;

import java.util.HashMap;

public class CodingTest {

	public static void main(String args[]) {
		System.out.println("This is rough stuff");
		String test1 = encode("aaaaaahhaazz");
		
		System.out.println(test1);
		
		String test2 = "aaaabbbz)(%(fmzz";
		track(test2);
	}
	
	public static String encode(String x) {
		//if character is between ascii codes 097 - 122 or 065 - 90
		int ascii = 0;
		String returnString = "";
		
		for ( char y : x.toCharArray()) {
			ascii = y;
			//Testing if the range is in the Ascii table
			if( (ascii >= 97 && ascii <= 122) || (ascii >= 65 && ascii <= 90)) {
				if( (ascii >= 97 && ascii <= 122) ) {
					ascii = (122 - ascii) + 97;
				}else{
					ascii = (90 - ascii) + 65;
				}
			}
			//append to string
			returnString = returnString + (char)ascii;
		}
		return returnString;
	}
	
	public static void track(String x) {
		//take string and feed it into a hashmap, the hashmap keeps the occurence and then spits it out 
		HashMap<Character, Integer> tracker= new HashMap<>();
		char track = 'e';
		int ascii = 0;
		
		for(int i = 0; i < 26; i++) {
			System.out.println((char)(i+97));
			//insert the characters of the alphabet
			tracker.put((char)(i+97),0);
		}
		
		for(int i = 0; i < x.length(); i++) {
			ascii = (int)x.charAt(i);
			if( (ascii >= 97 && ascii <= 122) || (ascii >= 65 && ascii <= 90)) {
				track = Character.toLowerCase( x.charAt(i) );
				tracker.put( track, tracker.get(track) + 1 ); 
			}
			//System.out.println( x.charAt(i) + " what " + (tracker.get(x.charAt(i)) +1) );
		}
		
		tracker.entrySet().forEach(entry ->{
			System.out.println(entry.getKey() + " " + entry.getValue());
		});
		
	}
}
