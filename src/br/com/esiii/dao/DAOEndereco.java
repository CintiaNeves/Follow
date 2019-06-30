package br.com.esiii.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.esiii.dominio.Cidade;
import br.com.esiii.dominio.Endereco;
import br.com.esiii.dominio.EntidadeDominio;
import br.com.esiii.dominio.Estado;
import br.com.esiii.util.Resultado;

public class DAOEndereco extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Endereco endereco = (Endereco) entidade;
		Resultado resultado = new Resultado();
		
		String sql = "INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getCidade().getNome());
			stmt.setString(6, endereco.getCidade().getEstado().getNome());
			stmt.setString(7, endereco.getCep());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			int idEnd = 0;
			if (rs.next())
				idEnd = rs.getInt(1);
			endereco.setId(idEnd);

			stmt.close();
			//con.close();
			resultado.sucesso("");
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro salvar, por favor, refaça a operação.");
			return resultado;
		}

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Endereco endereco = (Endereco) entidade;
		Resultado resultado = new Resultado();
		PreparedStatement stmt = null;

		String sql = null;
		
		try {
			if(endereco.getId() != 0){
				sql = "SELECT * FROM endereco where id = ? ";
				
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, endereco.getId());
				
			} else {
				sql = "SELECT * FROM endereco where logradouro = ? AND numero = ? AND complemento = ?"
						+ " AND bairro = ? AND cidade = ? AND estado = ? AND cep = ? ";
				
				stmt = con.prepareStatement(sql);
				stmt.setString(1, endereco.getLogradouro());
				stmt.setString(2, endereco.getNumero());
				stmt.setString(3, endereco.getComplemento());
				stmt.setString(4, endereco.getBairro());
				stmt.setString(5, endereco.getCidade().getNome());
				stmt.setString(6, endereco.getCidade().getEstado().getNome());
				stmt.setString(7, endereco.getCep());
			}
			ResultSet rs = stmt.executeQuery();

			List<EntidadeDominio> listEnd = new ArrayList<>();
			while (rs.next()) {
				
				Estado e = new Estado();
				e.setNome(rs.getString("estado"));
				
				Cidade c = new Cidade();
				c.setNome(rs.getString("cidade"));
				c.setEstado(e);
								
				endereco.setLogradouro((rs.getString("logradouro")));
				endereco.setNumero(rs.getString("numero"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCep(rs.getString("cep"));
				endereco.setId(rs.getInt("id"));
				endereco.setCidade(c);
				listEnd.add(endereco);
			}
			if(!listEnd.isEmpty()){
				resultado.setListaResultado(listEnd);
			}
			rs.close();
			stmt.close();
			resultado.sucesso(null);
			return resultado;

		} catch (SQLException e) {
			e.printStackTrace();
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
