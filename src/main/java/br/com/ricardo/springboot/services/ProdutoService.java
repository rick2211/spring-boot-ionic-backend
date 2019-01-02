package br.com.ricardo.springboot.services;

import br.com.ricardo.springboot.domain.model.Categoria;
import br.com.ricardo.springboot.domain.model.Pedido;
import br.com.ricardo.springboot.domain.model.Produto;
import br.com.ricardo.springboot.repositories.CategoriaRepository;
import br.com.ricardo.springboot.repositories.ProdutoRepository;
import br.com.ricardo.springboot.services.exceptions.ObjetctNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto find(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjetctNotFoundException("Objeto não encontrado! Id:"
                + id
                + ", Tipo: " + Pedido.class.getName()));
    }


    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        {
            List<Categoria> categorias = categoriaRepository.findAllById(ids);
            return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
        }
    }
}
