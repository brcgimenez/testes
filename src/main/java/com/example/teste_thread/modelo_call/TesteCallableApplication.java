package com.example.teste_thread.modelo_call;

import com.example.teste_thread.api.SmartcareClient;
import com.example.teste_thread.domain.DataEntryEntities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

//@SpringBootApplication
public class TesteCallableApplication {

	private ExecutorService executorService;

    public TesteCallableApplication(ExecutorService executorService) {
        this.executorService = executorService;
    }

	public void executeApplication() {
//		int numeroPrompts = 2;
//		executorService = Executors.newFixedThreadPool(numeroPrompts);

		SmartcareClient smartcareClient = new SmartcareClient();
		Map<String, Object> externalParams = new HashMap<>();
		externalParams.put("NC", "Nota clinica");

		DataEntryPEPCallable theSims = new DataEntryPEPCallable(smartcareClient, externalParams);
		DataEntryCPOECallable cpoe = new DataEntryCPOECallable(smartcareClient, externalParams);

		Future<DataEntryEntities> futureTheSims = executorService.submit(theSims);
		Future<DataEntryEntities> futureCpoe = executorService.submit(cpoe);

		try	{
			//Obtem as respostas
			DataEntryEntities theSimsData = futureTheSims.get();
			DataEntryEntities cpoeData = futureCpoe.get();

			//Processa as respostas
			System.out.println("The Sims: " + theSimsData.getName());
			System.out.println("CPOE: " + cpoeData.getName());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}

}
