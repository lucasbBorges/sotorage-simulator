package br.com.storage_simulator.application.port.executor;

public interface ExecutorPort {

    void submit(Runnable task);
    void shutdown();
}
