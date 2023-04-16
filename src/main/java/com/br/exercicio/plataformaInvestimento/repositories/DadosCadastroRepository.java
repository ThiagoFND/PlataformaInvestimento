package com.br.exercicio.plataformaInvestimento.repositories;

import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.br.exercicio.plataformaInvestimento.entities.DadosCadastro;

public interface DadosCadastroRepository extends CrudRepository<DadosCadastro, Long>{

}
