package com.iscte.youcredit.model;
import java.math.*;
import java.time.*;
import javax.persistence.*;
import org.openxava.annotations.*;
import org.openxava.model.*;
import org.openxava.util.*;

//-----------------------------------------------
//Modeliza��o de interface com utilizador 
//-----------------------------------------------
@View(members=
"Defini��o [" +
" tipo;" +
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
@Table(name = "en_tipo_relacao_entidade")


public class EN_Tipo_Relacao_Entidade {
	//-----------------------------------------
	//Defini��o de propriedades JPA/Hibernate 
	//-----------------------------------------
	@Id
	@Column(name="tipo_relacao_entidade", length=15)
	private String tipo; 
	
	@Hidden
	@Column(name="tipo_relacao_entidade_id")
	private int tiporelacaoentidadeid; 

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
	//Defini��o de m�todos JPA/Hibernate 
	//-----------------------------------------
	public int getTiporelacaoentidadeid() {
		return tiporelacaoentidadeid;
	}

	public void setTiporelacaoentidadeid(int ytiporelacaoentidadeid) {
		//this.tiporelacaoentidadeid = ytiporelacaoentidadeid;
	}

	public String getTipo() {
		return tipo; 
	}
	
	public void setTipo(String ytipo) {
		 this.tipo = ytipo; 
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
