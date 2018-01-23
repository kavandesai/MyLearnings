package learning;

public class Anagrams {

	public boolean isAnagram(String firstString, String secondString) {
		int[] a = new int [256];
		if (firstString.length() != secondString.length()) {
			return false;
		}
		for (int i=0,j = 0;i<firstString.length();i++,j++) {
			a[(int)firstString.charAt(i)] = ++a[(int)firstString.charAt(i)];
			a[(int)secondString.charAt(j)] = --a[(int)secondString.charAt(j)];
		}
		
		for (int i=0;i<a.length;i++) {
			if (a[i] !=0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] args) {
		Anagrams a = new Anagrams();
		boolean isAnagram = a.isAnagram("aaxx", "xxaa");
		System.out.println("Output "+isAnagram);
	}
}
