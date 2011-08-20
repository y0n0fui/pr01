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

import com.pp.admin.hibernate.KDescripcionRecursos;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class DescripcionRecursosWeb extends CRUDWeb{

	
	
	private KDescripcionRecursos descripcionRecursos;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(DescripcionRecursosWeb.class);
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	public DescripcionRecursosWeb() {
		descripcionRecursos=new KDescripcionRecursos();
	}

	
	public void create(ActionEvent evnt){
		this.descripcionRecursos=new KDescripcionRecursos();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		this.descripcionRecursos=paramsAdmin.getDescripcionRecursos((Integer)selectData[0]);
		try{
		paramsAdmin.delete(this.descripcionRecursos);
		this.descripcionRecursos=new KDescripcionRecursos();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("admindescrecursos.descrecursos.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.descripcionRecursos=paramsAdmin.getDescripcionRecursos((Integer)selectData[0]);
		toggleModal(null);
	}
	
	
	


	public void init(){
		dataTable=new DataTable();
		List<KDescripcionRecursos> descRecursos=paramsAdmin.getDescripcionRecursos();
		if(descRecursos!=null)
		for (KDescripcionRecursos kdesc : descRecursos) {
			dataTable.addReg(kdesc.getCodigoInternoRecurso(),kdesc.getDescripcion(),kdesc.getFechaActualizacion(),
					kdesc.getIpActualizacion(),kdesc.getUsuarioActualizacion(),
					kdesc.getFechaInsercion(),kdesc.getIpInsercion(),kdesc.getUsuarioInsercion());
		}
	}

	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.descripcionRecursos.getCodigoInternoRecurso()==0){
		this.descripcionRecursos.setFechaInsercion(new Date());
		this.descripcionRecursos.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.descripcionRecursos.setUsuarioInsercion(new BigDecimal(1));
		}else{
		this.descripcionRecursos.setFechaActualizacion(new Date());
		this.descripcionRecursos.setIpActualizacion(request.getRemoteAddr());
		this.descripcionRecursos.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(descripcionRecursos);
		init();
		toggleModal(evnt);
		
	}


	public KDescripcionRecursos getDescripcionRecursos() {
		return descripcionRecursos;
	}


	public void setDescripcionRecursos(KDescripcionRecursos descripcionRecursos) {
		this.descripcionRecursos = descripcionRecursos;
	}


	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}


	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}

	
	
}
