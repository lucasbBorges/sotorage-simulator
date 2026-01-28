package br.com.storage_simulator.domain.device;

import br.com.storage_simulator.domain.metrics.StorageMetrics;
import br.com.storage_simulator.domain.request.IORequest;

public interface StorageDevice {
	void submit(IORequest request);
	StorageMetrics getMetrics();
}
