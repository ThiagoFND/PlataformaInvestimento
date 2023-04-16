package com.br.exercicio.plataformaInvestimento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ManifestacaoAtendida {

	@ManyToOne
	@JoinColumn(nullable = false)
	private DadosCadastro usuario;
	private String tipo;
	private String texto;
	private String resposta;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public ManifestacaoAtendida() {
		
	}
	public ManifestacaoAtendida(DadosCadastro usuario, String tipo, String texto, String resposta) {
		super();
		this.usuario = usuario;
		this.tipo = tipo;
		this.texto = texto;
		this.resposta = "Falta Análise";
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

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
