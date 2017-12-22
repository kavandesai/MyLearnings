package learning;

import java.util.Scanner;

/*
 * Given a string str. 
 * Your task is to write a program that takes string str as input and rearrange 
 * characters of the given string such that the vowels and consonants occupy alternate
 *  position and the string so formed should be lexicographically (alphabetically) smallest.
 *  If string can not be rearranged in desired way, print “-1” (without quotes).
 */
public class VowelConsonant {
	private char vowelArray[] = {'a','e','i','o','u'};
	 
	private String transform(String str) {
		int textArray[] = new int[256];
		str = str.toLowerCase();
		char c[] = str.toCharArray();
		
		// to form such string need to minimum str.length /2 vowels if string.length % 2 = 0 
		// and maximum str.length/2 + 1 vowels if string.length %2 = 1 
		int minimumVowel = Math.floorDiv(str.length(),2); 
		for (char ch : c) {
			textArray[(int)ch] = textArray[(int)ch] + 1;
		}
		int vowelLength = 0;
		
		for (char ch : vowelArray) {
			vowelLength += textArray[(int)ch];
		}
		StringBuilder consonentString = new StringBuilder();
		StringBuilder vowelString = new StringBuilder();
		
		if (str.length()%2 == 0 && vowelLength != minimumVowel) {
			return "-1";
		} else if (str.length()%2 == 1 && 
				((vowelLength != minimumVowel) && (vowelLength != minimumVowel+1))) {
			return "-1";
		}
		// string can be transformed now formulate lexicographical transformation
		// formulate consonant only string first
				for (int ch =0 ;ch < textArray.length ; ch++) {
					if ( textArray[ch] > 0 && !isVowel(ch) ) {
						for (int i = 0; i< textArray[ch];i++) {
							consonentString.append((char)ch);
						}
					} else {
						for (int i = 0; i< textArray[ch];i++) {
							vowelString.append((char)ch);
						}
					}
				}
		
		
		StringBuilder transformedStr = new StringBuilder();
		int count = vowelString.length() >= consonentString.length() ? vowelString.length(): consonentString.length();
		for (int i =0;i<count;i++) {
			if (i<vowelString.length()) {
				transformedStr.append(vowelString.charAt(i));
			}
			if (i<consonentString.length()) {
				transformedStr.append(consonentString.charAt(i));
			}
		}
		
		return transformedStr.toString();
	}
	
	private boolean isVowel(int ch) {
		if (((char)ch) == 'a' || ((char)ch) == 'e' || ((char)ch) == 'i' || ((char)ch) == 'o' || ((char)ch) == 'u' ) {
			return true;
		}
		return false;
	}

	public static void main (String args[]) {
		VowelConsonant vc = new VowelConsonant();
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
		String [] str = new String [t];
        for (int i = 0; i < t ; i++) {
        	int length = in.nextInt();
        	 str[i] = in.next();
        }
        for (int i = 0; i < t ; i++) {
        	String output = vc.transform(str[i]);
        	System.out.println(output);
        }
    	
    	

		
	}
}