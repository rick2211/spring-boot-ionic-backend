package br.com.ricardo.cursomc.repositories;

import br.com.ricardo.cursomc.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
