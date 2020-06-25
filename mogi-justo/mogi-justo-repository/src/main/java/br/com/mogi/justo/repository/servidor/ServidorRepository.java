package br.com.mogi.justo.repository.servidor;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mogi.justo.model.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {
}
