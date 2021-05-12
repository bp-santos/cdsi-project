package com.iscte.youcredit.model;
//packages OpenXava
import org.openxava.annotations.*;
import org.openxava.model.*;
//packages JPA/Hibernate
import javax.persistence.*;
//packages utilit�rios 
import java.math.*;
import java.time.*;
import org.openxava.validators.*;
import org.openxava.util.*;

//-----------------------------------------------
//Modeliza��o de interface com utilizador 
//-----------------------------------------------
@View(members=
"Defini��o [" +
" sectoractividade;" +
" descricao;" +
"];" +
"Logging [" +
" datalog;" +
" utilizadorlog;" +
" estadolog;" +
"]"
)

//-----------------------------------------------
//Liga��o da classe a tabela via JPA/Hibernate 
//-----------------------------------------------
@Entity 
@Table(name = "en_sector_actividade")

public class EN_Sector_Actividade {
	//-----------------------------------------
	//Defini��o de propriedas JPA/Hibernate 
	//-----------------------------------------
	@Id
	@Column(name="sector_actividade", length=15)
	private String sectoractividade; 

	@Hidden
	@Column(name="sector_actividade_id")
	private int sectoractividadeid; 

	@Required
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
	//Defini��o de m�todos JPA/Hibernate 
	//-----------------------------------------
	public int getSectoractividadeid() {
		return sectoractividadeid;
	}

	public void setSectoractividadeid(int ysectoractividadeid) {
		//this.sectoractividadeid = ysectoractividadeid;
	}

	public String getSectoractividade() {
		return sectoractividade; 
	}
	
	public void setSectoractividade(String ysectoractividade) {
		 this.sectoractividade = ysectoractividade; 
	}
	
	public String getDescricao() {
		return descricao; 
	}
	public void setDescricao(String ydescricao) {
		if (Utilitarios.CampoStringValido(ydescricao,5)==false) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Descri��o: Valor incorreto ", ydescricao)
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
