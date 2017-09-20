package booking.com;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//File containing n words. Given a word w, and a number k. Find k words that occur before w in a file.
//https://www.careercup.com/question?id=5147882054221824
public class WordOccurence {
	static void printKwords(List<String> words, String w, int k) {
		Deque<String> q = new LinkedList<>();
		int i = 0;
		while (i < words.size()) {
			if (q.size() <= k && words.get(i) != w)
				q.addLast(words.get(i));
			else if (words.get(i) == w) {
				if (q.size() > k)
					q.removeFirst();
				q.addLast(w);
				break;
			} else {
				q.removeFirst();
				q.addLast(words.get(i));
			}
			i++;
		}
		while (!q.isEmpty()) {
			System.out.print(q.poll() + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] a = { "aaa", "bbb", "ccc", "booking", "alpha", "beta", "gamma" };
		List<String> words = Arrays.asList(a);
		String w = "booking";
		int k = 2;
		printKwords(words, w, k);
	}

}
