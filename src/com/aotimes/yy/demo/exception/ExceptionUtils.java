package com.aotimes.yy.demo.exception;

/**
 * @see 自定义异常类
 * @since 2016年1月21日
 * @category action
 * @author 杨阳
 */
public class ExceptionUtils extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionUtils() {
	}

	public ExceptionUtils(String message) {
		super(message);
	}
}
