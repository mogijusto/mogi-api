package br.com.mogi.justo.robo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.mogi.justo.model.Empregado;
import br.com.mogi.justo.model.Funcionario;
import br.com.mogi.justo.model.Servidor;

@Component
public class PortalTransparenciaMC {

	private static final String URL_SERVIDORES = "http://www.licitacao.pmmc.com.br/Transparencia/vencimentos2";

	private static final String URL_SERVIDOR = "http://www.licitacao.pmmc.com.br/Transparencia/detalhamento?rgf=";

	private HttpStatus status;

	private HttpHeaders headers = null;

	private RestTemplate rest;

	public PortalTransparenciaMC() {
		this.rest = new RestTemplate();
	}

	public static void main(String[] args) {
		PortalTransparenciaMC ptmc = new PortalTransparenciaMC();
		ptmc.consultarServidores();
	}

	public List<Servidor> consultarServidores() {
		String s = getServidores(URL_SERVIDORES);
		Funcionario f = new Gson().fromJson(s, Funcionario.class);
		return f.getServidores();
	}

	public Empregado consultarEmpregado(Long rgf) {
		String str = getServidores(URL_SERVIDOR + rgf);
		return new Gson().fromJson(str, Empregado.class);
	}

	public String getServidores(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		this.setStatus(responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());
		return responseEntity.getBody();
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public void setCoverter() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
		messageConverters.add(converter);
		rest.setMessageConverters(messageConverters);
	}
}
