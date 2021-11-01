package com.nomina.thymeleaf.nomina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nomina.thymeleaf.nomina.entity.Configuracion;
import com.nomina.thymeleaf.nomina.service.ConfiguracionService;

@Controller
public class NominaController {
	
	@Autowired
	private ConfiguracionService configuracionService;
	
	
	@GetMapping("/")
	public String index() {
		return "redirect:/nomina";
	}
	
	@GetMapping("/nomina")
	public String nomina(Model model) {
		model.addAttribute("bloqueaPantalla", "false");
		Configuracion configuracion = this.configuracionService.getConfiguracion();
		if(configuracion!=null) {
			if(configuracion.getToken()== null ||configuracion.getToken().length() == 0){
				model.addAttribute("bloquearPantalla", "true");
			}
		} 
		return "nomina";
	}

	public ConfiguracionService getConfiguracionService() {
		return configuracionService;
	}

	public void setConfiguracionService(ConfiguracionService configuracionService) {
		this.configuracionService = configuracionService;
	}
	
	

}
