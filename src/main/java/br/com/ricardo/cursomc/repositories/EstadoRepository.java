package br.com.ricardo.cursomc.repositories;

import br.com.ricardo.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
