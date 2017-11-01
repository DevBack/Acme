/**
 * 
 */
package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.connection.ConnectionFactory;
import br.com.model.Categoria;

/**
 * @author Elton Lima
 *
 */
public class CategoriaDao {

	Connection connection = null;
	
	public CategoriaDao() {
		
		this.connection = ConnectionFactory.getConnection();
		
	}
	
	public boolean create(Categoria categoria) {
		
		this.connection = ConnectionFactory.getConnection();
		
		String SQL = "INSERT INTO categoria (descricao) VALUES (?)";
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement(SQL);
			statement.setString(1, categoria.getDescricao());
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Categoria Criada com Sucesso!");
			return true;
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao Criar Categoria. " + e);
			return false;
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement);
			
		}		
	  }
	
	public List<Categoria> read() {
		
		this.connection = ConnectionFactory.getConnection();
		
		String SQL = "SELECT * FROM categoria";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Categoria> categorias = new ArrayList<>();
		
		try {
			
			statement = connection.prepareStatement(SQL);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Categoria categoria = new Categoria();
				
				categoria.setId(resultSet.getInt("id"));
				categoria.setDescricao(resultSet.getString("descricao"));
				categorias.add(categoria);
				
			}
			
		} catch (SQLException e) {
		
			System.err.println("Erro ao Consultar Categorias. " + e);
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement, resultSet);
			
		}
		
		return categorias;
	}
	
	
}
