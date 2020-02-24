package br.com.mogi.justo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mogi.justo.model.Teste;
import br.com.mogi.justo.repository.teste.TesteRepository;

@Service
public class TesteService {
	@Autowired
	private TesteRepository repository;

	public void saveOrUpdate(Teste teste) {
		repository.save(teste);
	}

	public Teste findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public void delete(Teste teste) {
		repository.delete(teste);
	}

	public List<Teste> findAll() {
		return repository.findAll();
	}
}
