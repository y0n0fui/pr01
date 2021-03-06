package com.pp.admin.web;


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
import com.pp.admin.hibernate.CCiudad;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class CityWeb extends CRUDWeb{

	private CCiudad ciudad;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(CityWeb.class);
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	public CityWeb() {
		ciudad=new CCiudad();
	}

	
	public void create(ActionEvent evnt){
		this.ciudad=new CCiudad();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		this.ciudad=paramsAdmin.getCiudad((Integer)selectData[0]);
		try{
		paramsAdmin.delete(this.ciudad);
		this.ciudad=new CCiudad();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("admintipoid.tipoid.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.ciudad=paramsAdmin.getCiudad((Integer)selectData[0]);
		toggleModal(null);
	}
	
	public CCiudad getCiudad() {
		return ciudad;
	}

	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}
	


	public void init(){
		dataTable=new DataTable();
		List<CCiudad> tiposId=paramsAdmin.getCiudad();
		if(tiposId!=null)
		for (CCiudad tipid : tiposId) {
			dataTable.addReg(tipid.getCodigoInternoCiudad(),tipid.getDescripcion(),tipid.getFechaActualizacion(),
					tipid.getIpActualizacion(),tipid.getUsuarioActualizacion(),
					tipid.getFechaInsercion(),tipid.getIpInsercion(),tipid.getUsuarioInsercion());
		}
	}

	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.ciudad.getCodigoInternoCiudad()==0){
		this.ciudad.setFechaInsercion(new Date());
		this.ciudad.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.ciudad.setUsuarioInsercion(1);
		}else{
		this.ciudad.setFechaActualizacion(new Date());
		this.ciudad.setIpActualizacion(request.getRemoteAddr());
		this.ciudad.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(ciudad);
		init();
		toggleModal(evnt);
		
	}




	public void setCiudad(CCiudad ciudad) {
		this.ciudad = ciudad;
	}




	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}

	
	
	
}
