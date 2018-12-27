package br.com.ricardo.springboot.services;

import br.com.ricardo.springboot.domain.model.Categoria;
import br.com.ricardo.springboot.repositories.CategoriaRepository;
import br.com.ricardo.springboot.services.exceptions.DataIntegrityException;
import br.com.ricardo.springboot.services.exceptions.ObjetctNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {
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

    public Categoria update(Categoria obj) {

        return categoriaRepository.save(obj);
    }


    public void delete(Integer id) {
        find(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {

            throw new DataIntegrityException("Não é possivel excluir Categoria que possui produtos");
        }

    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();


    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }
}
