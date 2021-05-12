package com.iscte.youcredit.model;

import java.math.*;
import java.time.*;
import javax.persistence.*;
import org.openxava.annotations.*;
import org.openxava.model.*;
import org.openxava.util.*;
import org.openxava.actions.*;
import com.iscte.youcredit.actions.*;

//-----------------------------------------------
//Modelização de interface com utilizador 
//-----------------------------------------------
@View(members=
"Definição [" +
" nacionalidade;" +
" descricao;" +
"];" +
"Logging [" +
" datalog;" +
" utilizadorlog;" +
" estadolog;" +
"]"
)

//-----------------------------------------------
//Ligação da classe a tabela via JPA/Hibernate 
//-----------------------------------------------
@Entity 
@Table(name = "en_nacionalidade")


public class EN_Nacionalidade {
	//-----------------------------------------
	//Definição de propriedas JPA/Hibernate 
	//-----------------------------------------
	@Id
	@Column(name="nacionalidade", length=15)
	private String nacionalidade; 

	@Hidden 
    @Column(name="nacionalidade_id")
	private int nacionalidadeid; 

	@ReadOnly
	@Column(name="descricao", length=50)
	private String descricao;
	
	@ReadOnly
	@Column(name="data_log")
	private LocalDate datalog;
    
	@ReadOnly
	@Column(name="utilizador_log")
	private int utilizadorlog;
	
	@ReadOnly
	@Column(name="estado_log",length=1)
	private String estadolog;

	//-----------------------------------------
	//Definição de métodos JPA/Hibernate 
	//-----------------------------------------
	public int getNacionalidadeid() {
		return nacionalidadeid;
	}

	public void setNacionalidadeid(int ynacionalidadeid) {
		//this.nacionalidadeid = ynacionalidadeid;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String ynacionalidade) {
		this.nacionalidade = ynacionalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String ydescricao) {
		if (Utilitarios.CampoStringValido(ydescricao,5)==false) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Descrição: Valor incorreto ", ydescricao)
	        );
	    }
		this.descricao = ydescricao;
	}
	public LocalDate getDatalog() {
		return datalog; 
	}
	public void setDatalog(LocalDate ydatalog) {
		if (ydatalog == null) {ydatalog = LocalDate.now();}
		this.datalog = ydatalog; 
	}

	public int getUtilizadorlog() {
		return utilizadorlog; 
	}
	public void setUtilizadorlog(int yutilizadorlog) {
	    yutilizadorlog=1;
		this.utilizadorlog = yutilizadorlog; 
	}

	public String getEstadolog() {
		return estadolog; 
	}

	public void setEstadolog(String yestadolog) {
		if (yestadolog.isEmpty() || yestadolog == null || yestadolog.isBlank() ) {yestadolog="A";}
		this.estadolog = yestadolog; 
	}
	
}
