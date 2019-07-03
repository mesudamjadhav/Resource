package com.yash.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MaxDuplicateWordCount {

	public Map<String, Integer> getWordCount(String fileName) throws IOException{
		FileInputStream fileInputStream = null;
		Scanner scanner = null;
		Map<String, Integer> wordMap = new HashMap<>();
		try {
			fileInputStream = new FileInputStream(fileName);
			scanner = new Scanner(fileInputStream);
			while (scanner.hasNext()) {
				String word = scanner.next();
				if(wordMap.containsKey(word)){
					Integer count = wordMap.get(word);
					count++;
					wordMap.put(word, count);
				}else{
					wordMap.put(word, 1);
				}
			}
		} catch (FileNotFoundException e) {
			throw e;
		}finally {
			fileInputStream.close();
			scanner.close();
		}
		return wordMap;
		
	}
	
	public List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap){
		Set<Entry<String, Integer>> set = wordMap.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(set);
		Integer length = list.size();
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				if(list.get(j).getValue() < list.get(j+1).getValue()){
					Entry<String, Integer> temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
		return list;
	}
	
	public static void main(String args[]) throws IOException{
		MaxDuplicateWordCount duplicateWordCount = new MaxDuplicateWordCount();
		Map<String, Integer> wordMap = duplicateWordCount.getWordCount("C:\\Users\\sudam.jadhav\\Desktop\\data.txt");
		System.out.println(duplicateWordCount.sortByValue(wordMap));
	}
}
