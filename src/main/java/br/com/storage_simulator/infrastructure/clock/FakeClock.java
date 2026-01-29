package br.com.storage_simulator.infrastructure.clock;

import br.com.storage_simulator.application.port.clock.ClockPort;

public class FakeClock implements ClockPort{
	private long currentTimeMillis;
	
	public FakeClock(long initialTimeMillis) {
		this.currentTimeMillis = initialTimeMillis;
	}
	
	@Override
	public long now() {
		return currentTimeMillis;
	}
	
	public void advanceMillis(long millis) {
		if (millis < 0) {
			throw new IllegalArgumentException("Cannot go back in time");
		}
		this.currentTimeMillis += millis;
	}
}
