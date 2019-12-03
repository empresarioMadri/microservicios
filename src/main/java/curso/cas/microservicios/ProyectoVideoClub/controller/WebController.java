package curso.cas.microservicios.ProyectoVideoClub.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videoClub")
public class WebController {

	@Value("${version}")
	private String appVersion;

	@Value("${app.version}")
	private String appVersion2;

	private static final Logger log = LoggerFactory.getLogger(WebController.class);

	@Autowired
	public WebController(ApplicationArguments args) {
		boolean disponible = args.containsOption("disponible");
		if (disponible)
			log.info("Esta habilitado");
		args.getNonOptionArgs().forEach(argumento -> log.info(argumento));
	}

	@PostConstruct
	public void init() {
		log.info("Versión del programa " + appVersion);
		log.info("Versión del programa2 " + appVersion2);
	}

	@GetMapping
	@ResponseBody
	public String index(@RequestParam String nombre) {
		return "<h3>Hola mundo " + nombre + "</h3>";
	}

	@GetMapping("/multiplicar")
	@ResponseBody
	public Integer multiplicar(@RequestParam Integer operador1, @RequestParam Integer operador2) {
		return operador1 * operador2;
	}

}
