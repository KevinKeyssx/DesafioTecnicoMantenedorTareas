package com.coopeuch.mantenedor.tareas.error;

/**
 * @author Kevin Candia
 * 23-09-2020
 */
public class NotFoundException extends RuntimeException{

	public NotFoundException(String message) {
		super(message);
	}

}
