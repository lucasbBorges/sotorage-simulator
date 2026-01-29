package br.com.storage_simulator.domain.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import br.com.storage_simulator.domain.request.IORequest;

public class IOQueue {
	private final BlockingQueue<IORequest> queue;
	
	public IOQueue (int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be > 0");
		}
		this.queue = new ArrayBlockingQueue<IORequest>(capacity);
	}
	
	public boolean enqueue(IORequest request) {
		return queue.offer(request);
	}
	
	public IORequest dequeue() {
		return queue.poll();
	}
	
	public int size() {
		return queue.size();
	}
	
	public int capacity() {
		return queue.remainingCapacity() + queue.size();
	}
}
