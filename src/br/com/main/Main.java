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
		funcionario.setNome("Josenildo Gomes da Silva Lima");
		funcionario.setMatricula("6940");
		funcionario.setSalario(1500);
		
		Email email = new Email();
		email.setDescricao("josenildo@live.com");
		
		funcionario.setEmail(email);
		
		List<Telefone> telefones = new ArrayList<>();
		Telefone telefone = new Telefone();
		telefone.setDdd("83");
		telefone.setNumero("9 8878-0098");
		telefones.add(telefone);
		
		Telefone telefone2 = new Telefone();
		telefone2.setDdd("83");
		telefone2.setNumero("9 8777-2982");
		telefones.add(telefone2);
		
		funcionario.setTelefones(telefones);
		
		List<Dependente> dependentes = new ArrayList<>();
		Dependente dependente = new Dependente();
		dependente.setNome("Suhellen");
		dependentes.add(dependente);
		
		Dependente dependente2 = new Dependente();
		dependente2.setNome("Zuleide");
		dependentes.add(dependente2);
		
		funcionario.setDependentes(dependentes);
		
		FuncionarioService fs = new FuncionarioService();
		fs.save(2, funcionario);
		
		


		
		
//		TelefoneDao dao = new TelefoneDao();
//		for(Telefone t : telefones) {
//			dao.sava(t);
//		}
		
		
	}
}
