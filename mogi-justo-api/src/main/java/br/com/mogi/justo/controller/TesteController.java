package br.com.mogi.justo.controller;

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

import br.com.mogi.justo.model.Teste;
import br.com.mogi.justo.service.TesteService;

@Controller
@RequestMapping("/test")
public class TesteController {
	@Autowired
	private TesteService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Teste>> pegar() {
		return new ResponseEntity<>(service.findAll(), OK);
	} 

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Teste> pegarUm(@PathVariable Integer id) {
		return new ResponseEntity<>(service.findById(id), OK); 
	} 

	@PostMapping(produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = { APPLICATION_JSON_VALUE,
			APPLICATION_XML_VALUE })
	public ResponseEntity<Void> salvar(@RequestBody(required = false) Teste teste) {
		System.out.println(teste);
		service.saveOrUpdate(teste);
		return new ResponseEntity<>(CREATED);
	}

	@PutMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = {
			APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody(required = false) Teste teste) {
		System.out.println(teste);
		System.out.println(id);
		teste.setId(id);
		service.saveOrUpdate(teste);
		return new ResponseEntity<>(CREATED);
	}

	@DeleteMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = {
			APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Teste teste = service.findById(id);
		service.delete(teste);
		return new ResponseEntity<>(OK);
	}
}
