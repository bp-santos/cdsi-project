package com.iscte.youcredit.model;
import java.time.*;

//packages standard OpenXava 
import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

//-----------------------------------------------
//Modelização interface com utilizador CRUD
//-----------------------------------------------
@View(members=
"utilizador;" +
"Identificação [" +
" entidade,existecrm;" +
" nome;" +
" datanascimento, genero, classenacionalidade;" +
" telefone, email;" +
" nif, cartaocidadao, passaporte;" +
" classeestadoentidade, dataestadoentidade;" +
"]" +
"Morada {" +
" morada;" +
" codigopostal;" +
"};" +
"Perfil Crédito {" +
" classesegmentocliente;" +
" entidadeempregadora,datainicioemprego;" +
" classesectoractividade,classesituacaoprofissional;" +
" salarioanual, creditosactuais;" +
" listanegra,rating;" +
"};" +
"Logging {" +
" datalog;" +
" utilizadorlog;" +
" estadolog;" +
"}"
)

//-----------------------------------------------
//Modelização interface com utilizador LIST
//-----------------------------------------------
@Tab(
	properties="nome,telefone,email,salarioanual",
	defaultOrder="${nome} desc, ${salarioanual} asc"
	//filter=ObterUtilizador.class, 
	//baseCondition="${entidadeid} = ?"
) 

//-----------------------------------------------
//Ligação da classe a tabela via JPA/Hibernate 
//-----------------------------------------------
@Entity 
@Table(name = "en_entidade")

public class EN_Entidade {
	//-------------------------------------------------------------------------------------------
	//Definição de propriedades JPA/Hibernate 
	//-------------------------------------------------------------------------------------------
	@Id
	@Column(name="entidade", length=25)
	private String entidade; 
	
	private String utilizador; 
	
	@Hidden
	@Column(name="entidade_id")
	private int entidadeid; 

	@ReadOnly
	@Column(name="nome", length=75)
	private String nome;

	@ReadOnly
	@Column(name="morada", length=100)
	private String morada;

	@ReadOnly
	@Column(name="codigo_postal", length=10)
	private String codigopostal;

	@ReadOnly
	@Column(name="email", length=50)
	private String email;

	@ReadOnly
	@Column(name="nif", length=10)
	private String nif;
	
	@ReadOnly
	@Column(name="cartao_cidadao", length=15)
	private String cartaocidadao;
	
	@ReadOnly
	@Column(name="passaporte", length=15)
	private String passaporte;

	@ReadOnly
	@Column(name="telefone", length=15)
	private String telefone;

	@ReadOnly
	@Column(name="data_nascimento")
	private LocalDate datanascimento;

	@ReadOnly
	@Column(name="nacionalidade_id")
	private int nacionalidadeid;

	@ReadOnly
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Nacionalidade classenacionalidade; 

	@ReadOnly
	@Column(name="genero", length=10)
	private String genero;
	
	@ReadOnly
	@Column(name="entidade_empregadora", length=50)
	private String entidadeempregadora;

	@ReadOnly
	@Column(name="data_inicio_emprego")
	private LocalDate datainicioemprego;

	@ReadOnly 
	@Column(name="rating")
	private int rating;

	@ReadOnly
	@Column(name="salario_anual")
	private double salarioanual;

	@ReadOnly
	@Column(name="creditos_actuais")
	private double creditosactuais;

	@ReadOnly
	@Column(name="lista_negra", length=75)
	private String listanegra;

	@Hidden
	@Column(name="sector_actividade_id")
	private int sectoractividadeid;

	@ReadOnly
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Sector_Actividade classesectoractividade; 

	@Hidden
	@Column(name="situacao_profissional_id")
	private int situacaoprofissionalid;

	@ReadOnly
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Situacao_Profissional classesituacaoprofissional; 

	@Hidden
	@Column(name="segmento_cliente_id")
	private int segmentoclienteid;

	@ReadOnly
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Segmento_Cliente classesegmentocliente; 

	@Hidden
	@Column(name="estado_entidade_id")
	private int estadoentidadeid;

	@ReadOnly
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Estado_Entidade classeestadoentidade; 

	@ReadOnly  
	@Column(name="data_estado_entidade")
	private LocalDate dataestadoentidade;

