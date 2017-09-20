package booking.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*Given any number of arrays containing numbers, write a function which
finds the numbers that appear in exactly two arrays.
arrays=[[6,2,2,0,4],[5,0,2,6,7,1],[6,7,9,9],] */
//In below solution we can user a extra class instead of HashSet. It will contain row and count of that variable.
public class NumInTwoArrays {
	static ArrayList findInTwo(ArrayList<ArrayList<Integer>> input) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (ArrayList<Integer> list : input) {
			HashSet<Integer> temp = new HashSet<>();
			temp.addAll(list);
			for (Integer i : temp) {
				if (!map.containsKey(i))
					map.put(i, 1);
				else
					map.put(i, map.get(i) + 1);
			}
		}
		for (Map.Entry<Integer, Integer> temp2 : map.entrySet()) {
			if (temp2.getValue() == 2)
				result.add(temp2.getKey());
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int arr[][] = { { 6, 2, 2, 0, 4 }, { 5, 0, 2, 6, 7, 1 }, { 6, 7, 9, 9
		// } };
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(6, 2, 2, 0, 4)));
		list.add(new ArrayList<>(Arrays.asList(5, 0, 2, 6, 7, 1)));
		list.add(new ArrayList<>(Arrays.asList(6, 7, 9, 9)));
		ArrayList<Integer> result = findInTwo(list);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}

}
