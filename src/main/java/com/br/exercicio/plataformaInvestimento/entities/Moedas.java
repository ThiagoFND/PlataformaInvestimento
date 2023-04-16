package com.br.exercicio.plataformaInvestimento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Moedas {

	private String nacionalidade;
	private String nomeMoeda;
	private String sigla;
	private Double valorCotacao;
	private String tipoMoeda;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Moedas() {

	}

	public Moedas(String nacionalidade, String nomeMoeda, String sigla, Double valorCotacao, String tipoMoeda) {
		super();
		this.nacionalidade = nacionalidade;
		this.nomeMoeda = nomeMoeda;
		this.sigla = sigla;
		this.valorCotacao = valorCotacao;
		this.tipoMoeda = tipoMoeda;
		this.id = id;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNomeMoeda() {
		return nomeMoeda;
	}

	public void setNomeMoeda(String nomeMoeda) {
		this.nomeMoeda = nomeMoeda;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Double getValorCotacao() {
		return valorCotacao;
	}

	public void setValorCotacao(Double valorCotacao) {
		this.valorCotacao = valorCotacao;
	}

	public String getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(String tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
