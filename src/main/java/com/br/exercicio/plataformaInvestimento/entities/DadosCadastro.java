package com.br.exercicio.plataformaInvestimento.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo")
public class DadosCadastro {

	private String nome;
	private String email;
	private Long cpf;
	private Long numero1;
	private Long numero2;
	private String usuario;
	private String senha;
	private Double saldo;
	private boolean Admin;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public DadosCadastro() {

	}

	public DadosCadastro(String nome, String email, Long cpf, Long numero1, Long numero2, String usuario, String senha,
			boolean Admin) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.usuario = usuario;
		this.senha = senha;
		this.id = id;
		this.Admin = Admin;
		this.saldo = (double) 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getNumero1() {
		return numero1;
	}

	public void setNumero1(Long numero1) {
		this.numero1 = numero1;
	}

	public Long getNumero2() {
		return numero2;
	}

	public void setNumero2(Long numero2) {
		this.numero2 = numero2;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = Admin;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
