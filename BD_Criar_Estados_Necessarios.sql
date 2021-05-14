use youcredit;
DELETE FROM cr_estado_credito_simulacao;
INSERT INTO cr_estado_credito_simulacao (estado_id,estado_simulacao,descricao,data_log,utilizador_log,estado_log)
VALUES (1,"Registado","Registado",current_timestamp(),0,"A");
INSERT INTO cr_estado_credito_simulacao (estado_id,estado_simulacao,descricao,data_log,utilizador_log,estado_log)
VALUES (2,"Para Aprovação","Para Aprovação",current_timestamp(),0,"A");
INSERT INTO cr_estado_credito_simulacao (estado_id,estado_simulacao,descricao,data_log,utilizador_log,estado_log)
VALUES (3,"Sem Efeito","Sem Efeito",current_timestamp(),0,"A");
INSERT INTO cr_estado_credito_simulacao (estado_id,estado_simulacao,descricao,data_log,utilizador_log,estado_log)
VALUES (4,"Aprovado","Aprovado",current_timestamp(),0,"A");
INSERT INTO cr_estado_credito_simulacao (estado_id,estado_simulacao,descricao,data_log,utilizador_log,estado_log)
VALUES (5,"Não Aprovado","Não Aprovado",current_timestamp(),0,"A");
INSERT INTO cr_estado_credito_simulacao (estado_id,estado_simulacao,descricao,data_log,utilizador_log,estado_log)
VALUES (6,"Sem Interesse","Sem Interesse",current_timestamp(),0,"A");
select * from cr_estado_credito_simulacao;
