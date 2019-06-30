package br.com.esiii.negocio;

import br.com.esiii.dao.DAOAluno;
import br.com.esiii.dao.IDAO;
import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

public class StValidarExistencia implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Aluno aluno = (Aluno) entidade;
		Resultado resultado = new Resultado();
		IDAO daoAluno = new DAOAluno(); 
		
		resultado = daoAluno.consultar(aluno);
		
		if(resultado.getContagem() == 0){
			return null;
		}else{
			return "O cpf informado já está cadastrado na base de dados!";
		}
		
	}

}
