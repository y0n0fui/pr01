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

import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.CTipoIdentificacion;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class EmpleadosWeb extends CRUDWeb{

	
	
	private CTipoIdentificacion tipoIdentificacion;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(EmpleadosWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;
	
	public EmpleadosWeb() {
		tipoIdentificacion=new CTipoIdentificacion();
	}

	
	public void create(ActionEvent evnt){
		this.tipoIdentificacion=new CTipoIdentificacion();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		this.tipoIdentificacion=userAdmin.getTipoIdentificacion((Integer)selectData[0]);
		try{
		userAdmin.delete(this.tipoIdentificacion);
		this.tipoIdentificacion=new CTipoIdentificacion();
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
		this.tipoIdentificacion=userAdmin.getTipoIdentificacion((Integer)selectData[0]);
		toggleModal(null);
	}
	
	public CTipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}
	


	public void init(){
		dataTable=new DataTable();
		List<CTipoIdentificacion> tiposId=userAdmin.getTipoIdentificacion();
		if(tiposId!=null)
		for (CTipoIdentificacion tipid : tiposId) {
			dataTable.addReg(tipid.getCodIntTipoId(),tipid.getDescripcion(),tipid.getFechaActualizacion(),
					tipid.getIpActualizacion(),tipid.getUsuarioActualizacion(),
					tipid.getFechaInsercion(),tipid.getIpInsercion(),tipid.getUsuarioInsercion());
		}
	}

	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.tipoIdentificacion.getCodIntTipoId()==0){
		this.tipoIdentificacion.setFechaInsercion(new Date());
		this.tipoIdentificacion.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.tipoIdentificacion.setUsuarioInsercion(1);
		}else{
		this.tipoIdentificacion.setFechaActualizacion(new Date());
		this.tipoIdentificacion.setIpActualizacion(request.getRemoteAddr());
		this.tipoIdentificacion.setUsuarioActualizacion(1);
		}
		userAdmin.save(tipoIdentificacion);
		init();
		toggleModal(evnt);
		
	}




	public void setTipoIdentificacion(CTipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}




	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}




	

	

	
}
