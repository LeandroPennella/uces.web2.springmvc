package ar.edu.uces.progweb2.springmvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleBean {

	private String parameter;

	public String getParameter() {
		return parameter;
	}

	@Value("${myApp.parameter}")
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}
