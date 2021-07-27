package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.dto.NovaCategoriaDTO;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import br.com.zup.casadocodigo.validator.NomeCategoriaDuplicadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository repository;
    private final NomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(nomeCategoriaDuplicadoValidator);
    }

    public CategoriaController(CategoriaRepository repository, NomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator) {
        this.repository = repository;
        this.nomeCategoriaDuplicadoValidator = nomeCategoriaDuplicadoValidator;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovaCategoriaDTO dto) {
        Categoria categoria = new Categoria(dto);
        repository.save(categoria);
        return ResponseEntity.ok().build();
    }

}
