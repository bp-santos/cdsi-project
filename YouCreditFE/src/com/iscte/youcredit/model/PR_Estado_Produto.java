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
" estado;" +
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
@Table(name = "pr_estado_produto")


public class PR_Estado_Produto {
    	//-----------------------------------------
		//Defini��o de propriedades JPA/Hibernate 
		//-----------------------------------------
		@Id
		@Column(name="estado_produto", length=15)
		private String estado; 
		
		@Hidden
		@Column(name="estado_produto_id")
		private int estadoprodutoid; 

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
		//Defini��o de m�todos JPA/Hibernate 
		//-----------------------------------------
		public int getEstadoprodutoid() {
			return estadoprodutoid;
		}

		public void setEstadoprodutoid(int yestadoprodutoid) {
			//this.estadoprodutoid = yestadoprodutoid;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String yestado) {
			if (yestado == "Ola" ) { 
		        throw new javax.validation.ValidationException(
		            XavaResources.getString(
		                "estado errado ",
		                yestado)
		        );
		    } 
			this.estado = yestado;
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
