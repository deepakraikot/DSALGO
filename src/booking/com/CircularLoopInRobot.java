package booking.com;

import java.util.HashMap;

//Sequence of robot moves and find circular loops in given moves sequence. sequence = "<<>>>>^v^v>><<" ,

// < WEST, > EAST, ^ NORTH, v SOUTH. ^v this is a circular loop. find all such loops in a moves sequence.  

public class CircularLoopInRobot {
	static int countLoops(String sequence) {
		int count = 0;
		HashMap<Character, Character> moves = new HashMap<>();
		moves.put('<', ' ');
		moves.put('>', ' ');
		moves.put('^', 'v');
		moves.put('v', '^');
		char curr;
		char last = sequence.charAt(0);
		for (int i = 1; i < sequence.length(); i++) {
			curr = sequence.charAt(i);
			if (moves.get(curr) == last)
				count++;
			last = curr;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sequence = "<<>>>>^v^v>><<";
		System.out.println(countLoops(sequence));
	}

}
