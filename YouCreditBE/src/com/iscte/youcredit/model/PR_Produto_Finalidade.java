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
"Relação Produto com Finalidade [" +
" produtofinalidadeid;" +
" classeproduto,classefinalidade;" +
" datainicio,datafim;" +
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
@Table(name = "pr_produto_objecto")

public class PR_Produto_Finalidade {
	//-----------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-----------------------------------------
	
	@Id 
	@ReadOnly
	@Column(name="produto_finalidade_id")
	private int produtofinalidadeid; 

	@Hidden
	@Column(name="produto_id")
	private int produtoid; 
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="nome", 
			condition="${estadolog} = 'A'")
	private PR_Produto classeproduto; 

	@Hidden
	@Column(name="finalidade_id")
	private int finalidadeid;

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private PR_Finalidade classefinalidade; 
	
	@Required
	@Column(name="data_inicio")
	private LocalDate datainicio;
	
	@Required
	@Column(name="data_fim")
	private LocalDate datafim;

	@Required
	@Column(name="descricao", length=50)
	private String descricao;

	@ReadOnly
	@Column(name="data_log")
	private LocalDate datalog;

	@ReadOnly
	@Column(name="utilizador_log")
	private int utilizadorlog;

	@Column(name="estado_log",length=1)
	private String estadolog;

	//-----------------------------------------
	//Definição de métodos JPA/Hibernate 
	//-----------------------------------------
	public int getProdutofinalidadeid() {
		return produtofinalidadeid;
	}

	public void setProdutofinalidadeid(int yprodutofinalidadeid) {
		//this.produtofinalidadeid = yprodutofinalidadeid;
	}

	public int getProdutoid() {
		return produtoid; 
	}

	public void setProdutoid(int yprodutoid) {
		 this.produtoid = yprodutoid; 
	}
	
	public PR_Produto getClasseproduto() {
		return classeproduto;
	}

	public void setClasseproduto(PR_Produto yclasseproduto) {
		this.classeproduto = yclasseproduto;
		this.produtoid = yclasseproduto.getProdutoid();
	}
	
	public int getFinalidadeid() {
		return finalidadeid; 
	}
	public void setFinalidadeid(int yfinalidadeid) {
		this.finalidadeid = yfinalidadeid; 
	}

	public PR_Finalidade getClassefinalidade() {
		return classefinalidade;
	}

	public void setClassefinalidade(PR_Finalidade yclassefinalidade) {
		this.classefinalidade = yclassefinalidade;
		this.finalidadeid = yclassefinalidade.getFinalidadeid();
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

	public LocalDate getDatainicio() {
		return datainicio; 
	}
	public void setDatainicio(LocalDate ytdatainicio) {
		this.datainicio = ytdatainicio; 
	}

	public LocalDate getDatafim() {
		return datafim; 
	}
	public void setDatafim(LocalDate ytdatafim) {
		this.datafim = ytdatafim; 
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
