package br.com.mogi.justo.service.servidor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mogi.justo.model.Servidor;
import br.com.mogi.justo.repository.servidor.ServidorRepository;

@Service
public class ServidorService {
	
	@Autowired
	private ServidorRepository repository;
	
	public void saveOrUpdate(Servidor servidor) {
		repository.save(servidor); 
	}

	public Servidor findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void delete(Servidor servidor) {
		repository.delete(servidor);
	}

	public List<Servidor> findAll() {
		return repository.findAll();
	}
	
	public List<Servidor> findAllLimit100First() {
		return repository.findAllLimit100First();
	}
	
	public void saveAll(List<Servidor> servidores) {
		repository.saveAll(servidores);
	}
	
	
	
}
