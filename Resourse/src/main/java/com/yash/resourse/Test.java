package com.yash.resourse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test  {

	private Integer count = 1;
	private Set<String> set = new HashSet<>();
	public void fibonacy(Integer first,Integer second,Integer n){
		Integer third = first + second;
		System.out.print(third+" ");
		if(n==0)
			return;
		fibonacy(second, third, n-1);
	}
	
	public void printNonRepetableCharacter(String str){
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> map1 = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(!map.containsKey(c) && !map1.containsKey(c)){
				map.put(c, 1);
				map1.put(c,1);
			}else{
				map1.put(c, map1.get(c)+1);
				if(map1.get(c)==2){
					map.remove(c);
				}
			}
		}
		System.out.println(map.keySet());
	}
	
	public void combinationsOfString(String s){
		
		for (int i = 1; i < s.length(); i++) {
				char [] arr = s.toCharArray();
//				if(i==1)
//					replaceChar(arr);
//				else{
					char temp = arr[i];
					arr[i] = arr[0];
					arr[0] = temp;
					replaceChar(arr);
//				}
		}
	}

	
	public void replaceChar(char [] arr){
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length-1; j++) {
				char [] arr1 = arr;
				char temp = arr1[i];
				arr1[i] = arr1[j];
				arr1[j] = temp;
				System.out.print(count++ +"\t");
				System.out.print(set.add(arr1.toString()) +"\t");
				System.out.println(arr1);
			}
		}
	}
	
	public static void main(String args[]) {
		
		Test test = new Test();
		test.combinationsOfString("ABC");
		
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.stream().forEach(e -> System.out.println(e));
	} 
	
}

