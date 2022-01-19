package com.coopeuch.mantenedor.tareas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TareasApplicationTests {

	@Test
	public void main() {
		TareasApplication.main(new String[] {});
		assertTrue(Boolean.TRUE);
	}
}
