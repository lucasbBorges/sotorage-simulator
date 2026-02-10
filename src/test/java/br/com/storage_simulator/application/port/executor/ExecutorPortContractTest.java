package br.com.storage_simulator.application.port.executor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

class ExecutorPortContractTest {

    @Test
    void shouldAllowExecutorPortImplementation() {
        ExecutorPort executor = new ExecutorPort() {
            @Override
            public void submit(Runnable task) {
                task.run();
            }

            @Override
            public void shutdown() {
                // no-op
            }
        };

        AtomicInteger counter = new AtomicInteger(0);
        executor.submit(counter::incrementAndGet);

        assertEquals(1, counter.get());
    }
}
