package booking.com;

import java.util.Arrays;

//https://www.careercup.com/question?id=5647860910522368
public class MaxGuestInHotel {
	static int findMax(int cin[], int cout[]) {
		int max = 0;
		Arrays.sort(cin);
		Arrays.sort(cout);
		int n = cin.length;
		int i = 1, j = 0;
		int count = 1;
		int day = cin[i];
		while ((i < n) && (j < n)) {
			if (cin[i] <= cout[j]) {
				count++;
				if (count > max) {
					max = count;
					day = cin[i];
				}
				i++;
			} else {
				count--;
				j++;
			}
		}
		System.out.println("Day is : " + day);
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cin[] = { 1, 2, 10, 5, 5 }; // CheckIN
		int cout[] = { 4, 5, 12, 9, 12 }; // CheckOut
		System.out.println("Max users on the day : " + findMax(cin, cout));
	}

}
