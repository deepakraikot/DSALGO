package booking.com;

import java.util.Arrays;
import java.util.Scanner;

/*Given the following list of objects {user, loginTime, logoutTime}. What is the maximum number of concurrent users logged in at the same time?

Input:
[
  {user: A, login: 1, logout: 3},
  {user: B, login: 3, logout: 4},
  {user: C, login: 1, logout: 2},
  {user: D, login: 123123123, logout: 987987987},
  {user: E, login: 1, logout: 3}
]

Output:
3  */
public class MaxConcurrentUsers {
	static class User {
		String user;
		int login;
		int logout;

		User(String user, int login, int logout) {
			this.user = user;
			this.login = login;
			this.logout = logout;
		}
	}

	static int maxConcurrent(User input[], int count) {
		int max = 1;
		int lin[] = new int[count];
		int lout[] = new int[count];
		for (int i = 0; i < count; i++) {
			lin[i] = input[i].login;
			lout[i] = input[i].logout;
		}
		Arrays.sort(lin);
		Arrays.sort(lout);
		int i = 1, j = 0;
		int c = 1;
		while ((i < count) && (j < count)) {
			if (lin[i] <= lout[j]) {
				c++;
				if (c > max)
					max = c;
				i++;
			} else {
				j++;
				c--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = 5;
		User input[] = new User[count];
		for (int i = 0; i < count; i++) {
			input[i] = new User(sc.next(), sc.nextInt(), sc.nextInt());
		}
		System.out.println(maxConcurrent(input, count));
		sc.close();
	}

}
