package br.com.storage_simulator.domain.device;

import org.junit.jupiter.api.Test;

import br.com.storage_simulator.domain.metrics.StorageMetrics;
import br.com.storage_simulator.domain.request.IORequest;

public class StorageDeviceContractTest {
	@Test
	void shouldAllowImplementationOfStorageDevice() {
		StorageDevice device = new StorageDevice() {
			@Override
			public void submit (IORequest request) {
				
			}
			
			@Override
			public StorageMetrics getMetrics() {
				return null;
			}
		};
		
	}
}
