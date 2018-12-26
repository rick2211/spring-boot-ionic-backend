package br.com.ricardo.cursomc.repositories;

import br.com.ricardo.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
