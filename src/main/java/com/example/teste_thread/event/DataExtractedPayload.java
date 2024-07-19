package com.example.teste_thread.event;

public class DataExtractedPayload {
    private Long id;
    private DataExtrated dataExtracteds;

    public DataExtrated getDataExtracteds() {
        return dataExtracteds;
    }

    public void setDataExtracteds(DataExtrated dataExtracteds) {
        this.dataExtracteds = dataExtracteds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
