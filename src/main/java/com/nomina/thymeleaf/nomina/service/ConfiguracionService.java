package com.nomina.thymeleaf.nomina.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nomina.thymeleaf.nomina.entity.Configuracion;
import com.nomina.thymeleaf.nomina.repository.ConfiguracionRespository;

@Service
public class ConfiguracionService {
	
	@Autowired
	private ConfiguracionRespository configuracionRespository;
	
	public Configuracion getConfiguracion() {
		
		List<Configuracion> configuraciones = new ArrayList<>();
		configuracionRespository.findAll().forEach(config->configuraciones.add(config));
		Configuracion configuracion = null;
		if(!configuraciones.isEmpty()) {
			configuracion = configuraciones.get(0);
		}
		
		return configuracion;
	}
	
	public void saveOrUpdate(Configuracion configuracion) {
		this.configuracionRespository.save(configuracion);
	}

}
