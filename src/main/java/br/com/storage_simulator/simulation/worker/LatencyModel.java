package br.com.storage_simulator.simulation.worker;

import java.util.Random;

public class LatencyModel {
	private final long baseLatencyMillis;
	private final long jitterMillis;
	private final Random random;
	
	public LatencyModel (long baseLatencyMillis, long jitterMillis) {
		if (baseLatencyMillis < 0 || jitterMillis < 0) {
			throw new IllegalArgumentException("Latency values must be >= 0");
		}
		this.baseLatencyMillis = baseLatencyMillis;
		this.jitterMillis = jitterMillis;
		this.random = new Random();
	}
	
	public long nextLatencyMillis() {
		if (jitterMillis == 0) {
			return baseLatencyMillis;
		}
		long variation = (long) (random.nextDouble() * jitterMillis);
		return baseLatencyMillis + variation;
	}
}
