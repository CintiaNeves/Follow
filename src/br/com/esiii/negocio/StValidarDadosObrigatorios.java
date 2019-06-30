package br.com.esiii.negocio;

import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.EntidadeDominio;

public class StValidarDadosObrigatorios implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Aluno aluno = (Aluno) entidade;
		
		StringBuilder mensagem = new StringBuilder();
		
		if(aluno.getNome() == null || aluno.getNome().equals("")){
			mensagem.append("Nome é obrigatório\n");
		}
		
		if(aluno.getCpf() == null || aluno.getCpf().equals("")){
			mensagem.append("CPF é obrigatório\n");
		}

		if(aluno.getRg() == null || aluno.getRg().equals("")){
			mensagem.append("RG é obrigatório\n");
		}
		
		if(aluno.getDataNascimento() == null || aluno.getDataNascimento().equals("")){
			mensagem.append("Data de nascimento é obrigatório\n");
		}
		
		if(aluno.getSexo() == null || aluno.getSexo().equals("")){
			mensagem.append("Selecione o gênero\n");
		}
		
		if(aluno.getEndereco().getLogradouro() == null || aluno.getEndereco().getLogradouro().equals("")){
			mensagem.append("Logradouro é obrigatório\n");
		}
		
		if(aluno.getEndereco().getNumero() == null || aluno.getEndereco().getNumero().equals("")){
			mensagem.append("Numero é obrigatório\n");
		}
		
		if(aluno.getEndereco().getBairro() == null || aluno.getEndereco().getBairro().equals("")){
			mensagem.append("Bairro é obrigatório\n");
		}
		
		if(aluno.getEndereco().getCidade().getNome() == null || aluno.getEndereco().getCidade().getNome().equals("")){
			mensagem.append("Cidade é obrigatório\n");
		}
		
		if(aluno.getEndereco().getCidade().getEstado().getNome() == null || aluno.getEndereco().getCidade().getEstado().getNome().equals("")){
			mensagem.append("Estado é obrigatório\n");
		}

		if(aluno.getEndereco().getCep() == null || aluno.getEndereco().getCep().equals("")){
			mensagem.append("CEP é obrigatório\n");
		}

		if(aluno.getTelefone() == null || aluno.getTelefone().equals("")){
			mensagem.append("Telefone é obrigatório\n");
		}

		if(aluno.getEmail() == null || aluno.getEmail().equals("")){
			mensagem.append("E-mail é obrigatório\n");
		}

		if(aluno.getCurso().getNomeCurso() == null || aluno.getCurso().getNomeCurso().equals("")){
			mensagem.append("Selecione um curso\n");
		}
		
		if(mensagem.length() == 0){
			return null;
		}
		return mensagem.toString();
	}

}
