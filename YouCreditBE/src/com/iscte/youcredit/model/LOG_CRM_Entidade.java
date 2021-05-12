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
" entidadeid,estado,rating,nif;" +
" nome;" +
" telefone,email;" +
" morada;" +
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
@Table(name = "log_crm_entidade")

public class LOG_CRM_Entidade {
	//-------------------------------------------------------------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-------------------------------------------------------------------------------------------
	@Id
	@ReadOnly
	@Column(name="log_crm_entidade_id")
	private int crmentidadeid; 

	@ReadOnly
	@Column(name="entidade_id")
	private int entidadeid; 

	@ReadOnly
	@Column(name="nome")
	private String nome; 

	@ReadOnly
	@Column(name="morada")
	private String morada; 

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
	@Column(name="estado")
	private String estado; 

	@ReadOnly
	@Column(name="rating")
	private int rating; 

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

	public int getCrmentidadeid() {
		return crmentidadeid;
	}

	public void setCrmentidadeid(int crmentidadeid) {
		this.crmentidadeid = crmentidadeid;
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

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
