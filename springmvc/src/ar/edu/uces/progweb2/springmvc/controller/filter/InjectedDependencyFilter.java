package ar.edu.uces.progweb2.springmvc.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.edu.uces.progweb2.springmvc.service.SimpleBean;

public class InjectedDependencyFilter implements Filter {
	private SimpleBean simpleBean;

	@Override
	public void init(FilterConfig config) throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(config
				.getServletContext());
		this.simpleBean = wac.getBean(SimpleBean.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		System.out.println("In InjectedDependencyFilter with parameter: " + simpleBean.getParameter());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
