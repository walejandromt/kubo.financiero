package prueba.core.banking.kubo.financiero.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

/**
 * Service PagaresService
 * 
 * @author @walejandromt (Williams Alejandro)
 *
 */
public interface PagaresService {

	/**
	 * Metodo actualiceTasaISR -> Se agrega Circuit Breaker
	 * 
	 * @param tasaisr
	 * @return
	 */
	@Retryable(value = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 1000))
	int actualiceTasaISR(BigDecimal tasaisr, Character estatus);

}
