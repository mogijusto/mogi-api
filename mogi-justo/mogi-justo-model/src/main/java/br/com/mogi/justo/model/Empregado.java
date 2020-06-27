package br.com.mogi.justo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String referencia;

	private String cargo;

	private String nome;

	private String regime;

	private String rgf;

	@OneToMany
	private List<Rendimento> rendimentos;

	@OneToMany
	private List<Desconto> descontos;

	@OneToMany
	private List<Total> totais;

	@OneToMany
	private List<Outro> outros;

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public List<Rendimento> getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(List<Rendimento> rendimentos) {
		this.rendimentos = rendimentos;
	}

	public List<Desconto> getDescontos() {
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}

	public List<Total> getTotais() {
		return totais;
	}

	public void setTotais(List<Total> totais) {
		this.totais = totais;
	}

	public List<Outro> getOutros() {
		return outros;
	}

	public void setOutros(List<Outro> outros) {
		this.outros = outros;
	}

	public Long getId() {
		return id;
	}

	public void setRgf(String rgf) {
		this.rgf = rgf;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
