package com.nomina.thymeleaf.nomina.validator;
import javax.validation.constraints.NotEmpty;

public class ConfiguracionValidator {
	
	@NotEmpty(message = "Debe ingresar un token.")
    private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

}
