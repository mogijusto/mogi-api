package br.com.mogi.justo.model.acesso;

import static javax.persistence.GenerationType.IDENTITY;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Ip {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "ip")
	private String ipNome;

	private String hostname;

	private Date acesso;

	public String getNumero() {
		return ipNome;
	}

	public void setNumero(String numero) {
		this.ipNome = numero;
	}

	public Date getAcesso() {
		return acesso;
	}

	public void setAcesso(Date acesso) {
		this.acesso = acesso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setIp(String ip) {
		this.ipNome = ip;
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
		return reflectionEquals(this, (Ip) obj);
	}

	@Override
	public String toString() {
		return reflectionToString(this, JSON_STYLE);
	}
}
