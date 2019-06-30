package br.com.esiii.negocio;

import br.com.esiii.dominio.EntidadeDominio;

public interface IStrategy {

	public String processar(EntidadeDominio entidade);
}
