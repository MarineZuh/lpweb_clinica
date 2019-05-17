package lpweb.projeto.clinica.controller.validation;

import lpweb.projeto.clinica.controller.response.Error;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class Validacao<T> {
    public List<Error> valida(T dto) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> validate =
                validator.validate(dto);

        final List<Error> erros = new ArrayList<>();

        validate.forEach(violation ->
        {
            final String campo = violation.getPropertyPath().toString();

            final String campoCapitalizado = campo.substring( 0, 1 ).toUpperCase()
                    + campo.substring( 1 );

            erros.add(new Error("Campo " + campoCapitalizado
                    + " " + violation.getMessage(),
                    violation.getInvalidValue().toString()
                            + violation.getMessageTemplate())); });
        return erros;
    }
}
