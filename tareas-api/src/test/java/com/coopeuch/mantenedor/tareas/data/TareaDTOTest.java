package com.coopeuch.mantenedor.tareas.data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import org.junit.Assert;

public class TareaDTOTest {

	private LocalDate date = LocalDate.now();

    @Test
	void testConstructor() {
		var tareaDTO = new TareaDTO(
			1L,
			"Tarea 1",
			date,
			true
		);
		assertEquals(tareaDTO);
	}

	@Test
	void testSetter() {
		var tareaDTO = new TareaDTO();
		tareaDTO.setIdentificador(1L);
		tareaDTO.setDescripcion("Tarea 1");
		tareaDTO.setFechaCreacion(date);
		tareaDTO.setVigente(true);
		assertEquals(tareaDTO);
	}

	private void assertEquals(TareaDTO tareaDTO) {
		Assert.assertNotNull(tareaDTO);
		Assert.assertNotEquals(true, tareaDTO.getIdentificador());
		Assert.assertEquals("Tarea 1", tareaDTO.getDescripcion());
		Assert.assertEquals(date, tareaDTO.getFechaCreacion());
		Assert.assertEquals(true, tareaDTO.getVigente());
	}

}