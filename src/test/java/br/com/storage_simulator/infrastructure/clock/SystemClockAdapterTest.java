package br.com.storage_simulator.infrastructure.clock;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.storage_simulator.application.port.clock.ClockPort;

public class SystemClockAdapterTest {
	@Test
	void shouldRegisterSystemClock() {
		ClockPort clock = new SystemClockAdapter();
		
		long before = System.currentTimeMillis();
		long now = clock.now();
		long after = System.currentTimeMillis();
		
		assertTrue(before <= now && after >= now);
	}
}
