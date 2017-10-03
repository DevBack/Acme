/**
 * 
 */
package br.com.service;

import br.com.dao.DependenteDao;
import br.com.dao.EmailDao;
import br.com.dao.FuncionarioDao;
import br.com.dao.TelefoneDao;
import br.com.model.Funcionario;

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
	
	public void save(Funcionario funcionario) {
		
		funcionarioDao.create(null, funcionario);
		
		emailDao.create(funcionario.getId(), funcionario.getEmail());
		
	}
	

}
