package com.iscte.youcredit.actions;

import java.time.*;

import org.openxava.actions.*;
import org.openxava.util.*;

import com.iscte.youcredit.model.*;

public class ActionEntidadeEliminar extends DeleteAction {

	@Override
	public void execute() throws Exception {
		//EN_Entidade EntidadeClasse = (EN_Entidade) getView().getEntity();
        //EntidadeClasse.setEstadolog("I"); 
        //EntidadeClasse.setDatalog(LocalDate.now());

		getView().setValue("estadolog", "I");
		
		//super.execute();
	    //getView().refresh();
	}
}