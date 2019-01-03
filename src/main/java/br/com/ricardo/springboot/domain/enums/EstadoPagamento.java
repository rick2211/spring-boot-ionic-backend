package br.com.ricardo.springboot.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    @Getter
    @Setter
    private int cod;
    @Getter
    @Setter
    private String descricao;

    public static EstadoPagamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        //Varre todos os valores de TipoCliente
        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;

            }

        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
