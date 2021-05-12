package com.iscte.youcredit.model;
//packages standard Java
import java.math.*;
import java.time.*;
//packages standard OpenXava 
import javax.persistence.*;
import org.openxava.annotations.*;
import org.openxava.model.*;
//packages espec�ficos de valida��es
import com.iscte.youcredit.actions.*; 
import org.openxava.util.*;
import org.openxava.validators.*;

//-----------------------------------------------
//Modeliza��o interface com utilizador CRUD
//-----------------------------------------------
@View(members=
"Identifica��o [" +
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
"Perfil Cr�dito {" +
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
//Modeliza��o interface com utilizador LIST
//-----------------------------------------------
@Tab(
	properties="nome,nif,telefone,email,salarioanual",
	defaultOrder="${nome} desc, ${salarioanual} asc"
) 

//-----------------------------------------------
//Liga��o da classe a tabela via JPA/Hibernate 
//-----------------------------------------------
@Entity 
@Table(name = "en_entidade")

public class EN_Entidade {
	//-------------------------------------------------------------------------------------------
	//Defini��o de propriedades JPA/Hibernate 
	//-------------------------------------------------------------------------------------------
	@Id
	@Column(name="entidade", length=25)
	private String entidade; 
		
	@Hidden
	@Column(name="entidade_id")
	private int entidadeid; 

	@Required
	@Column(name="nome", length=75)
	private String nome;

	@Required
	@Column(name="morada", length=100)
	private String morada;

	@Required
	@Column(name="codigo_postal", length=10)
	private String codigopostal;

	@Required
	@Column(name="email", length=50)
	private String email;

	@Required
	@Column(name="nif", length=10)
	private String nif;
	
	@Required
	@Column(name="cartao_cidadao", length=15)
	private String cartaocidadao;
	
	@Required
	@Column(name="passaporte", length=15)
	private String passaporte;

	@Required
	@Column(name="telefone", length=15)
	private String telefone;

	@Required
	@Column(name="data_nascimento")
	private LocalDate datanascimento;

	@Hidden
	@Column(name="nacionalidade_id")
	private int nacionalidadeid;

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Nacionalidade classenacionalidade; 

	@Required
	@Column(name="genero", length=10)
	private String genero;
	
	@Required
	@Column(name="entidade_empregadora", length=50)
	private String entidadeempregadora;

	@Required
	@Column(name="data_inicio_emprego")
	private LocalDate datainicioemprego;

	@Required
	@Action("Gerar.CalcularRating")
	@Column(name="rating")
	private int rating;

	@Required
	@Column(name="salario_anual")
	private double salarioanual;

	@Column(name="creditos_actuais")
	private double creditosactuais;

	@Column(name="lista_negra", length=75)
	private String listanegra;

	@Hidden
	@Column(name="sector_actividade_id")
	private int sectoractividadeid;

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Sector_Actividade classesectoractividade; 

	@Hidden
	@Column(name="situacao_profissional_id")
	private int situacaoprofissionalid;

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Situacao_Profissional classesituacaoprofissional; 

	@Hidden
	@Column(name="segmento_cliente_id")
	private int segmentoclienteid;

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList(
			descriptionProperties="descricao", 
			condition="${estadolog} = 'A'")
	private EN_Segmento_Cliente classesegmentocliente; 

	@Hidden
	@Column(name="estado_entidade_id")
	private int estadoentidadeid;

	@Required
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

	
	@Column(name="estado_log",length=1)
	private String estadolog;

	//-------------------------------------------------------------------------------------------
	//Defini��o de m�todos JPA/Hibernate 
	//-------------------------------------------------------------------------------------------

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
	                "Cart�o Cidad�o: Valor incorreto ", ycartaocidadao)
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
	                "C�digo Postal: Valor incorreto ", ycodigopostal)
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
		                "G�nero: Valor incorreto ", ygenero)
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
        if (yrating > 5) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Rating: Valor incorreto ", yrating)
	        );
	    }    
		this.rating = yrating; 
	}

	public double getSalarioanual() {
		return salarioanual; 
	}
	public void setSalarioanual(double ysalarioanual) {
	    if (ysalarioanual < 40000) { 
	        throw new javax.validation.ValidationException(
	            XavaResources.getString(
	                "Sal�rio Anual: Valor incorreto ", ysalarioanual)
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
