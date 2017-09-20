package booking.com;

import java.util.Map;
import java.util.TreeMap;

//https://www.careercup.com/question?id=4535655694598144
public class CreateHistogram {
	static void createHistogram(String words[], int n) {
		int maxCount = 0;
		TreeMap<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				String word = words[i].toLowerCase();
				if (map.containsKey(word.charAt(j))) {
					map.put(word.charAt(j), map.get(word.charAt(j)) + 1);
					if (maxCount < map.get(word.charAt(j)))
						maxCount = map.get(word.charAt(j));
				} else
					map.put(word.charAt(j), 1);
			}
		}
		System.out.println(map);
		for (Map.Entry<Character, Integer> hm : map.entrySet()) {
			int hist = (int) (hm.getValue() * 80 / maxCount);
			for (int i = 0; i < hist; i++) {
				System.out.print("*");
			}
			System.out.print(hm.getKey());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = new String[] { "abactor", "abaculus", "abacus", "Abaditeuuu" };
		createHistogram(words, words.length);

	}

}
