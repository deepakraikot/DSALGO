package booking.com;

public class Repeat {
	public static void main(String args[]) {
		System.out.println(new Repeat().compress("aabbbcaghgggfg fhggssssy"));
		System.out.println(new Repeat().customCompress("aabbbcaghgggfg fhggssssy"));
	}

	public String compress(String string) {
		if (string.length() == 0)
			return "";
		return compress(string, string.charAt(0), 0);
	}

	private String compress(String string, char c, int count) {
		if (string.length() == 0)
			return c + "" + count + "";
		if (string.charAt(0) == c) {
			return compress(string.substring(1), c, count + 1);
		} else {
			if (count == 0)
				return c + "" + compress(string.substring(1));
			return c + "" + count + compress(string);
		}
	}

	public String customCompress(String str) {
		if (str.length() == 0)
			return "";
		boolean flag = false;
		int count = 1;
		String res = "";
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
				flag = true;
			} else {
				if (flag == true) {
					res = res + str.charAt(i) + String.valueOf(count);
					flag = false;
				} else
					res = res + str.charAt(i) + String.valueOf(count);
				count = 1;
			}
		}
		res = res + str.charAt(str.length() - 1) + String.valueOf(count);
		return res;
	}
}