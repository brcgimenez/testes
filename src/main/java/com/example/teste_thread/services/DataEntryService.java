package com.example.teste_thread.services;

import com.example.teste_thread.domain.DataEntryEntities;
import com.example.teste_thread.api.SmartcareClient;

import java.util.Map;

public final class DataEntryService {

    public static DataEntryEntities getResponseTextDataEntry(SmartcareClient smartcareClient, Map<String, Object> externalParams, String endPoint) {
        System.out.printf("--- Conectando com Smartcare no endpoint: %s ---%n", endPoint);
        smartcareClient.execute();

        System.out.println("--- Serializando objetos ---");
        DataEntryEntities dataEntry = new DataEntryEntities();
        dataEntry.setName("bruno");

        return dataEntry;
    }
}
