package com.example.teste_thread.event;

import java.util.List;

public class DataExtrated {
    List<Object> diagnosis;
    List<Object> allergies;

    public DataExtrated(List<Object> diagnosis, List<Object> allergies) {
        this.diagnosis = diagnosis;
        this.allergies = allergies;
    }

    public List<Object> getDiagnosis() {
        return diagnosis;
    }

    public List<Object> getAllergies() {
        return allergies;
    }
}
