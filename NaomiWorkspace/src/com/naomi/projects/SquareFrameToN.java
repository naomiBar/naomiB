package com.naomi.projects;

public class SquareFrameToN {

	public static void main(String[] args) {
		
		int n = 8;
		int len = 2*n-1;
		int[][] arr = creatingArray(len);
	
		arr = initializingArray(arr, len, n);
		printingArray(arr,len);
		
	}
	
	
	static int[][] creatingArray(int len) {
		int[][] arr = new int[len][len];
		return arr;
	}
	
	static int[][] initializingArray(int[][] arr, int len, int n) {
		for(int h=0; h<n;h++) {
			for (int i= h; i < len-h; i++) {
				for (int j = h; j < len-h; j++) {
					arr[i][j] = h+1;
				}
			}
		}
		return arr;
	}

	static void printingArray(int[][] arr, int len) {
		for (int i= 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	

}
