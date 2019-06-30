package br.com.esiii.negocio;

import br.com.esiii.dao.DAOCurso;
import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.Curso;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

public class StAlocarCurso implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Aluno aluno = (Aluno) entidade;

		Curso curso = new Curso();
		curso = aluno.getCurso();

		DAOCurso dao = new DAOCurso();
		Resultado resultado = dao.consultar(curso);

		return resultado.getMensagem();
	}

}
