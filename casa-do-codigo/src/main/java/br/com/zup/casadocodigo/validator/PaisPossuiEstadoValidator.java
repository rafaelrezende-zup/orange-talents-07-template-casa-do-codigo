package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.model.dto.NovoClienteDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class PaisPossuiEstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoClienteDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovoClienteDTO dto = (NovoClienteDTO) target;
        Query query = manager.createQuery("select 1 from Pais p inner join Estado e " +
                " on e.pais.id = p.id " +
                " where p.id=:idPais and e.id=:idEstado");
        query.setParameter("idPais", dto.getIdPais());
        query.setParameter("idEstado", dto.getIdEstado());
        List<?> list = query.getResultList();
        if (list.isEmpty()) {
            errors.rejectValue("idEstado", null, "O estado de id " + dto.getIdEstado() + " não pertence ao país de código " + dto.getIdPais());
        }
    }
}
