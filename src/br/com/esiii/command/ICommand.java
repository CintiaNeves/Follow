package br.com.esiii.command;

import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;


/**
 * 
 * @author Cintia
 * Interface com método de  execução de entidade de domínio
 * Retorna uma String 
 */
public interface ICommand {

	public Resultado executar(EntidadeDominio e);
}


