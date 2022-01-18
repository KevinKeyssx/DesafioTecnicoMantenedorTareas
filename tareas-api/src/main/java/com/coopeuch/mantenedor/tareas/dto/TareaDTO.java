package com.coopeuch.mantenedor.tareas.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
@Setter
@Getter
@AllArgsConstructor
public class TareaDTO implements Serializable {

	@JsonProperty("identificador")
    private Long identificador;

	@Size(max = 100, message = "Descripcion debe tener mínimo 100 caracteres")
	@NotEmpty(message = "Descripcion no puede estar vacía")
	@NotNull(message = "Descripcion no puede ser nula")
	@JsonProperty("descripcion")
	private String descripcion;

	@CreationTimestamp
	@NotNull(message = "Fecha de creación no puede ser nula")
	@JsonProperty("fechaCreacion")
	private Date fechaCreacion;

	@NotNull(message = "Vigente no puede ser nulo")
	@JsonProperty("vigente")
	private Boolean vigente;

}