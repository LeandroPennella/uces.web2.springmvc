package ar.edu.uces.progweb2.springmvc.controller.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.progweb2.springmvc.dao.SomethingDao;
import ar.edu.uces.progweb2.springmvc.model.Something;

@Controller
public class JsonController {
	private SomethingDao somethingDao;

	@Autowired
	public void setSomethingDao(SomethingDao somethingDao) {
		this.somethingDao = somethingDao;
	}

	@RequestMapping(value = "/get/{id}")
	public @ResponseBody Map<String, Something> get(@PathVariable long id) {
		System.out.println("Get Something with id " + id);
		Map<String, Something> out = new HashMap<String, Something>();
		out.put("something", somethingDao.get(id));
		return out;
	}

	@RequestMapping(value = "/find")
	public @ResponseBody Map<String, Something> find(@RequestParam("id") long id) {
		System.out.println("Find Something with id " + id);
		Map<String, Something> out = new HashMap<String, Something>();
		out.put("something", somethingDao.get(id));
		return out;
	}

	@RequestMapping(value = "/find2")
	public @ResponseBody String find2(@RequestParam("id") long id) {
		System.out.println("Find Something with id " + id);
		Map<String, Something> out = new HashMap<String, Something>();
		out.put("something", somethingDao.get(id));
		// return out;
		return "/views/test.jsp";
	}

	@RequestMapping(value = "/createSomethingAjax", method = RequestMethod.POST)
	//responsebody y requestbody indica que voy a devolver y recibir json, respectivamente
	public @ResponseBody Map<String, Something> createSomething(@RequestBody Something something) {
		System.out.println("Creatin something with value " + something.getValue());
		somethingDao.save(something);
		Map<String, Something> out = new HashMap<String, Something>();
		out.put("something", something);
		return out;

	}
}
