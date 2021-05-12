package com.iscte.youcredit.actions;
import org.openxava.actions.*;
import com.iscte.youcredit.model.EN_Entidade;

public class ActionEntidadeGerarRating extends ViewBaseAction{
	
	@Override
	public void execute() throws Exception {
        double salarioanual; 
		double creditoactual;
		String entidadeempregadora;
        boolean empregado; 
        int rating; 
        
        //Obter valores para variáveis de cálculo
        salarioanual = (double) getView().getValue("salarioanual"); 
        creditoactual = (double) getView().getValue("creditosactuais"); 
        entidadeempregadora = (String) getView().getValue("entidadeempregadora"); 
	    empregado = true; 
        if (entidadeempregadora.isEmpty() || entidadeempregadora.isBlank()) {empregado=false;}

        //Calcular o rating  
        rating = 1; 
        if (salarioanual >100000 && empregado) 
           {rating=5;}
        else 
           {if (salarioanual >50000 && creditoactual==0 && empregado) 
               {rating=4;}
            else
               {if ((creditoactual < (0.20 * salarioanual))  && empregado) 
                   {rating=3;}
               else                
                   {if ((creditoactual < (0.40 * salarioanual))  && empregado) 
                       {rating=2;}
                   }
               }
           }
        getView().setValue("rating", rating);
        //getView().refresh();
    }
}
