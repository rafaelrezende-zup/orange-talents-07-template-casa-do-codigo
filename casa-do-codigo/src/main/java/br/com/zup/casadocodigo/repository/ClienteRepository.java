package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
