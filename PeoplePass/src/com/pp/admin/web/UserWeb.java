package com.pp.admin.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pp.admin.facade.IUserAdmin;



public class UserWeb {

	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(UserWeb.class);
	
	private String text;
	
	
	@Autowired
	private IUserAdmin userAdmin;
		
	
	public UserWeb() {
		
	}



	public String getText() {
		if(this.text==null)
			init();
		return text;
	}


	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}
	    
			
	public void init(){
		text="Hola Mundo";
	}


	public void setText(String text) {
		this.text = text;
	}


	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}

	
	
}
