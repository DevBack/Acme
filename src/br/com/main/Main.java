package br.com.main;

import java.sql.SQLException;
import java.util.List;

import br.com.model.Departamento;
import br.com.model.Dependente;
import br.com.model.Email;
import br.com.model.Funcionario;
import br.com.model.Telefone;
import br.com.service.DepartamentoService;
import br.com.service.FuncionarioService;

public class Main {


	public static void main(String args[]) throws SQLException {
			
//		FuncionarioService service = new FuncionarioService();
//		List<Funcionario> funcionarios = service.list();
//		
//		for(Funcionario funcionario : funcionarios) {
//			
//			System.out.println("ID: " + funcionario.getId());
//			System.out.println("Nome: " + funcionario.getNome());
//			System.out.println("Sal�rio: " + funcionario.getSalario());
//			System.out.println("Matricula: " + funcionario.getMatricula());
//			
//				for(Telefone telefone : funcionario.getTelefones()) {
//					System.out.println("Telefones: " + telefone.getDdd()+" "+telefone.getNumero());
//				}
//				
//				for(Dependente dependente : funcionario.getDependentes()) {
//					System.out.println("Dependentes: " + dependente.getNome());
//				}
//				
//				for(Email email : funcionario.getEmails()) {
//					System.out.println("Emails : " + email.getDescricao());
//				}
//			System.out.println("----------------------------------------");
//		}
		
		DepartamentoService service = new DepartamentoService();
		List<Departamento> departamentos = service.list();
		
		for(Departamento departamento : departamentos) {
			
			System.out.println("ID: " + departamento.getId());
			System.out.println("DEPARTAMENTO: " + departamento.getNome());
			System.out.println("FUNCIONARIOS: ");
			
			for(Funcionario funcionario : departamento.getFuncionarios()) {
				System.out.println(" NOME: " + funcionario.getNome());
				System.out.println(" MATRICULA: " + funcionario.getMatricula());
				
				for(Email email : funcionario.getEmails()) {
					System.out.println(" E-MAIL: " + email.getDescricao());
				}
			}
			
			System.out.println("----------------------------------------");
		}
		
	}
}
