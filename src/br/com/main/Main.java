package br.com.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.EmailDao;
import br.com.dao.TelefoneDao;
import br.com.model.Email;
import br.com.model.Funcionario;
import br.com.model.Telefone;

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
		
		List<Telefone> telefones = new ArrayList<>();

		Telefone telefone = new Telefone();
		telefone.setDdd("83");
		telefone.setNumero("98878-9138");		
		telefones.add(telefone);
		

		Telefone telefone2 = new Telefone();
		telefone2.setDdd("81");
		telefone2.setNumero("99957-9108");
		telefones.add(telefone2);

		
		Telefone telefone3 = new Telefone();
		telefone3.setDdd("11");
		telefone3.setNumero("99111-2983");
		telefones.add(telefone3);

		
		
		TelefoneDao dao = new TelefoneDao();
//		for(Telefone t : telefones) {
//			dao.sava(t);
//		}
		
		
	}
}
