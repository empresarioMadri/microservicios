package curso.cas.microservicios.ProyectoVideoClub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("nombre", "David");
		return "index";
	}

}
