package com.naomi.projects.calculator;

import java.util.Scanner;

public class CalulatorSystem {

	private Calculator calulator = new Calculator();
	private Scanner sc = new Scanner(System.in);
	private boolean systemOn;

	public void start() {
		this.systemOn = true;
		while (systemOn) {
			System.out.print("Enter exercise: ");
//			showMenu();
			String exercise = sc.nextLine();
			char[] vals = exercise.toCharArray();
			this.calulator.setRes(vals[0]-'0');
			switch (vals[1]) {
			case '+':
				this.calulator.add(vals[2]);
				break;
			case '-':
				this.calulator.sub(vals[2]);
				break;
			case '*':
				this.calulator.mul(vals[2]);
				break;
			case '/':
				try {
					this.calulator.div(vals[2]);
				} catch (CalculatorException e) {
					System.err.println("ERROR!! " + e.getMessage());
				}
				break;
//			case "=":
//				System.out.print("the result: "  + this.calulator.getRes());
//				break;
//			case "cl":
//				this.calulator.clear();
//				break;
//			case "q":
//				this.systemOn = false;
//				this.sc.close();
//				break;
			default:
//				System.out.println(command + " is not a supported action");
			}
			System.out.println(vals[0] + "" + vals[1] + vals[2] + "=" + (this.calulator.getRes()-'0'));
		}
	}

	public void showMenu() {
		System.out.println("\n====== Menu =======");
		System.out.println("Add .. .......... + ");
		System.out.println("Sub ............. - ");
		System.out.println("Mul ............. * ");
		System.out.println("Div ............. / ");
		System.out.println("Res ............. = ");
		System.out.println("Clear ........... cl ");
		System.out.println("exit ............ q");
		System.out.print("your choice: ");
	}

	
}
