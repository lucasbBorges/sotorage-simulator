package br.com.storage_simulator.domain.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import br.com.storage_simulator.domain.request.IORequest;
import br.com.storage_simulator.domain.request.IOType;

public class IOQueueTest {
	@Test
	void shouldCreateAndAddResquests() {
		IOQueue queue = new IOQueue(2);
		
		IORequest r1 = new IORequest(UUID.randomUUID(), IOType.READ, 64, 0);
		IORequest r2 = new IORequest(UUID.randomUUID(), IOType.WRITE, 64, 0);
	
		assertTrue(queue.enqueue(r1));
		assertTrue(queue.enqueue(r2));
		assertEquals(2, queue.size());
		assertEquals(2, queue.capacity());
		
		IORequest r3 = new IORequest(UUID.randomUUID(), IOType.READ, 64, 0);
		assertFalse(queue.enqueue(r3));
		
		
	}
	
	
}
