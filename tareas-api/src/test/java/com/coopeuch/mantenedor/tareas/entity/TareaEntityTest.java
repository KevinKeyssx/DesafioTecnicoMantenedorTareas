package com.coopeuch.mantenedor.tareas.entity;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class TareaEntityTest {

	Calendar date = Calendar.getInstance();


    @Test
	void testConstructor() {
		var tareaDTO = new TareaEntity(
			1L,
			"Tarea 1",
			date,
			true
		);
		assertEquals(tareaDTO);
	}

	@Test
	void testSetter() {
		var tareaDTO = new TareaEntity();
		tareaDTO.setIdentificador(1L);
		tareaDTO.setDescripcion("Tarea 1");
		tareaDTO.setFechaCreacion(date);
		tareaDTO.setVigente(true);;
		assertEquals(tareaDTO);
	}

	private void assertEquals(TareaEntity tareaEntity) {
		Assert.assertNotNull(tareaEntity);
		Assert.assertNotEquals(true, tareaEntity.getIdentificador());
		Assert.assertEquals("Tarea 1", tareaEntity.getDescripcion());
		Assert.assertEquals(new Date(), tareaEntity.getFechaCreacion());
		Assert.assertEquals(true, tareaEntity.getVigente());
	}
}