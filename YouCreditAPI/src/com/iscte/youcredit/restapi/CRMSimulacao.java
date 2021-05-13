package com.iscte.youcredit.restapi;

import java.io.*;
import java.time.*;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.openxava.jpa.*;

public class CRMSimulacao extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl ="";
		String servico ="";

		String simulacao_id="";
		String produto="";
		String instituicao_credito="";
		String entidade_id="";
		String nome="";
		String nif ="";
		String telefone ="";
		String email ="";
		String rating = "";
		String estado_entidade = "";
		String total_solicitado="0";
		double total_solicitado_valor = 0; 
		String total_possivel="0";
		double total_possivel_valor =0;
		String estado_simulacao="";
		String scoring="";
		String evento = "criar";
	    LocalDate data_evento =LocalDate.now(); 
	    LocalDate data_log =LocalDate.now(); 
	    int utilizador_log=0;
	    String estado_log="A";
	    
		String querySQL = "";
		int resQuery =0;
		String resServico ="";
		boolean pedidoValido = false;

		requestUrl = request.getRequestURI();
		servico = requestUrl.substring("/CRMEntidade/".length());
		
		if (request.getParameter("simulacaoid") !=null) {simulacao_id = request.getParameter("simulacaoid");}
		if (request.getParameter("produto") !=null) {produto = request.getParameter("produto");} 
		if (request.getParameter("instituicaocredito") !=null) {instituicao_credito = request.getParameter("instituicaocredito");} 
		if (request.getParameter("entidadeid") !=null) {entidade_id = request.getParameter("entidadeid");} 
		if (request.getParameter("nome") !=null) {nome = request.getParameter("nome");} 
		if (request.getParameter("nif") !=null) {nif = request.getParameter("nif");} 
		if (request.getParameter("telefone") !=null) {telefone = request.getParameter("telefone");} 
		if (request.getParameter("email") !=null) {email = request.getParameter("email");} 
		if (request.getParameter("rating") !=null) {rating = request.getParameter("rating");} 
		if (request.getParameter("estadoentidade") !=null) {estado_entidade = request.getParameter("estadoentidade");} 
		if (request.getParameter("totalsolicitado") !=null) 
		   {total_solicitado = request.getParameter("totalsolicitado");	
		    total_solicitado_valor = Double.parseDouble(total_solicitado);} 
		if (request.getParameter("totalpossivel") !=null) 
		   {total_possivel = request.getParameter("totalpossivel");
			total_possivel_valor = Double.parseDouble(total_possivel);} 
		if (request.getParameter("estadosimulacao") !=null) {estado_simulacao = request.getParameter("estadosimulacao");} 
		if (request.getParameter("scoring") !=null) {scoring = request.getParameter("scoring");} 
		if (request.getParameter("evento") !=null) {evento = request.getParameter("evento");} 

		//validações individuais
		if (servico==null) {resServico="serviço restAPI não indicado";}
		if (!simulacao_id.matches("[1-9]+")) {resServico="Erro parâmetro <simulacaoid>";}
		if (!entidade_id.matches("[1-9]+")) {resServico="Erro parâmetro <entidadeid>";}
		if (!rating.matches("[1-5]+") || rating.length()!=1) {resServico="Erro parâmetro <rating>";}
		if (!scoring.matches("[1-5]+") || rating.length()!=1) {resServico="Erro parâmetro <scoring>";}
		if (total_solicitado_valor ==0) {resServico="Erro parâmetro <totalsolicitado>";}
		if (!evento.equals("criar") && !evento.equals("alterar")) {resServico="Erro parâmetro <evento>";}
		if (produto.isBlank()) {resServico="Erro parâmetro <produto>";}
		if (instituicao_credito.isBlank()) {resServico="Erro parâmetro <instituicaocredito>";}
		if (produto.isBlank()) {resServico="Erro parâmetro <produto>";}
		if (nome.isBlank()) {resServico="Erro parâmetro <nome>";}
		if (nif.isBlank()) {resServico="Erro parâmetro <nif>";}
		if (telefone.isBlank()) {resServico="Erro parâmetro <telefone>";}
		if (email.isBlank()) {resServico="Erro parâmetro <email>";}
		if (estado_entidade.isBlank()) {resServico="Erro parâmetro <estadoentidade>";}
		if (estado_simulacao.isBlank()) {resServico="Erro parâmetro <estadosimulacao>";}
		
		//validações cruzadas
		if (resServico.isBlank()) {pedidoValido=true;}
		
		if(pedidoValido){
	        //Escrever na base de dados
			querySQL = "Insert Into LOG_CRM_Simulacao"; 
	        querySQL += " (simulacao_id, produto, instituicao_credito, entidade_id, nome, nif, telefone, email, rating, estado_entidade, total_solicitado, total_possivel, estado_simulacao, scoring, evento, data_evento, data_log, utilizador_log, estado_log)";
	        querySQL += " Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        EntityManager conexao = XPersistence.getManager();
	        Query query = conexao.createNativeQuery(querySQL);
			query.setParameter(1, simulacao_id);
	        query.setParameter(2, produto);
	        query.setParameter(3, instituicao_credito);
	        query.setParameter(4, entidade_id);
	        query.setParameter(5, nome);
	        query.setParameter(6, nif);
	        query.setParameter(7, telefone);
	        query.setParameter(8, email);
	        query.setParameter(9, rating);
	        query.setParameter(10, estado_entidade);
	        query.setParameter(11, total_solicitado_valor);
	        query.setParameter(12, total_possivel_valor);
	        query.setParameter(13, estado_simulacao);
	        query.setParameter(14, scoring);
	        query.setParameter(15, evento);
	        query.setParameter(16, data_evento);
	        query.setParameter(17, data_log);
	        query.setParameter(18, utilizador_log);
	        query.setParameter(19, estado_log);
	   
	        try {
	             resQuery = query.executeUpdate();
	             conexao.getTransaction().commit();
	             resServico="OK";
	            }
	        catch (Exception erro) {resServico ="Erro formato parâmetros";}
		}   
	    
		//Retornar Json            
		if (resServico.equals("OK"))
		   {String json = "{\n";
		    json += "\"servico\": " + servico + ",\n";
		    json += "\"metodo\": " + "GET" + ",\n";
		    json += "\"resServico\": " + resServico + ",\n";
		    json += "}";
		    response.getOutputStream().println(json);
		   }
		else
		   {String json = "{\n";
		    json += "\"servico\": " + servico + ",\n";
		    json += "\"metodo\": " + "GET" + ",\n";
		    json += "\"resServico\": " + resServico + ",\n";
		    json += "\"simulacaoid\": " + simulacao_id + ",\n";
		    json += "\"produto\": " + produto + ",\n";
		    json += "\"instituicaocredito\": " + instituicao_credito + "\n";
		    json += "\"entidadeid\": " + entidade_id + "\n";
		    json += "\"nome\": " + nome + "\n";
		    json += "\"nif\": " + nif + "\n";
		    json += "\"telefone\": " + telefone + "\n";
		    json += "\"email\": " + email + "\n";
		    json += "\"rating\": " + rating + "\n";
		    json += "\"estadoentidade\": " + estado_entidade + "\n";
		    json += "\"totalsolicitado\": " + total_solicitado + "\n";
		    json += "\"totalpossivel\": " + total_possivel + "\n";
		    json += "\"estadosimulacao\": " + estado_simulacao + "\n";
		    json += "\"scoring\": " + scoring + "\n";
		    json += "\"evento\": " + evento + "\n";
		    json += "\"dataevento\": " + data_evento + "\n";
		    json += "}";
		    response.getOutputStream().println(json);
		   }
	}
}
