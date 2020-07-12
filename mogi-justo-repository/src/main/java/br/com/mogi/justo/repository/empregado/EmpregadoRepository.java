package br.com.mogi.justo.repository.empregado;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mogi.justo.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	Empregado findByRgf(String rgf);
}
