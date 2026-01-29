package br.com.storage_simulator.infrastructure.clock;

import br.com.storage_simulator.application.port.clock.ClockPort;

public class SystemClockAdapter implements ClockPort{
	@Override
	public long now() {
		return System.currentTimeMillis();
	}
}
