package br.com.esiii.negocio;

import java.util.Calendar;

import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.EntidadeDominio;

public class StComplementarDtMatricula implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Aluno aluno = (Aluno) entidade;
		
		Calendar dataMatricula = Calendar.getInstance();
		aluno.setDataMatricula(dataMatricula);
		
		return null;
	}

}
