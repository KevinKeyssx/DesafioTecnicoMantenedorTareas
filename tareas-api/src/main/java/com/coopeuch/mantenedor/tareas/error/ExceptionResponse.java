package com.coopeuch.mantenedor.tareas.error;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Kevin Candia
 * 17-01-2022
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
