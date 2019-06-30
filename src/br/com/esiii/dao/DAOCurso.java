package br.com.esiii.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.esiii.dominio.Curso;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

public class DAOCurso extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Curso curso = (Curso) entidade;
		Resultado resultado = new Resultado();
		PreparedStatement stmt = null;

		String sql = "SELECT * FROM cursos where nomeCurso = ? ";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, curso.getNomeCurso());
			

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				curso.setNomeCurso(rs.getString("nomeCurso"));
				curso.setId(rs.getInt("id"));
				
				resultado.sucesso(null);
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		}

	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Curso> selectAtivos(){
		List<Curso> cursos = new ArrayList<>();
		PreparedStatement stmt = null;

		String sql = "SELECT * FROM cursos";

		try {
			
			stmt = con.prepareStatement(sql);
						ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Curso curso = new Curso();
				curso.setNomeCurso(rs.getString("nomeCurso"));
				curso.setId(rs.getInt("id"));
				
				cursos.add(curso);
			}

			rs.close();
			stmt.close();
			return cursos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
