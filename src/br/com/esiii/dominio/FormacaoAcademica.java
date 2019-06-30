package br.com.esiii.dominio;

import java.util.Date;

public class FormacaoAcademica {

	private String formacao;
	private String universidade;
	private Date anoFormacao;
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getUniversidade() {
		return universidade;
	}
	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}
	public Date getAnoFormacao() {
		return anoFormacao;
	}
	public void setAnoFormacao(Date anoFormacao) {
		this.anoFormacao = anoFormacao;
	}
	
	
}
