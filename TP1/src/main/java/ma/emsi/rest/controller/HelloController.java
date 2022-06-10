package ma.emsi.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller vs @RestController
 * 
 * @Controller : pour traiter les requêtes web HTTP.
 * @RestController : pour traiter les requêtes web Rest.
 *
 */
@RestController
public class HelloController {
	//@GetMapping(value={"/hello","/lien2","/lien3"})
	@GetMapping("/hello")
//	@RequestMapping(method=RequestMethod.GET,value={"/test","/hello"})
	public String hello() {
		return "Bonjour tout le monde";
	}
}
