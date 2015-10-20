package ar.edu.uces.progweb2.springmvc.view.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AvatarForm {
	private CommonsMultipartFile source;

	public CommonsMultipartFile getSource() {
		return source;
	}

	public void setSource(CommonsMultipartFile source) {
		this.source = source;
	}

}
