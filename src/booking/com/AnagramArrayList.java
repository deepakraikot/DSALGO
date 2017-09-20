package booking.com;

/* 
 You have two lists, the first contain larger words, write a method that finds if the anagram from the second list's word in the first list's word.
 calculate the complexity of the previous function. They gave me hints and later they considered my answer as weak.    
 **/
import java.util.ArrayList;

public class AnagramArrayList {
	static final int MAX = 256;

	// This function returns true if contents
	// of arr1[] and arr2[] are same, otherwise
	// false.
	static boolean compare(char arr1[], char arr2[]) {
		for (int i = 0; i < MAX; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}

	// This function search for all permutations
	// of pat[] in txt[]
	static void search(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		// countP[]: Store count of all
		// characters of pattern
		// countTW[]: Store count of current
		// window of text
		char[] countP = new char[MAX];
		char[] countTW = new char[MAX];
		for (int i = 0; i < M; i++) {
			(countP[pat.charAt(i)])++;
			(countTW[txt.charAt(i)])++;
		}

		// Traverse through remaining characters
		// of pattern
		for (int i = M; i < N; i++) {
			// Compare counts of current window
			// of text with counts of pattern[]
			if (compare(countP, countTW)) {
				System.out.println("Pattern is : " + pat + ", Word is : " + txt);
				System.out.println("Found at Index " + (i - M));
				System.out.println();
				return;
			}

			// Add current character to current
			// window
			(countTW[txt.charAt(i)])++;

			// Remove the first character of previous
			// window
			countTW[txt.charAt(i - M)]--;
		}

		// Check for the last window in text
		if (compare(countP, countTW)) {
			System.out.println("Pattern is : " + pat + ", Word is : " + txt);
			System.out.println("Found at Index " + (N - M));
			System.out.println();
		}
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		list1.add("Dentist");
		list1.add("Engineer");
		list1.add("Bangalore");
		list2.add("er");
		list2.add("en");
		list2.add("ist");
		for (String pat : list2) {
			for (String mat : list1) {
				search(pat, mat);
			}
		}
		// String txt = "Dentist";
		// String pat = "ist";
		// search(pat, txt);
	}
}