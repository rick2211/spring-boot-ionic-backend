package br.com.ricardo.springboot.services;

import br.com.ricardo.springboot.domain.model.Categoria;
import br.com.ricardo.springboot.repositories.CategoriaRepository;
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


    public Categoria insert(Categoria obj) {
        //Garante que o obj seja um novo
        obj.setId(null);
        return categoriaRepository.save(obj);
    }
}
