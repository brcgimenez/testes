package com.example.teste_thread.event;

import com.example.teste_thread.api.SmartcareClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventPEPProcessor {

    @Autowired
    private EventPublisher publisher;

    public void process() {
        SmartcareClient smartcareClient = new SmartcareClient();
        smartcareClient.execute();

        DataExtractedPayload payload = new DataExtractedPayload();
        //Seta o retorno do smartcare para o payload
        payload.setId(1L);
        payload.setDataExtracteds(new DataExtrated(List.of(new Object()), List.of(new Object())));

        DataExtractedGenerated event = new DataExtractedGenerated(this, payload);

        publisher.publish(event);
    }
}
