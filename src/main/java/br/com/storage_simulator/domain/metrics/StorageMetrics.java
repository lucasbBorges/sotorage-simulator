package br.com.storage_simulator.domain.metrics;

public class StorageMetrics {

    private long totalRequests;
    private long totalLatencyMillis;
    private long completedRequests;

    public StorageMetrics() {
        this.totalRequests = 0;
        this.totalLatencyMillis = 0;
        this.completedRequests = 0;
    }

    public void recordRequest() {
        totalRequests++;
    }

    public void recordCompletion(long latencyMillis) {
        completedRequests++;
        totalLatencyMillis += latencyMillis;
    }

    public long getTotalRequests() {
        return totalRequests;
    }

    public long getCompletedRequests() {
        return completedRequests;
    }

    public long getTotalLatencyMillis() {
        return totalLatencyMillis;
    }

    public double getAverageLatencyMillis() {
        if (completedRequests == 0) {
            return 0.0;
        }
        return (double) totalLatencyMillis / completedRequests;
    }
}

