package com.docker.intro.exception;

@SuppressWarnings("serial")
public class UserException extends Exception {
	
	public UserException(String errorMessage) {
        super(errorMessage);
    }
	
	public UserException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
