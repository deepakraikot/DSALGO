package booking.com;

//http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
import java.util.HashMap;

public class AnagramPatternSearch {

	public static boolean findAnagram(String s, String p) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0;
		for (int i = 0; i < p.length(); i++) {
			if (hm.containsKey(p.charAt(i)))
				hm.put(p.charAt(i), hm.get(p.charAt(i)) + 1);
			else
				hm.put(p.charAt(i), 1);
			if (map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), hm.get(i) + 1);
			else
				map.put(s.charAt(i), 1);
		}
		end = p.length() - 1;
		boolean ana = false;
		while (end < s.length()) {
			ana = isAnagram(hm, map);
			// System.out.println(map);
			if (ana == false) {
				if (map.get(s.charAt(start)) > 1)
					map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
				else
					map.remove(s.charAt(start));
				start++;
				end++;
				if (map.containsKey(s.charAt(end))) {
					map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
				} else
					map.put(s.charAt(end), 1);
			} else {
				System.out.println("String found, Start : " + start + " end : " + end);
				return true;
			}
		}
		return false;

	}

	static boolean isAnagram(HashMap<Character, Integer> hm, HashMap<Character, Integer> map) {
		for (Character key : hm.keySet()) {
			if (!(map.containsKey(key) && hm.get(key) == map.get(key)))
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Engineer";
		String p = "eer";
		System.out.println(s);
		System.out.println(p);
		System.out.println(findAnagram(s, p));
	}

}
