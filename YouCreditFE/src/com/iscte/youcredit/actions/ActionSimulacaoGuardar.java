package com.iscte.youcredit.actions;

import java.util.*;

import org.openxava.actions.*;


public class ActionSimulacaoGuardar extends ViewBaseAction {

	@Override
	//protected Map getValuesToSave() throws Exception {
	public void execute() throws Exception {

	    System.out.println(getView().getValues());	
	    
	    HashMap<String, String> estado = new HashMap(); 
	    estado.put("estado", "Para Aprovação");
	    getView().setValue("classeestadocredito", estado);
	    
//	    HashMap<String, String> referencia = new HashMap(); 
//	    String utilizador = (String) getView().getValue("utilizadorlog");
//	    String produtoid = (String) getView().getValue("produtoid");
//	    String datalog = (String) getView().getValue("datalog");
//	    referencia.put("referencia", (utilizador + "#" + produtoid + "#" + datalog).toString());
//	    getView().setValue("referencia", "12345");

	    executeAction("CRUD.save");
	}
}