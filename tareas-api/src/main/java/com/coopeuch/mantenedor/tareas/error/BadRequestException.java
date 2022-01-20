package com.coopeuch.mantenedor.tareas.error;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
public class BadRequestException extends RuntimeException{

	public BadRequestException(String message) {
		super(message);
	}

}
