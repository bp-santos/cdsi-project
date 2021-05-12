package com.iscte.youcredit.model;

import org.apache.commons.lang3.*;
import java.util.List;

public final class Utilitarios {

	public static boolean CampoStringValido(String ycampo, int ycomprimento) {
		boolean xretorno; 
		
		xretorno=true;
		if (ycampo.isEmpty()) {xretorno=false;}
		if (ycampo.isBlank()) {xretorno=false;}
		if (ycampo.length()<ycomprimento) {xretorno=false;}
		if (ycampo.compareTo(".")==0) {xretorno=false;}
		return xretorno; 
	}
	
	public static boolean CampoTelefoneValido(String ycampo) {
		boolean xretorno; 
		
		xretorno=true;
		if (ycampo.length()<8) {xretorno=false;}
		if (StringUtils.isNumeric(ycampo)==false) {xretorno=false;}
		return xretorno; 
	}

	public static boolean CampoNifValido(String ycampo) {
		boolean xretorno; 
		
		xretorno=true;
		if (ycampo.length()<7) {xretorno=false;}
		if (StringUtils.isNumeric(ycampo)==false) {xretorno=false;}
		return xretorno; 
	}

	public static boolean CampoPassaporteValido(String ycampo) {
		boolean xretorno; 
		
		xretorno=true;
		if (ycampo.isEmpty()) {xretorno=false;}
		if (ycampo.isBlank()) {xretorno=false;}
		if (ycampo.length()<9) {xretorno=false;}
		if (ycampo.compareTo(".")==0) {xretorno=false;}
		return xretorno; 
	}
	
	public static boolean CampoEmailValido(String ycampo) {
			boolean xretorno; 
			
			xretorno=true;
			if (ycampo.length()<11) {xretorno=false;}
			if (ycampo.contains("@")==false) {xretorno=false;}
			if (ycampo.contains(".")==false) {xretorno=false;}
			return xretorno; 
	}

	public static boolean CampoCartaoCidadaoValido(String ycampo) {
		boolean xretorno; 
		
		xretorno=true;
		if (ycampo.isEmpty()) {xretorno=false;}
		if (ycampo.isBlank()) {xretorno=false;}
		if (ycampo.length()<11) {xretorno=false;}
		if (ycampo.compareTo(".")==0) {xretorno=false;}
		return xretorno; 
    }

	public static boolean CampoCodigoPostalValido(String ycampo) {
		boolean xretorno; 
		
		xretorno=true;
		if (ycampo.isEmpty()) {xretorno=false;}
		if (ycampo.isBlank()) {xretorno=false;}
		if (ycampo.length()<8) {xretorno=false;}
		if (ycampo.compareTo(".")==0) {xretorno=false;}
		return xretorno; 
    }

	public static boolean CampoGeneroValido(String ycampo) {
		boolean xretorno;
		
		xretorno=true;
		if (ycampo.compareToIgnoreCase("Masculino") !=0 && ycampo.compareToIgnoreCase("Feminino") !=0 && ycampo.compareToIgnoreCase("Neutro")!=0) {xretorno=false;}
		return xretorno; 
    }
}
