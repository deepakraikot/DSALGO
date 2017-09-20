package booking.com;

//http://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
public class GetMinSquares {
	static int getMinSquares(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= n; i++) {
			// max value is i as i can always be represented
			// as 1*1 + 1*1 + ...
			dp[i] = i;
			for (int x = 1; x <= i; x++) {
				int temp = x * x;
				if (temp > i)
					break;
				else
					dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
			}
		}
		int res = dp[n];
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 121;
		System.out.println(getMinSquares(n));
	}

}
