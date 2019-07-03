package com.yash.test;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
	class Inner{
		public void m3(){
			System.out.println("m3 inner class called");
		}
	}
	public void m1(){
		class Local{
			public void m2(){
				System.out.println("m2 local called");
			System.out.println(Local.class.isLocalClass());
			}
		}new Local().m2();
	}

	
	List<Integer> integers = new ArrayList<>();

	public BubbleSort() {
		integers.add(10);
		integers.add(21);
		integers.add(31);
		integers.add(74);
		integers.add(55);
		integers.add(62);
		integers.add(71);
		integers.add(87);
		integers.add(91);
		integers.add(10);
	}
	
	public void bubbleSort(List<Integer> integers){
		
		
		for (int i = 1; i < integers.size(); i++) {
			for (int j = 0; j < integers.size()-i; j++) {
				if(integers.get(j) > integers.get(j +1)){
					Integer temp = integers.get(j);
					integers.set(j, integers.get(j+1));
					integers.set(j+1, temp);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		/*System.out.println(bubbleSort.integers);
		bubbleSort.bubbleSort(bubbleSort.integers);
		System.out.println(bubbleSort.integers);*/
		
		Inner obj = bubbleSort.new Inner();
		obj.m3();
		bubbleSort.m1();
	}

}
