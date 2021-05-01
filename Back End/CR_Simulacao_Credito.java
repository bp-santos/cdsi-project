package com.iscte.youcredit.model;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;


@View(members = "Identificação [" + "classeentidade,classeproduto;" + " referencia, flagcredito;" + " descricaoobjeto,scoring;"
		+ " duracao,parecer, classeestadocredito, classeperiodicidade;" + "]" + "Datas {" + " datainicio,datafim;"
		+ " datasolicitacao,dataavaliacao,datadecisao;" + " dataalteracaoestadocredito,dataalteracaoestadosimulacao;"
		+ "};" + "Totais {" + " totalsolicitado,totalconcedido,totalpossivel;"
		+ " totalcapital,totaljuro,totaldespesa,totalimposto;" + "}; " + "Login {" + " datalog;" + " utilizadorlog;"
		+ " estadolog;" + "}")

@Tab(properties = "simulacaocreditoid, flagcredito, datainicio, datafim", defaultOrder = "${simulacaocreditoid} asc")

@Entity
@Table(name = "cr_simulacao_credito")

public class CR_Simulacao_Credito {

	@Hidden
	@Column(name = "simulacao_credito_id")
	private int simulacaocreditoid;
	
	@Id
	@Column(name = "referencia", length = 50)
	private String referencia;

	@Required
	@Column(name = "flag_credito")
	private boolean flagcredito;

	@Required
	@Column(name = "data_solicitacao")
	private LocalDate datasolicitacao;

	@Required
	@Column(name = "data_decisao")
	private LocalDate datadecisao;

	@Required
	@Column(name = "data_inicio")
	private LocalDate datainicio;

	@Required
	@Column(name = "data_fim")
	private LocalDate datafim;

	@Required
	@Column(name = "data_avaliacao")
	private LocalDate dataavaliacao;

	@Required
	@Column(name = "data_alteracao_estado_credito")
	private LocalDate dataalteracaoestadocredito;
	
	@Required
	@Column(name = "data_alteracao_estado_simulacao")
	private LocalDate dataalteracaoestadosimulacao;

	@Required
	@Column(name = "total_solicitado")
	private double totalsolicitado;

	@Required
	@Column(name = "total_concedido")
	private double totalconcedido;

	@Required
	@Column(name = "total_possivel")
	private double totalpossivel;

	@Required
	@Column(name = "total_capital")
	private double totalcapital;

	@Required
	@Column(name = "total_juro")
	private double totaljuro;

	@Required
	@Column(name = "total_despesa")
	private double totaldespesa;

	@Required
	@Column(name = "total_imposto")
	private double totalimposto;

	@Required
	@Column(name = "descricao_objeto", length = 50)
	private String descricaoobjeto;

	@Required
	@Column(name = "duracao")
	private int duracao;

	@Required
	@Column(name = "scoring")
	private int scoring;

	@Required
	@Column(name = "parecer")
	private boolean parecer;

	@Hidden
	@Column(name = "estado_id")
	private int estadoid;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList(
    		descriptionProperties="estado",
    		condition="${estadolog} = 'A'")  
    private CR_Estado_Credito_Simulacao classeestadocredito;
	
	@Hidden
	@Column(name="periodicidade_id")
	private int periodicidadeid;

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList(
    		descriptionProperties="periodicidade",
    		condition="${estadolog} = 'A'")  
    private CR_Periodicidade classeperiodicidade;

