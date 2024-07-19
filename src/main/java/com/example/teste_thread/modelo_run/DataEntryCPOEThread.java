package com.example.teste_thread.modelo_run;

import com.example.teste_thread.api.SmartcareClient;
import com.example.teste_thread.services.DataEntryService;

import java.util.Map;

public class DataEntryCPOEThread extends Thread {

    public final SmartcareClient smartcareClient;
    public final Map<String, Object> externalParams;
    public final String ENDPOINT = "data-entry-cpoe";

    public DataEntryCPOEThread(SmartcareClient smartcareClient, Map<String, Object> externalParams) {
        this.smartcareClient = smartcareClient;
        this.externalParams = externalParams;
    }

    public String getResult() {
        return "Caso houver a necessidade de obter algum retorno";
    }

    @Override
    public void run() {
        DataEntryService.getResponseTextDataEntry(smartcareClient, externalParams, ENDPOINT);
    }
}
