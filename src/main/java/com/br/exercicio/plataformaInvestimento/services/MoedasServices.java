package com.br.exercicio.plataformaInvestimento.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.exercicio.plataformaInvestimento.entities.Moedas;
import com.br.exercicio.plataformaInvestimento.repositories.MoedasRepository;

@Service
public class MoedasServices {

	@Autowired
	MoedasRepository MRepositories;
	
	public void adicionarMoeda(String nacionalidade, String nomeMoeda, String sigla, Double valorCotacao, String tipoMoeda) {
		Moedas moeda = new Moedas(nacionalidade, nomeMoeda, sigla, valorCotacao, tipoMoeda);
		MRepositories.save(moeda);
	}
	
	public void listarMoedass() {
		for (Moedas moedalistar : MRepositories.findAll()) {
			System.out.println("\nId: " + moedalistar.getId());
			System.out.println("Nome: " + moedalistar.getNomeMoeda());
			System.out.println("Sigla: " + moedalistar.getSigla());
			System.out.println("Valor atual: " + moedalistar.getValorCotacao() + "\n");
		}
	}
	
	public void removerMoeda(long id) {
		for (Moedas moedaRemover : MRepositories.findAll()) {
			MRepositories.deleteById(id);
		}
	}
	
	public void atualizarValorMoeda(long id, Double novoValor) {
	    Optional<Moedas> moedaOptional = MRepositories.findById(id);
	    if (moedaOptional.isPresent()) {
	        Moedas moeda = moedaOptional.get();
	        moeda.setValorCotacao(novoValor);
	        MRepositories.save(moeda);
	        System.out.println("Valor atual da moeda atualizado com sucesso.");
	    } else {
	        System.out.println("Moeda não encontrada com o ID fornecido.");
	    }
	}
}
