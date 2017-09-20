package booking.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
 We have a log file, can grow pretty big.
Each line is a trace-log, and the first field is the RequestID.
We need to scan the file, and print all the logs for requests which resulted in error ..

001 <timestamp> BEGIN
001 <timestamp> fetched from db
001 <timestamp> some processing ..
002 <timestamp> BEGIN ..
002 <timestamp> fetched from db
001 <timestamp> returned success
003 <timestamp> BEGIN
001 <timestamp> END
003 <timestamp> some work
002 <timestamp> ERROR
003 <timestamp> some other work  
  */
public class LogFileWithError {
	static class Log {
		int id;
		ArrayList<String> details;
		boolean flag;

		Log(int id) {
			this.id = id;
			details = new ArrayList<String>();
			flag = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		HashMap<Integer, Log> map = new HashMap<>();
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (s.contains("exit"))
				break;
			String str[] = s.split(" ");
			if (map.containsKey(Integer.valueOf(str[0]))) {
				if (str[2].contains("ERROR")) {
					Log log = map.get(Integer.valueOf(str[0]));
					log.flag = true;
					StringBuilder temp = new StringBuilder();
					for (int i = 1; i < str.length; i++)
						temp.append(" " + str[i]);
					log.details.add(temp.toString());
					map.put(Integer.valueOf(str[0]), log);
				} else {
					Log log = map.get(Integer.valueOf(str[0]));
					StringBuilder temp = new StringBuilder();
					for (int i = 1; i < str.length; i++)
						temp.append(" " + str[i]);
					log.details.add(temp.toString());
					map.put(Integer.valueOf(str[0]), log);
				}
			} else {
				Log log = new Log(Integer.valueOf(str[0]));
				StringBuilder temp = new StringBuilder();
				for (int i = 1; i < str.length; i++)
					temp.append(" " + str[i]);
				log.details.add(temp.toString());
				map.put(Integer.valueOf(str[0]), log);
			}
		}
		for (

		Map.Entry<Integer, Log> hm : map.entrySet()) {
			if (hm.getValue().flag == true) {
				for (int i = 0; i < hm.getValue().details.size(); i++) {
					System.out.println(hm.getKey() + " " + hm.getValue().details.get(i));
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
