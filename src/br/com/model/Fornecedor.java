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
public class Fornecedor {

	private int id;
	private String cnpj;
	private Endereco endereco;
	private List<Telefone> telefones;
	private List<Email> emails;
	private List<Produto> produtos;
	private String nome;
	private String razaoSocial;
	
	public Fornecedor() {
		
		this.telefones = new ArrayList<Telefone>();
		this.emails = new ArrayList<Email>();
		this.produtos = new ArrayList<Produto>();
	}
	
	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
		
	}
	
	public void deleteTelefone( Telefone telefone) {
		this.telefones.remove(telefone);
		
	}
	
	public void addEmail(Email email) {
		this.emails.add(email);
		
	}
	
	public void deleteEmail(Email email) {
		this.emails.remove(email);
		
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
		
	}
	
	public void deleteProduto(Produto Produto) {
		this.produtos.remove(Produto);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
}
