package com.example.teste_thread.factory_method;

public class DiagnosisExtracted {

    private String code;
    private String name;

    public DiagnosisExtracted(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
