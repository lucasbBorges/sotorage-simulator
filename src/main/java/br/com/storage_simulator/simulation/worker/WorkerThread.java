package br.com.storage_simulator.simulation.worker;

public class WorkerThread implements Runnable{
	private final SyncWorker worker;
	private volatile boolean running = true;
	
	public WorkerThread(SyncWorker worker) {
		this.worker = worker;
	}
	
	@Override
	public void run() {
		while (running) {
			boolean processed = worker.processOne();
			if (!processed) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		}
	}
	
	public void stop() {
		running = false;
	}
}
