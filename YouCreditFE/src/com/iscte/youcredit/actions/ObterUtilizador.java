package com.iscte.youcredit.actions;
import java.util.*;
import org.openxava.filters.*;
import org.openxava.util.*;

import com.iscte.youcredit.model.*;

public class ObterUtilizador implements IFilter {

	public Object filter(Object parametro) throws FilterException { 
		int utilizadorid=0;
		Object [] retorno = null;
		utilizadorid=Utilizador.getUtilizadorid(Users.getCurrent());
		retorno = new Object[1];
		retorno[0]=utilizadorid;
		return retorno; 
	}
}
