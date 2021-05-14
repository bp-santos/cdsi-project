package com.iscte.youcredit.model;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@View(members=
"Definição ["+
"estado ,descricao;" +
"];" +
"Logging [" +
" datalog;" +
" utilizadorlog;" +
" estadolog;" +
"]"
)

@Tab(properties = "estado, descricao")

@Entity 
@Table(name = "cr_estado_credito_simulacao")

public class CR_Estado_Credito_Simulacao {
	
	@Id 
	@Column (name = "estado_simulacao", length = 15)
	private String estado;
	
	@Hidden 
    @Column(name="estado_id")
	private int estadoid; 
	
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getEstadoid() {
		return estadoid;
	}

	public void setEstadoid(int estadoid) {
		//this.estadoid = estadoid;
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