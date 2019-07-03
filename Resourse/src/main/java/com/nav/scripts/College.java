package com.nav.scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class College {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> student = new ArrayList<>();

		Address a1 = new Address(101, "magarpatta");
		Address a2 = new Address(101, "hinjewadi");
		Address a3 = new Address(101, "hadapsar");

		Student s1 = new Student(1, "naveen", a1);
		Student s2 = new Student(3, "praveen", a2);
		Student s3 = new Student(2, "adam", a3);

		student.add(s1);
		student.add(s2);
		student.add(s3);
		Collections.sort(student);

			System.out.println(student);
	}

}
