package ma.emsi.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	// Spring utilise Spring EL (Spring Expression Language)
	@Value("${url}")
	private String url;
	
	@RequestMapping(value = "/name")
	public String name() {
		return url;
	}
}
