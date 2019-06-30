package br.com.esiii.command;

import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

/**
 * 
 * @author Cintia
 * Classe concreta que herda da Classe abstrata Command 
 * Implementa o método executar da InterfaceCommand 
 *
 */

public class CmdSalvar extends AbstractCommand {
	
	@Override
	public Resultado executar(EntidadeDominio e) {
		
		return fachada.salvar(e);
		
	}
}
