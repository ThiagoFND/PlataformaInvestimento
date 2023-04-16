package com.br.exercicio.plataformaInvestimento.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "Modelo")
public class Manifestacao {

	@ManyToOne
	@JoinColumn(nullable = false)
	private DadosCadastro usuario;
	private String tipo;
	private String texto;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Manifestacao() {

	}

	public Manifestacao(DadosCadastro usuario, String tipo, String texto) {
		super();
		this.usuario = usuario;
		this.tipo = tipo;
		this.texto = texto;
		this.id = id;
	}

	public DadosCadastro getUsuario() {
		return usuario;
	}

	public void setUsuario(DadosCadastro usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
