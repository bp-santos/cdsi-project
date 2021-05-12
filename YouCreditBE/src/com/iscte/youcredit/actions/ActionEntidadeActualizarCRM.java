package com.iscte.youcredit.actions;

import java.io.*;
import java.net.*;
//import org.json.JSONObject;
import java.util.*;

import org.openxava.actions.*;

import com.iscte.youcredit.model.*;

public class ActionEntidadeActualizarCRM extends ViewBaseAction{
    private static EN_Entidade EntidadeClasse; 
    private static final String urlAPI = "http://localhost:8080/YouCreditAPI/"; 
    
	@Override 
	public void execute() throws Exception {
        		 
	    String RetornoCall; 
	    EntidadeClasse = (EN_Entidade) getView().getEntity();
        
	    RetornoCall = callGet("CRMEntidade");
	    System.out.println("callGet "+RetornoCall);
	    
	    getView().setValue("existecrm", "S");
	    
	    //getView().setEditable(EntidadeClasse.getNome(),true);

	}
	
	private static String callGet(String servico) throws IOException{

		String listaParametros = "?entidadeid=" + URLEncoder.encode(String.valueOf(EntidadeClasse.getEntidadeid()),"UTF-8");
		listaParametros += "&nome=" + URLEncoder.encode(EntidadeClasse.getNome(),"UTF-8");
		listaParametros += "&morada=" + URLEncoder.encode(EntidadeClasse.getMorada(),"UTF-8");
		listaParametros += "&nif=" + URLEncoder.encode(EntidadeClasse.getNif(),"UTF-8");
		listaParametros += "&telefone=" + URLEncoder.encode(EntidadeClasse.getTelefone(),"UTF-8");
		listaParametros += "&email=" + URLEncoder.encode(EntidadeClasse.getEmail(),"UTF-8");
		listaParametros += "&estado=" + URLEncoder.encode(EntidadeClasse.getClasseestadoentidade().getEstadoentidade(),"UTF-8");
		listaParametros += "&rating=" + URLEncoder.encode(String.valueOf(EntidadeClasse.getRating()),"UTF-8");
		if (EntidadeClasse.getClasseestadoentidade().getEstadoentidade().contains("Activo"))
		   {listaParametros += "&evento=" + URLEncoder.encode("criar","UTF-8");}
		else
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
			
			String listaParametros = "?entidadeid=" + URLEncoder.encode(String.valueOf(EntidadeClasse.getEntidadeid()),"UTF-8");
			listaParametros += "&nome=" + URLEncoder.encode(EntidadeClasse.getNome(),"UTF-8");
			listaParametros += "&morada=" + URLEncoder.encode(EntidadeClasse.getMorada(),"UTF-8");
			listaParametros += "&nif=" + URLEncoder.encode(EntidadeClasse.getNif(),"UTF-8");
			listaParametros += "&telefone=" + URLEncoder.encode(EntidadeClasse.getTelefone(),"UTF-8");
			listaParametros += "&email=" + URLEncoder.encode(EntidadeClasse.getEmail(),"UTF-8");
			listaParametros += "&estado=" + URLEncoder.encode(EntidadeClasse.getClasseestadoentidade().getEstadoentidade(),"UTF-8");
			listaParametros += "&rating=" + URLEncoder.encode(String.valueOf(EntidadeClasse.getRating()),"UTF-8");
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
