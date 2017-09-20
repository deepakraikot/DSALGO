package booking.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Sort the content of a file based on second field.
class Employee implements Comparator<Employee> {
	String name;
	int age;
	char gender;

	Employee(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	Employee() {
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		if (e1.age < e2.age)
			return -1;
		else if (e1.age > e2.age)
			return 1;
		else
			return 0;
	}

}

public class SortingFileOnContent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> e = new ArrayList<>();
		Employee e1 = new Employee("Jervie", 12, 'M');
		Employee e2 = new Employee("Jaimy", 11, 'F');
		Employee e3 = new Employee("Tony", 23, 'M');
		Employee e4 = new Employee("Janey", 11, 'F');
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		Collections.sort(e, new Employee());
		for (Employee obj : e) {
			System.out.println("Name : " + obj.name + " Age : " + obj.age + " Gender : " + obj.gender);
		}
	}

}
