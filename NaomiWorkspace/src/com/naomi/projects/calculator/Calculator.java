package com.naomi.projects.calculator;

public class Calculator {

	private double res;

	public void setRes(double res) {
		this.res = res;
	}

	public double getRes() {
		return res;
	}

	public void add(double val) {
		this.res += val;
	}

	public void sub(double val) {
		this.res -= val;
	}

	public void mul(double val) {
		this.res *= val;
	}

	public void div(double val) throws CalculatorException {
		if (val == 0) {
			throw new CalculatorException("divided failed - you can not divided by zero");
		}
		this.res /= val;
	}

	public void clear() {
		this.res = 0;
	}
}
