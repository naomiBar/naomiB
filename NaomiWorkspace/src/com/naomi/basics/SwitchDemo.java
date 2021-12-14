package com.naomi.basics;

import java.util.Scanner;

public class SwitchDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a day: ");
		String day = sc.nextLine();
		sc.close();
		
		switch (day) {
		case "sunday":
		case "monday":
		case "wednesday":
		case "thursday":
			System.out.println( "go home at 16:30");
			break;
			
		case "tuesday":
			System.out.println( "go home at 12:30");
			break;
			
		case "friday":
		case "saturday":
			System.out.println( "go home - it's weekend");
			break;
			
			default:
				System.out.println(day + " is not a day");
		}
	}

}
