package com.iscte.youcredit.actions;

import java.time.*;

import org.openxava.calculators.*;

public class CalcularDataInicio implements ICalculator {
	private static final long serialVersionUID = 1L;
	public Object calculate() throws Exception {
		return LocalDate.now();
	}
}
