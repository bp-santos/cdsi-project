package com.iscte.youcredit.model;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@View(members=
"Definição ["+
"periodicidade, descricao;" +
"];" +
"Logging [" +
" datalog;" +
" utilizadorlog;" +
" estadolog;" +
"]"
)

@Tab(properties = "periodicidade, descricao")

@Entity 
@Table(name = "cr_periodicidade_estado_prestacao")

public class CR_Periodicidade {

	@Id
	@Column (name = "periodicidade", length = 15)	
	private String periodicidade;
	
	@Hidden 
    @Column(name="periodicidade_id")
	private int periodicidadeid; 
	
	@Column(name = "descricao",length= 15)
	private String descricao;
	
	@ReadOnly
	@Column(name="data_log")
	private LocalDate datalog;
    
	@ReadOnly
	@Column(name="utilizador_log")
	private int utilizadorlog;
	
	@Column(name="estado_log",length=1)
	private String estadolog;
		
	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}
	
	public int getPeriodicidadeid() {
		return periodicidadeid;
	}

	public void setPeriodicidadeid(int periodicidadeid) {
		//this.periodicidadeid = periodicidadeid;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	    yutilizadorlog=Utilizador.getUtilizadorid(Users.getCurrent());
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