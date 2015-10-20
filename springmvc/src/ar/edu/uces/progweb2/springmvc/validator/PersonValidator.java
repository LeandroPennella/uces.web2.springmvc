package ar.edu.uces.progweb2.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ar.edu.uces.progweb2.springmvc.model.Person;

//lo va a manejar spring
@Component
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Person person = (Person) object;
		//manera 1
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "erros.person.name.empty");
		//manera 2
		if (person.getName().equals("asdf")) {
			errors.rejectValue("name", "erros.person.name.asdf");
		}

	}

}
