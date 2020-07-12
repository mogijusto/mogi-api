package br.com.mogi.justo.controller.ip;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mogi.justo.model.acesso.Ip;
import br.com.mogi.justo.service.ip.IpService;

@Controller
@RequestMapping("/v1/ip")
public class IpController {
	@Autowired
	private IpService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Ip>> pegar() {
		return new ResponseEntity<>(service.findAll(), OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Ip> pegarUm(@PathVariable Long id) {
		return new ResponseEntity<>(service.findOne(id), OK);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public ResponseEntity<Void> salvar(@RequestBody(required = false) Ip ip) {
		service.saveOrUpdate(ip);
		return new ResponseEntity<>(CREATED);
	}

	@PutMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = {
			APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody(required = false) Ip ip) {
		ip.setId(id);
		service.saveOrUpdate(ip);
		return new ResponseEntity<>(CREATED);
	}

	@DeleteMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = {
			APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Ip ip = service.findOne(id);
		service.delete(ip);
		return new ResponseEntity<>(OK);
	}
}
