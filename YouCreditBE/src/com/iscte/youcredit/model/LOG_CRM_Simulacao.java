package com.iscte.youcredit.model;
//packages standard Java
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
" entidadeid,nif;" +
" nome;" +
" telefone,email;" +
"]" +
"Simulação [" +
" simulacaoid;" +
" instituicaocredito, produto;" +
" totalsolicitado,totalpossivel;" +
" estadosimulacao,scoring;" +
"]" +
"Acção [" +
" evento,dataevento;" +
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
@Table(name = "log_crm_simulacao")


public class LOG_CRM_Simulacao {
	//-------------------------------------------------------------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-------------------------------------------------------------------------------------------
	@Id
	@ReadOnly
	@Column(name="log_crm_simulacao_id")
	private int crmsimulacaoid; 

	@ReadOnly
	@Column(name="simulacao_id")
	private int simulacaoid; 

	@ReadOnly
	@Column(name="produto")
	private String produto; 

	@ReadOnly
	@Column(name="institucao_credito")
	private String instituicaocredito; 

	@ReadOnly
	@Column(name="entidade_id")
	private int entidadeid; 

	@ReadOnly
	@Column(name="nome")
	private String nome; 

	@ReadOnly
	@Column(name="nif")
	private String nif; 

	@ReadOnly
	@Column(name="telefone")
	private String telefone; 

	@ReadOnly
	@Column(name="email")
	private String email; 

	@ReadOnly
	@Column(name="rating")
	private int rating; 

	@ReadOnly
	@Column(name="estado_entidade")
	private String estadoentidade; 

	@ReadOnly
	@Column(name="total_solicitado")
	private double totalsolicitado; 

	@ReadOnly
	@Column(name="total_possivel")
	private double totalpossivel; 

	@ReadOnly
	@Column(name="estado_simulacao")
	private String estadosimulacao; 

	@ReadOnly
	@Column(name="scoring")
	private int scoring; 

	@ReadOnly
	@Column(name="evento")
	private String evento; 

	@ReadOnly
	@Column(name="data_evento")
	private LocalDate dataevento; 

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

	public int getCrmsimulacaoid() {
		return crmsimulacaoid;
	}

	public void setCrmsimulacaoid(int crmsimulacaoid) {
		this.crmsimulacaoid = crmsimulacaoid;
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

	public String getInstituicaocredito() {
		return instituicaocredito;
	}

	public void setInstituicaocredito(String instituicaocredito) {
		this.instituicaocredito = instituicaocredito;
	}

	public int getEntidadeid() {
		return entidadeid;
	}

	public void setEntidadeid(int entidadeid) {
		this.entidadeid = entidadeid;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getEstadoentidade() {
		return estadoentidade;
	}

	public void setEstadoentidade(String estadoentidade) {
		this.estadoentidade = estadoentidade;
	}

	public double getTotalsolicitado() {
		return totalsolicitado;
	}

	public void setTotalsolicitado(double totalsolicitado) {
		this.totalsolicitado = totalsolicitado;
	}

	public double getTotalpossivel() {
		return totalpossivel;
	}

	public void setTotalpossivel(double totalpossivel) {
		this.totalpossivel = totalpossivel;
	}

	public String getEstadosimulacao() {
		return estadosimulacao;
	}

	public void setEstadosimulacao(String estadosimulacao) {
		this.estadosimulacao = estadosimulacao;
	}

	public int getScoring() {
		return scoring;
	}

	public void setScoring(int scoring) {
		this.scoring = scoring;
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
