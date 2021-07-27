package br.com.zup.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exist {

    String message() default "ID inválido";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> domainClass();

}
