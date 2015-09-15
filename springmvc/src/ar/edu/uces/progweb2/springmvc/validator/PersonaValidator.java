package ar.edu.uces.progweb2.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ar.edu.uces.progweb2.springmvc.model.Persona;

//lo va a manejar spring
@Component
public class PersonaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Persona.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Persona persona = (Persona) object;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "erros.person.name.empty");
		if(!errors.hasFieldErrors("edad"))
		{
		if ((persona.getEdad()>100)||(persona.getEdad()<1)) {
			errors.rejectValue("edad", "erros.person.edad");
		}}
	}

}
