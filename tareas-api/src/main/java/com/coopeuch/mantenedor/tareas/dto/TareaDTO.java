package com.coopeuch.mantenedor.tareas.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TareaDTO implements Serializable {

    private Long identificador;

	private String descripcion;

	private Date fechaCreacion;

	private Boolean vigente;

}