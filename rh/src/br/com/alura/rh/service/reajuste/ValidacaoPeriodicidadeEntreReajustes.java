package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {	
	
	//regra minimo de 6 meses 
	public void validar(Funcionario funcionario, BigDecimal aumento) {
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		long mesesDesteUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
		if (mesesDesteUltimoReajuste  < 6) {
			throw new ValidacaoException("Intervalo entre reajustes deve ser de no minimo 6 meses!");
		}
	
	}
}
