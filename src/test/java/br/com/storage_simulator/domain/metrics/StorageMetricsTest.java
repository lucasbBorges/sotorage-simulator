package br.com.storage_simulator.domain.metrics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StorageMetricsTest {
	@Test
	void shouldStartWithZeroMetrics() {
		StorageMetrics metrics = new StorageMetrics();
		
		assertEquals(0.0, metrics.getAverageLatencyMillis());
		assertEquals(0, metrics.getTotalLatencyMillis());
		assertEquals(0, metrics.getCompletedRequests());
		assertEquals(0, metrics.getTotalRequests());
	}
	
	@Test
	void shouldRecordRequestMetrics() {
		StorageMetrics metrics = new StorageMetrics();
		metrics.recordRequest();
		metrics.recordRequest();
		
		metrics.recordCompletion(10);
		metrics.recordCompletion(20);
		
		assertEquals(2, metrics.getTotalRequests());
		assertEquals(2, metrics.getCompletedRequests());
		assertEquals(15, metrics.getAverageLatencyMillis());
		assertEquals(30, metrics.getTotalLatencyMillis());
	}
}

