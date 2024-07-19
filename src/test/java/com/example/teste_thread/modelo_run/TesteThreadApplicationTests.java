package com.example.teste_thread.modelo_run;

import com.example.teste_thread.api.SmartcareClient;
import com.example.teste_thread.domain.DataEntryEntities;
import com.example.teste_thread.modelo_call.DataEntryCPOECallable;
import com.example.teste_thread.modelo_call.DataEntryPEPCallable;
import com.example.teste_thread.modelo_call.TesteCallableApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@SpringBootTest
class TesteThreadApplicationTests {
	@Mock
	private SmartcareClient smartcareClient;

	@Mock
	private DataEntryPEPThread theSimsThread;

	@Mock
	private DataEntryCPOEThread cpoeThread;

	private TesteThreadApplication testeThreadApplication;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		testeThreadApplication = new TesteThreadApplication();
	}

	@DisplayName("executeApplication should handle successful execution")
	@Test
	void executeApplication_SuccessfulExecution() throws InterruptedException {
		doNothing().when(theSimsThread).start();
		doNothing().when(cpoeThread).start();
		doNothing().when(theSimsThread).join();
		doNothing().when(cpoeThread).join();

		testeThreadApplication.executeApplication();

		verify(theSimsThread, times(1)).start();
		verify(cpoeThread, times(1)).start();
		verify(theSimsThread, times(1)).join();
		verify(cpoeThread, times(1)).join();
	}

	@DisplayName("executeApplication should handle interrupted exception")
	@Test
	void executeApplication_InterruptedException() throws InterruptedException {
		doThrow(InterruptedException.class).when(theSimsThread).join();

		testeThreadApplication.executeApplication();

		verify(theSimsThread, times(1)).start();
		verify(cpoeThread, times(1)).start();
		verify(theSimsThread, times(1)).join();
	}
}
