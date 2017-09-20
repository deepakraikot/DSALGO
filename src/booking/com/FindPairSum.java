package booking.com;

//Identify whether there exists a pair of numbers in an array such that their sum is equal to N
import java.util.HashMap;

public class FindPairSum {
	static int findPairSum(int arr[], int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i]) + 1);
		}
		int twice_count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.get(sum - arr[i]) != null) {
				twice_count++;
				System.out.println(arr[i] + " " + (sum - arr[i]));
			}
			if (sum - arr[i] == arr[i])
				twice_count--;
		}
		return twice_count / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 5, 7, -1, 5 };
		int sum = 6;
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println("Sum : " + sum);
		System.out.println(findPairSum(arr, sum));
	}

}
