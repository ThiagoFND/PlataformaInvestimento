package com.br.exercicio.plataformaInvestimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.exercicio.plataformaInvestimento.entities.Admin;
import com.br.exercicio.plataformaInvestimento.entities.DadosCadastro;
import com.br.exercicio.plataformaInvestimento.entities.Usuario;
import com.br.exercicio.plataformaInvestimento.repositories.DadosCadastroRepository;

@Service
public class DadosCadastroServices {

	@Autowired
	DadosCadastroRepository DCRepositories;

	// esse método cadastra o usuário
	public void cadastroUsuario(String nome, String email, Long cpf, Long numero1, Long numero2, String usuario,
			String senha) {
		Usuario addUsuario = new Usuario(nome, email, cpf, numero1, numero2, usuario, senha);
		DCRepositories.save(addUsuario);
	}

	// esse método cadastra o admin
	public void cadastroAdmin(String nome, String email, Long cpf, Long numero1, Long numero2, String usuario,
			String senha) {
		Admin addAdmin = new Admin(nome, email, cpf, numero1, numero2, usuario, senha, true);
		DCRepositories.save(addAdmin);
	}

	// esse método utiliza um for para fazer uma verificação e validação para login
	public DadosCadastro loginUsuario(String usuario, String senha) {
		for (DadosCadastro p : DCRepositories.findAll()) {
			if (p.getUsuario().equals(usuario) && p.getSenha().equals(senha) && !p.isAdmin()) {
				// login efetuado com sucesso
				return p;
			} else {
				// usuário ou senha incorretos
			}
		}
		return null;
	}

	// esse método utiliza um for para fazer uma verificação e login para admin
	// utilizando o atributo Admin como true
	public DadosCadastro loginAdmin(String usuario, String senha) {
		for (DadosCadastro p : DCRepositories.findAll()) {
			if (usuario.equals(p.getUsuario()) && senha.equals(p.getSenha()) && p.isAdmin()) {
				return p;
				// login efetuado com sucesso
			} else {
				// usuário ou senha incorretos
			}
		}
		return null;
	}

	// esse método lista todos os dados dos usuários, com a excessão da senha
	public void listarDados() {
		for (DadosCadastro listarDados : DCRepositories.findAll()) {
			System.out.println("\nId: " + listarDados.getId());
			System.out.println("Usuario: " + listarDados.getUsuario());
		}
	}

	// esse método adiciona um saldo ao usuário, é utilizando quando o mesmo chama a
	// função depósito
	public void adicionarSaldo(DadosCadastro usuario, Double saldo) {
		Optional<DadosCadastro> dadosCadastrais = DCRepositories.findById(usuario.getId());
		if (dadosCadastrais.isPresent()) {
			DadosCadastro dados = dadosCadastrais.get();
			Double saldoAtual = dados.getSaldo();
			Double novoSaldo = saldoAtual + saldo;
			dados.setSaldo(novoSaldo);
			DCRepositories.save(dados);
		} else {
			System.out.println("ID não encontrado");
		}
	}

	// esse método saca um valor do usuário
	public void sacar(DadosCadastro usuario, Double valor) {
		Optional<DadosCadastro> dadosCadastrais = DCRepositories.findById(usuario.getId());
		if (dadosCadastrais.isPresent()) {
			DadosCadastro dados = dadosCadastrais.get();
			Double saldoAtual = dados.getSaldo();
			Double novoSaldo = saldoAtual - valor;
			dados.setSaldo(novoSaldo);
			DCRepositories.save(dados);
		} else {
			System.out.println("ID não encontrado");
		}
	}

	// esse método verifica se o usuário tem saldo para investimento
	public DadosCadastro verificarSaldo(DadosCadastro usuario, Double valorInvestir) {
		for (DadosCadastro dCadastrais : DCRepositories.findAll()) {
			if (dCadastrais.getSaldo() >= 1) {
				System.out.println("Valor suficiente");
				return dCadastrais;
			} else {
			}
		}
		return null;

	}
}
