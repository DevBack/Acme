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

import com.mysql.jdbc.Statement;

import br.com.connection.ConnectionFactory;
import br.com.model.Fornecedor;

/**
 * @author Elton Lima
 *
 */
public class FornecedorDao {

	Connection connection = null;
	EnderecoDao enderecoDao = null;
	
	public FornecedorDao() {
		
		this.connection = ConnectionFactory.getConnection();
		this.enderecoDao = new EnderecoDao();
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
	
	public List<Fornecedor> read(){
		
		this.connection = ConnectionFactory.getConnection();
		
		String SQL = "SELECT * FROM fornecedor";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		try {
			
			statement = connection.prepareStatement(SQL);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(resultSet.getInt("id"));
				fornecedor.setCnpj(resultSet.getString("cnpj"));
				fornecedor.setEndereco(enderecoDao.read(fornecedor.getId()));
				fornecedor.setTelefone(resultSet.getString("telefone"));
				fornecedor.setEmail(resultSet.getString("email"));
				fornecedor.setNome(resultSet.getString("nome"));
				fornecedor.setRazaoSocial(resultSet.getString("razao_social"));
				
				fornecedores.add(fornecedor);
			}
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao l�r Fornecedores. " + e);
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement, resultSet);
			
		}
		
		return fornecedores;	
	}
	
	
}