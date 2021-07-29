package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Cliente;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.model.dto.NovoClienteDTO;
import br.com.zup.casadocodigo.repository.ClienteRepository;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;
import br.com.zup.casadocodigo.validator.PaisPossuiEstadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;
    private final PaisPossuiEstadoValidator paisPossuiEstadoValidator;
    private final ClienteRepository repository;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(paisPossuiEstadoValidator);
    }

    public ClienteController(PaisRepository paisRepository,
                             EstadoRepository estadoRepository,
                             PaisPossuiEstadoValidator paisPossuiEstadoValidator,
                             ClienteRepository repository) {
        this.repository = repository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.paisPossuiEstadoValidator = paisPossuiEstadoValidator;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cria(@RequestBody @Valid NovoClienteDTO dto) {
        Pais pais = paisRepository.getById(dto.getIdPais());
        Estado estado = estadoRepository.getById(dto.getIdEstado());
        Cliente cliente = new Cliente(dto, pais, estado);
        repository.save(cliente);
        return ResponseEntity.ok().build();
    }

}
