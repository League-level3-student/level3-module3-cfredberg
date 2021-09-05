package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	String s1 = "";
    	for (char chr:characters) {
    		s1 = s1 + chr;
    	}
    	s1 = str + s1;
    	System.out.println(s1);
        return s1;
    }
    
    public static String reverse(String str) {
    	String s1 = "";
    	for (char chr:str.toCharArray()) {
    		s1 = chr + s1;
    	}
        return s1;
    }
    
    public static String insert(String str, int index, char newChar) {
        return null;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
        return null;
    }
}