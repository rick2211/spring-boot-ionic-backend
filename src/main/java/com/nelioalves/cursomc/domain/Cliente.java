package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.TipoCliente;

import javax.persistence.Entity;

@Entity
public class Cliente {

    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private TipoCliente tipo;



}
