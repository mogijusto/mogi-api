package br.com.mogi.justo.repository.servidor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.mogi.justo.model.Servidor;

public interface ServidorRepositoryCustom  {
	@Query(name = "Servidor.findAllLimit100First", value = "select s from Servidor s")
	List<Servidor> findAllLimit100First();
}
