package com.br.exercicio.plataformaInvestimento.entities;

import jakarta.persistence.Entity;

@Entity
public class Admin extends DadosCadastro{
	public Admin() {

	}

	public Admin(String nome, String email, Long cpf, Long numero1, Long numero2,
			String usuario, String senha, boolean Admin) {
		super(nome, email, cpf, numero1, numero2, usuario, senha, true);
		this.setAdmin(true);
	}

}
