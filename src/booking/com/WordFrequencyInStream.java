package booking.com;

//Given dictionary of words, and a character stream. Find frequency of words in character stream.
//http://techieme.in/word-frequency-in-stream/
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyInStream {
	private TrieNode root;

	public WordFrequencyInStream() {
		this.root = new TrieNode(' ');
	}

	public void addWord(String word) {
		char[] cArray = word.toCharArray();
		TrieNode temp = root;
		TrieNode tn = null;
		int index = 0;

		do {
			tn = temp.children[cArray[index] - 'a'];
			if (tn != null) {
				temp = tn;
				index++;
				// if the word got over, then it is already in the trie.
				if (index >= word.length()) {
					temp.terminal = true;
					temp.word = word;
					return;
				}
			}
		} while (tn != null);

		// temp is the last node and the word to add is lengthier
		for (; index < cArray.length; index++) {
			temp.children[cArray[index] - 'a'] = new TrieNode(cArray[index]);
			temp = temp.children[cArray[index] - 'a'];
		}

		temp.terminal = true;
		temp.word = word;
	}

	public static void main(String[] args) {
		WordFrequencyInStream trie = new WordFrequencyInStream();
		trie.addWord("aca");
		trie.addWord("cat");
		trie.addWord("hell");
		trie.addWord("hello");
		trie.addWord("lock");
		trie.addWord("word");
		char[] stream = "acacathellockword".toCharArray();
		Map<String, Integer> map = new HashMap<>();

		wordMap(trie, stream, map);
		System.out.println(map);
	}

	private static void wordMap(WordFrequencyInStream T, char[] stream, Map<String, Integer> feq) {

		Deque<TrieNode> DQ = new ArrayDeque<TrieNode>();
		Deque<TrieNode> RQ = new ArrayDeque<TrieNode>();
		for (char c : stream) {
			DQ.add(T.root);
			while (!DQ.isEmpty()) {
				TrieNode first = DQ.removeFirst();
				if (first.terminal) {
					if (feq.containsKey(first.word)) {
						feq.put(first.word, feq.get(first.word) + 1);
					} else {
						feq.put(first.word, 1);
					}
				}

				TrieNode tn = first.children[c - 'a'];
				if (tn != null) {
					RQ.add(tn);
				}
			}

			DQ.addAll(RQ);
			RQ.clear();
		}
		// once the character stream ends, and the queue still has some nodes,
		// check if the nodes end in valid words and print them accordingly
		while (!DQ.isEmpty()) {
			TrieNode first = DQ.removeFirst();
			if (first.terminal) {
				System.out.println(first.word);
			}
		}
		return;
	}

}

class TrieNode {
	TrieNode[] children;
	char label;
	boolean terminal;
	String word;

	private static int ALPHABET_SIZE = 26;

	public TrieNode() {
		this.children = new TrieNode[ALPHABET_SIZE];
	}

	public TrieNode(char l) {
		this();
		this.label = l;
	}
}
