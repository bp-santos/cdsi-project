package com.iscte.youcredit.actions;

import org.openxava.actions.*;

import com.iscte.youcredit.model.*;

public class ActionSimulacaoGerarScoring extends ViewBaseAction {

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		double salarioanual;
		double totalsolicitado;
		String entidadeavalista;
		boolean avalista;
		int score;
		int rating;

		CR_Simulacao_Credito simulacao = (CR_Simulacao_Credito) getView().getEntity();
		
		// Obter valores para variaveis de calculo
		rating = simulacao.getClasseentidade().getRating();
		salarioanual = simulacao.getClasseentidade().getSalarioanual();
		totalsolicitado = simulacao.getTotalsolicitado();
		entidadeavalista = simulacao.getEntidadeavalista();
		avalista = true;

		if (entidadeavalista.isEmpty() || entidadeavalista.isBlank()) {
			avalista = false;
		}

		// Calcular o rating

		score = 1;
		if (rating == 5 && totalsolicitado < (0.05 * salarioanual)) {
			score = 5;
		} else {
			if (rating == 5 && totalsolicitado < (0.10 * salarioanual) && avalista) {
				score = 4;
			} else {
				if (rating > 3 && totalsolicitado < (0.20 * salarioanual)) {
					score = 3;
				} else {
					if (rating > 2 && totalsolicitado < (0.10 * salarioanual)) {
						score = 2;
					}
				}
			}
			getView().setValue("scoring", score);
			// getView().refresh();
		}
	}
}