	@Hidden
	@Column(name = "produto_id")
	private int produtoid;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="nome", 
			condition="${estadolog} = 'A'")
	private PR_Produto classeproduto;

	@Hidden
	@Column(name = "entidade_id")
	private int entidadeid;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="nome", 
			condition="${estadolog} = 'A'")
	private EN_Entidade classeentidade; 
	
	@ReadOnly  
	@Column(name="data_log")
	private LocalDate datalog;

	@ReadOnly  
	@Column(name="utilizador_log")
	private int utilizadorlog;
	
	@Column(name="estado_log",length=1)
	private String estadolog;

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		if (referencia.isEmpty() || referencia.isBlank() || referencia == null) {referencia = getUtilizadorlog() + "#" + getProdutoid() + "#" + getDatalog();}
		this.referencia = referencia;
	}

	public int getSimulacaocreditoid() {
		return simulacaocreditoid;
	}

	public void setSimulacaocreditoid(int simulacaocreditoid) {
		//this.simulacaocreditoid = simulacaocreditoid;
	}

	public boolean isFlagcredito() {
		return flagcredito;
	}

	public void setFlagcredito(boolean flagcredito) {
		if (flagcredito) {
			if (!this.parecer)
				throw new javax.validation.ValidationException(
					XavaResources.getString("Parecer: Valor insuficiente ", parecer));
		}
		this.flagcredito = flagcredito;
	}

	public LocalDate getDatasolicitacao() {
		return datasolicitacao;
	}

	public void setDatasolicitacao(LocalDate datasolicitacao) {
		if(datasolicitacao==null) {datasolicitacao = LocalDate.now();}
		this.datasolicitacao = datasolicitacao;
	}

	public LocalDate getDatadecisao() {
		return datadecisao;
	}

	public void setDatadecisao(LocalDate datadecisao) {
		if(datadecisao==null) {datadecisao = LocalDate.now();}
		this.datadecisao = datadecisao;
	}

	public LocalDate getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(LocalDate datainicio) {
		if(datainicio==null) {datainicio = LocalDate.now();}
		this.datainicio = datainicio;
	}

	public LocalDate getDatafim() {
		return datafim;
	}

	public void setDatafim(LocalDate datafim) {
		if(datafim==null) {datafim = LocalDate.now();}	
		if (datainicio.isAfter(datafim)) {
			throw new javax.validation.ValidationException(
				XavaResources.getString("Data inicio superior a data de fim ", datainicio, datafim));
		}
		this.datafim = datafim;
	}

	public LocalDate getDataavaliacao() {
		return dataavaliacao;
	}

	public void setDataavaliacao(LocalDate dataavaliacao) {
		if(dataavaliacao==null) {dataavaliacao = LocalDate.now();}
		this.dataavaliacao = dataavaliacao;
	}

	public LocalDate getDataalteracaoestadocredito() {
		return dataalteracaoestadocredito;
	}

	public void setDataalteracaoestadocredito(LocalDate dataalteracaoestadocredito) {
		if(dataalteracaoestadocredito==null) {dataalteracaoestadocredito = LocalDate.now();}
		this.dataalteracaoestadocredito = dataalteracaoestadocredito;
	}

	public LocalDate getDataalteracaoestadosimulacao() {
		return dataalteracaoestadosimulacao;
	}

	public void setDataalteracaoestadosimulacao(LocalDate dataalteracaoestadosimulacao) {
		if(dataalteracaoestadosimulacao==null) {dataalteracaoestadosimulacao = LocalDate.now();}
		this.dataalteracaoestadosimulacao = dataalteracaoestadosimulacao;
	}

	public double getTotalsolicitado() {
		return totalsolicitado;
	}

	public void setTotalsolicitado(double totalsolicitado) {
		if (totalsolicitado >= 500 && totalsolicitado <= 2500)
			this.totalsolicitado = totalsolicitado;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Total Solicidado: Valor incorreto ", totalsolicitado));
	}

	public double getTotalconcedido() {
		return totalconcedido;
	}

	public void setTotalconcedido(double totalconcedido) {
		if (totalconcedido >= 500 && totalconcedido <= 2500) {
			this.totalconcedido = totalconcedido;
		} else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Total Concedido: Valor incorreto ", totalconcedido));
	}

	public double getTotalpossivel() {
		return totalpossivel;
	}

	public void setTotalpossivel(double totalpossivel) {
		if (totalpossivel > 0)
			this.totalpossivel = totalpossivel;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Total Possível: Valor incorreto ", totalpossivel));
	}

	public double getTotalcapital() {
		return totalcapital;
	}

	public void setTotalcapital(double totalcapital) {
		if (totalcapital > 0)
			this.totalcapital = totalcapital;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Total Capital: Valor incorreto ", totalcapital));
	}

	public double getTotaljuro() {
		return totaljuro;
	}

	public void setTotaljuro(double totaljuro) {
		if (totaljuro > 0)
			this.totaljuro = totaljuro;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Total Juro: Valor insuficiente ", totaljuro));
	}

	public double getTotaldespesa() {
		return totaldespesa;
	}

	public void setTotaldespesa(double totaldespesa) {
		if (totaldespesa > 0)
			this.totaldespesa = totaldespesa;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Total Despesa: Valor insuficiente ", totaldespesa));
	}

	public double getTotalimposto() {
		return totalimposto;
	}

	public void setTotalimposto(double totalimposto) {
		if (totalimposto > 0)
			this.totalimposto = totalimposto;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Total Imposto: Valor insuficiente ", totalimposto));
	}

	public String getDescricaoobjeto() {
		return descricaoobjeto;
	}

	public void setDescricaoobjeto(String descricaoobjeto) {
		this.descricaoobjeto = descricaoobjeto;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		if (duracao >= 6 && duracao <= 36)
			this.duracao = duracao;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Duracao: Valor incorreto ", duracao));
	}

	public int getScoring() {
		return scoring;
	}

	public void setScoring(int scoring) {
		if (scoring >= 1 && scoring <= 5)
			this.scoring = scoring;
		else
			throw new javax.validation.ValidationException(
				XavaResources.getString("Scoring: Valor incorreto ", scoring));
	}

	public boolean isParecer() {
		return parecer;
	}

	public void setParecer(boolean parecer) {
		this.parecer = parecer;
	}

	public int getEstadoid() {
		return estadoid;
	}

	public void setEstadoid(int estadoid) {
		this.estadoid = estadoid;
	}

	public int getPeriodicidadeid() {
		return periodicidadeid;
	}

	public void setPeriodicidadeid(int periodicidadeid) {
		this.periodicidadeid = periodicidadeid;
	}

	public int getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(int produtoid) {
		this.produtoid = produtoid;
	}

	public int getEntidadeid() {
		return entidadeid;
	}

	public void setEntidadeid(int entidadeid) {
		this.entidadeid = entidadeid;
	}

	public CR_Estado_Credito_Simulacao getClasseestadocredito() {
		return classeestadocredito;
	}

	public void setClasseestadocredito(CR_Estado_Credito_Simulacao classeestadocredito) {
		this.classeestadocredito = classeestadocredito;
		this.estadoid = classeestadocredito.getEstadoid();
	}

	public CR_Periodicidade getClasseperiodicidade() {
		return classeperiodicidade;
	}

	public void setClasseperiodicidade(CR_Periodicidade classeperiodicidade) {
		this.classeperiodicidade = classeperiodicidade;
		this.periodicidadeid = classeperiodicidade.getPeriodicidadeid(); 
	}

	public PR_Produto getClasseproduto() {
		return classeproduto;
	}

	public void setClasseproduto(PR_Produto classeproduto) {
		this.classeproduto = classeproduto;
		this.produtoid = classeproduto.getProdutoid(); 
	}

	public EN_Entidade getClasseentidade() {
		return classeentidade;
	}

	public void setClasseentidade(EN_Entidade classeentidade) {
		this.classeentidade = classeentidade;
		this.entidadeid = classeentidade.getEntidadeid(); 
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
	
	public LocalDate getDatalog() {
		return datalog; 
	}
	public void setDatalog(LocalDate ydatalog) {
		if (ydatalog == null) {ydatalog = LocalDate.now();}
		this.datalog = ydatalog; 
	}
}
