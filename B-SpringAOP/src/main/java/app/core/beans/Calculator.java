package app.core.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator implements CalculatorInterface{

	@Override
	public String div(int a, int b) {
		String str = a + " / " + b + " = " + (a/b) + " [Rem: " + (a%b) + "]";
		System.out.println(str);
		return str;
	}

}
