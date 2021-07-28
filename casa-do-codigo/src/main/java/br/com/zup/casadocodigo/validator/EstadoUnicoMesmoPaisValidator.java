package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.model.dto.NovoEstadoDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class EstadoUnicoMesmoPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoEstadoDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovoEstadoDTO dto = (NovoEstadoDTO) target;
        Query query = manager.createQuery("select 1 from Estado where nome=:value and pais_id=:idPais");
        query.setParameter("value", dto.getNome());
        query.setParameter("idPais", dto.getIdPais());
        List<?> list = query.getResultList();
        if (!list.isEmpty()) {
            errors.rejectValue("nome", null, "O estado " + dto.getNome() + " já está cadastrado no país de código " + dto.getIdPais());
        }
    }
}
