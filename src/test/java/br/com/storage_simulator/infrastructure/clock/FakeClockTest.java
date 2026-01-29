package br.com.storage_simulator.infrastructure.clock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FakeClockTest {
	@Test
	void shouldReturnInitialTime() {
		FakeClock fakeClock = new FakeClock(123L);
		assertEquals(123L, fakeClock.now());
	}
	
	@Test
    void shouldAdvanceTimeCorrectly() {
        FakeClock clock = new FakeClock(1000L);

        clock.advanceMillis(500);
        assertEquals(1500L, clock.now());

        clock.advanceMillis(250);
        assertEquals(1750L, clock.now());
    }
	
	@Test
	void shouldNotAllowNegativeTimeAdvance() {
		FakeClock clock = new FakeClock(1000L);
		assertThrows(IllegalArgumentException.class,
				() -> clock.advanceMillis(-10L));
	}
}
