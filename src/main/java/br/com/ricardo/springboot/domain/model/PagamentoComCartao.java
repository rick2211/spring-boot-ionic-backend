package br.com.ricardo.springboot.domain.model;

import br.com.ricardo.springboot.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@JsonTypeName("pagamentoComCartao")
@EqualsAndHashCode(callSuper = false)
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1l;

    private Integer numeroDeParcelas;


    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
