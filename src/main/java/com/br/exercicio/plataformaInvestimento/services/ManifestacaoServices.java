package com.br.exercicio.plataformaInvestimento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.exercicio.plataformaInvestimento.entities.DadosCadastro;
import com.br.exercicio.plataformaInvestimento.entities.Manifestacao;
import com.br.exercicio.plataformaInvestimento.entities.ManifestacaoAtendida;
import com.br.exercicio.plataformaInvestimento.repositories.ManifestacaoAtendidaRepository;
import com.br.exercicio.plataformaInvestimento.repositories.ManifestacaoRepository;

@Service
public class ManifestacaoServices {

	@Autowired
	ManifestacaoRepository MRepositories;
	
	@Autowired
	ManifestacaoAtendidaRepository MRARepositories;

	// esse método adiciona uma manifestação a uma tabela quando o usuário cadastrar
	public void adicionarManifestacao(DadosCadastro usuario, String tipo, String texto) {
		Manifestacao addMan = new Manifestacao(usuario, tipo, texto);
		MRepositories.save(addMan);
	}
	
	// esse método é utilizado para quando o usuário cadastrar, ir também para outra tabela
	public void adicionarManifestacaoAtendida(DadosCadastro usuario, String tipo, String texto, String resposta) {
		ManifestacaoAtendida addManAten = new ManifestacaoAtendida(usuario, tipo, texto, resposta);
		MRARepositories.save(addManAten);
	}
	
	// esse método irá listar as manifestaçõse quando o admin chamar o método
	public void listarManifestacao() {
		for (Manifestacao m1 : MRepositories.findAll()) {
			System.out.println("\nId: " + m1.getId());
			System.out.println("Usuário: " + m1.getUsuario());
			System.out.println("Tipo: " + m1.getTipo());
			System.out.println("Texto: " + m1.getTexto());
		}
	}
	
	// esse método irá remover a manifestação da tabela
	public void removerManifestacao(long id) {
		MRepositories.deleteById(id);
	}
	
	// esse método é utilizado quando o admin responde, modificando o valor resposta da tabela para o que o admin digitar
	public void atualizarMAnifestacao(long id, String resposta) {
		Optional<ManifestacaoAtendida> ManAtendida = MRARepositories.findById(id);
		if (ManAtendida.isPresent()) {
			ManifestacaoAtendida ManAten = ManAtendida.get();
			ManAten.setResposta(resposta);
			MRARepositories.save(ManAten);
		} else {
			System.out.println("Manifestação não encontrada");
		}
	}
}
