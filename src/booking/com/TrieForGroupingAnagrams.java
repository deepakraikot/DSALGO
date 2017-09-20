package booking.com;

//http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TrieForGroupingAnagrams {
	final static int ALPHABET_SIZE = 26;

	class TrieNode {
		ArrayList<Integer> anagramIndices;
		TrieNode[] children;

		TrieNode() {
			children = new TrieNode[ALPHABET_SIZE];
			this.anagramIndices = new ArrayList();
		}
	}

	TrieNode root;

	public TrieForGroupingAnagrams() {
		this.root = new TrieNode();
	}

	private int getIndex(char ch) {
		return ch - 'a';
	}

	private void insertIntoTrie(String key, int index, HashMap anagramNode) {
		if (key == null)
			return;
		key = key.toLowerCase();
		TrieNode currentNode = this.root;
		int charIndex = 0;
		while (charIndex < key.length()) {
			int childIndex = getIndex(key.charAt(charIndex));
			if (childIndex < 0 || childIndex >= ALPHABET_SIZE) {
				System.out.println("Invalid Key");
				return;
			}
			if (currentNode.children[childIndex] == null) {
				currentNode.children[childIndex] = new TrieNode();
			}
			currentNode = currentNode.children[childIndex];
			charIndex += 1;
		}
		if (charIndex == key.length()) {
			currentNode.anagramIndices.add(index);
			anagramNode.put(currentNode, currentNode.anagramIndices);
		}
		return;
	}

	public void printGroupAnagrams(String[] sequence) {
		HashMap<TrieNode, ArrayList<Integer>> anagramNodes = new HashMap();
		for (int i = 0; i < sequence.length; i++) {
			char[] charSequence = sequence[i].toCharArray();
			Arrays.sort(charSequence);

			insertIntoTrie(new String(charSequence), i, anagramNodes);
		}
		Iterator<ArrayList<Integer>> mapItr = anagramNodes.values().iterator();
		while (mapItr.hasNext()) {
			ArrayList<Integer> currentAnagramList = mapItr.next();
			for (int j = 0; j < currentAnagramList.size(); j++) {
				int indexForSequence = currentAnagramList.get(j);
				System.out.print(" " + sequence[indexForSequence]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieForGroupingAnagrams obj = new TrieForGroupingAnagrams();
		String[] sequence = { "car", "ape", "meal", "pea", "male", "arc", "lame", "dog" };
		obj.printGroupAnagrams(sequence);
	}

}
/*
 * Time Complexity is O(m.nlogn) where m is total number of words in given
 * sequence and n is the average length of each word in given sequence. Space
 * Complexity is Worst case : O(m*n)
 */