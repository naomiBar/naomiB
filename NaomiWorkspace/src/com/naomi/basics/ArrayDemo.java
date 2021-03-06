package com.naomi.basics;

import java.util.Arrays;

import com.naomi.basics.classes.point.Point;

public class ArrayDemo {

	public static void main(String[] args) {

		int[] arr = new int[2];
		arr[0] = 5;
		arr[1] = 10;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]: " + arr[i]);
		}
		System.out.println("===============");

		char[] cArr = { 'a', 'b', 'c', 'd' };
		System.out.println("cArr.length: " + cArr.length);
		for (char letter : cArr) {
			System.out.print(letter + " ");
		}
		System.out.println("\n===============");

		int[] grades = new int[10];
		for (int i = 0; i < grades.length; i++) {
			grades[i] = (int) (Math.random() * 41) + 60; // 60-100 inclusive
			System.out.println("grades[" + i + "]: " + grades[i]);
		}
		System.out.println("===============");

		Point[] points = new Point[2];
		points[0] = new Point(5, 5);
		points[1] = new Point(2, 3);
		for (int i = 0; i < points.length; i++) {
			System.out.print("point " + (i+1) + ": ");
			points[i].printPoint();
		}
		System.out.println("===============");
		
		String[] machine = {"ON", "OFF", "STAND_BY"};
		int status = (int)(Math.random() * machine.length); // 0-2 inclusive
		switch (status) {
		case 0:
			System.out.println("status: " +  machine[0]);
			break;
		case 1:
			System.out.println("status: " +  machine[1]);
			break;
		case 2:
			System.out.println("status: " +  machine[2]);
			break;
		}
		System.out.println("===============");
		
		//copy array to another array
		int[] arr1 = {2,4,6};
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = new int[arr1.length+2];
		System.out.println(Arrays.toString(arr2));
		
		//0-from where to start copy arr1
		//1-from where start initialize arr2
		System.arraycopy(arr1, 0, arr2, 1, arr1.length);
		System.out.println(Arrays.toString(arr2));
	}
}
