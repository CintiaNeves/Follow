package br.com.esiii.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.esiii.dao.DAOAluno;
import br.com.esiii.dao.IDAO;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.negocio.IStrategy;
import br.com.esiii.negocio.StAlocarCurso;
import br.com.esiii.negocio.StComplementarDtMatricula;
import br.com.esiii.negocio.StValidaCpf;
import br.com.esiii.negocio.StValidarDadosObrigatorios;
import br.com.esiii.negocio.StValidarEndereco;
import br.com.esiii.negocio.StValidarExistencia;
//import br.com.esiii.negocio.StValidarExistencia;
import br.com.esiii.negocio.StValidarIdadeAluno;
import br.com.esiii.util.Resultado;

public class Fachada implements IFachada {

	private Map<String, List<IStrategy>> mapStrategy;
	private Map<String, IDAO> mapDAO;
	private List<IStrategy> listStrategySalvar;

	public Fachada() {

		mapStrategy = new HashMap<String, List<IStrategy>>();
		mapDAO = new HashMap<String, IDAO>();

		listStrategySalvar = new ArrayList<IStrategy>();

		listStrategySalvar.add(new StValidarDadosObrigatorios());
		listStrategySalvar.add(new StValidaCpf());
		listStrategySalvar.add(new StValidarExistencia());
		listStrategySalvar.add(new StValidarIdadeAluno());		
		listStrategySalvar.add(new StComplementarDtMatricula());
		listStrategySalvar.add(new StValidarEndereco());
		listStrategySalvar.add(new StAlocarCurso());
		
		mapStrategy.put("SALVAR", listStrategySalvar);
		mapDAO.put("ALUNO", new DAOAluno());

	}

public Resultado validarStrategys(EntidadeDominio entidade, String operacao){
		
		Resultado resultado = new Resultado();
		String mensagem = "";
		String mensagens = "";
		
		List<IStrategy> listStrategy;
		listStrategy = mapStrategy.get(operacao);
		
		for (IStrategy iStrategy : listStrategy) {
			
			mensagem = iStrategy.processar(entidade);
			if(mensagem != null){
				mensagens += mensagem;
			}
		}
		
		if(mensagens == ""){
			resultado.sucesso("SUCESSO");
		}else{
			List<EntidadeDominio> l = new ArrayList<>();
			l.add(entidade);
			resultado.setListaResultado(l);
			resultado.erro(mensagens);
		}
		
		return resultado;
	}


	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		resultado = validarStrategys(entidade, "SALVAR");
	
		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName().toUpperCase());
			resultado = dao.salvar(entidade);
		}
		
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		IDAO dao = mapDAO.get(entidade.getClass().getSimpleName().toUpperCase());
		return dao.consultar(entidade);
	}

}
