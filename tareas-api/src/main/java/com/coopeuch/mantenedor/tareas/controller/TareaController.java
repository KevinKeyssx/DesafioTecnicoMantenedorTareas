package com.coopeuch.mantenedor.tareas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.coopeuch.mantenedor.tareas.common.Constants;
import com.coopeuch.mantenedor.tareas.common.Util;
import com.coopeuch.mantenedor.tareas.data.ResponseDTO;
import com.coopeuch.mantenedor.tareas.data.TareaDTO;
import com.coopeuch.mantenedor.tareas.interfaces.ITarea;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
@RestController
@RequestMapping(Constants.END_TAREA)
@Log4j2
public class TareaController {

    @Autowired
	private ITarea iTarea;

    @GetMapping(path = Constants.SEARCH_ALL, produces = "application/json")
	public ResponseEntity<List<TareaDTO>> findAll() {
		log.info("*START - Controller findAll*");
		var tareasDTO = iTarea.findAll();
		log.info("*FINISHED - Controller findAll*");
		return new ResponseEntity<>(tareasDTO, new Util(true).typeStatus(tareasDTO));
	}

	@PostMapping(path =	Constants.SAVE, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> save(@Valid @RequestBody TareaDTO tareaDTO) {
		log.info("*START - Controller save*");
		iTarea.save(tareaDTO);
		log.info("*FINISHED - Controller save*");
		return new ResponseEntity<>(new ResponseDTO(Constants.SUCCESS_SAVE, new Date(), true), HttpStatus.CREATED);
	}

	@DeleteMapping(path = Constants.DELETE, produces = "application/json")
	public ResponseEntity<ResponseDTO> deleteById(@RequestParam(value = "identificador", required = true) Long identificador) {
		log.info("*START - Controller deleteById*");
		iTarea.deleteById(identificador);
		log.info("*FINISHED - Controller deleteById*");
		return new ResponseEntity<>(new ResponseDTO(Constants.SUCCESS_DELETE, new Date(), true), HttpStatus.ACCEPTED);
	}

}