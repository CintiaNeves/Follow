package br.com.esiii.dominio;

import java.util.List;

public class Disciplina {

	private String nome;
	private List<Trabalho> trabalhos;
	private List<Prova> provas;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Trabalho> getTrabalhos() {
		return trabalhos;
	}
	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}
	public List<Prova> getProvas() {
		return provas;
	}
	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}
	
	
}
