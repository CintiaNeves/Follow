package br.com.esiii.command;

import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;


/**
 * 
 * @author Cintia
 * Interface com m�todo de  execu��o de entidade de dom�nio
 * Retorna uma String 
 */
public interface ICommand {

	public Resultado executar(EntidadeDominio e);
}


