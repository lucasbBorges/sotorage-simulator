package br.com.storage_simulator.domain.request;

import java.util.UUID;

public class IORequest {

    private final UUID id;
    private final IOType type;
    private final int sizeKb;
    private final long arrivalTime;

    public IORequest(UUID id, IOType type, int sizeKb, long arrivalTime) {
        this.id = id;
        this.type = type;
        this.sizeKb = sizeKb;
        this.arrivalTime = arrivalTime;
    }

    public UUID getId() {
        return id;
    }

    public IOType getType() {
        return type;
    }

    public int getSizeKb() {
        return sizeKb;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}

