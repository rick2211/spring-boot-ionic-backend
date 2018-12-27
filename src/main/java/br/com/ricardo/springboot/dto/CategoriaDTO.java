package br.com.ricardo.springboot.dto;

import br.com.ricardo.springboot.domain.model.Categoria;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;


    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nome = obj.getNome();

    }

}
