package booking.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Auto complete a String, using TRIE. Booking.com Question
public class AutoCompleteString {
	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;

	public AutoCompleteString() {
		root = new TrieNode();
	}

	public void insert(String word) {
		// word.toLowerCase();
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public int calculateCompleteWords() {
		return calculateCompleteWords(root);
	}

	private int calculateCompleteWords(TrieNode node) {
		if (node == null)
			return 0;
		int count = 0;
		if (node.endOfWord == true) {
			count = 1;
		}
		Iterator<Character> iterator = node.children.keySet().iterator();
		while (iterator.hasNext()) {
			Character character = iterator.next();
			count += calculateCompleteWords(node.children.get(new Character(character)));
		}
		return count;
	}

	public Set<String> findSuggestions(String word) {
		// word = word.toLowerCase();
		TrieNode node = isPrefix(word);
		if (node == null) {
			return new HashSet<>();
		}
		return findSuggestions(node, word);
	}

	private Set<String> findSuggestions(TrieNode node, String word) {
		Set<String> result = new HashSet<>();
		Iterator<Character> iterator = node.children.keySet().iterator();
		while (iterator.hasNext()) {
			Character character = iterator.next();
			if (node.children.get(character).endOfWord == true) {
				result.add(word + character.charValue() + "");
			}
			result.addAll(findSuggestions(node.children.get(character), word + character.charValue() + ""));
		}
		return result;
	}

	private TrieNode isPrefix(String word) {
		return isPrefix(word, root);
	}

	private TrieNode isPrefix(String word, TrieNode node) {
		if (word.length() == 0)
			return null;
		if (node == null)
			return null;
		char character = word.charAt(0);
		if (node.children.containsKey(new Character(character))) {
			if (word.length() == 1) {
				return node.children.get(new Character(character));
			}
			return isPrefix(word.substring(1), node.children.get(new Character(character)));
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoCompleteString obj = new AutoCompleteString();
		obj.insert("Gaurav");
		obj.insert("Gau");
		obj.insert("GauravSankhla");
		obj.insert("GauravS");
		obj.insert("Gaurav Sankhla");
		System.out.println(obj.calculateCompleteWords());
		Set<String> suggestions = obj.findSuggestions("Gau");
		for (String word : suggestions) {
			System.out.println(word);
		}
	}
}
