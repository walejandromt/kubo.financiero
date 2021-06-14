package prueba.core.banking.kubo.financiero.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import prueba.core.banking.kubo.financiero.entity.Pagares;

/**
 * Repository PagaresRepository
 * 
 * @author @walejandromt (Williams Alejandro)
 *
 */
@Repository
public interface PagaresRepository extends JpaRepository<Pagares, Integer>, JpaSpecificationExecutor<Pagares> {

	/**
	 * Llama Stored Procedure actualice_tasaISR
	 * 
	 * @param tasaisr
	 * @return
	 */
	@Procedure("actualice_tasaISR")
	int actualiceTasaISR(@Param("tasa_isr") BigDecimal tasaisr, @Param("param_estatus") Character estatus);
}
