package com.br.exercicio.plataformaInvestimento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Investidores {

	@ManyToOne
	@JoinColumn(nullable = false)
	private DadosCadastro usuario;
	private String nomeMoeda;
	private double valorInvestir;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Investidores() {

	}

	public Investidores(DadosCadastro usuario, String nomeMoeda, double valorInvestir) {
		super();
		this.usuario = usuario;
		this.nomeMoeda = nomeMoeda;
		this.valorInvestir = valorInvestir;
		this.id = id;
	}

	public DadosCadastro getUsuario() {
		return usuario;
	}

	public void setUsuario(DadosCadastro usuario) {
		this.usuario = usuario;
	}

	public String getNomeMoeda() {
		return nomeMoeda;
	}

	public void setNomeMoeda(String nomeMoeda) {
		this.nomeMoeda = nomeMoeda;
	}

	public double getValorInvestir() {
		return valorInvestir;
	}

	public void setValorInvestir(double valorInvestir) {
		this.valorInvestir = valorInvestir;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
