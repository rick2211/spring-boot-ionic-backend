package br.com.ricardo.cursomc.repositories;

import br.com.ricardo.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
