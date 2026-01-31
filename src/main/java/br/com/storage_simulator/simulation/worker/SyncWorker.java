package br.com.storage_simulator.simulation.worker;

import br.com.storage_simulator.application.port.clock.ClockPort;
import br.com.storage_simulator.domain.metrics.StorageMetrics;
import br.com.storage_simulator.domain.queue.IOQueue;
import br.com.storage_simulator.domain.request.IORequest;

public class SyncWorker {
	private final IOQueue queue;
	private final StorageMetrics metrics;
	private final ClockPort clock;
	private final long baseLatencyMillis;
	
	public SyncWorker(IOQueue queue,
					  StorageMetrics metrics,
					  ClockPort clock,
					  long baseLatencyMillis) {
		this.queue = queue;
		this.metrics = metrics;
		this.clock = clock;
		this.baseLatencyMillis = baseLatencyMillis;
	}
	
	/*
	 * Processa exatamente UMA requisição, se existir.
	 * Retorna true se algo foi processado
	 * */
	public boolean processOne() {
		IORequest request = queue.dequeue();
		if (request == null) {
			return false;
		}
		metrics.recordRequest();
		long start = clock.now();
		
		// simulação de latência (sem sleep real)
		simulateLatency();
		
		long end = clock.now();
		long latency = end - start;
		
		metrics.recordCompletion(latency);
		return true;
	}
	
	private void simulateLatency() {
		// avançamos o tempo via clock falso
		if (clock instanceof br.com.storage_simulator.infrastructure.clock.FakeClock fake) {
			fake.advanceMillis(baseLatencyMillis);
		} else {
			try {
				Thread.sleep(baseLatencyMillis);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
