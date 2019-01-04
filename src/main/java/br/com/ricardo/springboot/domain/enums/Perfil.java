package br.com.ricardo.springboot.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    @Getter
    @Setter
    private int cod;
    @Getter
    @Setter
    private String descricao;

    public static Perfil toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        //Varre todos os valores de TipoCliente
        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;

            }

        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
