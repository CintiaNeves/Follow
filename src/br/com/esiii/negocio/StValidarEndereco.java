package br.com.esiii.negocio;

import br.com.esiii.dao.DAOEndereco;
import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.Endereco;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

public class StValidarEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Aluno aluno = (Aluno) entidade;
		
		Endereco endereco = new Endereco();
		endereco = aluno.getEndereco();
		
		DAOEndereco dao = new DAOEndereco();
		
		Resultado resultado = dao.consultar(endereco);
		aluno.setEndereco(endereco);
		return resultado.getMensagem();
	}

}
