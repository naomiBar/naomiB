package com.naomi.jars;

import api.converter.currency.currencyConverter;
import api.converter.temperature.TemperatureConverter;

public class Main {

	public static void main(String[] args) {
		System.out.println("start test");

		double nis = 100;
		double dollar = currencyConverter.convertNISToDollar(nis);
		System.out.println(dollar);
		// to print in a formatted style
		System.out.format("%.2f nis are %.2f $\n", nis, dollar);

		double celsius = 8;
		double farenheit = TemperatureConverter.convertCelsiusToFahrenheit(celsius);
		System.out.println(celsius + " celsius is " + farenheit + " farenheit");

		// to print in a formatted style
		System.out.format("dollars: %.2f", dollar);

	}

}
