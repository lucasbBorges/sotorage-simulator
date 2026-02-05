package br.com.storage_simulator.simulation.worker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import br.com.storage_simulator.domain.metrics.StorageMetrics;
import br.com.storage_simulator.domain.queue.IOQueue;
import br.com.storage_simulator.domain.request.IORequest;
import br.com.storage_simulator.domain.request.IOType;
import br.com.storage_simulator.infrastructure.clock.FakeClock;

public class SyncWorkerTest {
	@Test
	void shouldProcessingSingleRequestAndUpdateMetrics() {
		StorageMetrics metrics = new StorageMetrics();
		IOQueue queue = new IOQueue(1);
		FakeClock clock = new FakeClock(1000);
		LatencyModel latencyModel = new LatencyModel(10, 5);
		
		IORequest request = new IORequest(
				UUID.randomUUID(),
				IOType.READ,
				64,
				clock.now()
		);
		
		queue.enqueue(request);
		
		SyncWorker worker = new SyncWorker(queue, metrics, clock, latencyModel);
		boolean processed = worker.processOne();
		
		assertTrue(processed);
		assertEquals(1, metrics.getCompletedRequests());
		assertEquals(1, metrics.getTotalRequests());
		assertTrue(metrics.getAverageLatencyMillis() >= 10);
        assertTrue(metrics.getAverageLatencyMillis() <= 15);
	}
	
	@Test
	void shouldProcessRequestsInSeparateThread() throws InterruptedException {
	    IOQueue queue = new IOQueue(10);
	    StorageMetrics metrics = new StorageMetrics();
	    FakeClock clock = new FakeClock(0L);

	    LatencyModel latencyModel = new LatencyModel(5, 0);
	    SyncWorker syncWorker = new SyncWorker(queue, metrics, clock, latencyModel);

	    WorkerThread workerThread = new WorkerThread(syncWorker);
	    Thread thread = new Thread(workerThread);
	    thread.start();

	    queue.enqueue(new IORequest(UUID.randomUUID(), IOType.READ, 64, 0));
	    queue.enqueue(new IORequest(UUID.randomUUID(), IOType.READ, 64, 0));

	    Thread.sleep(10);

	    workerThread.stop();
	    thread.join();

	    assertEquals(2, metrics.getCompletedRequests());
	}

}
