package com.example.teste_thread.modelo_call;

import com.example.teste_thread.api.SmartcareClient;
import com.example.teste_thread.domain.DataEntryEntities;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@SpringBootTest
class TesteCallableApplicationTests {

	@Mock
	private SmartcareClient smartcareClient;

	@Mock
	private ExecutorService executorService;

	@Mock
	private Future<DataEntryEntities> future;

	private TesteCallableApplication testeThreadApplication;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		testeThreadApplication = new TesteCallableApplication(executorService);
	}

	@DisplayName("executeApplication should handle successful execution")
	@Test
	void executeApplication_SuccessfulExecution() throws ExecutionException, InterruptedException {
		when(executorService.submit(any(Callable.class))).thenReturn(future);
		when(future.get()).thenReturn(new DataEntryEntities());

		testeThreadApplication.executeApplication();

		verify(executorService, times(1)).submit(any(DataEntryPEPCallable.class));
		verify(executorService, times(1)).submit(any(DataEntryCPOECallable.class));
		verify(future, times(2)).get();
		verify(executorService).shutdown();
	}

	@DisplayName("executeApplication should handle execution exception")
	@Test
	void executeApplication_ExecutionException() throws ExecutionException, InterruptedException {
		when(executorService.submit(any(Callable.class))).thenReturn(future);
		when(future.get()).thenThrow(ExecutionException.class);

		testeThreadApplication.executeApplication();

		verify(executorService, times(1)).submit(any(DataEntryPEPCallable.class));
		verify(future, times(1)).get();
		verify(executorService).shutdown();
	}

	@DisplayName("executeApplication should handle interrupted exception")
	@Test
	void executeApplication_InterruptedException() throws ExecutionException, InterruptedException {
		when(executorService.submit(any(Callable.class))).thenReturn(future);
		when(future.get()).thenThrow(InterruptedException.class);

		testeThreadApplication.executeApplication();

		verify(executorService, times(1)).submit(any(DataEntryPEPCallable.class));
		verify(future, times(1)).get();
		verify(executorService).shutdown();
	}

}
