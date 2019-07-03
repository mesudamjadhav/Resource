package com.yash.test;

public class DigonalMatrix {
	private Integer matrix[][] = {{1,2,3,4},
								  {5,6,7,8},
								  {9,10,11,12},
								  {13,14,15,16},
								  };
	
	public static void main(String args[]){
		DigonalMatrix digonalMatrix = new DigonalMatrix();
		digonalMatrix.printMatrix();
//		digonalMatrix.displayDigonalMatrix();
		digonalMatrix.circularMatrix();
		
				
	}
	
	public void displayDigonalMatrix(){
		int line = matrix.length * 2 - 1;
		int row = matrix.length;
		int col = matrix[0].length;
		int rowCounter = 0;
		int colCounter = 0;
		System.out.println("Digonal Matrix: ");
		for (int i = 0; i <= line; i++) {
			
			rowCounter = i < row ? i : row-1;
			colCounter = i < row ? 0 : colCounter + 1;
			
			for (int j = colCounter; j <= i; j++) {
				if(j>=col){
					continue;
				}
				System.out.print(matrix[rowCounter--][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public void printMatrix(){
		Integer row = matrix.length;
		Integer col = matrix[0].length;
		System.out.println("Matrix : ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void circularMatrix(){
		Integer row = matrix.length;
		Integer col = matrix[0].length;
		System.out.println("Circular Matrix : ");
		int j = 0;
		int i = 0;
		int count = 0;
		boolean flag = true;
		int n = row * col;
		int pass = 0;
		while(count < n){
		
			if(flag){
				i=j=pass;
				for (; j < col; j++) {
					count++;
					System.out.print(matrix[i][j] + "\t");
				}
				j--;
//				i++;
				System.out.println();
				for (; i < row; i++) {
					count++;
					System.out.print(matrix[i][j] + "\t");
				}
				System.out.println();
				flag = !flag;
			}else{
				col--;
				row--;
				pass++;
				i = row;
				j = col;
				for (; j > pass; j--) {
					count++;
					System.out.print(matrix[i][j] + "\t");
				}
				System.out.println();
				for (; i > pass; i--) {
					count++;
					System.out.print(matrix[i][j] + "\t");
				}
				flag = !flag;
				System.out.println();
			}
		}
		
		System.out.println();
	}
	
}
