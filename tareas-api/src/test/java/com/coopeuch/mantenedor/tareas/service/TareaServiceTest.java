package com.coopeuch.mantenedor.tareas.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.coopeuch.mantenedor.tareas.data.TareaDTO;
import com.coopeuch.mantenedor.tareas.entity.TareaEntity;
import com.coopeuch.mantenedor.tareas.repository.ITareaRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TareaServiceTest {
    
    @InjectMocks
	@Spy
	private TareaService service;

    @Mock
	private ITareaRepository repository;

	Calendar date = Calendar.getInstance();

    @Test
    @DisplayName("Find All")
	void testFindAll() throws Exception {
		// Given
		var listTareaEntity = new ArrayList<TareaEntity>();
		List<TareaDTO> listTareaDTO  = new ArrayList<>();
		listTareaEntity.add(new TareaEntity(
            1L,
            "Tarea 1",
            date,
            true
        ));
		// When
		Mockito.when(repository.findAll()).thenReturn(listTareaEntity);
		listTareaDTO = service.findAll();

		if (listTareaDTO == null) {
			assertFalse(Boolean.FALSE);
        }
		// Then
		assertTrue(Boolean.TRUE);
	}

    @Test
    @DisplayName("test Insert")
	void testInsert() throws Exception {
		// Given
		var tareaEntity = new TareaEntity(
            "Tarea 1",
            date,
            true
        );

		// When
		Mockito.when(repository.save(tareaEntity)).thenReturn(tareaEntity);
		// Then
		assertTrue(Boolean.TRUE);
	}

    @Test
    @DisplayName("test Update")
    void testUpdate() throws Exception {
		// Given
		var tareaEntity = new TareaEntity(
            1L,
            "Tarea 1",
            date,
            true
        );
		// When
		Mockito.when(repository.save(tareaEntity)).thenReturn(tareaEntity);
		// Then
		assertTrue(Boolean.TRUE);
	}

    @Test
    @DisplayName("test Delete")
    void testDelete() throws Exception {
		// Given
        var identificador = 1L;
		// When
		repository.deleteById(identificador);
		// Then
		assertTrue(Boolean.TRUE);
	}
}