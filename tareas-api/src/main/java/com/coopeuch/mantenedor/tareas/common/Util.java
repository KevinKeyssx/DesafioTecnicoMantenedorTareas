package com.coopeuch.mantenedor.tareas.common;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
public class Util implements Serializable {

    private static final long serialVersionUID = 1L;

    public Util(Boolean value) {
        if (Boolean.FALSE.equals(value)) {
            throw new IllegalAccessError("Ilegal access.");
        }
    }

    public HttpStatus typeStatus(Object object){
        return object == null || object.toString().equals("[]") || object.toString().isBlank() ? 
            HttpStatus.NO_CONTENT: HttpStatus.OK;
    }

}
