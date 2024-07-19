package com.example.teste_thread.factory_method;

import java.util.List;
import java.util.stream.Collectors;

public class GenerateDiagnosisDataExtraction extends GenerateDataExtraction<DiagnosisExtracted> {

    public GenerateDiagnosisDataExtraction(List<DiagnosisExtracted> diagnosisExtracteds) {
        this.data = diagnosisExtracteds;
    }

    @Override
    List<Object> generateDataExtraction() {
        //Gera uma lista de DataExtraction a ser salvo.
        return this.data.stream()
                .map(diag -> {
                    //gerar o que for comum para todos os itens
                    Object common = generateCommons();

                    //gerar o que for especifico para o item

                    //retorna um objeto do tipo DataExtraction
                    return new Object();
                })
                .collect(Collectors.toList());
    }
}
