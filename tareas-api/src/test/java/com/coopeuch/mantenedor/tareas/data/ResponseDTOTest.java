package com.coopeuch.mantenedor.tareas.data;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class ResponseDTOTest {
        
    @Test
	void testConstructor() {
		var responseDTO = new ResponseDTO(
			"Tarea 1",
			new Date(1L),
			true
		);
		assertEquals(responseDTO);
	}

	@Test
	void testSetter() {
		var responseDTO = new ResponseDTO();
		responseDTO.setResponse("Tarea 1");
		responseDTO.setDate(new Date(1L));
		responseDTO.setStatus(true);
		assertEquals(responseDTO);
	}

	private void assertEquals(ResponseDTO responseDTO) {
		Assert.assertNotNull(responseDTO);
		Assert.assertEquals("Tarea 1", responseDTO.getResponse());
		Assert.assertEquals(new Date(1L), responseDTO.getDate());
		Assert.assertEquals(true, responseDTO.getStatus());
	}

}