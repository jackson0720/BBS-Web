package com.skysoft.tphone.exception;

/**
 * @author Chunkie Yeung
 *
 */
public class DaoException extends RuntimeException{

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
