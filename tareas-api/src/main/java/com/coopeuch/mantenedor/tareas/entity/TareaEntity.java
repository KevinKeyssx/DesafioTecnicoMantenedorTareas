package com.coopeuch.mantenedor.tareas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.coopeuch.mantenedor.tareas.common.ConstantsDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = ConstantsDB.TABLE_LABEL, schema = ConstantsDB.SCHEMA)
public class TareaEntity implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identificador", nullable = false)
    private Long identificador;

    @Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;

    @Temporal(TemporalType.DATE)
	@Column(name = "fechaCreacion", nullable = false)
	private Date fechaCreacion;

    @Column(name = "vigente", nullable = false)
	private Boolean vigente;

}