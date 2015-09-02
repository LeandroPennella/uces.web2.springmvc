package ar.edu.uces.progweb2.springmvc.controller.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.dao.AvatarDao;
import ar.edu.uces.progweb2.springmvc.model.Avatar;
import ar.edu.uces.progweb2.springmvc.validator.AvatarValidator;
import ar.edu.uces.progweb2.springmvc.view.form.AvatarForm;

@Controller
public class AvatarController {

	private AvatarDao avatarDao;
	private AvatarValidator avatarValidator;

	@Autowired
	public void setAvatarDao(AvatarDao avatarDao) {
		this.avatarDao = avatarDao;
	}

	@Autowired
	public void setAvatarValidator(AvatarValidator avatarValidator) {
		this.avatarValidator = avatarValidator;
	}

	@RequestMapping(value = "/formAvatar", method = RequestMethod.GET)
	public ModelAndView init() {
		System.out.println("AvatarController - init");
		ModelAndView model = new ModelAndView("/views/avatarForm.jsp");
		model.addObject("avatar", new AvatarForm());
		return model;
	}

	@RequestMapping(value = "/createAvatar", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("avatar") AvatarForm avatarForm,
			BindingResult result) {
		this.avatarValidator.validate(avatarForm, result);
		if (result.hasErrors()) {
			return new ModelAndView("/views/avatarForm.jsp");
		}
		Avatar avatar = new Avatar();
		avatar.setSource(avatarForm.getSource().getBytes());
		avatarDao.save(avatar);
		return new ModelAndView("/views/avatarShow.jsp", "idAvatar",
				avatar.getId());
	}

	@RequestMapping(value = "/showAvatar", method = RequestMethod.GET)
	public @ResponseBody byte[] show(@RequestParam("id") long id) {
		Avatar avatar = avatarDao.get(id);
		return avatar.getSource();
	}

}
