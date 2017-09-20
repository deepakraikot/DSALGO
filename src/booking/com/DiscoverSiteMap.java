package booking.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

//https://www.careercup.com/question?id=5701929771466752
public class DiscoverSiteMap {

	public static void main(String[] args) throws IOException {
		HashMap<String, String> currentPageTracker = new HashMap<String, String>();
		HashMap<String, HashSet<String>> links = new HashMap<>();
		InputStream fileIs = DiscoverSiteMap.class.getResourceAsStream("log.txt");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(fileIs))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(" ");
				// System.out.println(tokens[2] + " " + tokens[4]);
				if (!currentPageTracker.containsKey(tokens[2])) {
					currentPageTracker.put(tokens[2], tokens[4]);
				} else {
					String prevPage = currentPageTracker.get(tokens[2]);
					if (links.containsKey(prevPage)) {
						links.get(prevPage).add(tokens[4]);
					} else {
						HashSet<String> set = new HashSet<String>();
						set.add(tokens[4]);
						links.put(prevPage, set);
					}
					currentPageTracker.put(tokens[2], tokens[4]);
				}
			}
			System.out.println(links);
		}
	}
}