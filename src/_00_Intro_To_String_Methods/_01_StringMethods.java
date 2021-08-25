package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        if (s1.length() > s2.length()) {
        	return s1;
        }
    	return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	String str = "";
    	String newStr = "";
        for (int i = 0; i < s.length(); i++) {
        	str = str + s.charAt(i);
        	if (str.length() == 12) {
        		for (int j = 0; j < 11; j++) {
        			newStr = newStr + str.charAt(j+1);
        		}
        		str = newStr;
        		newStr = "";
        	}
        	if (str.equals("underscores")) {
        		str = "";
        		for (int j = 0; j < s.length(); j++) {
        			if (s.charAt(j) == ' ') {
        				str = str + "_";
        			}else {
        				str = str + s.charAt(j);
        			}
        		}
        		return str;
        	}
        }
    	return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	boolean isSpaced = false;
    	boolean isFirst = false;
    	char str1 = ' ';
    	String str2 = "";
    	String str = "";
    	for (int i = 0; i < s1.length(); i++) {
    		if (s1.charAt(i) == ' ') {
    			if (isFirst == true) {
    				isSpaced = true;
    				str = str + s1.charAt(i);
    			}
    		}else {
    			str = str + s1.charAt(i);
    			isFirst = true;
    			if (isSpaced == true) {
    				str1 = s1.charAt(i);
    				str2 = str;
    			}
    		}
    	}
    	
    	isSpaced = false;
    	isFirst = false;
    	str = "";
    	for (int i = 0; i < s2.length(); i++) {
    		if (s2.charAt(i) == ' ') {
    			if (isFirst == true) {
    				isSpaced = true;
    				str = str + s2.charAt(i);
    			}
    		}else {
    			isFirst = true;
    			str = str + s2.charAt(i);
    			if (isSpaced == true) {
    				if (s2.charAt(i) < str1) {
    					str1 = s2.charAt(i);
        				str2 = str;
    				}
    			}
    		}
    	}
    	isSpaced = false;
    	isFirst = false;
    	str = "";
    	for (int i = 0; i < s3.length(); i++) {
    		if (s3.charAt(i) == ' ') {
    			if (isFirst == true) {
    				str = str + s3.charAt(i);
    				isSpaced = true;
    			}
    		}else {
    			isFirst = true;
    			str = str + s3.charAt(i);
    			if (isSpaced == true) {
    				if (s3.charAt(i) < str1) {
    					str1 = s3.charAt(i);
        				str2 = str;
    				}
    			}
    		}
    	}
        return str2;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int total = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (Character.isDigit(s.charAt(i))) {
    			total += Character.getNumericValue(s.charAt(i));
    			System.out.println(total);
    		}
    	}
        return total;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
        return 0;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
        return null;
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        return null;
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
        return 0;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        return 0;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
        return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
