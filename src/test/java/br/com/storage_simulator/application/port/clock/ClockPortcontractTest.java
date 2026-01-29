package br.com.storage_simulator.application.port.clock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClockPortcontractTest {
	@Test
	void shouldRespectClockContract() {
		ClockPort clock = new ClockPort() {
			@Override
			public long now() {
				return 123L;
			}
		};
		assertEquals(123L, clock.now());
	}
}
