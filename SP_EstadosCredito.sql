DROP EVENT IF EXISTS `Evento_ActualizarEstado_5dias`;
CREATE EVENT `Evento_ActualizarEstado_5dias`
	ON SCHEDULE EVERY 60 minute
    STARTS current_timestamp()
    DO CALL ActualizarEstadoSimulacao(5,3,"Sem Efeito");
    
DROP EVENT IF EXISTS `Evento_ActualizarEstado_10dias`;
CREATE EVENT `Evento_ActualizarEstado_10dias`
	ON SCHEDULE EVERY 60 minute
    STARTS current_timestamp()
    DO CALL ActualizarEstadoSimulacao(10,6,"Sem Interesse");
    
use youcredit;
DROP PROCEDURE IF EXISTS ActualizarEstadoSimulacao
DELIMITER $$
CREATE PROCEDURE ActualizarEstadoSimulacao(IN ytempo INTEGER, IN estado INTEGER, estado_nome VARCHAR(20))
BEGIN
DECLARE xfim_cursor INTEGER DEFAULT 0;
 DECLARE xestado VARCHAR(1);
 DECLARE xestado_id INTEGER;
 DECLARE xqtd_registos INTEGER;

 DECLARE xCursorSimulaçoes CURSOR FOR
 SELECT estado_id
 FROM cr_simulacao_credito
 WHERE datediff(curdate(),data_alteracao_estado_credito) > ytempo; # 5 ou 10 dias
DECLARE CONTINUE HANDLER FOR NOT FOUND SET xfim_cursor = 1;

 OPEN xCursorSimulacoes;
 SET xqtd_registos = 0;
 ObterSimulacao: LOOP
 FETCH xCursorSimulacoes INTO xestado_id; 

 IF xfim_cursor = 1 THEN
 LEAVE ObterSimulacao;
 END IF;
 UPDATE cr_simulacao_credito
 SET estado_id = estado, classeestadocredito_estado_simulacao = estado_nome
 WHERE estado_id = xestado_id;
 SET xqtd_registos = xqtd_registos + 1;
 END LOOP ObterSimulacao;
 CLOSE xCursorSimulacoes;
END$$
DELIMITER ;

#SET @@GLOBAL.event_scheduler = ON;
#CALL ActualizarEstadoSimulacao(10,6,"Sem Interesse");