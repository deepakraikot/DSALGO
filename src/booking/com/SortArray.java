package booking.com;

//Sort names in such a way that each name is followed by a name which starts with last character of previous name.
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortArray {

	public static void main(String[] args) {
		String[] input = new String[] { "Luis", "Hector", "Selena", "Emmanuel", "Amish", "Pie", "Rat" };
		String[] result = new String[input.length];
		Set<Character> set = new HashSet<Character>();
		Map<Character, String> map = new HashMap<Character, String>();
		// All start char in set.

		for (String s : input) {
			char[] ch = s.toLowerCase().toCharArray();
			set.add(ch[0]);
			map.put(ch[ch.length - 1], s);

		}
		String lastWord = null;
		// Trying to find a string whose end char doesn't start a new string.So
		// that should be last.
		for (String s : input) {
			char[] ch = s.toLowerCase().toCharArray();
			if (!set.contains(ch[ch.length - 1])) {
				lastWord = s;
				break;
			}
		}

		result[result.length - 1] = lastWord;

		for (int i = result.length - 2; i >= 0; i--) {
			result[i] = map.get(result[i + 1].toLowerCase().toCharArray()[0]);

		}

		// Output

		for (String s : result) {
			System.out.print(s + " ");
		}

	}
}