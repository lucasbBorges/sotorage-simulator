package br.com.storage_simulator.domain.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class IORequestTest {
	
	@Test
	void shouldCreatValidIORequest() {
		UUID id = UUID.randomUUID();
		long now = System.currentTimeMillis();
		
		IORequest request = new IORequest (id, IOType.READ, 64, now);
		
		assertEquals(id, request.getId());
		assertEquals(now, request.getArrivalTime());
		assertEquals(IOType.READ, request.getType());
		assertEquals(64, request.getSizeKb());
	}
}
