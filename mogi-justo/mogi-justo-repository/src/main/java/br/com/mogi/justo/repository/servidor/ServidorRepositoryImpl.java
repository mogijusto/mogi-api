package br.com.mogi.justo.repository.servidor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.mogi.justo.model.Servidor;

public class ServidorRepositoryImpl implements ServidorRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Servidor> findAllLimit100First() {
		Query query = this.entityManager.createNamedQuery("Servidor.findAllLimit100First");
		query.setMaxResults(100);
		return query.getResultList();
	}

}
