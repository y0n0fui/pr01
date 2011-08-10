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

import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.CTipoCargo;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.admin.hibernate.KUsuariosEmpresas;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class UsuarioEmpresasWeb extends CRUDWeb{

	
	
	
	private KUsuariosEmpresas usuarioEmpresas;
	
	private SelectItem[] tipoCargos;
	
	private Integer tipoCargoid=0;
	
	private SelectItem[] empresas;
	
	private Integer empresasid=0;
	
	
	public UsuarioEmpresasWeb() {
		usuarioEmpresas=new KUsuariosEmpresas();
	}
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(UsuarioEmpresasWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;

	
	public void init(){
		dataTable=new DataTable();
		List<KUsuariosEmpresas> usuarioEmpresa=userAdmin.getUsuarioEmpresas();
		if(usuarioEmpresa!=null)
		for (KUsuariosEmpresas uEmpresa : usuarioEmpresa) {
			dataTable.addReg(uEmpresa.getCodigoInternoUsuario(),uEmpresa.getNombreFuncionario(),uEmpresa.getFechaActualizacion(),
					uEmpresa.getIpActualizacion(),uEmpresa.getUsuarioActualizacion(),
					uEmpresa.getFechaInsercion(),uEmpresa.getIpInsercion(),uEmpresa.getUsuarioInsercion());
		}
		initTipoCargo();
		initEmpresas();
	}
	
	
	private void initTipoCargo(){
		List<CTipoCargo> listTipoCargo=userAdmin.getTipoCargo();
		tipoCargos=new SelectItem[listTipoCargo.size()];
		int i=0;
		for (CTipoCargo cTipoCargo : listTipoCargo) {
			tipoCargos[i]=new SelectItem(cTipoCargo.getCodigoInternoCargo(),cTipoCargo.getDescripcion());
			i++;
		}
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
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.usuarioEmpresas.setCTipoCargo(userAdmin.getTipoCargo(tipoCargoid));
		this.usuarioEmpresas.setKEmpresas(userAdmin.getEmpresa(empresasid));
		if(this.usuarioEmpresas.getCodigoInternoUsuario()==0){
		this.usuarioEmpresas.setFechaInsercion(new Date());
		this.usuarioEmpresas.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.usuarioEmpresas.setUsuarioInsercion(1);
		}else{
		this.usuarioEmpresas.setFechaActualizacion(new Date());
		this.usuarioEmpresas.setIpActualizacion(request.getRemoteAddr());
		this.usuarioEmpresas.setUsuarioActualizacion(1);
		}
		userAdmin.save(usuarioEmpresas);
		init();
		toggleModal(evnt);
		
	}
	

	
	public void create(ActionEvent evnt){
		this.usuarioEmpresas=new KUsuariosEmpresas();
		toggleModal(evnt);
	}
	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.usuarioEmpresas=userAdmin.getUsuarioEmpresas((Integer)selectData[0]);
		tipoCargoid=this.usuarioEmpresas.getCTipoCargo().getCodigoInternoCargo();
		empresasid=this.usuarioEmpresas.getKEmpresas().getCodigoInternoEmpresa();
		toggleModal(null);
	}

	public void delete(ActionEvent evnt){
		this.usuarioEmpresas=userAdmin.getUsuarioEmpresas((Integer)selectData[0]);
		try{
		userAdmin.delete(this.usuarioEmpresas);
		this.usuarioEmpresas=new KUsuariosEmpresas();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("adminuserempresa.usuarioempresa.error.delete", context ));
		}
	}
	


	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}




	public KUsuariosEmpresas getUsuarioEmpresas() {
		return usuarioEmpresas;
	}


	public void setUsuarioEmpresas(KUsuariosEmpresas usuarioEmpresas) {
		this.usuarioEmpresas = usuarioEmpresas;
	}


	public SelectItem[] getTipoCargos() {
		return tipoCargos;
	}
	
	


	public void setTipoCargos(SelectItem[] tipoCargos) {
		this.tipoCargos = tipoCargos;
	}




	public Integer getTipoCargoid() {
		return tipoCargoid;
	}




	public void setTipoCargoid(Integer tipoCargoid) {
		this.tipoCargoid = tipoCargoid;
	}


	public SelectItem[] getEmpresas() {
		return empresas;
	}


	public void setEmpresas(SelectItem[] empresas) {
		this.empresas = empresas;
	}


	public Integer getEmpresasid() {
		return empresasid;
	}


	public void setEmpresasid(Integer empresasid) {
		this.empresasid = empresasid;
	}

	
	
}
