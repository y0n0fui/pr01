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
import com.pp.admin.hibernate.KEmpresaCorreo;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class EmpresaCorreoWeb extends CRUDWeb{

	
	
	private KEmpresaCorreo empresaCorreo;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(EmpresaCorreoWeb.class);
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	public EmpresaCorreoWeb() {
		empresaCorreo=new KEmpresaCorreo();
	}

	
	public void create(ActionEvent evnt){
		this.empresaCorreo=new KEmpresaCorreo();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		this.empresaCorreo=paramsAdmin.getEmpresaCorreo((Integer)selectData[0]);
		try{
		paramsAdmin.delete(this.empresaCorreo);
		this.empresaCorreo=new KEmpresaCorreo();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("adminempresacorreo.ecorreo.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.empresaCorreo=paramsAdmin.getEmpresaCorreo((Integer)selectData[0]);
		toggleModal(null);
	}
	
	public KEmpresaCorreo getEmpresaCorreo() {
		return empresaCorreo;
	}

	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}




	public void init(){
		dataTable=new DataTable();
		List<KEmpresaCorreo> empresasCorreo=paramsAdmin.getEmpresaCorreo();
		if(empresasCorreo!=null)
		for (KEmpresaCorreo eCorreo : empresasCorreo) {
			dataTable.addReg(eCorreo.getCodEmpresaCorreo(),eCorreo.getRazonSocial(),eCorreo.getFechaActualizacion(),
					eCorreo.getIpActualizacion(),eCorreo.getUsuarioActualizacion(),
					eCorreo.getFechaInsercion(),eCorreo.getIpInsercion(),eCorreo.getUsuarioInsercion());
		}
	}




	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.empresaCorreo.getCodEmpresaCorreo()==0){
		this.empresaCorreo.setFechaInsercion(new Date());
		this.empresaCorreo.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.empresaCorreo.setUsuarioInsercion(1);
		}else{
		this.empresaCorreo.setFechaActualizacion(new Date());
		this.empresaCorreo.setIpActualizacion(request.getRemoteAddr());
		this.empresaCorreo.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(empresaCorreo);
		init();
		toggleModal(evnt);
		
	}




	public void setEmpresaCorreo(KEmpresaCorreo empresaCorreo) {
		this.empresaCorreo = empresaCorreo;
	}




	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}
	


	

	
}
