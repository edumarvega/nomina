package com.nomina.thymeleaf.nomina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nomina.thymeleaf.nomina.entity.Persona;

@Service
public class AutenticacionService {
	
	@Autowired
	private ConfiguracionService configuracionService;
		
	public Persona autenticarse(String cuit) throws Exception {
		String url = this.configuracionService.getConfiguracion().getUrl()+cuit;
		String token = this.configuracionService.getConfiguracion().getToken();
	    RestTemplate restTemplate = new RestTemplate();
	    Persona persona = null;
	    try {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.set("Authorization", "Bearer " +token);
	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	        ResponseEntity<Persona> response = restTemplate.exchange(url, HttpMethod.GET, entity, Persona.class);
	        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
	        if(response.hasBody()) {
	        	persona = response.getBody();
	        }
	    }
	    catch (Exception e) {
	    	System.out.println("** Exception: "+ e.getMessage());
	    	if(e.getMessage().contains("404")) {
	    		throw new Exception("Error: El servicio de nominas no se encuentra disponible.");
	    	} else if(e.getMessage().contains("403") && e.getMessage().contains("Access Denied")) {
	    		throw new Exception("Error: Acceso denegado, verifique token.");
	    	} else if(e.getMessage().contains("500") && e.getMessage().contains("Invalid token")) {
	    		throw new Exception("Error: Token vencido, haga click en Configurar token.");
	    	} else if(e.getMessage().contains("500") && e.getMessage().contains("parsing and verifying token")) {
	    		throw new Exception("Error: Token inválido, haga click en Configurar token."); 
	    	} else {
	    		throw new Exception("Error: "+e.getMessage());
	    	}
	    	
	    	
	    }
	    
	    return persona;
		
	}

	public ConfiguracionService getConfiguracionService() {
		return configuracionService;
	}


	public void setConfiguracionService(ConfiguracionService configuracionService) {
		this.configuracionService = configuracionService;
	}

	
}
