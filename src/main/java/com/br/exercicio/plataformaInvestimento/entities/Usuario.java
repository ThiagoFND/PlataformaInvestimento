package com.br.exercicio.plataformaInvestimento.entities;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends DadosCadastro {

	public Usuario() {

	}

	public Usuario(String nome, String email, Long cpf, Long numero1, Long numero2,
			String usuario, String senha) {
		super(nome, email, cpf, numero1, numero2, usuario, senha, false);
	}
}
