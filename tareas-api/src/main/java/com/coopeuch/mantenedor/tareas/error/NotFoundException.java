package com.coopeuch.mantenedor.tareas.error;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
public class NotFoundException extends RuntimeException{

	public NotFoundException(String message) {
		super(message);
	}

}
