package com.example.teste_thread.domain;

import java.util.List;

public class DataEntryEntities {
    private String name;
    private List<DataEntryEntities> diagnosis;

    public DataEntryEntities() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataEntryEntities> getDiagnosis() {
        return diagnosis;
    }
}
