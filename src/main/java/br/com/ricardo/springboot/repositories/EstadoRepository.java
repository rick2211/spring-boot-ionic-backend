package br.com.ricardo.springboot.repositories;

import br.com.ricardo.springboot.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
