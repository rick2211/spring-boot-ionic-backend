package br.com.ricardo.springboot.services;

import br.com.ricardo.springboot.domain.enums.Perfil;
import br.com.ricardo.springboot.domain.enums.TipoCliente;
import br.com.ricardo.springboot.domain.model.Cidade;
import br.com.ricardo.springboot.domain.model.Cliente;
import br.com.ricardo.springboot.domain.model.Endereco;
import br.com.ricardo.springboot.dto.ClienteDTO;
import br.com.ricardo.springboot.dto.ClienteNewDTO;
import br.com.ricardo.springboot.repositories.ClienteRepository;
import br.com.ricardo.springboot.repositories.EnderecoRepository;
import br.com.ricardo.springboot.security.UserSS;
import br.com.ricardo.springboot.services.exceptions.AuthorizationException;
import br.com.ricardo.springboot.services.exceptions.DataIntegrityException;
import br.com.ricardo.springboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Cliente find(Integer id) {

        UserSS user = UserService.authenticated();
        if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado");
        }

        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }


    @Transactional
    public Cliente insert(Cliente obj) {
        //Garante que o obj seja um novo
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return clienteRepository.save(newObj);
    }


    public void delete(Integer id) {
        find(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {

            throw new DataIntegrityException("Não é possivel excluir Cliente que tenha pedidos");
        }

    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();


    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null,null);
    }

    public Cliente fromDTO(ClienteNewDTO objDto) {

        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipoCliente()), bCryptPasswordEncoder.encode(objDto.getSenha()));

        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);

        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);

        cli.getEnderecos().add(end);

        cli.getTelefones().add(objDto.getTelefone1());

        if (objDto.getTelefone2() != null) {

            cli.getTelefones().add(objDto.getTelefone2());

        }

        if (objDto.getTelefone3() != null) {

            cli.getTelefones().add(objDto.getTelefone3());

        }

        return cli;

    }



    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}
