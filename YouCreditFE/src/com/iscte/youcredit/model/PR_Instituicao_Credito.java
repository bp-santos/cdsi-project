package com.iscte.youcredit.model;
import java.math.*;
import java.time.*;
import javax.persistence.*;
import org.openxava.annotations.*;
import org.openxava.model.*;
import org.openxava.util.*;

//-----------------------------------------------
//Modelização de interface com utilizador 
//-----------------------------------------------
@View(members=
"Identificação [" +
" banco;" +
" nome;" +
" nif;" +
"]" +
"Morada [" +
" morada;" +
" codigopostal;" +
"];" +
"Protocolo [" +
" referencia,datainicio, datafim;" +
" contactocomercial;" +
" contactocredito;" +
" contactoit;" +
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
@Table(name = "pr_instituicao_credito")

public class PR_Instituicao_Credito {
	//-----------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-----------------------------------------
	@Hidden 
	@Column(name="instituicao_credito_id")
	private int instituicaocreditoid; 
	
	@Id
	@Column(name="instituicao_credito", length=15)
	private String banco; 

	@ReadOnly
	@Column(name="nome", length=50)
	private String nome;

	@Required
	@Column(name="morada", length=100)
	private String morada;

	@Required
	@Column(name="codigo_postal", length=10)
	private String codigopostal;

	@Required
	@Column(name="nif", length=10)
	private String nif;

	@Required
	@Column(name="contacto_comercial", length=50)
	private String contactocomercial;

	@Required
	@Column(name="contacto_credito", length=50)
	private String contactocredito;

	@Required
	@Column(name="contacto_it", length=50)
	private String contactoit;

	@Required
	@Column(name="protocolo_ref", length=30)
	private String referencia;

	@ReadOnly
	@Column(name="data_inicio")
	private LocalDate datainicio;

	@ReadOnly
	@Column(name="data_fim")
	private LocalDate datafim;

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
	public int getInstituicaocreditoid() {
		return instituicaocreditoid;
	}

	public void setInstituicaocreditoid(int yinstituicaocreditoid) {
		//this.instituicaocreditoid = yinstituicaocreditoid;
	}

	public String getBanco() {
		return banco; 
	}
	
	public void setBanco(String ybanco) {
		 this.banco = ybanco; 
	}
	
	public String getNome() {
		return nome; 
	}
	public void setNome(String ynome) {
		this.nome = ynome; 
	}

	public String getMorada() {
		return morada; 
	}
	public void setMorada(String ymorada) {
		this.morada = ymorada; 
	}

	public String getCodigopostal() {
		return codigopostal; 
	}
	public void setCodigopostal(String ycodigopostal) {
		this.codigopostal = ycodigopostal; 
	}

	public String getNif() {
		return nif; 
	}
	public void setNif(String ynif) {
		this.nif = ynif; 
	}

	public String getContactocomercial() {
		return contactocomercial; 
	}
	public void setContactocomercial(String ycontactocomercial) {
		this.contactocomercial = ycontactocomercial; 
	}

	public String getContactocredito() {
		return contactocredito; 
	}
	public void setContactocredito(String ycontactocredito) {
		this.contactocredito = ycontactocredito; 
	}

	public String getContactoit() {
		return contactoit; 
	}
	public void setContactoit(String ycontactoit) {
		this.contactoit = ycontactoit; 
	}

	public String getReferencia() {
		return referencia; 
	}
	public void setReferencia(String yreferencia) {
		this.referencia = yreferencia; 
	}

	public LocalDate getDatainicio() {
		return datainicio; 
	}
	public void setDatainicio(LocalDate ydatainicio) {
		if (ydatainicio == null) {ydatainicio=LocalDate.now();}
		this.datainicio = ydatainicio; 
	}

	public LocalDate getDatafim() {
		return datafim; 
	}
	public void setDatafim(LocalDate ydatafim) {
		if (ydatafim == null) {ydatafim=LocalDate.now().plusYears(20);}
		this.datafim = ydatafim; 
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
		if (yestadolog.isEmpty() || yestadolog.isBlank() || yestadolog==null) {yestadolog="A";}
		this.estadolog = yestadolog; 
	}
	//--------------------------------------------
	//Método de validação total do ecrã
	//--------------------------------------------
	@PrePersist @PreUpdate // Antes de criar ou alterar o registo
	private void validate()  throws Exception {
		if (datainicio.isAfter(datafim) ) { 
			throw new javax.validation.ValidationException(
			          XavaResources.getString(
			                "Data inicio superior a data de fim ",
			                datainicio,datafim)
			        );
			 }
		}

}
