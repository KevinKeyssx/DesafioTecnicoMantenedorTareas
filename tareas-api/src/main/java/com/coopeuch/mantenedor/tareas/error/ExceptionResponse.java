package com.coopeuch.mantenedor.tareas.error;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Kevin Candia
 * 01-11-2020
 */
@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse implements Serializable{

	private LocalDateTime timestamp;

	private String message;

	private String details;

	private static final long serialVersionUID = 1L;

}
