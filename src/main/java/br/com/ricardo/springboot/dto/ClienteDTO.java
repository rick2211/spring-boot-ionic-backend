package br.com.ricardo.springboot.dto;

import br.com.ricardo.springboot.domain.model.Cliente;
import br.com.ricardo.springboot.services.validation.ClienteUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
@Data
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;
    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;
    @NotEmpty(message = "Preenchimento Obrigatório")
    @Email(message = " Email inválido")
    private String email;

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();

    }
}
