package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.dto.NovoAutorDTO;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.validator.EmailDuplicadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository repository;
    private final EmailDuplicadoValidator emailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailDuplicadoValidator);
    }

    public AutorController(AutorRepository repository, EmailDuplicadoValidator emailDuplicadoValidator) {
        this.repository = repository;
        this.emailDuplicadoValidator = emailDuplicadoValidator;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovoAutorDTO dto) {
        Autor autor = new Autor(dto);
        repository.save(autor);
        return ResponseEntity.ok().build();
    }

}
