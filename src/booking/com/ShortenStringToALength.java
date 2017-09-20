package booking.com;

//Shorted string to a specified length without cutting words.
public class ShortenStringToALength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String yourString = "Featuring stylish rooms and moornings for recreation boats, Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ River in Amsterdam."; // replace
		// with
		// your
		// string.
		int maxLength = 30; // maximum number of characters to extract

		// trim the string to the maximum length
		String trimmedString = yourString.substring(0, maxLength);

		// re-trim if we are in the middle of a word
		trimmedString = trimmedString.substring(0, Math.min(trimmedString.length(), trimmedString.lastIndexOf(" ")));
		System.out.println(trimmedString);
	}

}
