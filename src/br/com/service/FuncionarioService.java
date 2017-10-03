/**
 * 
 */
package br.com.service;

import java.util.ArrayList;

import br.com.dao.DependenteDao;
import br.com.dao.EmailDao;
import br.com.dao.FuncionarioDao;
import br.com.dao.TelefoneDao;
import br.com.model.Dependente;
import br.com.model.Funcionario;
import br.com.model.Telefone;

/**
 * @author Elton Lima
 *
 */
public class FuncionarioService {

	private FuncionarioDao funcionarioDao;
	private DependenteDao dependenteDao;
	private EmailDao emailDao;
	private TelefoneDao telefoneDao;
	
	public FuncionarioService() {
		
		this.funcionarioDao = new FuncionarioDao();
		this.dependenteDao = new DependenteDao();
		this.emailDao = new EmailDao();
		this.telefoneDao = new TelefoneDao();

	}
	
	public void save(Integer dpt, Funcionario funcionario) {
	
		Integer departamento = dpt;
		
	//INSERT de Funcionário
		Integer key = funcionarioDao.create(departamento, funcionario);
	
	//INSERT de E-mail do Funcionário
		emailDao.create(key, funcionario.getEmail());
		
	//INSERT da Lista de Telefones do Funcionário	
		for(Telefone telefone : funcionario.getTelefones()) {
			telefoneDao.create(key, telefone);
		}
		
	//INSERT da Lista de Dependentes do Funcionário	
		for(Dependente dependente : funcionario.getDependentes()) {
			dependenteDao.create(key, dependente);
		}		
	}
	
	public void list() {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario funcionario = new Funcionario();
		
		
		
	}
}
