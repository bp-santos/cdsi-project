package com.iscte.youcredit.actions;

import java.io.*;
import java.net.*;
import java.util.*;

import org.openxava.actions.*;

import com.iscte.youcredit.model.*;

public class ActionSimulacaoActualizarCRM extends ViewBaseAction{
    private static CR_Simulacao_Credito SimulacaoClasse; 
    private static final String urlAPI = "http://localhost:8081/YouCreditAPI/"; 
    
	@Override 
	public void execute() throws Exception {
        		 
	    String RetornoCall; 
	    SimulacaoClasse = (CR_Simulacao_Credito) getView().getEntity();
        
	    RetornoCall = callGet("CRMSimulacao");
	    System.out.println("callGet "+RetornoCall);
	    
	    getView().setValue("existecrm", "S");
	    
	    //getView().setEditable(EntidadeClasse.getNome(),true);

	}
	
	private static String callGet(String servico) throws IOException{

		String listaParametros = "?simulacaoid=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getSimulacaocreditoid()),"UTF-8");
		listaParametros += "&produto=" + URLEncoder.encode(SimulacaoClasse.getClasseproduto().getProduto(),"UTF-8");
		listaParametros += "&instituicaocredito=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseproduto().getClasseinstituicaocredito().getBanco()),"UTF-8");
		listaParametros += "&entidadeid=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseentidade().getEntidadeid()),"UTF-8");
		listaParametros += "&nome=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getNome(),"UTF-8");
		listaParametros += "&nif=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getNif(),"UTF-8");
		listaParametros += "&telefone=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getTelefone(),"UTF-8");
		listaParametros += "&email=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getEmail(),"UTF-8");
		listaParametros += "&rating=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseentidade().getRating()),"UTF-8");
		listaParametros += "&estadoentidade=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseentidade().getClasseestadoentidade().getEstadoentidade()),"UTF-8");
		listaParametros += "&totalsolicitado=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalsolicitado()),"UTF-8");
		listaParametros += "&totalpossivel=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalpossivel()),"UTF-8");
		listaParametros += "&estadosimulacao=" + URLEncoder.encode(SimulacaoClasse.getClasseestadocredito().getEstado(),"UTF-8");
		listaParametros += "&scoring=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getScoring()),"UTF-8");
		if (SimulacaoClasse.getClasseestadocredito().getEstado().contains("Para Aprovação"))
		   {listaParametros += "&evento=" + URLEncoder.encode("criar","UTF-8");}
		if (SimulacaoClasse.getClasseestadocredito().getEstado().contains("Aprovado"))
		   {listaParametros += "&evento=" + URLEncoder.encode("alterar","UTF-8");}	

		HttpURLConnection connection = (HttpURLConnection) new URL(urlAPI + servico + listaParametros).openConnection();
			
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if (responseCode == 200){
				String response = "";
				Scanner scanner = new Scanner(connection.getInputStream());
				while(scanner.hasNextLine()){
					response += scanner.nextLine();
					response += "\n";
				}
				scanner.close();

				return response;
			}
			
		return null;
	}	
		
	private static String callPost(String servico) throws IOException{
			String retorno=""; 
			
			HttpURLConnection connection = (HttpURLConnection) new URL(urlAPI + servico).openConnection();

			connection.setRequestMethod("POST");
			
			String listaParametros = "?simulacaocreditoid=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getSimulacaocreditoid()),"UTF-8");
			listaParametros += "&produto=" + URLEncoder.encode(SimulacaoClasse.getClasseproduto().getProduto(),"UTF-8");
			listaParametros += "&banco=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseproduto().getClasseinstituicaocredito().getBanco()),"UTF-8");
			listaParametros += "&entidadeid=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseentidade().getEntidadeid()),"UTF-8");
			listaParametros += "&nome=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getNome(),"UTF-8");
			listaParametros += "&nif=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getNif(),"UTF-8");
			listaParametros += "&telefone=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getTelefone(),"UTF-8");
			listaParametros += "&email=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getEmail(),"UTF-8");
			listaParametros += "&rating=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseentidade().getRating()),"UTF-8");
			listaParametros += "&estadoentidade=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getClasseentidade().getClasseestadoentidade().getEstadoentidade()),"UTF-8");
			listaParametros += "&totalsolicitado=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalsolicitado()),"UTF-8");
			listaParametros += "&totalpossivel=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalpossivel()),"UTF-8");
			listaParametros += "&estado=" + URLEncoder.encode(SimulacaoClasse.getClasseestadocredito().getEstado(),"UTF-8");
			listaParametros += "&scoring=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getScoring()),"UTF-8");
			listaParametros += "&evento=" + URLEncoder.encode("criar","UTF-8");
	
			connection.setDoOutput(true);
		    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
		    wr.write(listaParametros);
		    wr.flush();
			
			int responseCode = connection.getResponseCode();
			if (responseCode == 200){
				String response = "";
				Scanner scanner = new Scanner(connection.getInputStream());
				while(scanner.hasNextLine()){
					response += scanner.nextLine();
					response += "\n";
				}
				scanner.close();

				return response;
			}
		return null;
	}
}
