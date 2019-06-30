package br.com.esiii.dao;

import java.sql.Connection;

import br.com.esiii.util.ConnectionFactory;

public abstract class AbstractDAO implements IDAO{
	
	Connection con = new ConnectionFactory().getConnection();

}
