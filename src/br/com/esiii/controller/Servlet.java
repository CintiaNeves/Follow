package br.com.esiii.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esiii.command.CmdConsultar;
import br.com.esiii.command.CmdSalvar;
import br.com.esiii.command.ICommand;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;
import br.com.esiii.viewhelper.IViewHelper;
import br.com.esiii.viewhelper.VHAluno;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/Pages/servlet"})

public class Servlet extends HttpServlet{
    
	private Map<String, ICommand> mapCommand;
	private Map<String, IViewHelper> mapViewHelper;
	
	
	public Servlet(){
		
		mapCommand = new HashMap<String, ICommand>();
		mapViewHelper = new HashMap<String, IViewHelper>();
		
		mapCommand.put("CONSULTAR", new CmdConsultar());
		mapCommand.put("SALVAR", new CmdSalvar());
		
		mapViewHelper.put("VHALUNO", new VHAluno());
		
		
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {
	
		String operacao = request.getParameter("btnOperacao");
		ICommand command = mapCommand.get(operacao);
		
		String formName = request.getParameter("FormName");
 		IViewHelper viewHelper = mapViewHelper.get(formName);
		
		EntidadeDominio entidade = viewHelper.getEntidade(request);
		

		Resultado resultado = command.executar(entidade);
		
		viewHelper.setView(resultado, request, response);
	}
}
