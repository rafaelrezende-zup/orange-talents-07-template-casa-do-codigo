package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.model.dto.NovoLivroDTO;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import br.com.zup.casadocodigo.repository.LivroRepository;
import br.com.zup.casadocodigo.validator.DataFuturaValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final AutorRepository autorRepository;
    private final DataFuturaValidator dataFuturaValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(dataFuturaValidator);
    }

    public LivroController(LivroRepository repository,
                           CategoriaRepository categoriaRepository,
                           AutorRepository autorRepository,
                           DataFuturaValidator dataFuturaValidator) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
        this.dataFuturaValidator = dataFuturaValidator;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovoLivroDTO dto) {
        Categoria categoria = categoriaRepository.getById(dto.getIdCategoria());
        Autor autor = autorRepository.getById(dto.getIdAutor());
        Livro livro = new Livro(dto, categoria, autor);
        repository.save(livro);
        return ResponseEntity.ok().build();
    }

}
