package com.yash.test;

import java.util.Scanner;

public class Lift {

//	private Integer floors;
//
//	private List<Integer> callFromFloors;

	private Integer currentPosition;

	private Scanner scanner = new Scanner(System.in);

	public Integer getCall() {
		return scanner.nextInt();
	}

	public void openDoore(){
		System.out.println("Door Open");
	}
	
	
	public void setCurrentPosition(Integer currentPosition){
		this.currentPosition = currentPosition;
	}
	
	public void controller(){
		while (true) {
			System.out.println("Enter Floor No : ");
			switch (getCall()) {
			case 1:
				if (currentPosition != 1) {
					if(currentPosition > 1){
						
					}
				}
				break;

			case 2:

				break;

			case 3:

				break;
			case 4:

				break;
			case 5:

				break;

			case 6:

				break;
			case 7:

				break;
				
			default:
				break;
			}
		}

	}
	
	public static void main(String[] args) {
//		Lift lift = new Lift();
	}

}
