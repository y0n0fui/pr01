package com.pp.admin.web;


import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IParamsAdmin;
import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.KCondicionesEspeciales;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class CondicionesEspecialesWeb extends CRUDWeb{

	
	
	private KCondicionesEspeciales condicionesEspeciales;
	
	
	
	private SelectItem[] empresas;

	private Integer idempresa = 0;
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(CondicionesEspecialesWeb.class);
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	@Autowired
	private IUserAdmin userAdmin;
	
	
	public CondicionesEspecialesWeb() {
		condicionesEspeciales=new KCondicionesEspeciales();
		condicionesEspeciales.setKEmpresas(new KEmpresas());
	}

	
	public void create(ActionEvent evnt){
		this.condicionesEspeciales=new KCondicionesEspeciales();
		toggleModal(evnt);
	}
	
	public void delete(ActionEvent evnt){
		this.condicionesEspeciales=paramsAdmin.getCondicionesEspeciales((Integer)selectData[0]);
		try{
		paramsAdmin.delete(this.condicionesEspeciales);
		this.condicionesEspeciales=new KCondicionesEspeciales();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("admincondespeciales.condespeciales.error.delete", context ));
		}
	}
	
	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.condicionesEspeciales=paramsAdmin.getCondicionesEspeciales((Integer)selectData[0]);
		idempresa=this.condicionesEspeciales.getKEmpresas().getCodigoInternoEmpresa();
		toggleModal(null);
	}
	

	
	public KCondicionesEspeciales getCondicionesEspeciales() {
		return condicionesEspeciales;
	}
	
	public SelectItem[] getEmpresas() {
		return empresas;
	}

	public Integer getIdempresa() {
		return idempresa;
	}


	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}


	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}



	public void init(){
		dataTable=new DataTable();
		List<KCondicionesEspeciales> condicionesList=paramsAdmin.getCondicionesEspeciales();
		if(condicionesEspeciales!=null)
		for (KCondicionesEspeciales kCondicionesEspeciales : condicionesList) {
			dataTable.addReg(kCondicionesEspeciales.getCodigoInternoCondicion(),kCondicionesEspeciales.getDescripcion(),kCondicionesEspeciales.getFechaActualizacion(),
					kCondicionesEspeciales.getIpActualizacion(),kCondicionesEspeciales.getUsuarioActualizacion(),
					kCondicionesEspeciales.getFechaInsercion(),kCondicionesEspeciales.getIpInsercion(),kCondicionesEspeciales.getUsuarioInsercion());
		}
		initEmpresas();
	}



	private void initEmpresas(){
		List<KEmpresas> listEmpresas=userAdmin.getEmpresas();
		empresas=new SelectItem[listEmpresas.size()];
		int i=0;
		for (KEmpresas empresa : listEmpresas) {
			empresas[i]=new SelectItem(empresa.getCodigoInternoEmpresa(),empresa.getNroIdentificacion());
			i++;
		}
	}




	public void onSave(ActionEvent evnt){
		this.condicionesEspeciales.setKEmpresas(userAdmin.getEmpresa(idempresa));
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.condicionesEspeciales.getCodigoInternoCondicion()==0){
		this.condicionesEspeciales.setFechaInsercion(new Date());
		this.condicionesEspeciales.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.condicionesEspeciales.setUsuarioInsercion(1);
		}else{
		this.condicionesEspeciales.setFechaActualizacion(new Date());
		this.condicionesEspeciales.setIpActualizacion(request.getRemoteAddr());
		this.condicionesEspeciales.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(condicionesEspeciales);
		init();
		toggleModal(evnt);
		
	}




	public void setCondicionesEspeciales(
			KCondicionesEspeciales condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
	}




	public void setEmpresas(SelectItem[] empresas) {
		this.empresas = empresas;
	}




	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}

	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}
	
	
	
}
