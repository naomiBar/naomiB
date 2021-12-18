package com.naomi.exercises;

import java.util.Arrays;

public class Lab10 {

	public static void main(String[] args) {

		System.out.println("   Ex1:");
		int[] arr1 = { 1, 2, 3, 1, 2, 3, 3, 2, 1, 9, 5, 1, 1, 9 };
		int count3 = 0, count1 = 0;
		for (int i : arr1) {
			if (i == 3) {
				count3++;
			} else if (i == 1) {
				count1++;
			}
		}
		System.out.println("3 values are in the array " + count3 + " times");
		System.out.println("1 values are in the array " + count1 + " times");

		
		
		System.out.println("===============");
		System.out.println("   Ex2:");
		int[] arr2 = { 1, 2, 5, 1, 6, 1, 5, 4, 8 };
		int[] newArr = new int[arr2.length];
		int count = 0;
		for (int i = 0; i < arr2.length; i++) {
			boolean found = false;
			for (int j = 0; j < newArr.length; j++) {
				if (arr2[i] == newArr[j]) {
					arr2[i] = 0;
					found = true;
				}
			}
			if (!(found)) {
				newArr[count++] = arr2[i];
			}
		}
		arr2 = new int[count];
		System.arraycopy(newArr, 0, arr2, 0, count);
		System.out.println(Arrays.toString(arr2));

		
		
		System.out.println("===============");
		System.out.println("   Ex3:");
		int[] arr3 = new int[10];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = (int) (Math.random() * 101);
		}
		System.out.println(Arrays.toString(arr3));
		newArr = new int[arr3.length];
		int index = arr3.length - 1;
		for (int i = 0; i < arr3.length; i++) {
			newArr[index--] = arr3[i];

		}
		System.out.println(Arrays.toString(newArr));

		
		
		System.out.println("===============");
		System.out.println("   Ex4:");
		int[][] grades = new int[20][10];
		int sumStudents = 0;
		for (int i = 0; i < grades.length; i++) {
			int sum = 0;
			for (int j = 0; j < grades[i].length; j++) {
				grades[i][j] = (int) (Math.random() * 21) + 80;
				sum += grades[i][j];
			}
			System.out.println("student " + (i+1) + ": " + sum/grades[i].length);
			sumStudents += sum/grades[i].length;
		}
		System.out.println("the class average grade is " + sumStudents/grades.length);
	}
}
