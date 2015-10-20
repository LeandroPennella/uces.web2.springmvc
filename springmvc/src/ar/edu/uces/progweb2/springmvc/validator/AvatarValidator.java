package ar.edu.uces.progweb2.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ar.edu.uces.progweb2.springmvc.view.form.AvatarForm;

@Component
public class AvatarValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AvatarForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		AvatarForm form = (AvatarForm) object;
		if (form.getSource().isEmpty()) {
			errors.rejectValue("source", "errors.avatar.source.empty");
		}
	}

}
