package com.example.teste_thread.modelo_call;

import com.example.teste_thread.api.SmartcareClient;
import com.example.teste_thread.domain.DataEntryEntities;
import com.example.teste_thread.services.DataEntryService;
import com.example.teste_thread.services.GenerateInformationDiagnosisService;

import java.util.Map;
import java.util.concurrent.Callable;

public class DataEntryPEPCallable implements Callable<DataEntryEntities> {

    public final SmartcareClient smartcareClient;
    public final Map<String, Object> externalParams;
    public final String ENDPOINT = "data-entry";

    public DataEntryPEPCallable(SmartcareClient smartcareClient, Map<String, Object> externalParams) {
        this.smartcareClient = smartcareClient;
        this.externalParams = externalParams;
    }

    @Override
    public DataEntryEntities call() throws Exception {
        DataEntryEntities dataEntryEntities = DataEntryService.getResponseTextDataEntry(smartcareClient, externalParams, ENDPOINT);

        GenerateInformationDiagnosisService.generate(dataEntryEntities.getDiagnosis());

        return dataEntryEntities;
    }
}
