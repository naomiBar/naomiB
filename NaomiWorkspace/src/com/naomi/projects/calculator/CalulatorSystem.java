package com.naomi.projects.calculator;

import java.util.Scanner;

public class CalulatorSystem {

	private Calculator calulator = new Calculator();
	private Scanner sc = new Scanner(System.in);
	private boolean systemOn;

	public void start() {
		this.systemOn = true;
		while (systemOn) {
			System.out.print("Enter exercise(q-to quit): ");
			String exercise = sc.nextLine();
			char[] vals = exercise.toCharArray();
			
			if (vals[0] != 'q') {
				this.calulator.setRes(Double.parseDouble(Character.toString(vals[0])));
				double num = Double.parseDouble(Character.toString(vals[2]));

				switch (vals[1]) {
				case '+':
					this.calulator.add(num);
					System.out.println(vals[0] + " + " + vals[2] + " = " + Double.toString(this.calulator.getRes()));
					break;
				case '-':
					this.calulator.sub(num);
					System.out.println(vals[0] + " - " + vals[2] + " = " + Double.toString(this.calulator.getRes()));
					break;
				case '*':
					this.calulator.mul(num);
					System.out.println(vals[0] + " * " + vals[2] + " = " + Double.toString(this.calulator.getRes()));
					break;
				case '/':
					try {
						this.calulator.div(num);
						System.out
								.println(vals[0] + " / " + vals[2] + " = " + Double.toString(this.calulator.getRes()));
					} catch (CalculatorException e) {
						System.err.println("ERROR!! " + e.getMessage());
					}
					break;
				}
			} else {
				this.systemOn = false;
				this.sc.close();
				System.out.println("\n\t BYE! :)");
			}
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
