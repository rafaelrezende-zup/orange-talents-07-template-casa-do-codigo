package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.model.dto.NovoEstadoDTO;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;
import br.com.zup.casadocodigo.validator.EstadoUnicoMesmoPaisValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoRepository repository;
    private final PaisRepository paisRepository;
    private final EstadoUnicoMesmoPaisValidator estadoUnicoMesmoPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoUnicoMesmoPaisValidator);
    }

    public EstadoController(EstadoRepository repository,
                            PaisRepository paisRepository,
                            EstadoUnicoMesmoPaisValidator estadoUnicoMesmoPaisValidator) {
        this.repository = repository;
        this.paisRepository = paisRepository;
        this.estadoUnicoMesmoPaisValidator = estadoUnicoMesmoPaisValidator;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovoEstadoDTO dto) {
        Pais pais = paisRepository.getById(dto.getIdPais());
        Estado estado = new Estado(dto, pais);
        repository.save(estado);
        return ResponseEntity.ok().build();
    }

}
