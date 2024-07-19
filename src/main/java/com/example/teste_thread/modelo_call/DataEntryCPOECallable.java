package com.example.teste_thread.modelo_call;

import com.example.teste_thread.api.SmartcareClient;
import com.example.teste_thread.domain.DataEntryEntities;
import com.example.teste_thread.services.DataEntryService;

import java.util.Map;
import java.util.concurrent.Callable;

public class DataEntryCPOECallable implements Callable<DataEntryEntities> {

    public final SmartcareClient smartcareClient;
    public final Map<String, Object> externalParams;
    public final String ENDPOINT = "data-entry-cpoe";

    public DataEntryCPOECallable(SmartcareClient smartcareClient, Map<String, Object> externalParams) {
        this.smartcareClient = smartcareClient;
        this.externalParams = externalParams;
    }

    @Override
    public DataEntryEntities call() throws Exception {
        return DataEntryService.getResponseTextDataEntry(smartcareClient, externalParams, ENDPOINT);
    }
}
