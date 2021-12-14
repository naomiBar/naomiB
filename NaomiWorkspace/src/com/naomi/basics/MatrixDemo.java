package com.naomi.basics;

public class MatrixDemo {

	public static void main(String[] args) {
		
		int[][] mat1 = new int[4][3];
		mat1[0][0]  = 5;
		mat1[3][2]  = 3;
		
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[i].length; j++) {
				System.out.print(mat1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
		
		
		int[][] mat2 =  {{1,1,1},{2,2},{3,3,3,3}};
		for (int[] line : mat2) {
			for (int value : line) {
				System.out.print(value);
			}
			System.out.println();
		}
		System.out.println("===============");
		
		
		int[][] mat3 = new int[4][];
		mat3[0] = new int[10];
		mat3[1] = new int[5];
		mat3[2] = new int[2];
		mat3[3] = new int[8];
		
		for (int i = 0; i < mat3.length; i++) {
			for (int j = 0; j < mat3[i].length; j++) {
				mat3[i][j] =  (int)(Math.random()*101);
				System.out.print(mat3[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");

		
		int[][] mat4 = new int[3][];
		mat4[0] = new int[]{1,2,3,4,5};
		mat4[1] = new int[]{3,6,9};
		mat4[2] = new int[2];
		
		for (int i = 0; i < mat4.length; i++) {
			for (int j = 0; j < mat4[i].length; j++) {
				System.out.print(mat4[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
	}
}
