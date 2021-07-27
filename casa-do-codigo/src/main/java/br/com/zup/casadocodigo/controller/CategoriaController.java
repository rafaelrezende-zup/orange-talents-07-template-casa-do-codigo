package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.dto.NovaCategoriaDTO;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovaCategoriaDTO dto) {
        Categoria categoria = new Categoria(dto);
        repository.save(categoria);
        return ResponseEntity.ok().build();
    }

}
