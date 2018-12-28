package br.com.ricardo.springboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private String nome;

    private String email;

    private String cpfOuCnpj;

    private Integer tipoCliente;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;

}
