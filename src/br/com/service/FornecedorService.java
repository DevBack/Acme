package br.com.service;

import java.util.List;

import br.com.dao.FornecedorDao;
import br.com.model.Endereco;
import br.com.model.Fornecedor;

/**
 * @author Elton Lima
 *
 */
public class FornecedorService {

	private FornecedorDao fornecedorDao;
	
	
	public FornecedorService() {
		
		this.fornecedorDao = new FornecedorDao();
	}
	
	public void save(Fornecedor fornecedor, Endereco endereco) {
		
		fornecedorDao.create(fornecedor, endereco);
	}
	
	public List<Fornecedor> list(){
		
		return this.fornecedorDao.read();
	}
	
	public void edit(Fornecedor fornecedor, Endereco endereco) {
		
		fornecedorDao.update(fornecedor, endereco);
	}
	
	public void delete(Fornecedor fornecedor) {
		
		fornecedorDao.delete(fornecedor);
	}
}
