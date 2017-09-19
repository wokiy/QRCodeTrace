package com.jackdaw.exception;

public class FileNotExsitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5548413712201479646L;

	public FileNotExsitException() {

	}

	public FileNotExsitException(String message) {
		super(message);

	}

	public FileNotExsitException(Throwable cause) {
		super(cause);

	}

	public FileNotExsitException(String message, Throwable cause) {
		super(message, cause);

	}

	public FileNotExsitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
