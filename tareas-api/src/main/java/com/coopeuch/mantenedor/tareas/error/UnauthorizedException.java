package com.coopeuch.mantenedor.tareas.error;

/**
 * @author Kevin Candia
 * 23-09-2020
 */
public class UnauthorizedException extends RuntimeException {

	public UnauthorizedException(String message) {
		super(message);
	}

}
