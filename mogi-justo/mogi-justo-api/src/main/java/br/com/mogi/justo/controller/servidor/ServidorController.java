package br.com.mogi.justo.controller.servidor;

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

import br.com.mogi.justo.model.Servidor;
import br.com.mogi.justo.robo.PortalTransparenciaMC;
import br.com.mogi.justo.service.servidor.ServidorService;

@Controller
@RequestMapping("/servidores")
public class ServidorController {
	
	@Autowired
	private ServidorService service;
	
	@Autowired
	private PortalTransparenciaMC ptmc;
	
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping(consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Servidor>> getAll() {
		return new ResponseEntity<>(service.findAll(), OK);
	} 

	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Servidor> getOne(@PathVariable String id) {
		return new ResponseEntity<>(service.findById(id), OK); 
	} 

	@PostMapping(produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = { APPLICATION_JSON_VALUE,
			APPLICATION_XML_VALUE })
	public ResponseEntity<Void> save(@RequestBody(required = false) Servidor servidor) {
		List<Servidor> servidores = ptmc.consultarServidores();
		service.saveAll(servidores);
		
		System.out.println(servidor);
		service.saveOrUpdate(servidor);
		return new ResponseEntity<>(CREATED);
	}

	@PutMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = {
			APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody(required = false) Servidor servidor) {
		System.out.println(servidor);
		System.out.println(id);
		servidor.setRgf(id);
		service.saveOrUpdate(servidor);
		return new ResponseEntity<>(CREATED);
	}

	@DeleteMapping(value = "/{id}", produces = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE }, consumes = {
			APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public ResponseEntity<Void> delete(@PathVariable String id) {
		Servidor servidor = service.findById(id);
		service.delete(servidor);
		return new ResponseEntity<>(OK);
	}
}
