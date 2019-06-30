package br.com.esiii.facade;

import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

public interface IFachada {

	public Resultado salvar(EntidadeDominio e);
	
	public Resultado consultar(EntidadeDominio e);
}
