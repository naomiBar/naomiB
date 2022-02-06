package app.core.exceptions;

public class StoreExceptions extends Exception {

	public StoreExceptions() {
	}

	public StoreExceptions(String message) {
		super(message);
	}

	public StoreExceptions(Throwable cause) {
		super(cause);
	}

	public StoreExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public StoreExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
