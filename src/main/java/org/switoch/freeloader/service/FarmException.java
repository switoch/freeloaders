package org.switoch.freeloader.service;

public class FarmException extends Exception {

	private final Type code;
	
	private final Object value1;
	
	private final Object value2;

	public Object getValue1() {
		return value1;
	}

	public Object getValue2() {
		return value2;
	}

	public FarmException(Type code, Object value1, Object value2) {
		super();
		this.code = code;
		this.value1 = value1;
		this.value2 = value2;
	}

	public Type getCode() {
		return code;
	}

	public enum Type {
		FOOD_NOT_ENOUGH,
		WATER_NOT_ENOUGH,
		GARBAGE_TRUNK_IS_FULL;
	}
}
