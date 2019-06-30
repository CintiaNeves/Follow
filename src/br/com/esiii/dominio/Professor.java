package br.com.esiii.dominio;

import java.util.List;

public class Professor extends Pessoa {

	private List<FormacaoAcademica> formacoes;

	public List<FormacaoAcademica> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<FormacaoAcademica> formacoes) {
		this.formacoes = formacoes;
	}
	
	
}
