package booking.com;

//Fibonacci in recursion and iteration.
public class Fibonacci {

	// T(n) = T(n-1) + T(n-2) which is exponential.
	static int fiboRecur(int n) {
		if (n <= 1)
			return n;
		return fiboRecur(n - 1) + fiboRecur(n - 2);

	}

	// O(n) time and space both.
	static int fiboDP(int n) {
		int f[] = new int[n + 1];
		int i;
		f[0] = 0;
		f[1] = 1;
		for (i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	// Time - O(n) space O(1)
	static int fiboIter(int n) {
		int a = 0, b = 1, c;
		if (n == 0)
			return a;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		// System.out.println("Recursin : " + fiboRecur(n));
		System.out.println("DP : " + fiboDP(n));
		System.out.println("Iteration : " + fiboIter(n));
	}

}
