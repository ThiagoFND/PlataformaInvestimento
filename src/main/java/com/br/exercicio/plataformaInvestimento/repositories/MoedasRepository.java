package com.br.exercicio.plataformaInvestimento.repositories;

import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.br.exercicio.plataformaInvestimento.entities.Moedas;

public interface MoedasRepository extends CrudRepository<Moedas, Long>{

}
