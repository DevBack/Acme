/**
 * 
 */
package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import br.com.connection.ConnectionFactory;
import br.com.model.Fornecedor;

/**
 * @author Elton Lima
 *
 */
public class FornecedorDao {

	Connection connection = null;
	
	public FornecedorDao() {
		
		this.connection = ConnectionFactory.getConnection();

	}
	
	public Integer create(Fornecedor fornecedor, Integer idEndereco) {
		
		this.connection = ConnectionFactory.getConnection();
		
		String SQL = "INSERT INTO fornecedor (cnpj, id_endereco, nome, razao_social) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = null;
		
		ResultSet resultSet = null;
		Integer generatedId = null;
		
		try {
			
			statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, fornecedor.getCnpj());
			statement.setInt(2, idEndereco);
			statement.setString(3, fornecedor.getNome());
			statement.setString(4, fornecedor.getRazaoSocial());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				generatedId = resultSet.getInt(1);
				fornecedor.setId(generatedId);
			}
			
			JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com Sucesso!");
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao Cadastrar Fornecedor. " + e);
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement, resultSet);
			
		}
		
		return generatedId;
		
	}
	
	
}
