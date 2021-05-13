DROP EVENT IF EXISTS `Evento_ActualizarEstado_5dias`;
CREATE EVENT `Evento_ActualizarEstado_5dias`
	ON SCHEDULE EVERY 60 minute
    STARTS current_timestamp()
    DO CALL ActualizarEstadosSimulacao();
    
DROP EVENT IF EXISTS `Evento_ActualizarEstado_10dias`;
CREATE EVENT `Evento_ActualizarEstado_10dias`
	ON SCHEDULE EVERY 60 minute
    STARTS current_timestamp()
    DO CALL ActualizarEstadosCredito();
    
DELIMITER $$
-- CREATE PROCEDURE ActualizarEstados
CREATE PROCEDURE ActualizarEstadosSimulacao()
BEGIN

	SELECT simulacao_credito_id, estado_id
	FROM cr_simulacao_credito
	WHERE datediff(curdate(),data_alteracao_estado_simulacao) > 5;
    
    UPDATE novoestado SET estado_id = 5
    WHERE estado = "Sem Interesse"
    AND descricao = "Sem Interesse";

END$$
DELIMITER ; 

DELIMITER $$
CREATE PROCEDURE ActualizarEstadosCredito()
BEGIN

	SELECT simulacao_credito_id, estado_id
	FROM cr_simulacao_credito
	WHERE datediff(curdate(),data_alteracao_estado_simulacao) > 10;

END$$
DELIMITER ; 