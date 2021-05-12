package com.iscte.youcredit.model;
import java.math.*;
import java.time.*;
//packages standard OpenXava 
import javax.persistence.*;
import org.openxava.annotations.*;
import org.openxava.model.*;
//packages específicos de validações
import com.iscte.youcredit.actions.*; 
import org.openxava.util.*;
import org.openxava.validators.*;

//-----------------------------------------------
//Modelização interface com utilizador CRUD
//-----------------------------------------------
@View(members=
"Entidade [" +
" nif;" +
" nome;" +
"]" +
"Simulação [" +
" simulacaoid;" +
" produto;" +
" totalsolicitado;" +
"]" +
"Acção [" +
" evento,dataevento;" +
" parecerresultado,parecerobs;" +
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
@Table(name = "log_parecer_quotacao")

public class LOG_ParecerIC {

	//-------------------------------------------------------------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-------------------------------------------------------------------------------------------
	@Id
	@ReadOnly
	@Column(name="log_parecer_quotacao_id")
	private int logparecerquotacaoid;
	
	@ReadOnly
	@Column(name="simulacao_id")
	private int simulacaoid;

	@ReadOnly
	@Column(name="produto")
	private String produto;

	@ReadOnly
	@Column(name="nome")
	private String nome;

	@ReadOnly
	@Column(name="nif")
	private String nif;

	@ReadOnly
	@Column(name="total_solicitado")
	private double totalsolicitado;

	@ReadOnly
	@Column(name="evento")
	private String evento;

	@ReadOnly
	@Column(name="data_evento")
	private LocalDate dataevento;

	@ReadOnly
	@Column(name="parecer_obs")
	private String parecerobs;

	@ReadOnly
	@Column(name="parecer_resultado")
	private boolean parecerresultado;

	@ReadOnly  
	@Column(name="data_log")
	private LocalDate datalog;

	@ReadOnly
	@Column(name="utilizador_log")
	private int utilizadorlog;
	
	@ReadOnly
	@Column(name="estado_log",length=1)
	private String estadolog;

	//-------------------------------------------------------------------------------------------
	//Definição de métodos JPA/Hibernate 
	//-------------------------------------------------------------------------------------------
	public int getLogparecerquotacaoid() {
		return logparecerquotacaoid;
	}

	public void setLogparecerquotacaoid(int logparecerquotacaoid) {
		this.logparecerquotacaoid = logparecerquotacaoid;
	}

	public int getSimulacaoid() {
		return simulacaoid;
	}

	public void setSimulacaoid(int simulacaoid) {
		this.simulacaoid = simulacaoid;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public double getTotalsolicitado() {
		return totalsolicitado;
	}

	public void setTotalsolicitado(double totalsolicitado) {
		this.totalsolicitado = totalsolicitado;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getDataevento() {
		return dataevento;
	}

	public void setDataevento(LocalDate dataevento) {
		this.dataevento = dataevento;
	}

	public String getParecerobs() {
		return parecerobs;
	}

	public void setParecerobs(String parecerobs) {
		this.parecerobs = parecerobs;
	}

	public boolean isParecerresultado() {
		return parecerresultado;
	}

	public void setParecerresultado(boolean parecerresultado) {
		this.parecerresultado = parecerresultado;
	}

	public LocalDate getDatalog() {
		return datalog;
	}

	public void setDatalog(LocalDate datalog) {
		this.datalog = datalog;
	}

	public int getUtilizadorlog() {
		return utilizadorlog;
	}

	public void setUtilizadorlog(int utilizadorlog) {
		this.utilizadorlog = utilizadorlog;
	}

	public String getEstadolog() {
		return estadolog;
	}

	public void setEstadolog(String estadolog) {
		this.estadolog = estadolog;
	}
}
