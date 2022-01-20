package com.coopeuch.mantenedor.tareas.controller;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.coopeuch.mantenedor.tareas.data.TareaDTO;
import com.coopeuch.mantenedor.tareas.service.TareaService;
import com.coopeuch.mantenedor.tareas.common.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TareaController {

    @Autowired
	private MockMvc mockMvc;

    @MockBean
	private TareaService service;

	private LocalDate date = LocalDate.now();

    @Test
	@DisplayName("Get /search")
	void testGetData() throws Exception {
		@SuppressWarnings("unchecked")
		List<TareaDTO> testTarea = Mockito.mock(List.class);
		ObjectMapper obj = new ObjectMapper();
		Mockito.when(service.findAll()).thenReturn(testTarea);
		mockMvc.perform(get(Constants.END_TAREA + Constants.SEARCH_ALL).contentType(MediaType.APPLICATION_JSON)
            .content(obj.writeValueAsString(testTarea)))
            .andExpect(status().isOk());
	}

    @Test
	@DisplayName("Post /insert")
	void testCreate() throws Exception {
		ObjectMapper obj = new ObjectMapper();
		var tareaDTO = new TareaDTO(
            null, 
            "insert test",
            date,
            true
        );

		mockMvc.perform(post(Constants.END_TAREA + Constants.SAVE).contentType(MediaType.APPLICATION_JSON)
            .content(obj.writeValueAsString(tareaDTO)))
            .andExpect(status().isCreated());
	}

    @Test
	@DisplayName("Post / update")
	void testUpdate() throws Exception {
		ObjectMapper obj = new ObjectMapper();
		var tareaDTO = new TareaDTO(
            100L, 
            "update test",
            date,
            true
        );

		mockMvc.perform(post(Constants.END_TAREA + Constants.SAVE).contentType(MediaType.APPLICATION_JSON)
            .content(obj.writeValueAsString(tareaDTO)))
            .andExpect(status().isCreated());
	}

    @Test
	@DisplayName("Delete / delete")
	void testDelete() throws Exception {
		ObjectMapper obj = new ObjectMapper();
		var identificador = 100L;
		mockMvc.perform(delete(Constants.END_TAREA + Constants.DELETE + "?identificador=" + identificador)
            .contentType(MediaType.APPLICATION_JSON)
            .content(obj.writeValueAsString(new TareaDTO())))
            .andExpect(status().isAccepted());
	}
}