	@ReadOnly  
	@Column(name="existe_crm",length=1)
	private String existecrm;

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
	public String getUtilizador() {
	    utilizador = Users.getCurrent(); 
		return utilizador; 
	}
	
	public int getEntidadeid() {
		return entidadeid; 
	}
	
	public void setEntidadeid(int yentidadeid) {
		 //this.entidadeid = yentidadeid; 
	}

	public String getEntidade() {
		return entidade; 
	}
	
	public void setEntidade(String yentidade) {
		 this.entidade = yentidade; 
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

	public String getNif() {
		return nif; 
	}
	public void setNif(String ynif) {
		if (Utilitarios.CampoNifValido(ynif)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "NIF: Valor incorreto ", ynif)
	        );
     	}    
		this.nif = ynif; 
	}

	public String getCartaocidadao() {
		return cartaocidadao; 
	}
	public void setCartaocidadao(String ycartaocidadao) {
		if (Utilitarios.CampoCartaoCidadaoValido(ycartaocidadao)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Cartão Cidadão: Valor incorreto ", ycartaocidadao)
	        );
     	}    
		this.cartaocidadao = ycartaocidadao; 
	}

	public String getPassaporte() {
		return passaporte; 
	}
	public void setPassaporte(String ypassaporte) {
		if (Utilitarios.CampoPassaporteValido(ypassaporte)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Passaporte: Valor incorreto ", ypassaporte)
	        );
     	}    
		this.passaporte = ypassaporte; 
	}

	public int getNacionalidadeid() {
		return nacionalidadeid; 
	}
	public void setNacionalidadeid(int ynacionalidadeid) {
		this.nacionalidadeid = ynacionalidadeid; 
	}

	public EN_Nacionalidade getClassenacionalidade() {
		return classenacionalidade; 
	}
	public void setClassenacionalidade(EN_Nacionalidade yclassenacionalidade) {
		this.classenacionalidade = yclassenacionalidade;
		this.nacionalidadeid = yclassenacionalidade.getNacionalidadeid(); 
	}

	
	public LocalDate getDatainicioemprego() {
		return datainicioemprego; 
	}
	public void setDatainicioemprego(LocalDate ydatainicioemprego) {
	    if (ydatainicioemprego.isAfter(LocalDate.now())) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Data Inicio Emprego: Valor incorreto ", ydatainicioemprego)
	        );
	    }    
		this.datainicioemprego = ydatainicioemprego; 
	}
	
	public String getMorada() {
		return morada; 
	}
	public void setMorada(String ymorada) {
	    if (Utilitarios.CampoStringValido(ymorada,15)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Morada: Valor incorreto ", ymorada)
	        );
	    }    
		this.morada = ymorada; 
	}

	public String getEmail() {
		return email; 
	}
	public void setEmail(String yemail) {
		if (Utilitarios.CampoEmailValido(yemail)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Email: Valor incorreto ", yemail)
	        );
     	}    
		this.email = yemail; 
	}

	public String getTelefone() {
		return telefone; 
	}
	public void setTelefone(String ytelefone) {
		if (Utilitarios.CampoTelefoneValido(ytelefone)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Telefone: Valor incorreto ", ytelefone)
	        );
     	}    
		this.telefone = ytelefone; 
	}

	public String getCodigopostal() {
		return codigopostal; 
	}
	public void setCodigopostal(String ycodigopostal) {
		if (Utilitarios.CampoCodigoPostalValido(ycodigopostal)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Código Postal: Valor incorreto ", ycodigopostal)
	        );
     	}    
		this.codigopostal = ycodigopostal; 
	}

	public LocalDate getDatanascimento() {
		return datanascimento; 
	}
	public void setDatanascimento(LocalDate ydatanascimento) {
	    if ((ydatanascimento.getYear() - LocalDate.now().getYear())<19) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Data Nascimento: Valor incorreto ", ydatanascimento)
	        );
	    }    
		this.datanascimento = ydatanascimento; 
	}

	public String getGenero() {
		return genero; 
	}
	public void setGenero(String ygenero) {
		if (Utilitarios.CampoGeneroValido(ygenero)==false) { 
		        throw new javax.validation.ValidationException(
		            XavaResources.getString(
		                "Género: Valor incorreto ", ygenero)
		        );
		}    
		this.genero = ygenero; 
	}
	
	public String getEntidadeempregadora() {
		return entidadeempregadora; 
	}
	public void setEntidadeempregadora(String yentidadeempregadora) {
	    if (Utilitarios.CampoStringValido(yentidadeempregadora,15)==false) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Entidade Empregadora: Valor incorreto ", yentidadeempregadora)
	        );
	    }    
		this.entidadeempregadora = yentidadeempregadora; 
	}

	public int getRating() {
		return rating; 
	}
	public void setRating(int yrating) {
		this.rating = yrating; 
	}

	public double getSalarioanual() {
		return salarioanual; 
	}
	public void setSalarioanual(double ysalarioanual) {
	    if (ysalarioanual < 40000) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Salário Anual: Valor incorreto ", ysalarioanual)
	        );
	    }    
		this.salarioanual = ysalarioanual; 
	}
	
	public double getCreditosactuais() {
		return creditosactuais; 
	}
	public void setCreditosactuais(double ycreditosactuais) {
		this.creditosactuais = ycreditosactuais; 
	}
	
	public String getListanegra() {
		return listanegra; 
	}
	public void setListanegra(String ylistanegra) {
		this.listanegra = ylistanegra; 
	}

	public int getSectoractividadeid() {
		return sectoractividadeid; 
	}
	public void setSectoractividadeid(int ysectoractividadeid) {
		this.sectoractividadeid = ysectoractividadeid; 
	}

	public EN_Sector_Actividade getClassesectoractividade() {
		return classesectoractividade; 
	}
	public void setClassesectoractividade(EN_Sector_Actividade yclassesectoractividade) {
		this.classesectoractividade = yclassesectoractividade; 
		if (this.sectoractividadeid != yclassesectoractividade.getSectoractividadeid())
	  	   {this.dataestadoentidade=LocalDate.now();
			this.sectoractividadeid = yclassesectoractividade.getSectoractividadeid();
	  	   }
	}

	public int getSituacaoprofissionalid() {
		return situacaoprofissionalid; 
	}
	public void setSituacaoprofissionalid(int ysituacaoprofissionalid) {
		this.situacaoprofissionalid = ysituacaoprofissionalid; 
	}
	
	public EN_Situacao_Profissional getClassesituacaoprofissional() {
		return classesituacaoprofissional; 
	}
	public void setClassesituacaoprofissional(EN_Situacao_Profissional yclassesituacaoprofissional) {
		this.classesituacaoprofissional = yclassesituacaoprofissional; 
		this.situacaoprofissionalid = yclassesituacaoprofissional.getSituacaoprofissionalid(); 
	}

	
	public int getSegmentoclienteid() {
		return segmentoclienteid; 
	}
	public void setSegmentoclienteid(int ysegmentoclienteid) {
		this.segmentoclienteid = ysegmentoclienteid; 
	}

	public EN_Segmento_Cliente getClassesegmentocliente() {
		return classesegmentocliente; 
	}
	public void setClassesegmentocliente(EN_Segmento_Cliente yclassesesegmentocliente) {
		this.classesegmentocliente = yclassesesegmentocliente; 
		this.segmentoclienteid = yclassesesegmentocliente.getSegmentoclienteid(); 
	}

	public int getEstadoentidadeid() {
		return estadoentidadeid; 
	}
	public void setEstadoentidadeid(int yestadoentidadeid) {
		this.estadoentidadeid = yestadoentidadeid; 
	}

	public EN_Estado_Entidade getClasseestadoentidade() {
		return classeestadoentidade; 
	}

	public void setClasseestadoentidade(EN_Estado_Entidade yclasseestadoentidade) {
		this.classeestadoentidade = yclasseestadoentidade;
		if (this.estadoentidadeid != yclasseestadoentidade.getEstadoentidadeid())
		   {this.estadoentidadeid = yclasseestadoentidade.getEstadoentidadeid();
		   this.dataestadoentidade = LocalDate.now();
		   }
	}

	public LocalDate getDataestadoentidade() {
		return dataestadoentidade; 
	}
	public void setDataestadoentidade(LocalDate ydataestadoentidade) {
		//this.dataestadoentidade = ydataestadoentidade; 
	}

	public String getExistecrm() {
		return existecrm; 
	}
	public void setExistecrm(String yexistecrm) {
		this.existecrm = yexistecrm; 
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
