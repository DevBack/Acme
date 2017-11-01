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
import br.com.model.Endereco;

/**
 * @author Elton Lima
 *
 */
public class EnderecoDao {

	Connection connection = null;
	
	public EnderecoDao() {
		
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean create(Endereco endereco) {
		
		connection = ConnectionFactory.getConnection();
		String SQL = "INSERT INTO endereco(rua, numero, complemento, referencia, cep, bairro, cidade, estado, pais) VALUES(?,?,?,?,?,?,?,?,?,)";
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement(SQL);
			statement.setString(1, endereco.getRua());
			statement.setInt(2, endereco.getNumero());
			statement.setString(3, endereco.getComplemento());
			statement.setString(4, endereco.getReferencia());
			statement.setString(5, endereco.getCep());
			statement.setString(6, endereco.getBairro());
			statement.setString(7, endereco.getCidade());
			statement.setString(8, endereco.getEstado());
			statement.setString(9, endereco.getPais());
			
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Endereço Salvo Com Sucesso!");
			return true;
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao Salvar Endereço. " + e);
			return false;
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement);
			
		}	
	}
	
	public List<Endereco> read(){
		
		connection = ConnectionFactory.getConnection();
		
		String SQL = "SELECT * FROM endereco";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Endereco> enderecos = new ArrayList<>();
		
		try {
			
			statement = connection.prepareStatement(SQL);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Endereco endereco = new Endereco();
				
				endereco.setId(resultSet.getInt("id"));
				endereco.setRua(resultSet.getString("rua"));
				endereco.setNumero(resultSet.getInt("numero"));
				endereco.setComplemento(resultSet.getString("complemento"));
				endereco.setReferencia(resultSet.getString("referencia"));
				endereco.setCep(resultSet.getString("cep"));
				endereco.setBairro(resultSet.getString("bairro"));
				endereco.setCidade(resultSet.getString("cidade"));
				endereco.setEstado(resultSet.getString("estado"));
				endereco.setPais(resultSet.getString("pais"));
				
				enderecos.add(endereco);
			}
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao Listar Endereços. " + e);
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement, resultSet);
			
		}
		
		return enderecos;
	}
	
	public boolean update(Endereco endereco){
		
		connection = ConnectionFactory.getConnection();
		
		String SQL = "UPDATE endereco SET rua = ?, numero = ?, complemento = ?, referencia = ?, cep = ?, bairro = ?, cidade = ?, estado = ?, pais = ? WHERE id = ?";
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement(SQL);
			statement.setString(1, endereco.getRua());
			statement.setInt(2, endereco.getNumero());
			statement.setString(3, endereco.getComplemento());
			statement.setString(4, endereco.getReferencia());
			statement.setString(5, endereco.getCep());
			statement.setString(6, endereco.getBairro());
			statement.setString(7, endereco.getCidade());
			statement.setString(8, endereco.getEstado());
			statement.setString(9, endereco.getPais());
			statement.setInt(10, endereco.getId());
			
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Endereço Atualizado com Sucesso!");
			return true;
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao Atualizar Endereço. " + e);
			return false;
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement);
			
		}
	}
	
	public boolean delete(Endereco endereco) {
		
		connection = ConnectionFactory.getConnection();
		
		String SQL = "DELETE * FROM endereco WHERE id = ?";
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement(SQL);
			statement.setInt(1, endereco.getId());
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Endereço Excluído com Sucesso!");
			return true;
			
		} catch (SQLException e) {
			
			System.err.println("Erro ao Excluir Endereço. " + e);
			return false;
			
		}finally {
			
			ConnectionFactory.closeConnection(this.connection, statement);
			
		}	
	}
}
