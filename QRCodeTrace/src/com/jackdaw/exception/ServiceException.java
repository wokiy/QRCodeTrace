package com.jackdaw.exception;

/**
 * 业务层（服务层）异常
 * @author E-Kunt
 *
 */
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
}
