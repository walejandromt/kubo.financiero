package prueba.core.banking.kubo.financiero.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import prueba.core.banking.kubo.financiero.repository.PagaresRepository;
import prueba.core.banking.kubo.financiero.service.PagaresService;

/**
 * Implementacion PagaresServiceImpl
 * 
 * @author @walejandromt (Williams Alejandro)
 *
 */
@Log4j2
@Service
public class PagaresServiceImpl implements PagaresService {

	/**
	 * Repository PagaresRepository
	 */
	@Autowired
	private PagaresRepository pagaresRepository;

	/**
	 * Metodo actualiceTasaISR
	 */
	@Override
	public int actualiceTasaISR(BigDecimal tasaisr, Character estatus) {
		log.info("Se intenta llamar el Store Procedure actualice_tasaISR {}", tasaisr);
		return pagaresRepository.actualiceTasaISR(tasaisr, estatus);
	}

}
