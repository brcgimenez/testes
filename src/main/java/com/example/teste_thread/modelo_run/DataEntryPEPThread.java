package com.example.teste_thread.modelo_run;

import com.example.teste_thread.api.SmartcareClient;
import com.example.teste_thread.domain.DataEntryEntities;
import com.example.teste_thread.services.DataEntryService;
import com.example.teste_thread.services.GenerateInformationDiagnosisService;

import java.util.Map;

public class DataEntryPEPThread extends Thread {

    public final SmartcareClient smartcareClient;
    public final Map<String, Object> externalParams;
    public final String ENDPOINT = "data-entry";

    public DataEntryPEPThread(SmartcareClient smartcareClient, Map<String, Object> externalParams) {
        this.smartcareClient = smartcareClient;
        this.externalParams = externalParams;
    }

    public String getResult() {
        return "Caso houver a necessidade de obter algum retorno";
    }

    @Override
    public void run() {
        DataEntryEntities dataEntryEntities = DataEntryService.getResponseTextDataEntry(smartcareClient, externalParams, ENDPOINT);

        GenerateInformationDiagnosisService.generate(dataEntryEntities.getDiagnosis());
    }
}
