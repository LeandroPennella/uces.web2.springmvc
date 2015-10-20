package ar.edu.uces.progweb2.springmvc.controller.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.progweb2.springmvc.dao.SomethingDao;
import ar.edu.uces.progweb2.springmvc.model.Something;

@Controller
public class CreateController {
	private SomethingDao somethingDao;

	@Autowired
	public void setSomethingDao(SomethingDao somethingDao) {
		this.somethingDao = somethingDao;
	}

	@RequestMapping(value = "/createSomething")
	public ModelAndView createSomething() {
		System.out.println("MyController - createSomething");
		Something something = new Something();
		something.setValue("asdf");
		this.somethingDao.save(something);
		ModelAndView out = new ModelAndView("/views/somethingCreated.jsp");
		out.addObject("something", something);
		return out;
	}
}
