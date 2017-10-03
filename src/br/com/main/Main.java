package br.com.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Dependente;
import br.com.model.Email;
import br.com.model.Funcionario;
import br.com.model.Telefone;
import br.com.service.FuncionarioService;

public class Main {

	/*
	 * TESTANDO LEITURA
	 *
	 * public static void main(String args[]){
	 * 
	 * EmailDao email = new EmailDao();
	 * 
	 * for(Email e: email.read()) {
	 * 
	 * System.out.println("ID: " +e.getId()+" DESCRIÇÃO: " +e.getDescricao()); } }
	 */

	/*
	 * TESTANDO ATUALIZAÇÃO
	 * 
	 * public static void main(String args[]){
	 * 
	 * Email email = new Email(); email.setId(1);
	 * email.setDescricao("eltonlima.iesp@hotmail.com");
	 * 
	 * EmailDao dao = new EmailDao(); dao.update(email);
	 * 
	 * }
	 */

	public static void main(String args[]) throws SQLException {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Suhellen Gomes S Lima");
		funcionario.setMatricula("8767");
		funcionario.setSalario(2000);
		
		Email email = new Email();
		email.setDescricao("suhellenlima@live.com");
		
		funcionario.setEmail(email);
		
		List<Telefone> telefones = new ArrayList<>();
		Telefone telefone = new Telefone();
		telefone.setDdd("81");
		telefone.setNumero("9 9900-0098");
		telefones.add(telefone);
		
		Telefone telefone2 = new Telefone();
		telefone2.setDdd("81");
		telefone2.setNumero("9 8887-0907");
		telefones.add(telefone2);
		
		funcionario.setTelefones(telefones);
		
		List<Dependente> dependentes = new ArrayList<>();
		Dependente dependente = new Dependente();
		dependente.setNome("José Arimetéia");
		dependentes.add(dependente);
		
		Dependente dependente2 = new Dependente();
		dependente2.setNome("Chiquinho");
		dependentes.add(dependente2);
		
		funcionario.setDependentes(dependentes);
		
		FuncionarioService fs = new FuncionarioService();
		fs.save(4, funcionario);
		
		


		
		
//		TelefoneDao dao = new TelefoneDao();
//		for(Telefone t : telefones) {
//			dao.sava(t);
//		}
		
		
	}
}
