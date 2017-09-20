package booking.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//www.careercup.com/question?id=5664081785651200
public class CommonHotels {
	static void lookUpUsers(int users[][]) {
		Map<Integer, Integer> hotels = new HashMap<Integer, Integer>();
		for (int i = 0; i < users.length; i++) {
			int values[] = users[i];
			HashSet<Integer> uniqueVisitors = new HashSet<>();
			for (int j = 0; j < values.length; j++)
				uniqueVisitors.add(values[j]);
			for (Integer hotelId : uniqueVisitors) {
				if (hotels.get(hotelId) != null)
					hotels.put(hotelId, hotels.get(hotelId) + 1);
				else
					hotels.put(hotelId, 1);
			}
			System.out.println("Unique Visitors by Hotel ID : ");
			for (int hotelID : hotels.keySet()) {
				System.out.println("Hotel ID : " + hotelID + " Real Visitors : " + hotels.get(hotelID));
			}
			for (int hotelID : hotels.keySet()) {
				if (hotels.get(hotelID) == users.length) {
					System.out.println("Common Hotel ID : " + hotelID);
					break;
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 2, 3, 1 }, { 2, 5, 3 }, { 7, 3, 1 } };
		lookUpUsers(arr);
	}

}
