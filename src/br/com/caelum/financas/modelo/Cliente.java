package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String profissao;
	private String endereco;
	
	@JoinColumn(unique = true)
	@OneToOne
	private Conta conta;
	
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	@Deprecated
	public Cliente() {}
	
	public Cliente(Integer id) {
		this.id = id;
	}
	
	public Cliente(Integer id, String nome, String profissao, String endereco, Conta conta) {
		this(nome, profissao, endereco, conta);
		this.id = id;
	}
	
	public Cliente(String nome, String profissao, String endereco, Conta conta) {
		this.nome = nome;
		this.profissao = profissao;
		this.endereco = endereco;
		this.conta = conta;
	}
	
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", profissao=" + profissao + ", endereco=" + endereco + ", conta=" + conta + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getProfissao()=" + getProfissao() + ", getEndereco()=" + getEndereco() + ", getConta()=" + getConta() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}