package com.pp.admin.web;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.admin.hibernate.KUsuariosEmpresas;
import com.pp.admin.hibernate.KUsuariosFunciones;
import com.pp.util.DataTable;



public class UsuarioFuncionesWeb extends CRUDWeb{

	
	
	
	private KUsuariosFunciones usuarioFunciones;
	

	
	private SelectItem[] empresas;
	
	private Integer empresasid=0;
	
	private SelectItem[] usuariosEmpresas;
	
	private Integer usuariosEmpresasid=0;	
	
	public UsuarioFuncionesWeb() {
		usuarioFunciones=new KUsuariosFunciones();
		usuarioFunciones.setUsuariosEmpresas(new KUsuariosEmpresas());
		
		
	}
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(UsuarioFuncionesWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;

	
	public void init(){
		dataTable=new DataTable();
		List<KUsuariosFunciones> usuarioFunciones=userAdmin.getUsuariosFunciones();
		if(usuarioFunciones!=null)
		for (KUsuariosFunciones uFunciones : usuarioFunciones) {
			dataTable.addReg(uFunciones.getCodigoInternoUsuario(),uFunciones.getUsuariosEmpresas().getNombreFuncionario(),uFunciones.getFechaActualizacion(),
					uFunciones.getIpActualizacion(),uFunciones.getUsuarioActualizacion(),
					uFunciones.getFechaInsercion(),uFunciones.getIpInsercion(),uFunciones.getUsuarioInsercion());
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
	
	
	
	public void loadUserEmpresas(ValueChangeEvent valueChangeEvent){
		Integer newValue=(Integer)valueChangeEvent.getNewValue();
		List<KUsuariosEmpresas> listUsuarioEmpresas=userAdmin.getUsuarioEmpresasByEmpresa(newValue);
		usuariosEmpresas=new SelectItem[listUsuarioEmpresas.size()];
		int i=0;
		for (KUsuariosEmpresas kUsuariosEmpresas : listUsuarioEmpresas) {
 			usuariosEmpresas[i]=new SelectItem(kUsuariosEmpresas.getCodigoInternoUsuario(), kUsuariosEmpresas.getNombreFuncionario());
 			i++;
		}
	}
	 
	
	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.usuarioFunciones.setUsuariosEmpresas(userAdmin.getUsuarioEmpresas(usuariosEmpresasid));
		if(this.usuarioFunciones.getCodigoInternoUsuario()==0){
		this.usuarioFunciones.setFechaInsercion(new Date());
		this.usuarioFunciones.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.usuarioFunciones.setUsuarioInsercion(new BigDecimal(1));
		}else{
		this.usuarioFunciones.setFechaActualizacion(new Date());
		this.usuarioFunciones.setIpActualizacion(request.getRemoteAddr());
		this.usuarioFunciones.setUsuarioActualizacion(1);
		}
		userAdmin.save(usuarioFunciones);
		init();
		toggleModal(evnt);
		
	}
	

	
	public void create(ActionEvent evnt){
		this.usuarioFunciones=new KUsuariosFunciones();
		toggleModal(evnt);
	}
	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.usuarioFunciones=userAdmin.getUsuarioFunciones((Integer)selectData[0]);
		empresasid=this.usuarioFunciones.getUsuariosEmpresas().getKEmpresas().getCodigoInternoEmpresa();
		usuariosEmpresasid=this.usuarioFunciones.getUsuariosEmpresas().getCodigoInternoUsuario();
		toggleModal(null);
	}

	public void delete(ActionEvent evnt){
		this.usuarioFunciones=userAdmin.getUsuarioFunciones((Integer)selectData[0]);
		userAdmin.delete(this.usuarioFunciones);
		this.usuarioFunciones=new KUsuariosFunciones();
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




	public KUsuariosFunciones getUsuarioEmpresas() {
		return usuarioFunciones;
	}


	public void setUsuarioEmpresas(KUsuariosFunciones usuarioFunciones) {
		this.usuarioFunciones = usuarioFunciones;
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




	public KUsuariosFunciones getUsuarioFunciones() {
		return usuarioFunciones;
	}




	public void setUsuarioFunciones(KUsuariosFunciones usuarioFunciones) {
		this.usuarioFunciones = usuarioFunciones;
	}




	public SelectItem[] getUsuariosEmpresas() {
		return usuariosEmpresas;
	}




	public void setUsuariosEmpresas(SelectItem[] usuariosEmpresas) {
		this.usuariosEmpresas = usuariosEmpresas;
	}




	public Integer getUsuariosEmpresasid() {
		return usuariosEmpresasid;
	}




	public void setUsuariosEmpresasid(Integer usuariosEmpresasid) {
		this.usuariosEmpresasid = usuariosEmpresasid;
	}




	
	
}
