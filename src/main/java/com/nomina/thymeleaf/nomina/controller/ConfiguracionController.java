package com.nomina.thymeleaf.nomina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfiguracionController {
	
	@GetMapping("/configuracion")
	public String configuracion() {
		return "configuracion";
	}
	

}
