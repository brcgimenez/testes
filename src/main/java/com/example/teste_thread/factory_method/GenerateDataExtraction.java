package com.example.teste_thread.factory_method;

import java.util.List;

public abstract class GenerateDataExtraction<T> {
    List<T> data;

    public GenerateDataExtraction() {
    }

    abstract List<Object> generateDataExtraction();

    //DataExtraction
    public List<Object> execute() {
        return this.generateDataExtraction();
    }

    //DataExtraction
    protected Object generateCommons() {
        //gerar o que for comum para todos os itens
        //retorna um objeto do tipo DataExtraction
        return new Object();
    }
}
