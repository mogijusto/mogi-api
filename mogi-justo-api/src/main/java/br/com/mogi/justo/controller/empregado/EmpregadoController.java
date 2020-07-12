package br.com.mogi.justo.controller.empregado;

import static java.lang.Long.parseLong;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mogi.justo.model.Empregado;
import br.com.mogi.justo.model.Servidor;
import br.com.mogi.justo.robo.PortalTransparenciaMC;
import br.com.mogi.justo.service.empregado.EmpregadoService;

@Controller
@RequestMapping("/v1/empregado")
public class EmpregadoController {

	@Autowired
	private PortalTransparenciaMC ptmc;

	@Autowired
	private EmpregadoService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}", consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Empregado> pegarUm(@PathVariable Long id) {
		return new ResponseEntity<>(service.findByRgf(valueOf(id)), OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(consumes = { APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Empregado> save() {
		System.out.println("valores");
		List<Servidor> consultarServidores = ptmc.consultarServidores();
		consultarServidores.stream().forEach(item -> {
			Empregado consultarEmpregado = ptmc.consultarEmpregado(parseLong(item.getRgf()));
			try {
				consultarEmpregado.setRgf(item.getRgf());
				System.out.println(consultarEmpregado);
				Thread.sleep(100);
				service.saveOrUpdate(consultarEmpregado);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		return new ResponseEntity<>(OK);
	}
}
