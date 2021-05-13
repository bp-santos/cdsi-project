package com.iscte.youcredit.restapi;
import java.io.IOException;
import java.time.*;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openxava.jpa.*;

public class ObterParecerIC extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestUrl ="";
		String servico ="";

		String simulacao_id="0";
		String produto="";
		String nome="";
		String nif="";
		String total_solicitado="";
		double total_solicitado_valor=0;
		String evento ="";
	    LocalDate data_evento =LocalDate.now(); 
	    LocalDate data_log =LocalDate.now(); 
	    int utilizador_log=0;
	    String estado_log="A"; 
		
	    String parecer_obs ="";
	    String parecer_resultado =""; 
	    
	    String querySQL = "";
		int resQuery =0;
		String resServico ="";
		boolean pedidoValido = false;

		requestUrl = request.getRequestURI();
		servico = requestUrl.substring("/ObterParecerIC/".length());
		
		if (request.getParameter("simulacaoid") !=null) {simulacao_id = request.getParameter("simulacaoid");}
		if (request.getParameter("produto") !=null) {produto = request.getParameter("produto");} 
		if (request.getParameter("nome") !=null) {nome = request.getParameter("nome");} 
		if (request.getParameter("nif") !=null) {nif = request.getParameter("nif");} 
		if (request.getParameter("totalsolicitado") !=null) 
		   {total_solicitado = request.getParameter("totalsolicitado");
			total_solicitado_valor = Double.parseDouble(total_solicitado);}  
		if (request.getParameter("evento") !=null) {evento = request.getParameter("evento");} 

		//validações individuais
		if (servico==null) {resServico="serviço restAPI não indicado";}
		if (!simulacao_id.matches("[1-9]+")) {resServico="Erro parâmetro <simulacaoid>";}
		if (total_solicitado_valor==0) {resServico="Erro parâmetro <totalsolicitado>";}
		
		//validações cruzadas
		if (resServico.isBlank())			
		   {if (!simulacao_id.isBlank()  && !produto.isBlank() && !nome.isBlank() && !nif.isBlank() && !total_solicitado.isBlank())
			   {if (evento.equals("parecer"))
				   {pedidoValido=true;}
			    else {resServico="Erro parâmetro obrigatório <evento=parecer>";}
			   }
		    else {resServico="Erro parâmetros obrigatórios <simulacaoid,produto,nome,nif,totalsolicitado>";}
		   }
		
		if(pedidoValido){
	        //Calcular Parecer
			parecer_resultado="NOK";
			if (nome.contains("Catarina") || nome.contains("Francisco") || nome.contains("Gabriela"))
			   {parecer_resultado="OK";
			    parecer_obs = "Aposta segura";}
			if (nif.startsWith("2") && nome.length() > 7) 
			   {parecer_resultado="OK";
			    parecer_obs = "Avaliar peso dos créditos actuais";}
			if (total_solicitado.startsWith("3") && nome.length() > 7) 
			   {parecer_resultado="OK";
			    parecer_obs = "Rever taxas antes de aprovar";}
					
			//Escrever na base de dados
			querySQL = "Insert Into LOG_Parecer_Quotacao"; 
	        querySQL += " (simulacao_id, produto, nome, nif, total_solicitado, evento, data_evento, parecer_obs, parecer_resultado, data_log, utilizador_log, estado_log)";
	        querySQL += " Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        EntityManager conexao = XPersistence.getManager();
	        Query query = conexao.createNativeQuery(querySQL);
			query.setParameter(1, simulacao_id);
	        query.setParameter(2, produto);
	        query.setParameter(3, nome);
	        query.setParameter(4, nif);
	        query.setParameter(5, total_solicitado_valor);
	        query.setParameter(6, evento);
	        query.setParameter(7, data_evento);
	        query.setParameter(8, parecer_obs);
	        query.setParameter(9, parecer_resultado);
	        query.setParameter(10, data_log);
	        query.setParameter(11, utilizador_log);
	        query.setParameter(12, estado_log);
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
		    json += "\"parecerobs\": " + parecer_obs + ",\n";
		    json += "\"parecerresultado\": " + parecer_resultado + ",\n";
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
		    json += "\"nome\": " + nome + "\n";
		    json += "\"nif\": " + nif + "\n";
		    json += "\"totalsolicitado\": " + total_solicitado + "\n";
		    json += "\"evento\": " + evento + "\n";
		    json += "\"dataevento\": " + data_evento + "\n";
		    json += "}";
		    response.getOutputStream().println(json);
		   }
	}

}
