package br.com.esiii.command;

import br.com.esiii.facade.Fachada;
import br.com.esiii.facade.IFachada;

/**
 * 
 * @author Cintia
 * Classe abstrata que implenta Interface Command 
 * Responsável pela instância da Fachada 
 *
 */

public abstract class AbstractCommand implements ICommand{
	
	protected IFachada fachada = new Fachada();
}
