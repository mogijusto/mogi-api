package br.com.mogi.justo.repository.ip;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mogi.justo.model.acesso.Ip;

public interface IpRepository extends JpaRepository<Ip, Long> {

}
