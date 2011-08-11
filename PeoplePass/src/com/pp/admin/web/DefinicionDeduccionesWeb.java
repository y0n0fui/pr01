package com.pp.admin.web;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IParamsAdmin;
import com.pp.admin.hibernate.KDefinicionDeducciones;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class DefinicionDeduccionesWeb extends CRUDWeb{

	
	
	
	private KDefinicionDeducciones definicionDeducciones;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(DefinicionDeduccionesWeb.class);
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	public DefinicionDeduccionesWeb() {
		definicionDeducciones=new KDefinicionDeducciones();
	}

	
	public void create(ActionEvent evnt){
		this.definicionDeducciones=new KDefinicionDeducciones();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		this.definicionDeducciones=paramsAdmin.getDefinicionDeducciones((Integer)selectData[0]);
		try{
		paramsAdmin.delete(this.definicionDeducciones);
		this.definicionDeducciones=new KDefinicionDeducciones();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("admindefdeduc.def.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.definicionDeducciones=paramsAdmin.getDefinicionDeducciones((Integer)selectData[0]);
		toggleModal(null);
	}
	
	public KDefinicionDeducciones getDefinicionDeducciones() {
		return definicionDeducciones;
	}

	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}




	public void init(){
		dataTable=new DataTable();
		List<KDefinicionDeducciones> defs=paramsAdmin.getDefinicionDeducciones();
		if(defs!=null)
		for (KDefinicionDeducciones definicionDeducciones : defs) {
			dataTable.addReg(definicionDeducciones.getCodigoInternoDeduccion(),definicionDeducciones.getDescripcion(),definicionDeducciones.getFechaActualizacion(),
					definicionDeducciones.getIpActualizacion(),definicionDeducciones.getUsuarioActualizacion(),
					definicionDeducciones.getFechaInsercion(),definicionDeducciones.getIpInsercion(),definicionDeducciones.getUsuarioInsercion());
		}
	}




	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.definicionDeducciones.getCodigoInternoDeduccion()==0){
		this.definicionDeducciones.setFechaInsercion(new Date());
		this.definicionDeducciones.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.definicionDeducciones.setUsuarioInsercion(1);
		}else{
		this.definicionDeducciones.setFechaActualizacion(new Date());
		this.definicionDeducciones.setIpActualizacion(request.getRemoteAddr());
		this.definicionDeducciones.setUsuarioActualizacion(new BigDecimal(1));
		}
		paramsAdmin.save(definicionDeducciones);
		init();
		toggleModal(evnt);
		
	}




	public void setDefinicionDeducciones(
			KDefinicionDeducciones definicionDeducciones) {
		this.definicionDeducciones = definicionDeducciones;
	}




	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}
	


	
	
}
