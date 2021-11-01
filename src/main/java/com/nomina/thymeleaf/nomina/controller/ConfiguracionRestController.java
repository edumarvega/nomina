package com.nomina.thymeleaf.nomina.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomina.thymeleaf.nomina.entity.Configuracion;
import com.nomina.thymeleaf.nomina.response.ResponseConfiguracion;
import com.nomina.thymeleaf.nomina.service.ConfiguracionService;
import com.nomina.thymeleaf.nomina.validator.ConfiguracionValidator;

@RestController
@RequestMapping("/api/configuraciones")
public class ConfiguracionRestController {
	
	@Autowired
	private ConfiguracionService configuracionService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody ConfiguracionValidator configuracion, Errors errors) {

		ResponseConfiguracion result = new ResponseConfiguracion();
		
		if (errors.hasErrors()) {

			result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		} else {
	
			try {
				Configuracion config = this.configuracionService.getConfiguracion();
				config.setToken(configuracion.getToken().trim());
				this.configuracionService.saveOrUpdate(config);
				result.setMsg("El dato fue guardado correctamente.");
			 
			} catch (Exception e) {
				result.setMsg("Error: Hubo uno error al guardar el dato.");
			}
			
			return ResponseEntity.ok(result);

		}

	}

	public ConfiguracionService getConfiguracionService() {
		return configuracionService;
	}

	public void setConfiguracionService(ConfiguracionService configuracionService) {
		this.configuracionService = configuracionService;
	}
	
}
