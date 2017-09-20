package booking.com;

//For Unsorted - http://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
public class IntersectionUnionSortedArrays {
	static void findIntersection(int arr[], int arr2[]) {
		int m = arr.length;
		int n = arr2.length;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (arr[i] < arr2[j])
				i++;
			else if (arr[i] > arr2[j])
				j++;
			else {
				System.out.print(arr[i++] + " ");
				j++;
			}
		}
	}

	static void findUnion(int arr[], int arr2[]) {
		int m = arr.length;
		int n = arr2.length;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (arr[i] < arr2[j])
				System.out.print(arr[i++] + " ");
			else if (arr2[j] < arr[i])
				System.out.print(arr2[j++] + " ");
			else {
				System.out.print(arr[i++] + " ");
				j++;
			}
		}
		while (i < m)
			System.out.print(arr[i++] + " ");
		while (j < n)
			System.out.print(arr2[j++] + " ");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = { 1, 2, 4, 5, 6 };
		int arr2[] = { 2, 3, 5, 7 };
		findIntersection(arr1, arr2);
		System.out.println();
		findUnion(arr1, arr2);

	}

}
// O(m+n)
