package br.com.ricardo.springboot.repositories;

import br.com.ricardo.springboot.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
