USE youcredit;

DROP TABLE IF EXISTS cr_simulacao_credito;
DROP TABLE IF EXISTS cr_estado_credito_simulacao;
DROP TABLE IF EXISTS cr_periodicidade_estado_prestacao;

CREATE TABLE cr_estado_credito_simulacao (
	estado_id INT AUTO_INCREMENT,
    estado_simulacao VARCHAR (15) NOT NULL,
    descricao VARCHAR (15) NOT NULL,
	data_log TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    utilizador_log INT NOT NULL,
    estado_log VARCHAR(1) NOT NULL DEFAULT "A",
    
    PRIMARY KEY (estado_id),
	CONSTRAINT cr_estado_credito_simulacao_chk_estadolog CHECK (estado_log="A" OR estado_log="I")
);

CREATE TABLE cr_periodicidade_estado_prestacao (
	periodicidade_id INT AUTO_INCREMENT,
    periodicidade VARCHAR(15) NOT NULL,
    descricao VARCHAR(15) NOT NULL,
	data_log TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    utilizador_log INT NOT NULL,
    estado_log VARCHAR(1) NOT NULL DEFAULT "A",
    
    PRIMARY KEY (periodicidade_id),
	CONSTRAINT cr_periodicidade_estado_prestacao_chk_estadolog CHECK (estado_log="A" OR estado_log="I")  
);

CREATE TABLE cr_simulacao_credito (
	simulacao_id INT AUTO_INCREMENT,
	referencia VARCHAR(50) NOT NULL, 					
    flag_credito BOOLEAN NOT NULL,					
    data_solicitacao DATE,							
    data_decisao DATE,								
    data_inicio DATE NOT NULL,	
    data_fim DATE,							
    data_avaliacao DATE,						
    data_alteracao_estado_credito DATE,         	
    total_solicitado DOUBLE NOT NULL,			
    total_concedido DOUBLE,					
    total_possivel DOUBLE NOT NULL,					
    total_capital DOUBLE,			
    total_juro DOUBLE NOT NULL,							
    total_despesa DOUBLE NOT NULL,					
    total_imposto DOUBLE NOT NULL,					
    descricao_objeto VARCHAR(50),				
    duracao INT,							
    scoring INT NOT NULL,									
    data_alteracao_estado_simulacao DATE NOT NULL,			
    parecer BOOLEAN NOT NULL,
    estado_id INT,
    periodicidade_id INT,
    produto_id INT,
    entidade_id INT,
    entidadeavalista VARCHAR(50),
	existe_crm VARCHAR(1), 
    data_log TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    utilizador_log INT NOT NULL,
    estado_log VARCHAR(1) NOT NULL DEFAULT "A",
    
    PRIMARY KEY (simulacao_id),
    
    FOREIGN KEY (estado_id)
        REFERENCES cr_estado_credito_simulacao (estado_id),
        
	FOREIGN KEY (periodicidade_id)
        REFERENCES cr_periodicidade_estado_prestacao (periodicidade_id),
        
	FOREIGN KEY (produto_id)
        REFERENCES pr_produto (produto_id),
        
	FOREIGN KEY (entidade_id)
        REFERENCES en_entidade (entidade_id),
        
	CONSTRAINT cr_simulacao_credito_chk_estadolog CHECK (estado_log="A" OR estado_log="I")  
);
