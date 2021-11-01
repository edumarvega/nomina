package com.nomina.thymeleaf.nomina.response;

import com.nomina.thymeleaf.nomina.entity.Persona;

public class ResponsePersona {
	
	private String msg;
    private Persona result;
	
    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Persona getResult() {
		return result;
	}
	public void setResult(Persona result) {
		this.result = result;
	}
    
    

}
