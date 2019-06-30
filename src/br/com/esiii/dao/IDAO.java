package br.com.esiii.dao;

import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

public interface IDAO {
	
	public Resultado salvar(EntidadeDominio entidade);
	public Resultado consultar (EntidadeDominio entidade);
	public Resultado alterar (EntidadeDominio entidade);
	public Resultado excluir (EntidadeDominio entidade);
	
}
