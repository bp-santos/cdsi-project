package com.iscte.youcredit.actions;

import java.io.*;
import java.net.*;
import java.util.*;

import org.openxava.actions.*;

import com.iscte.youcredit.model.*;

public class ActionSimulacaoActualizarCRM extends ViewBaseAction{
    private static CR_Simulacao_Credito SimulacaoClasse; 
    private static final String urlAPI = "http://localhost:8080/YouCreditAPI/"; 
    
	@Override 
	public void execute() throws Exception {
        		 
	    String RetornoCall; 
	    SimulacaoClasse = (CR_Simulacao_Credito) getView().getEntity();
        
	    RetornoCall = callGet("CRMEstado");
	    System.out.println("callGet "+RetornoCall);
	    
	    getView().setValue("existecrm", "S");
	    
	    //getView().setEditable(EntidadeClasse.getNome(),true);

	}
	
	private static String callGet(String servico) throws IOException{

		String listaParametros = "?simulacaocreditoid=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getSimulacaocreditoid()),"UTF-8");
		listaParametros += "&referencia=" + URLEncoder.encode(SimulacaoClasse.getReferencia(),"UTF-8");
		listaParametros += "&flagcredito=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.isFlagcredito()),"UTF-8");
		listaParametros += "&datasolicitacao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatasolicitacao()),"UTF-8");
		listaParametros += "&datadecisao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatadecisao()),"UTF-8");
		listaParametros += "&datainicio=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatainicio()),"UTF-8");
		listaParametros += "&datafim=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatafim()),"UTF-8");
		listaParametros += "&dataavaliacao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDataavaliacao()),"UTF-8");
		listaParametros += "&dataalteracaoestadocredito=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDataalteracaoestadocredito()),"UTF-8");
		listaParametros += "&dataalteracaoestadosimulacao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDataalteracaoestadosimulacao()),"UTF-8");
		listaParametros += "&totalsolicitado=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalsolicitado()),"UTF-8");
		listaParametros += "&totalconcedido=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalconcedido()),"UTF-8");
		listaParametros += "&totalpossivel=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalpossivel()),"UTF-8");
		listaParametros += "&totalcapital=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalcapital()),"UTF-8");
		listaParametros += "&totaljuro=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotaljuro()),"UTF-8");
		listaParametros += "&totaldespesa=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotaldespesa()),"UTF-8");
		listaParametros += "&totalimposto=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalimposto()),"UTF-8");
		listaParametros += "&descricaoobjeto=" + URLEncoder.encode(SimulacaoClasse.getDescricaoobjeto(),"UTF-8");
		listaParametros += "&duracao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDuracao()),"UTF-8");
		listaParametros += "&entidadeavalista=" + URLEncoder.encode(SimulacaoClasse.getEntidadeavalista(),"UTF-8");
		listaParametros += "&scoring=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getScoring()),"UTF-8");
		listaParametros += "&parecer=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.isParecer()),"UTF-8");
		listaParametros += "&estado=" + URLEncoder.encode(SimulacaoClasse.getClasseestadocredito().getEstado(),"UTF-8");
		listaParametros += "&periodicidade=" + URLEncoder.encode(SimulacaoClasse.getClasseperiodicidade().getPeriodicidade(),"UTF-8");
		listaParametros += "&produto=" + URLEncoder.encode(SimulacaoClasse.getClasseproduto().getProduto(),"UTF-8");
		listaParametros += "&entidade=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getEntidade(),"UTF-8");
		
		if (SimulacaoClasse.getClasseestadocredito().getEstado().contains("Aprovado"))
		   {listaParametros += "&evento=" + URLEncoder.encode("alterar","UTF-8");}
		if (SimulacaoClasse.getClasseestadocredito().getEstado().contains("Para Aprovação"))
		   {listaParametros += "&evento=" + URLEncoder.encode("criar","UTF-8");}	

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
			listaParametros += "&referencia=" + URLEncoder.encode(SimulacaoClasse.getReferencia(),"UTF-8");
			listaParametros += "&flagcredito=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.isFlagcredito()),"UTF-8");
			listaParametros += "&datasolicitacao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatasolicitacao()),"UTF-8");
			listaParametros += "&datadecisao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatadecisao()),"UTF-8");
			listaParametros += "&datainicio=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatainicio()),"UTF-8");
			listaParametros += "&datafim=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDatafim()),"UTF-8");
			listaParametros += "&dataavaliacao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDataavaliacao()),"UTF-8");
			listaParametros += "&dataalteracaoestadocredito=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDataalteracaoestadocredito()),"UTF-8");
			listaParametros += "&dataalteracaoestadosimulacao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDataalteracaoestadosimulacao()),"UTF-8");
			listaParametros += "&totalsolicitado=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalsolicitado()),"UTF-8");
			listaParametros += "&totalconcedido=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalconcedido()),"UTF-8");
			listaParametros += "&totalpossivel=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalpossivel()),"UTF-8");
			listaParametros += "&totalcapital=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalcapital()),"UTF-8");
			listaParametros += "&totaljuro=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotaljuro()),"UTF-8");
			listaParametros += "&totaldespesa=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotaldespesa()),"UTF-8");
			listaParametros += "&totalimposto=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getTotalimposto()),"UTF-8");
			listaParametros += "&descricaoobjeto=" + URLEncoder.encode(SimulacaoClasse.getDescricaoobjeto(),"UTF-8");
			listaParametros += "&duracao=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getDuracao()),"UTF-8");
			listaParametros += "&entidadeavalista=" + URLEncoder.encode(SimulacaoClasse.getEntidadeavalista(),"UTF-8");
			listaParametros += "&scoring=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.getScoring()),"UTF-8");
			listaParametros += "&parecer=" + URLEncoder.encode(String.valueOf(SimulacaoClasse.isParecer()),"UTF-8");
			listaParametros += "&estado=" + URLEncoder.encode(SimulacaoClasse.getClasseestadocredito().getEstado(),"UTF-8");
			listaParametros += "&periodicidade=" + URLEncoder.encode(SimulacaoClasse.getClasseperiodicidade().getPeriodicidade(),"UTF-8");
			listaParametros += "&produto=" + URLEncoder.encode(SimulacaoClasse.getClasseproduto().getProduto(),"UTF-8");
			listaParametros += "&entidade=" + URLEncoder.encode(SimulacaoClasse.getClasseentidade().getEntidade(),"UTF-8");
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
