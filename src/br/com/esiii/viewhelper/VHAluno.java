package br.com.esiii.viewhelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.Cidade;
import br.com.esiii.dominio.Curso;
import br.com.esiii.dominio.Endereco;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.dominio.Estado;
import br.com.esiii.dominio.Ra;
import br.com.esiii.dominio.Telefone;
import br.com.esiii.util.Resultado;

public class VHAluno implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String id = request.getParameter("txtId");
		String nome = request.getParameter("txtNome");
		String sexo = request.getParameter("txtSexo");
		String cpf = request.getParameter("txtCPF");
		String stDataNascimento = request.getParameter("txtDataNascimento");
		String stRg = request.getParameter("txtRg");
		String stRa = request.getParameter("txtRA");
		
		String stLogradouro = request.getParameter("txtLogradouro");
		String stNumero = request.getParameter("txtNumero");
		String stComplemento = request.getParameter("txtComplemento");
		String stBairro = request.getParameter("txtBairro");
		String stCidade = request.getParameter("txtCidade");
		String stEstado = request.getParameter("txtEstado");
		String stCep = request.getParameter("txtCep");
		String stTelefone = request.getParameter("txtTelefone");
		String stEmail = request.getParameter("txtEmail");
		
		String stNomeCurso = request.getParameter("txtCurso");
		
		stDataNascimento = (stDataNascimento == "") ? null : stDataNascimento;
		
		Calendar dataNascimento = null;
		
		if(stDataNascimento != null)
		{
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date data = format.parse(stDataNascimento);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		id = (id == null) ? "0" : id;
		stRa = (stRa == null || stRa == "") ? "0" : stRa;
		sexo = (sexo == null) ? "" : sexo;
		nome = (nome == null) ? null : nome.toUpperCase();
		
		Estado estado = new Estado(stEstado);
		Cidade cidade = new Cidade(stCidade, estado);
		Endereco endereco = new Endereco(stLogradouro, stNumero, stCep, stComplemento, cidade, stBairro);
		
		Telefone telefone = new Telefone(stTelefone);
		
		Ra ra = new Ra();
		ra.setId(Integer.parseInt(stRa));
		Curso curso = new Curso(stNomeCurso);
		
		Aluno aluno = new Aluno(Integer.parseInt(id), nome, sexo, cpf, dataNascimento, stRg, stEmail, endereco, telefone, curso, ra);
		
		return aluno;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
 		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");		
		
		if(resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);
		
		if(operacao.equals("SALVAR")){
			if(resultado.getErro()){
				request.setAttribute("aluno", (Aluno) resultado.getListaResultado().get(0));
			}
		} else if(operacao.equals("CONSULTAR")){
			if(!resultado.getErro()){
				if(resultado.getResultado() != null){
					request.setAttribute("aluno", (Aluno) resultado.getResultado());
				}else{
					request.setAttribute("resultado", resultado.getListaResultado());
				}
			}
		}
		try {
			if(operacao.equals("SALVAR")){
			RequestDispatcher rd = request.getRequestDispatcher("Teste.jsp");
			rd.forward(request, response);
			}
			else if(operacao.equals("CONSULTAR")){
				if(resultado.getResultado() != null){					
					RequestDispatcher rd = request.getRequestDispatcher("Visualizar.jsp");
					rd.forward(request, response);
				} else if(resultado.getListaResultado() != null){
					RequestDispatcher rd = request.getRequestDispatcher("Consulta.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("Consulta.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}

}
