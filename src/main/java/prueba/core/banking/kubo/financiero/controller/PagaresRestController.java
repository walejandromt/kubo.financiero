package prueba.core.banking.kubo.financiero.controller;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import prueba.core.banking.kubo.financiero.service.PagaresService;

/**
 * Controlador para la entidad PAGARES
 * 
 * @author @walejandromt (Williams Alejandro)
 *
 */
@Log4j2
@RestController
@Tag(name = "PagaresRestController", description = "Controlador para la entidad PAGARES")
public class PagaresRestController {

	/**
	 * Servicio PagaresService
	 */
	@Autowired
	private PagaresService pagaresService;

	/**
	 * Metodo actualiceTasaISR
	 * 
	 * @param tasaIsr
	 * @return
	 * @throws SQLException
	 */
	@PostMapping("actualiceTasaISR/{tasaIsr}/{estatus}")
	@Operation(summary = "Actualizar Tasa ISR", description = "Llama Stored Procedure para actualizar la tasa de ISR e intereses")
	public int actualiceTasaISR(@PathVariable BigDecimal tasaIsr, @PathVariable Character estatus) throws SQLException {
		log.info(">>> actualiceTasaISR {} - Estatus {}", tasaIsr, estatus);
		return pagaresService.actualiceTasaISR(tasaIsr, estatus);
	}
}
