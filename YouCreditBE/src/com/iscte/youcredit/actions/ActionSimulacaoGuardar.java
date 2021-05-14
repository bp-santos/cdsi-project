package com.iscte.youcredit.actions;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.util.*;


public class ActionSimulacaoGuardar extends ViewBaseAction {

	@Override
	public void execute() throws Exception {

	    System.out.println(getView().getValues());	
	    System.out.println("Rui Pedro");
	    HashMap<String, String> estado = new HashMap(); 
	    boolean flag = (boolean) getView().getValue("flagcredito");
	    double concedido = (double) getView().getValue("totalconcedido");
	    if(flag) {
	    	if(concedido >= 500 && concedido <= 5000) {
	    		estado.put("estado", "Aprovado");
	    		getView().setValue("classeestadocredito", estado);
	    	}
	    	else
				throw new javax.validation.ValidationException(
						XavaResources.getString("Total Concedido: Valor incorreto ", concedido));
	    }
	    else {
	    	if(concedido == 0) {
	    		estado.put("estado", "Não Aprovado");
	    		getView().setValue("classeestadocredito", estado);
	    	}else
				throw new javax.validation.ValidationException(
						XavaResources.getString("Total Concedido: tem de ser crédito para ter valor ", concedido));
	    }

	    executeAction("CRUD.save");
	}
}