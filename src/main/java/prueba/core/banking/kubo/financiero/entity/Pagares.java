package prueba.core.banking.kubo.financiero.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entity Pagares
 * 
 * @author @walejandromt (Williams Alejandro)
 *
 */
@Data
@Entity
@Table(name = "PAGARES")
public class Pagares implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7677307010590496383L;

	/**
	 * Atributo pagareid
	 */
	@Id
	@Column(name = "pagareid")
	private Integer pagareid;

	/**
	 * Atributo cuentaid
	 */
	@Column(name = "cuentaid")
	private Integer cuentaid;

	/**
	 * Atributo clienteid
	 */
	@Column(name = "clienteid")
	private Integer clienteid;

	/**
	 * Atributo tipoinversionid
	 */
	@Column(name = "tipoinversionid")
	private Integer tipoinversionid;

	/**
	 * Atributo fechainicio
	 */
	@Column(name = "fechainicio")
	private LocalDate fechainicio;

	/**
	 * Atributo fechavencimiento
	 */
	@Column(name = "fechavencimiento")
	private LocalDate fechavencimiento;

	/**
	 * Atributo montoinversion
	 */
	@Column(name = "montoinversion")
	private BigDecimal montoinversion;

	/**
	 * Atributo plazo
	 */
	@Column(name = "plazo")
	private Integer plazo;

	/**
	 * Atributo tasa
	 */
	@Column(name = "tasa")
	private BigDecimal tasa;

	/**
	 * Atributo tasaisr
	 */
	@Column(name = "tasaisr")
	private BigDecimal tasaisr;

	/**
	 * Atributo tasaneta
	 */
	@Column(name = "tasaneta")
	private BigDecimal tasaneta;

	/**
	 * Atributo interesgenerado
	 */
	@Column(name = "interesgenerado")
	private BigDecimal interesgenerado;

	/**
	 * Atributo interesrecibir
	 */
	@Column(name = "interesrecibir")
	private BigDecimal interesrecibir;

	/**
	 * Atributo interesretener
	 */
	@Column(name = "interesretener")
	private BigDecimal interesretener;

	/**
	 * Atributo estatus
	 */
	@Column(name = "estatus")
	private Character estatus;

	/**
	 * Atributo reinvertir
	 */
	@Column(name = "reinvertir")
	private Character reinvertir;

	/**
	 * Atributo inversionrenovada
	 */
	@Column(name = "inversionrenovada")
	private Integer inversionrenovada;

	/**
	 * Atributo monedaid
	 */
	@Column(name = "monedaid")
	private Integer monedaid;

	/**
	 * Atributo etiqueta
	 */
	@Column(name = "etiqueta")
	private String etiqueta;

	/**
	 * Atributo saldoprovision
	 */
	@Column(name = "saldoprovision")
	private BigDecimal saldoprovision;

	/**
	 * Atributo valorgat
	 */
	@Column(name = "valorgat")
	private BigDecimal valorgat;

	/**
	 * Atributo beneficiario
	 */
	@Column(name = "beneficiario")
	private Character beneficiario;

	/**
	 * Atributo valorgatreal
	 */
	@Column(name = "valorgatreal")
	private BigDecimal valorgatreal;

	/**
	 * Atributo fechavenant
	 */
	@Column(name = "fechavenant")
	private LocalDate fechavenant;

	/**
	 * Atributo direccionip
	 */
	@Column(name = "direccionip")
	private String direccionip;

}
