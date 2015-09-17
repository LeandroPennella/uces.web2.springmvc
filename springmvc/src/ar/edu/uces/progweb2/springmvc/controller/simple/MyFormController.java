package ar.edu.uces.progweb2.springmvc.controller.simple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.model.Career;
import ar.edu.uces.progweb2.springmvc.model.Person;
import ar.edu.uces.progweb2.springmvc.validator.PersonValidator;
@SessionAttributes({"combo"})
@Controller
public class MyFormController {

	private PersonValidator personValidator;

	@Autowired
	public void setPersonValidator(PersonValidator personValidator) {
		this.personValidator = personValidator;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		System.out.println("MyFormController - init");
		List<Career> combo = new ArrayList<Career>();
		combo.add(new Career(1, "aaa"));
		combo.add(new Career(2, "bbb"));
		model.addAttribute("combo", combo);
		model.addAttribute("person", new Person());
		return new ModelAndView("/views/form.jsp");
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public ModelAndView process(@ModelAttribute("person") Person person, BindingResult result, SessionStatus status) {
		this.personValidator.validate(person, result);
		if (result.hasErrors()) {
			return new ModelAndView("/views/form.jsp");
		}
		status.setComplete(); // borra la session
		return new ModelAndView("/views/result.jsp", "person", person);
	}
}
