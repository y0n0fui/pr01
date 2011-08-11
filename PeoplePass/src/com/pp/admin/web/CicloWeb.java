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
import com.pp.admin.hibernate.KCiclo;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class CicloWeb extends CRUDWeb{

	
	
	private KCiclo ciclo;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(CicloWeb.class);
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	public CicloWeb() {
		ciclo=new KCiclo();
	}

	
	public void create(ActionEvent evnt){
		this.ciclo=new KCiclo();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		this.ciclo=paramsAdmin.getCiclo((Integer)selectData[0]);
		try{
		paramsAdmin.delete(this.ciclo);
		this.ciclo=new KCiclo();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("adminciclo.ciclo.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.ciclo=paramsAdmin.getCiclo((Integer)selectData[0]);
		toggleModal(null);
	}
	
	public KCiclo getCiclo() {
		return ciclo;
	}

	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}




	public void init(){
		dataTable=new DataTable();
		List<KCiclo> ciclos=paramsAdmin.getCiclo();
		if(ciclos!=null)
		for (KCiclo ciclo : ciclos) {
			dataTable.addReg(ciclo.getCodigoInternoCiclo(),ciclo.getDescripcion(),ciclo.getFechaActualizacion(),
					ciclo.getIpActualizacion(),ciclo.getUsuarioActualizacion(),
					ciclo.getFechaInsercion(),ciclo.getIpInsercion(),ciclo.getUsuarioInsercion());
		}
	}




	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.ciclo.getCodigoInternoCiclo()==0){
		this.ciclo.setFechaInsercion(new Date());
		this.ciclo.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.ciclo.setUsuarioInsercion(1);
		}else{
		this.ciclo.setFechaActualizacion(new Date());
		this.ciclo.setIpActualizacion(request.getRemoteAddr());
		this.ciclo.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(ciclo);
		init();
		toggleModal(evnt);
		
	}




	public void setCiclo(KCiclo ciclo) {
		this.ciclo = ciclo;
	}




	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}
	


	
	
}
