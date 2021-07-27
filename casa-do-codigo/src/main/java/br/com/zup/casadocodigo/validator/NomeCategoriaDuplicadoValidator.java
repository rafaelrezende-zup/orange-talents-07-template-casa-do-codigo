package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.dto.NovaCategoriaDTO;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeCategoriaDuplicadoValidator implements Validator {

    private CategoriaRepository repository;

    public NomeCategoriaDuplicadoValidator(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovaCategoriaDTO dto = (NovaCategoriaDTO) target;
        Optional<Categoria> categoria = repository.findByNome(dto.getNome());
        if (categoria.isPresent()) {
            errors.rejectValue("nome", null, "Nome '" + dto.getNome() + "' já cadastrado");
        }
    }
}
