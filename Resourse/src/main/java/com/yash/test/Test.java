package com.yash.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

	Set<String> set = new HashSet<>();

	public static void main(String[] akrgs) {

		Test test = new Test();
		test.pattern();
	}
	
	
	public void pattern(){
		int n = 20; 
		for (int i = n; i >= 0; i--) {
			for (int j = i; j <= n; j++) {
				System.out.print("*  ");
			}
			
			
			for (int j = 0; j < i; j++) {
				System.out.print("      ");
			}
			
			for (int j = i; j <= n; j++) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
		
		
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print("*  ");
			}
			
			
			for (int j = 0; j <= i; j++) {
				System.out.print("      ");
			}
			
			for (int j = i; j < n; j++) {
				System.out.print("*  ");
			}
			
			System.out.println();
		}
	}

	public void tenTable() {

		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < 100; j+=10) {
				System.out.print((i + j) + "\t");
			}
			System.out.println();
		}
	}

	public void twosTable() {

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.print((i * j) + "\t");
			}
			System.out.println();
		}
	}

	public void elevensTable() {

		for (int i = 1; i <= 10; i++) {
			for (int j = 11; j <= 20; j++) {
				System.out.print((i * j) + "\t");
			}
			System.out.println();
		}
	}

	public void twentyOnesTable() {

		for (int i = 1; i <= 10; i++) {
			for (int j = 21; j <= 30; j++) {
				System.out.print((i * j) + "\t");
			}
			System.out.println();
		}
	}
	
	public void mergeMap(Map<String, String> map1, Map<String, String> map2) {
		int keyValue = map1.size();
		String key = "";
		for (Map.Entry<String, String> e : map2.entrySet()) {
			key = e.getKey() + (++keyValue);
			if (map1.containsKey(key)) {
				key = e.getKey() + (++keyValue);
			}

			map1.put(key, e.getValue());
		}
	}

	public void permutationsOfString(String s) {

		Integer length = s.length();
		permute(s.toCharArray());
		for (int i = 1; i < length; i++) {
			char[] c = swapCaharacter(s.toCharArray(), i, 0);
			permute(c);
		}
		System.out.println(set.size());
		System.out.println(set);
	}

	public void permute(char[] c) {
		Integer length = c.length;
		set.add(new String(c));
		System.out.println(new String(c));
		for (int i = 1; i < length; i++) {
			for (int j = 2; j < length; j++) {
				String str = new String(swapCaharacter(c, i, j));
				set.add(str);
				System.out.println(str);
			}
		}

	}

	public char[] swapCaharacter(char[] s, Integer fromIndex, Integer toIndex) {
		char from = s[fromIndex];
		char to = s[toIndex];
		s[fromIndex] = to;
		s[toIndex] = from;
		return s;
	}
}
