package br.com.ricardo.springboot.repositories;

import br.com.ricardo.springboot.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
