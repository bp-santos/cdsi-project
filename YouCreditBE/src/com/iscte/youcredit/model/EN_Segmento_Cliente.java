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
" segmentocliente;" +
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
@Table(name = "en_segmento_cliente")


public class EN_Segmento_Cliente {
	//-----------------------------------------
	//Definição de propriedas JPA/Hibernate 
	//-----------------------------------------
	@Id
	@Column(name="segmento_cliente", length=15)
	private String segmentocliente; 
	
	@Hidden
	@Column(name="segmento_cliente_id")
	private int segmentoclienteid; 

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
	public int getSegmentoclienteid() {
		return segmentoclienteid;
	}

	public void setSegmentoclienteid(int ysegmentoclienteid) {
		//this.segmentoclienteid = ysegmentoclienteid;
	}

	public String getSegmentocliente() {
		return segmentocliente; 
	}
	
	public void setSegmentocliente(String ysegmentocliente) {
		 this.segmentocliente = ysegmentocliente; 
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

}
