package br.com.ricardo.springboot.repositories;

import br.com.ricardo.springboot.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
