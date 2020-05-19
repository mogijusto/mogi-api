package br.com.mogi.justo.model;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servidor {
	
	@Id
	private String rgf;
	private String nome;
	private String cargo;
	private String rendimentos;
	public String getRgf() {
		return rgf;
	}
	public void setRgf(String rgf) {
		this.rgf = rgf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getRendimentos() {
		return rendimentos;
	}
	public void setRendimentos(String rendimentos) {
		this.rendimentos = rendimentos;
	}
	
	@Override
	public String toString() {
		return reflectionToString(this, JSON_STYLE);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		return reflectionEquals(this, (Servidor) obj);
	}
}
