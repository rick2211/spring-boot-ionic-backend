package br.com.ricardo.springboot.repositories;

import br.com.ricardo.springboot.domain.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {


}
