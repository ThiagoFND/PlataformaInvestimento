package com.br.exercicio.plataformaInvestimento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.exercicio.plataformaInvestimento.entities.DadosCadastro;
import com.br.exercicio.plataformaInvestimento.entities.Investidores;
import com.br.exercicio.plataformaInvestimento.entities.Moedas;
import com.br.exercicio.plataformaInvestimento.repositories.DadosCadastroRepository;
import com.br.exercicio.plataformaInvestimento.repositories.InvestidoresRepository;
import com.br.exercicio.plataformaInvestimento.repositories.MoedasRepository;

@Service
public class InvestidoresServices {

	@Autowired
	DadosCadastroRepository DCRepositories;
	
	@Autowired
	InvestidoresRepository IRepositories;

	@Autowired
	MoedasRepository MRepositories;

	// esse método é para o usuário investir na moeda que quiser
	public Moedas investirMoeda(DadosCadastro usuario, String nomeMoeda, double valorInvestir) {
		Investidores investir = new Investidores(usuario, nomeMoeda, valorInvestir);

		for (Moedas verificarMoedas : MRepositories.findAll()) {
			if (nomeMoeda.equals(nomeMoeda)) {
				return verificarMoedas;
			}
		}
		return null;
	}
	
	// esse método valor na moeda que o usuário quiser
	public void adicionarInvestimento(DadosCadastro usuario, String nomeMoeda, double valorInvestir) {
		Investidores moedaSalvar = new Investidores(usuario, nomeMoeda, valorInvestir);
		IRepositories.save(moedaSalvar);
	}
}
