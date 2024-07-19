package com.example.teste_thread.modelo_run;

import com.example.teste_thread.api.SmartcareClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

//@SpringBootApplication
public class TesteThreadApplication {

	public void executeApplication() {
		SmartcareClient smartcareClient = new SmartcareClient();
		Map<String, Object> externalParams = new HashMap<>();
		externalParams.put("NC", "Nota clinica");

		DataEntryPEPThread theSims = new DataEntryPEPThread(smartcareClient, externalParams);
		theSims.setName("The Sims");
		DataEntryCPOEThread cpoe = new DataEntryCPOEThread(smartcareClient, externalParams);
		cpoe.setName("CPOE");

		//Inicia a execução
		theSims.start();
		cpoe.start();


		try {
			//Aguarda a finalização
			theSims.join();
			cpoe.join();

			//Obtem os resultados se necessário
			System.out.println("The Sims: " + theSims.getResult());
			System.out.println("CPOE: " + cpoe.getResult());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
