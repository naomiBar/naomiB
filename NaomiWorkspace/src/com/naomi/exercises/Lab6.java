package com.naomi.exercises;

public class Lab6 {

	public static void main(String[] args) {

		System.out.println("   Ex1:");
		int n1 = 1, n2 = 0;
		int next = 0;
		for (int i = 1; i <= 40; i++) {
			next = n1 + n2;
			n1 = n2;
			n2 = next;
			System.out.print(next + " ");
		}

		
		
		System.out.println("\n===============");
		System.out.println("   Ex2:");
		int index = (int) (Math.random() * 40) + 1;
		n1 = 1;
		n2 = 0;
		next = 0;
		for (int i = 1; i <= index; i++) {
			next = n1 + n2;
			n1 = n2;
			n2 = next;
		}
		System.out.println(index + " -> " + next);

		
		
		System.out.println("===============");
		System.out.println("   Ex3:");
		int value = (int) (Math.random() * 41) + 1; //10-50
		System.out.println(value);
		n1 = 1;
		n2 = 0;
		next = 0;
		for (int i = 1; i <= value; i++) {
			next = n1 + n2;
			n1 = n2;
			n2 = next;
			if (next > value) {
				break;
			}
			System.out.print(next + " ");
		}
	}
}
