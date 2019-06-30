package br.com.esiii.negocio;

import java.util.Calendar;

import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.EntidadeDominio;

public class StValidarIdadeAluno implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Aluno aluno = (Aluno) entidade;
		Calendar dataNascimento = aluno.getDataNascimento();
		
		if(dataNascimento != null){
			
			Calendar dataAtual = Calendar.getInstance();
			
			int idade = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
			
			if(idade >= 17){
				return null;
			}else{
				return "O aluno deve ter no mínimo 17 anos";
			}
		}
		else{
			return null;
		}
		
	}

}
