package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.model.dto.NovoPaisDTO;
import br.com.zup.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisRepository repository;

    public PaisController(PaisRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovoPaisDTO dto) {
        Pais pais = new Pais(dto);
        repository.save(pais);
        return ResponseEntity.ok().build();
    }

}
