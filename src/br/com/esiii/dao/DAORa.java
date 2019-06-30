package br.com.esiii.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.esiii.dominio.Aluno;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.util.Resultado;

public class DAORa extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Aluno aluno = (Aluno) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO ra (idAluno) VALUES (?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, aluno.getId());
			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			
			int idRa = 0;
			if (rs.next())
				idRa = rs.getInt(1);
			aluno.getRa().setId(idRa);

			stmt.close();
			//con.close();
			resultado.sucesso("");
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("");
			return resultado;
		}

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		return null;
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
