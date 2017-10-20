/**
 * 
 */
package br.com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elton Lima
 *
 */
public class Cliente {

	private int id;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private List<Telefone> telefones;
	private Email email;
	
	public Cliente() {
		
		this.telefones = new ArrayList<>();
		
	}
	
	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
		
	}
	
	public void deleteTelefone(Telefone telefone) {
		this.telefones.remove(telefone);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
	
}
