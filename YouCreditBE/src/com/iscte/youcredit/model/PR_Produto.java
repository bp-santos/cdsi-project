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
" produto,nome;" +
" classeinstituicaocredito;" +
" datainicio, datafim;" +
" classeestadoproduto, dataestadoproduto;" +
"]" +
"Condições [" +
" tempodecisao;" +
" limiteminimo;" +
" limitemaximo;" +
" taxajuro;" +
" taxadespesacontratacao,taxaimpostocontratacao;" +
" taxadespesacobranca,taxaimpostocobranca;" +
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
@Table(name = "pr_produto")


public class PR_Produto {
	//-----------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-----------------------------------------
	@Id
	@Column(name="produto", length=15)
	private String produto;

	//private String utilizador; 
	
	@Hidden
	@Column(name="produto_id")
	private int produtoid;

	@Required
	@Column(name="nome", length=50)
	private String nome; 

	@Required
	@Column(name="tempo_decisao")
	private int tempodecisao;
	
	@Hidden
	@Column(name="instituicao_credito_id")
	private int instituicaocreditoid; 
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="nome", 
			condition="${estadolog} = 'A'")
	private PR_Instituicao_Credito classeinstituicaocredito;
	 
	@Hidden
	@Column(name="estado_produto_id")
	private int estadoprodutoid;

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private PR_Estado_Produto classeestadoproduto;

	@ReadOnly
	@Column(name="data_estado_produto")
	private LocalDate dataestadoproduto;

	@Column(name="data_inicio")
	private LocalDate datainicio;

	@Column(name="data_fim")
	private LocalDate datafim;

	@Required
	@Column(name="limite_maximo")
	private double limitemaximo;

	@Required
	@Column(name="limite_minimo")
	private double limiteminimo;
	
	@Required
	@Column(name="taxa_juro")
	private double taxajuro;

	@Required
	@Column(name="taxa_despesa_contratacao")
	private double taxadespesacontratacao;

	@Required
	@Column(name="taxa_imposto_contratacao")
	private double taxaimpostocontratacao;

	@Required
	@Column(name="taxa_despesa_cobranca")
	private double taxadespesacobranca;

	@Required
	@Column(name="taxa_imposto_cobranca")
	private double taxaimpostocobranca;

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
	//public String getUtilizador() {
	//	this.utilizador = Users.getCurrent();
	//	return utilizador;
	//}

	
	public int getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(int yprodutoid) {
		//this.produtoid = yprodutoid;
	}

	public int getInstituicaocreditoid() {
		return instituicaocreditoid; 
	}
	
	public void setInstituicaocreditoid(int yinstituicaocreditoid) {
		this.instituicaocreditoid = yinstituicaocreditoid; 
	}

	public PR_Instituicao_Credito getClasseinstituicaocredito() {
		return classeinstituicaocredito;
	}

	public void setClasseinstituicaocredito(PR_Instituicao_Credito yclasseinstituicaocredito) {
		this.classeinstituicaocredito = yclasseinstituicaocredito;
		this.instituicaocreditoid = yclasseinstituicaocredito.getInstituicaocreditoid();
	}

	
	public String getNome() {
		return nome; 
	}
	
	public void setNome(String ynome) {
		if (Utilitarios.CampoStringValido(ynome,10)==false) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Nome: Valor incorreto ", ynome)
	        );
	    } 
		this.nome = ynome; 
	}
	
	public String getProduto() {
		return produto; 
	}
	public void setProduto(String yproduto) {
		if (Utilitarios.CampoStringValido(yproduto,5)==false) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Produto: Valor incorreto ", yproduto)
	        );
	    } 
		this.produto = yproduto; 
	}

	public int getTempodecisao() {
		return tempodecisao; 
	}
	public void setTempodecisao(int ytempodecisao) {
		if (ytempodecisao==0 || ytempodecisao > 10) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Tempo decisão: Valor incorreto ", ytempodecisao)
	        );
	    } 
		this.tempodecisao = ytempodecisao; 
	}

	public int getEstadoprodutoid() {
		return estadoprodutoid; 
	}
	public void setEstadoprodutoid(int yestadoprodutoid) {
		this.estadoprodutoid = yestadoprodutoid; 
	}

	public PR_Estado_Produto getClasseestadoproduto() {
		return classeestadoproduto;
	}

	public void setClasseestadoproduto(PR_Estado_Produto yclasseestadoproduto) {
		this.classeestadoproduto = yclasseestadoproduto;
		if (this.estadoprodutoid != yclasseestadoproduto.getEstadoprodutoid())
		   {this.estadoprodutoid = yclasseestadoproduto.getEstadoprodutoid();
		    this.dataestadoproduto= LocalDate.now();
		   }
	}
	
	public LocalDate getDataestadoproduto() {
		return dataestadoproduto; 
	}
	public void setDataestadoproduto(LocalDate ydataestadoproduto) {
		//this.dataestadoproduto = ydataestadoproduto; 
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
	
	public double getLimitemaximo() {
		return limitemaximo; 
	}
	public void setLimitemaximo(double ylimitemaximo) {
		if (ylimitemaximo==0 || ylimitemaximo > 5000) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Limite máximo: Valor incorreto ", ylimitemaximo)
	        );
	    } 
		this.limitemaximo = ylimitemaximo; 
	}

	public double getLimiteminimo() {
		return limiteminimo; 
	}
	public void setLimiteminimo(double ylimiteminimo) {
		if (ylimiteminimo < 500) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Limite mínimo: Valor incorreto ", ylimiteminimo)
	        );
	    } 
		this.limiteminimo = ylimiteminimo; 
	}

	public double getTaxajuro() {
		return taxajuro; 
	}
	public void setTaxajuro(double ytaxajuro) {
		if (ytaxajuro == 0 || ytaxajuro > 100) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Taxa de Juro: Valor incorreto ", ytaxajuro)
	        );
	    } 
		this.taxajuro = ytaxajuro; 
	}
	
	public double getTaxadespesacontratacao() {
		return taxadespesacontratacao; 
	}
	public void setTaxadespesacontratacao(double ytaxadespesacontratacao) {
		if (ytaxadespesacontratacao == 0 || ytaxadespesacontratacao > 100) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Taxa de Despesas de Contratação: Valor incorreto ", ytaxadespesacontratacao)
	        );
	    } 
		this.taxadespesacontratacao = ytaxadespesacontratacao; 
	}
	
	public double getTaxaimpostocontratacao() {
		return taxaimpostocontratacao; 
	}
	public void setTaxaimpostocontratacao(double ytaxaimpostocontratacao) {
		if (ytaxaimpostocontratacao == 0 || ytaxaimpostocontratacao > 100) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Taxa de Imposto de Contratação: Valor incorreto ", ytaxaimpostocontratacao)
	        );
	    } 
		this.taxaimpostocontratacao = ytaxaimpostocontratacao; 
	}
	
	public double getTaxadespesacobranca() {
		return taxadespesacobranca; 
	}
	public void setTaxadespesacobranca(double ytaxadespesacobranca) {
		if (ytaxadespesacobranca == 0 || ytaxadespesacobranca > 100) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Taxa de Despesas de Cobrança: Valor incorreto ", ytaxadespesacobranca)
	        );
	    } 
		this.taxadespesacobranca = ytaxadespesacobranca; 
	}
	
	public double getTaxaimpostocobranca() {
		return taxaimpostocobranca; 
	}
	public void setTaxaimpostocobranca(double ytaxaimpostocobranca) {
		if (ytaxaimpostocobranca == 0 || ytaxaimpostocobranca > 100) { 
		    throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Taxa de Imposto de Cobrança: Valor incorreto ", ytaxaimpostocobranca)
	        );
	    } 
		this.taxaimpostocobranca = ytaxaimpostocobranca; 
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
