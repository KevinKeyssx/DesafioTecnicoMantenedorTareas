package com.coopeuch.mantenedor.tareas.error;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
public class UnauthorizedException extends RuntimeException {

	public UnauthorizedException(String message) {
		super(message);
	}

}
