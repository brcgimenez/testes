package com.example.teste_thread.event;

import com.example.teste_thread.factory_method.GenerateDataExtraction;
import com.example.teste_thread.factory_method.GenerateDiagnosisDataExtraction;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Listener
 */
@Component
public class GenerateDiagnosisDataEntry implements ApplicationListener<DataExtractedGenerated> {

    @Override
    public void onApplicationEvent(DataExtractedGenerated event) {
        try {
            //Executa o que deve ser feito quando o evento é disparado

            System.out.println("Event received: " + event.getPayload().getId());
            System.out.println("Event received: " + event.getPayload().getDataExtracteds());
            GenerateDataExtraction generate = new GenerateDiagnosisDataExtraction(event.getPayload().getDataExtracteds().getDiagnosisExtracteds());
            List<Object> retorno = generate.execute();

            dataExtractionService.saveAll(retorno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 *
 * this.myEvent()
 * .subscribe(() -> {});
 *
 * Outra classe
 * this.myEvent()
 * .subscribe(() -> {});
 */