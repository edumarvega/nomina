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

import com.nomina.thymeleaf.nomina.entity.Persona;
import com.nomina.thymeleaf.nomina.response.ResponsePersona;
import com.nomina.thymeleaf.nomina.service.AutenticacionService;
import com.nomina.thymeleaf.nomina.validator.NominaValidator;

@RestController
@RequestMapping("/api/nominas")
public class NominaRestController {
	
	@Autowired
	private AutenticacionService autenticacionService;
	
	@PostMapping("/search")
	public ResponseEntity<?> search(@Valid @RequestBody NominaValidator search, Errors errors) {

		ResponsePersona result = new ResponsePersona();
		result.setMsg("Sin resultado.");

		if (errors.hasErrors()) {

			result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return ResponseEntity.badRequest().body(result);

		} else {

			String cuit = search.getCuit().replaceAll("-","");
			Persona persona;
			try {
				persona = this.autenticacionService.autenticarse(cuit);
				if (persona != null) {
					result.setMsg("Resultado encontrado:");
					result.setResult(persona);
				} 
			} catch (Exception e) {
				result.setMsg(e.getMessage());;
			}
			
			return ResponseEntity.ok(result);

		}

	}

	public AutenticacionService getAutenticacionService() {
		return autenticacionService;
	}

	public void setAutenticacionService(AutenticacionService autenticacionService) {
		this.autenticacionService = autenticacionService;
	}
	
	

}
