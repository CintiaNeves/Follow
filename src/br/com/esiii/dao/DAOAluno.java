package br.com.esiii.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.Curso;
import br.com.esiii.dominio.Endereco;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.dominio.Ra;
import br.com.esiii.dominio.Telefone;
import br.com.esiii.util.Resultado;

public class DAOAluno extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		Aluno aluno = (Aluno) entidade;
		Resultado resultado = new Resultado();
		if (aluno.getEndereco().getId() == 0) {
			IDAO dao = new DAOEndereco();
			Endereco endereco = aluno.getEndereco();
			dao.salvar(endereco);
		}

		String sql = "INSERT INTO alunos (nome, sexo, cpf, dataNascimento, dataMatricula, rg, status, idEndereco, email, telefone, curso, semestre) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getSexo());
			stmt.setString(3, aluno.getCpf());
			stmt.setDate(4, new Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setDate(5, new Date(aluno.getDataMatricula().getTimeInMillis()));
			stmt.setString(6, aluno.getRg());
			stmt.setString(7, "ATIVO");
			stmt.setInt(8, aluno.getEndereco().getId());
			stmt.setString(9, aluno.getEmail());
			stmt.setString(10, aluno.getTelefone().getNumero());
			stmt.setInt(11, aluno.getCurso().getId());
			stmt.setInt(12, 1);

			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				aluno.setId(rs.getInt(1));

			stmt.close();
			IDAO dao = new DAORa();
			dao.salvar(aluno);

			sql = "update alunos set idra=? where id=" + aluno.getId() + "";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, aluno.getRa().getId());

			stmt.execute();
			stmt.close();
			//con.close();

			resultado.sucesso("Salvo com sucesso!");
			return resultado;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultado.erro("Erro salvar, por favor, refaça a operação.");
			return resultado;
		}
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Aluno aluno = (Aluno) entidade;
		Resultado resultado = new Resultado();
		int contagem = 0;
		
		DAOCurso daoCurso = new DAOCurso();
		List<Curso> cursos = new ArrayList<>();
		cursos = daoCurso.selectAtivos();
		
		Map<Integer, String> mapaCursos = new HashMap<Integer, String>();
		for(Curso c : cursos){
			mapaCursos.put(c.getId(), c.getNomeCurso());
		}
		try {
			
			List<EntidadeDominio> alunos = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
			Boolean visualizar = false;
			if(aluno.getId() != 0){
				
				stmt = this.con.prepareStatement("SELECT * FROM alunos WHERE id = ?");
				stmt.setInt(1, aluno.getId());
				visualizar = true;
				
			} else if(aluno.getCpf() != ""){
				
				stmt = this.con.prepareStatement("SELECT * FROM alunos where cpf = ?");
				stmt.setString(1, aluno.getCpf());
				
			}else if(aluno.getNome()!= ""){
				
				stmt = this.con.prepareStatement("SELECT * FROM alunos where nome like ?");
				stmt.setString(1, "%" + aluno.getNome() + "%");
				
			}else if(aluno.getRa().getId() != 0){
				
				stmt = this.con.prepareStatement("SELECT * FROM alunos where idRa like ?");
				stmt.setInt(1, aluno.getRa().getId());
				
			}else{
				resultado.erro("NECESSÁRIO PREENCHER UM DOS CAMPOS DE CONSULTA!");
				return resultado;
			}
			
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
								
				Aluno a = new Aluno();
				Ra ra = new Ra();
				Curso curso = new Curso();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				ra.setId(rs.getInt("idRa"));
				a.setRa(ra);
				a.setSexo(rs.getString("sexo"));
				a.setCpf(rs.getString("cpf"));
				a.setRg(rs.getString("rg"));
				curso.setId(Integer.parseInt(rs.getString("curso")));
				curso.setNomeCurso(mapaCursos.get(curso.getId()));
				a.setCurso(curso);
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				a.setDataNascimento(data);
				
				Calendar dataMatricula = Calendar.getInstance();
				dataMatricula.setTime(rs.getDate("dataMatricula"));
				a.setDataMatricula(dataMatricula);
				
				a.setSemestre(rs.getInt("semestre"));
				a.setEmail(rs.getString("email"));
				
				Telefone tel = new Telefone();
				tel.setNumero(rs.getString("telefone"));
				a.setTelefone(tel);
				
				List<EntidadeDominio> listEnd = new ArrayList<>();
				Endereco end = new Endereco();
				DAOEndereco daoEndereco = new DAOEndereco();
				Resultado res = new Resultado();
				end.setId(rs.getInt("idEndereco"));
				res = daoEndereco.consultar(end);
				listEnd = res.getListaResultado();
				end = (Endereco) listEnd.get(0);
				a.setEndereco(end);
				
				alunos.add(a);
				contagem++;
			}
			
			if(visualizar){
				resultado.setResultado(alunos.get(0));
			} else{
				resultado.setListaResultado(alunos);
			}
			
			
			if(contagem == 0){
				resultado.sucesso("Nenhum aluno encontrado.");
			}
			else{
				resultado.sucesso("");
			}
			
			resultado.setContagem(contagem);
			rs.close();
			stmt.close();
			return resultado;
			
		} catch (SQLException e1) {
			
						e1.printStackTrace();
						resultado.erro("Erro de consulta.");
						return resultado;
		}
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {

		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {

		return null;
	}
}
