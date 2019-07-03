package com.yash.test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReversEachWordOfString {

	public String reversString(String str){
		StringBuilder returnString = new StringBuilder(str);
		returnString = returnString.reverse();
		return returnString.toString();
	}
	
	public String reversWord(String str){
		String [] array = str.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append(" " + reversString(array[i]));
		}
		return builder.toString();
	}
	
	protected Number show() throws ArrayIndexOutOfBoundsException{
		try (FileInputStream fis = new FileInputStream("")){
			
		} catch (IOException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
			if(e instanceof IOException){
				
			}else{
				
			}
		}
		return null;
	}
	
	public static void main(String args[]){
		ReversEachWordOfString eachWordOfString = new ReversEachWordOfString();
		System.out.println(eachWordOfString.reversWord("Thanks for coming YASH"));
	}
}
