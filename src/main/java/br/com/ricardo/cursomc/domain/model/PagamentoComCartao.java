package br.com.ricardo.cursomc.domain.model;

import br.com.ricardo.cursomc.domain.enums.EstadoPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1l;

    private Integer numeroDeParcelas;


    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
