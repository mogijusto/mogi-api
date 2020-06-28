package br.com.mogi.justo.service.ip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mogi.justo.model.acesso.Ip;
import br.com.mogi.justo.repository.ip.IpRepository;

@Service
public class IpService {
	@Autowired
	private IpRepository repository;

	public Ip findOne(Long id) {
		return repository.getOne(id);
	}

	public List<Ip> findAll() {
		return repository.findAll();
	}

	public void delete(Ip ip) {
		repository.delete(ip);
	}

	public void saveOrUpdate(Ip ip) {
		repository.save(ip);
	}
}
