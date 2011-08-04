package com.pp.admin.web;


import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.CTipoCargo;
import com.pp.util.DataTable;



public class TipoCargoWeb extends CRUDWeb{

	
	
	private CTipoCargo tipoCargo;
	
	
	
	
	
	public TipoCargoWeb() {
		tipoCargo=new CTipoCargo();
	}
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(TipoCargoWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;

	
	public void init(){
		dataTable=new DataTable();
		List<CTipoCargo> roles=userAdmin.getTipoCargo();
		if(roles!=null)
		for (CTipoCargo kRole : roles) {
			dataTable.addReg(kRole.getCodigoInternoCargo(),kRole.getDescripcion(),kRole.getFechaActualizacion(),
					kRole.getIpActualizacion(),kRole.getUsuarioActualizacion(),
					kRole.getFechaInsercion(),kRole.getIpInsercion(),kRole.getUsuarioInsercion());
		}
	}
	
	
	
	
	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.tipoCargo.getCodigoInternoCargo()==0){
		this.tipoCargo.setFechaInsercion(new Date());
		this.tipoCargo.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.tipoCargo.setUsuarioInsercion(1);
		}else{
		this.tipoCargo.setFechaActualizacion(new Date());
		this.tipoCargo.setIpActualizacion(request.getRemoteAddr());
		this.tipoCargo.setUsuarioActualizacion(1);
		}
		userAdmin.save(tipoCargo);
		init();
		toggleModal(evnt);
		
	}
	

	
	public void create(ActionEvent evnt){
		this.tipoCargo=new CTipoCargo();
		toggleModal(evnt);
	}
	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.tipoCargo=userAdmin.getTipoCargo((Integer)selectData[0]);
		toggleModal(null);
	}

	public void delete(ActionEvent evnt){
		this.tipoCargo=userAdmin.getTipoCargo((Integer)selectData[0]);
		userAdmin.delete(this.tipoCargo);
		this.tipoCargo=new CTipoCargo();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
	}
	


	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}




	public CTipoCargo getTipoCargo() {
		return tipoCargo;
	}




	public void setTipoCargo(CTipoCargo tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	

	
}
