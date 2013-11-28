package com.amos.spring.service;

public class LogicException extends RuntimeException {

	private static final long serialVersionUID = -1382995533096866707L;

	public LogicException() {
		super("业务逻辑异常");
	}

	public LogicException(String message) {
		super(message);
	}

}
