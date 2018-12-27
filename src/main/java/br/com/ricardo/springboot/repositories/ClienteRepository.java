package br.com.ricardo.springboot.repositories;

import br.com.ricardo.springboot.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}