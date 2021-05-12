package com.iscte.youcredit.model;

import javax.persistence.*;
import org.openxava.jpa.*;

public class Utilizador {
       
        public static int getUtilizadorid(String yutilizador)
       {int pos_separador = yutilizador.indexOf("_");
        String utilizadortemp=""; 
        int utilizadorid=0;  
        if (pos_separador > 0)
        	{utilizadortemp= yutilizador.substring(pos_separador+1, yutilizador.length());}
        if (utilizadortemp.matches("[0-9]")) {utilizadorid= Integer.parseInt(utilizadortemp);}
        return utilizadorid;
        }

        public static String getUtilizadorarea(String yutilizador)
       {int pos_separador = yutilizador.indexOf("_");
        String utilizadorarea=""; 
        if (pos_separador > 0)
        	{utilizadorarea= yutilizador.substring(0,pos_separador);}
        return utilizadorarea;
        }

       public static String getUtilizadornome(String yutilizador)
       {String utilizadornome="";
    	String querySql = "SELECT nome FROM EN_Entidade WHERE entidade_id = " + getUtilizadorid(yutilizador);
        Query conexao = XPersistence.getManager().createQuery(querySql);
       	if (conexao != null) {
        try {utilizadornome = (String) conexao.getSingleResult();} 
       	catch(Exception erro) {};}
    	return utilizadornome;
       }

       public static int getUtilizadorestado(String yutilizador)
       {int estadoid=0;
    	String querySql = "SELECT estado_entidade_id FROM EN_Entidade WHERE entidade_id = " + getUtilizadorid(yutilizador);
    	Query conexao = XPersistence.getManager().createQuery(querySql);
      	if (conexao !=null) {
      	try {estadoid = (int) conexao.getSingleResult();}
      	catch (Exception erro) {};}
      	System.out.println("Raios");
      	return estadoid;
       }
}
