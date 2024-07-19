package com.example.teste_thread.event;

import org.springframework.context.ApplicationEvent;

public class DataExtractedGenerated extends ApplicationEvent {

    private DataExtractedPayload payload;

    public DataExtractedGenerated(Object source, DataExtractedPayload payload) {
        super(source);
        this.payload = payload;
    }

    public DataExtractedPayload getPayload() {
        return payload;
    }
}
