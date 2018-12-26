package br.com.ricardo.cursomc.repositories;

import br.com.ricardo.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
