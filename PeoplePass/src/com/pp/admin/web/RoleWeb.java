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
import com.pp.admin.hibernate.KRoles;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class RoleWeb extends CRUDWeb{

	
	
	private KRoles role;
	
	
	
	
	public RoleWeb() {
		role=new KRoles();
	}
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(RoleWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;

	
	public void init(){
		dataTable=new DataTable();
		List<KRoles> roles=userAdmin.getRoles();
		if(roles!=null)
		for (KRoles kRole : roles) {
			dataTable.addReg(kRole.getCodigoInternoRole(),kRole.getDescripcion(),kRole.getFechaActualizacion(),
					kRole.getIpActualizacion(),kRole.getUsuarioActualizacion(),
					kRole.getFechaInsercion(),kRole.getIpInsercion(),kRole.getUsuarioInsercion());
		}
	}
	
	
	
	
	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.role.getCodigoInternoRole()==0){
		this.role.setFechaInsercion(new Date());
		this.role.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.role.setUsuarioInsercion(1);
		}else{
		this.role.setFechaActualizacion(new Date());
		this.role.setIpActualizacion(request.getRemoteAddr());
		this.role.setUsuarioActualizacion(1);
		}
		userAdmin.save(role);
		init();
		toggleModal(evnt);
		
	}
	

	
	public void create(ActionEvent evnt){
		this.role=new KRoles();
		toggleModal(evnt);
	}
	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.role=userAdmin.getRoles((Integer)selectData[0]);
		toggleModal(null);
	}

	public void delete(ActionEvent evnt){
		this.role=userAdmin.getRoles((Integer)selectData[0]);
		try{
		userAdmin.delete(this.role);
		this.role=new KRoles();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("adminrole.role.error.delete", context ));
		}
	}
	


	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}

	public KRoles getRole() {
		return role;
	}


	public void setRole(KRoles role) {
		this.role = role;
	}

	
}
