package br.com.esiii.dominio;

public class Nota {

	private double nota;
	private AtividadeAvaliativa atividade; 

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public AtividadeAvaliativa getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeAvaliativa atividade) {
		this.atividade = atividade;
	}
	
}
