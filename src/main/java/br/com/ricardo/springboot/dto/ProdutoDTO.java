package br.com.ricardo.springboot.dto;

import br.com.ricardo.springboot.domain.model.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(Produto obj) {
        id = obj.getId();
        nome = obj.getNome();
        preco = obj.getPreco();

    }
}
