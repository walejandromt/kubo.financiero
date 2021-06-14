-- TABLA PARA RESPALDO
CREATE TABLE `PAGARES_BITACORAS` (
  `PagareID_Key` int(12) NOT NULL AUTO_INCREMENT,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PagareID` int(12) NOT NULL,
  `CuentaID` int(12) NOT NULL,
  `ClienteID` int(11) DEFAULT NULL,
  `TipoInversionID` int(11) NOT NULL COMMENT 'LLave FK Tipo de Inversion',
  `FechaInicio` date NOT NULL COMMENT 'Fecha de Inicio de Inversion',
  `FechaVencimiento` date NOT NULL COMMENT 'Fecha de Vencimiento de Inversion',
  `MontoInversion` decimal(12,2) DEFAULT NULL,
  `Plazo` int(11) NOT NULL COMMENT 'Plazo en Dias',
  `Tasa` decimal(12,2) DEFAULT NULL,
  `TasaISR` decimal(12,2) DEFAULT NULL,
  `TasaNeta` decimal(12,2) DEFAULT NULL,
  `InteresGenerado` decimal(12,2) DEFAULT NULL,
  `InteresRecibir` decimal(12,2) DEFAULT NULL,
  `InteresRetener` decimal(12,2) DEFAULT NULL,
  `Estatus` char(1) NOT NULL COMMENT 'Estatus de la Inversion\n	''A''.- Alta (no autorizada)\n	''N''.- Vigente (cargada a cuenta)\n	''P''.- Pagada (abonada a cuenta)\n	''C''.- Cancelada\n	''V''.- Vencida\n',
  `Reinvertir` char(5) DEFAULT NULL COMMENT 'Tipo de Reinversion Automatica \nC = Capital \nCI = Capital mas interes \nN = Ninguna',
  `InversionRenovada` int(11) DEFAULT NULL COMMENT 'Numero de Inversion Renovada. Inicialmente es\nCero, se llena cuando se realize la reinversion.',
  `MonedaID` int(11) DEFAULT NULL COMMENT 'Moneda de la\nInversion',
  `Etiqueta` varchar(100) DEFAULT NULL COMMENT 'Etiqueta o \nReferencia del\nMotivo de Apertura\nde la Inversion',
  `SaldoProvision` decimal(12,2) DEFAULT NULL COMMENT 'Saldo o Acumulado\nDiario del\nInteres\nProvisionado',
  `ValorGat` decimal(12,2) DEFAULT NULL COMMENT 'Calculo GAT',
  `Beneficiario` char(1) DEFAULT NULL COMMENT 'Tipo de Beneficiario de la inversión, puede ser: Cuenta Socio "S"   o Propio de la Inversión "I"',
  `ValorGatReal` decimal(12,2) DEFAULT NULL,
  `FechaVenAnt` date DEFAULT NULL COMMENT 'Fecha en que se vencio anticipadamente la inversion ',
  `DireccionIP` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`PagareID_Key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tablas de respaldos de inversiones';

-- TRIGGER PARA HACER RESPALDO EN CADA MODIFICACION DE LA TABLA, GUARDANDO FECHA DEL REGISTRO EN 'CREATED'
CREATE TRIGGER `TRIGGER_PAGARES_BITACORAS` BEFORE UPDATE ON `PAGARES` FOR EACH ROW
	INSERT INTO kubofinanciero.PAGARES_BITACORAS
(created, PagareID, CuentaID, ClienteID, TipoInversionID, FechaInicio, FechaVencimiento, MontoInversion, Plazo, Tasa, TasaISR, TasaNeta, InteresGenerado, InteresRecibir, InteresRetener, Estatus, Reinvertir, InversionRenovada, MonedaID, Etiqueta, SaldoProvision, ValorGat, Beneficiario, ValorGatReal, FechaVenAnt, DireccionIP)
VALUES(current_timestamp(), old.PagareID, old.CuentaID, old.ClienteID, old.TipoInversionID, old.FechaInicio, old.FechaVencimiento, old.MontoInversion, old.Plazo, old.Tasa, old.TasaISR, old.TasaNeta, old.InteresGenerado, old.InteresRecibir, old.InteresRetener, old.Estatus, old.Reinvertir, old.InversionRenovada, old.MonedaID, old.Etiqueta, old.SaldoProvision, old.ValorGat, old.Beneficiario, old.ValorGatReal, old.FechaVenAnt, old.DireccionIP);

	
-- STORED PROCEDURE	PARA ACTUALIZAR TASA_ISR Y ACTUALIZAR LOS INTERESES
DROP PROCEDURE IF EXISTS kubofinanciero.actualice_tasaISR;

DELIMITER $$
$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `kubofinanciero`.`actualice_tasaISR`(IN tasa_isr decimal(12,2), IN param_estatus char(1), OUT response_out INT)
BEGIN
	UPDATE kubofinanciero.PAGARES SET TasaISR = tasa_isr, InteresRetener = ((MontoInversion * TasaISR * Plazo ) / (360*100)), InteresRecibir = (InteresGenerado - InteresRetener) WHERE Estatus = param_estatus;
	SELECT 0 into response_out;
END$$
DELIMITER ;


	



