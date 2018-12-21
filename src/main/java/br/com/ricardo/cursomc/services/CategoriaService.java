package br.com.ricardo.cursomc.services;

import br.com.ricardo.cursomc.domain.Categoria;
import br.com.ricardo.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);

        return obj.orElseThrow(() -> new ObjetctNotFoundException("Objeto não encontrado! Id:"
                + id
                + ", Tipo: " + Categoria.class.getName()));
    }
}
