package br.com.ricardo.cursomc.repositories;

import br.com.ricardo.cursomc.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
