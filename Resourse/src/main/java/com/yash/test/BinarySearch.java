package com.yash.test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	List<Integer> integers = new ArrayList<>();

	public BinarySearch() {
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		integers.add(5);
		integers.add(6);
		integers.add(7);
		integers.add(8);
		integers.add(9);
		integers.add(10);
		integers.add(11);
		integers.add(12);
		integers.add(13);
		integers.add(14);
		integers.add(15);
	}

	public Integer search(List<Integer> integers, Integer item,Integer first,Integer last) {
		Integer size = (last+first) / 2;
		if (item == integers.get(0)) {
			return integers.get(0);
		} else {
			if(item != integers.get(size) && size == integers.size()-1) {
				return null;
			}
			if (item == integers.get(size)) {
				return integers.get(size);
			} else if (item < integers.get(size)) {
				return search(integers, item, first,size);
			} else if (item > integers.get(size)) {
				return search(integers, item,size,last);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.search(binarySearch.integers, 15,0,15));
	}

}
