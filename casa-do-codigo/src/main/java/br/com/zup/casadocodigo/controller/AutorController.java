package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.dto.AutorDTO;
import br.com.zup.casadocodigo.model.dto.NovoAutorDTO;
import br.com.zup.casadocodigo.repository.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovoAutorDTO dto) {
        Autor autor = new Autor(dto);
        try {
            repository.save(autor);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado.", e);
        }
        return ResponseEntity.ok().build();
    }

}
