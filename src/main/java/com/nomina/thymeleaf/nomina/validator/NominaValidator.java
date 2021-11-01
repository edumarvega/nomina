package com.nomina.thymeleaf.nomina.validator;
import javax.validation.constraints.NotEmpty;

public class NominaValidator {
	
	@NotEmpty(message = "Debe ingresar un cuit.")
    private String cuit;

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	

}
