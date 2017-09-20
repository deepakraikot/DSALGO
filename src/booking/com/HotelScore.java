package booking.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/*
You have rating (0-10) of the hotels per user in this format:

scores = [
    {'hotel_id': 1001, 'user_id': 501, 'score': 7},
    {'hotel_id': 1001, 'user_id': 502, 'score': 7},
    {'hotel_id': 1001, 'user_id': 503, 'score': 7},
    {'hotel_id': 2001, 'user_id': 504, 'score': 10},
    {'hotel_id': 3001, 'user_id': 505, 'score': 5},
    {'hotel_id': 2001, 'user_id': 506, 'score': 5}
]

Any given hotel might have more than one score.

Implement a function, get_hotels(scores, min_avg_score) that returns a list of hotel ids that have average score equal to or higher than min_avg_score.

get_hotels(scores, 5) -> [1001, 2001, 3001]
get_hotels(scores, 7) -> [1001, 2001]
*/
public class HotelScore {
	static class Hotel {
		int hotel_id;
		int user_id;
		int score;

		Hotel(int hotel_id, int user_id, int score) {
			this.hotel_id = hotel_id;
			this.user_id = user_id;
			this.score = score;
		}
	}

	static void getScores(Hotel hotels[], int min_avg_score) {
		HashMap<Integer, Integer> scoreCount = new HashMap<>();
		for (Hotel h : hotels) {
			if (scoreCount.containsKey(h.hotel_id)) {
				int avg = (scoreCount.get(h.hotel_id) + h.score) / 2;
				scoreCount.put(h.hotel_id, avg);
			} else
				scoreCount.put(h.hotel_id, h.score);
		}
		TreeSet<Integer> ts = new TreeSet<>();
		for (Map.Entry<Integer, Integer> map : scoreCount.entrySet()) {
			if (map.getValue() >= min_avg_score)
				ts.add(map.getKey());
			// System.out.print(map.getKey() + " ");
		}
		System.out.println(ts);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = 6;
		Hotel hotels[] = new Hotel[count];
		for (int i = 0; i < count; i++) {
			hotels[i] = new Hotel(sc.nextInt(), sc.nextInt(), sc.nextInt());
			// hotels[i].hotel_id = sc.nextInt();
			// hotels[i].user_id = sc.nextInt();
			// hotels[i].score = sc.nextInt();
		}
		getScores(hotels, 5);
		getScores(hotels, 7);
		sc.close();
	}

}
