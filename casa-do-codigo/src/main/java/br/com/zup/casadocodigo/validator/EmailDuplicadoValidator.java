package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.dto.NovoAutorDTO;
import br.com.zup.casadocodigo.repository.AutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    private final AutorRepository repository;

    public EmailDuplicadoValidator(AutorRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovoAutorDTO dto = (NovoAutorDTO) target;
        Optional<Autor> autor = repository.findByEmail(dto.getEmail());
        if (autor.isPresent()) {
            errors.rejectValue("email", null, "E-mail '" + dto.getEmail() + "' já cadastrado");
        }
    }

}
