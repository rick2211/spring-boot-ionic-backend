package br.com.ricardo.springboot.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    @Getter
    @Setter
    private int cod;
    @Getter
    @Setter
    private String descriçao;


    public static TipoCliente toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        //Varre todos os valores de TipoCliente
        for (TipoCliente x : TipoCliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;

            }

        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
