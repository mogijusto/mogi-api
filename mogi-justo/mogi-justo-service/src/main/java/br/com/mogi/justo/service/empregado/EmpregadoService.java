package br.com.mogi.justo.service.empregado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mogi.justo.model.Empregado;
import br.com.mogi.justo.repository.empregado.EmpregadoRepository;

@Service
public class EmpregadoService {
	
	@Autowired
	private EmpregadoRepository repository;

	public void saveOrUpdate(Empregado empregado) {
		repository.save(empregado);
	}

	public Empregado findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void delete(Empregado empregado) {
		repository.delete(empregado);
	}

	public List<Empregado> findAll() {
		return repository.findAll();
	}
}
