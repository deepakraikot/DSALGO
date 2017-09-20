package booking.com;

/* shift an array to the right by n positions such that the right most indexes are become the first ones and the first ones move ahead.
like:
1 2 3 4 5 --> shift by 2 --> 4 5 1 2 3 */
//http://www.geeksforgeeks.org/array-rotation/
public class ShiftArray {
	// Time Complexity - O(n*d) , Space O(1)
	static void rightRotate(int arr[], int d, int n) {
		int i;
		for (i = 0; i < d; i++) {
			rightRotateOne(arr, n);
		}
	}

	static void rightRotateOne(int arr[], int n) {
		int i, temp;
		temp = arr[n - 1];
		for (i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[i] = temp;
	}

	// Rotate by using gcd, O(n) time complexity and O(1) space complexity
	static void rightRotateGCD(int arr[], int d, int n) {
		int i, j, k, temp;
		for (i = 0; i < gcd(d, n); i++) {
			j = n - i - 1;
			temp = arr[j];
			while (true) {
				k = j - d;
				if (k < 0)
					k = k + n;
				if (k == (n - i - 1))
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int arr2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int k = 3;
		System.out.print("Original Array : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		rightRotate(arr, k, arr.length);
		System.out.print("\nAfter rotation by " + k + " positions : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.print("\nWith GCD Method : ");
		rightRotateGCD(arr2, k, arr2.length);
		for (int i : arr2) {
			System.out.print(i + " ");
		}
	}

}
