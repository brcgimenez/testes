package com.example.teste_thread.services;

import com.example.teste_thread.domain.DataEntryEntities;

import java.util.List;

public class GenerateInformationDiagnosisService {

    public static void generate(List<DataEntryEntities> diagnosis) {
        diagnosis
                .parallelStream()
                .forEach();
    }

}
