package com.yash.test;

public class FindGretestNumberFromAlphaNumStr {
	
	public Integer numberListFromString(String str){
		
		Integer length = str.length();
		StringBuilder builder = new StringBuilder();
		Integer maxNumber = 0;
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				builder.append(str.charAt(i));
			}else if(!builder.toString().isEmpty()){
				Integer number = Integer.parseInt(builder.toString());
				builder = new StringBuilder();
				if(maxNumber < number){
					maxNumber = number;
				}
			}
		}
		if(!builder.toString().isEmpty()){
			Integer number = Integer.parseInt(builder.toString());
			builder = new StringBuilder();
			if(maxNumber < number){
				maxNumber = number;
			}
		}
		
		return maxNumber;
	}
	
	
	public static void main(String args[]){
		FindGretestNumberFromAlphaNumStr alphaNumStr = new FindGretestNumberFromAlphaNumStr();
		
		System.out.println(alphaNumStr.numberListFromString("abcd123bdtgsj0854ghs4587"));
	}
}
