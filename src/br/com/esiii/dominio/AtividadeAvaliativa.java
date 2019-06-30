package br.com.esiii.dominio;

import java.util.Date;

public abstract class AtividadeAvaliativa {
	
	protected Date data;
	protected double peso;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
