package com.naomi.projects;

import java.util.Scanner;

public class Boom7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("enter 1st number: ");
		int a = sc.nextInt();
		System.out.print("enter 2nd  number: ");
		int b = sc.nextInt();
		sc.close();

		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		for (int i = a; i <= b; i++) {
			boolean isSeven = false;			
			if (i % 7 == 0 || i % 10 == 7) {
				isSeven = true;
			} else {
				int temp = i;
				while (temp != 0) {
					temp = temp / 10;
					if (temp % 10 == 7) {
						isSeven = true;
						temp = 0;
					}
				}
			}

			if (isSeven) {
				System.out.print("Boom" + " ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
}
