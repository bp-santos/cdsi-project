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
"Definição [" +
" finalidade;" +
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
@Table(name = "pr_finalidade")

public class PR_Finalidade {
	//-----------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-----------------------------------------
	@Id
	@Column(name="finalidade", length=15)
	private String finalidade; 
	
	@Hidden
	@Column(name="finalidade_id")
	private int finalidadeid; 

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
	public int getFinalidadeid() {
		return finalidadeid;
	}

	public void setFinalidadeid(int yfinalidadeid) {
		//this.finalidadeoid = yfinalidadeid;
	}

	public String getFinalidade() {
		return finalidade; 
	}
	
	public void setFinalidade(String yfinalidade) {
		 this.finalidade = yfinalidade; 
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
		if (yestadolog.isEmpty() || yestadolog.isBlank() || yestadolog==null) {yestadolog="A";}
	    this.estadolog = yestadolog; 
	}

}
