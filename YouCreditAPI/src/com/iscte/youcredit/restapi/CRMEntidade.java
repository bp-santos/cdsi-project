package com.iscte.youcredit.restapi;

import java.io.*;
import java.time.*;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.openxava.jpa.*;
import org.openxava.util.*;

public class CRMEntidade extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		String requestUrl ="";
		String servico ="";

		String entidade_id="0";
		String nome="";
		String morada="";
		String nif="";
		String telefone="";
		String email ="";
		String estado ="";
		String rating ="0";
		String evento = "";
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
		
		if (request.getParameter("entidadeid") !=null) {entidade_id = request.getParameter("entidadeid");}
		if (request.getParameter("nome") !=null) {nome = request.getParameter("nome");} 
		if (request.getParameter("morada") !=null) {morada = request.getParameter("morada");} 
		if (request.getParameter("nif") !=null) {nif = request.getParameter("nif");} 
		if (request.getParameter("telefone") !=null) {telefone = request.getParameter("telefone");} 
		if (request.getParameter("email") !=null) {email = request.getParameter("email");} 
		if (request.getParameter("estado") !=null) {estado = request.getParameter("estado");} 
		if (request.getParameter("rating") !=null) {rating = request.getParameter("rating");} 
		if (request.getParameter("evento") !=null) {evento = request.getParameter("evento");} 

		//validações individuais
		if (servico==null) {resServico="serviço restAPI não indicado";}
		if (!entidade_id.matches("[1-9]+")) {resServico="Erro parâmetro <entidadeid>";}
		if (!rating.matches("[1-5]+") || rating.length()!=1) {resServico="Erro parâmetro <rating>";}
				
		//validações cruzadas
		if (resServico.isBlank())			
		   {if (!entidade_id.isBlank()  && !nome.isBlank() && !telefone.isBlank() && !email.isBlank() && !estado.isBlank())
			   {if (evento.equals("criar") || evento.equals("alterar"))
				   {pedidoValido=true;}
			    else {resServico="Erro parâmetro obrigatório <evento=criar|alterar>";}
			   }
		    else {resServico="Erro parâmetros obrigatórios <entidadeid,nome,telefone,email,estado>";}
		   }
		
		if(pedidoValido){
	        //Escrever na base de dados
			querySQL = "Insert Into LOG_CRM_Entidade"; 
	        querySQL += " (entidade_id, nome, morada, nif, telefone, email, estado, rating, evento, data_evento, data_log, utilizador_log, estado_log)";
	        querySQL += " Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        EntityManager conexao = XPersistence.getManager();
	        Query query = conexao.createNativeQuery(querySQL);
			query.setParameter(1, entidade_id);
	        query.setParameter(2, nome);
	        query.setParameter(3, morada);
	        query.setParameter(4, nif);
	        query.setParameter(5, telefone);
	        query.setParameter(6, email);
	        query.setParameter(7, estado);
	        query.setParameter(8, rating);
	        query.setParameter(9, evento);
	        query.setParameter(10, data_evento);
	        query.setParameter(11, data_log);
	        query.setParameter(12, utilizador_log);
	        query.setParameter(13, estado_log);
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
		    json += "\"entidadeid\": " + entidade_id + ",\n";
		    json += "\"nome\": " + nome + ",\n";
		    json += "\"morada\": " + morada + "\n";
		    json += "\"nif\": " + nif + "\n";
		    json += "\"telefone\": " + telefone + "\n";
		    json += "\"email\": " + email + "\n";
		    json += "\"estado\": " + estado + "\n";
		    json += "\"rating\": " + rating + "\n";
		    json += "\"evento\": " + evento + "\n";
		    json += "\"dataevento\": " + data_evento + "\n";
		    json += "}";
		    response.getOutputStream().println(json);
		   }
	}
}
