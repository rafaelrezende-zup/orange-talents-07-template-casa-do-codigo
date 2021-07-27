package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.model.dto.NovoLivroDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class DataFuturaValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoLivroDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovoLivroDTO dto = (NovoLivroDTO) target;
        if (dto.getDataPublicacao().isBefore(LocalDate.now())) {
            errors.rejectValue("dataPublicacao", null, "A data de publicação precisa ser no futuro.");
        }
    }

}
