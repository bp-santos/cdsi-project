package com.iscte.youcredit.actions;

import org.openxava.actions.*;

public class ActionSimulacaoGerarScoring extends ViewBaseAction {

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		double salarioanual; 
		double creditosolicitado;
		double totalsolicitado;
		String entidadeavalista;
		boolean avalista; 
        int score; 
        int rating;
        
        //Obter valores para variaveis de calculo
        rating = (int) getView().getValue("rating"); 
        salarioanual = (double) getView().getValue("salarioanual"); 
        totalsolicitado = (double) getView().getValue("totalsolicitado"); 
        creditosolicitado = (double) getView().getValue("creditosactuais"); 
        entidadeavalista = (String) getView().getValue("entidadeempregadora"); 
        avalista = true;
	
        if (entidadeavalista.isEmpty() || entidadeavalista.isBlank()) {avalista=false;}

        //Calcular o rating  
   
        score=1;
        if (rating==5 && totalsolicitado<(0.05*salarioanual)) 
           {score=5;}
        else 
           {if (rating==5 && totalsolicitado<(0.10*salarioanual) && avalista) 
               {score=4;}
            else
               {if (rating>3 && totalsolicitado<(0.20*salarioanual)) 
                   {score=3;}
               else                
                   {if (rating>2 && totalsolicitado<(0.10*salarioanual)) 
                       {score=2;}
               }    
           }
        getView().setValue("scoring", score);
        //getView().refresh();
	}
  }
}
