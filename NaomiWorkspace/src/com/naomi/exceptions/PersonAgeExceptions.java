package com.naomi.exceptions;

public class PersonAgeExceptions extends Exception {

	public PersonAgeExceptions() {
		super();
	}

	public PersonAgeExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PersonAgeExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonAgeExceptions(String message) {
		super(message);
	}

	public PersonAgeExceptions(Throwable cause) {
		super(cause);
	}
}
