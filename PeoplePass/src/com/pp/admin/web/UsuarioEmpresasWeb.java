package com.pp.admin.web;


import java.util.ArrayList;
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

import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.pp.admin.facade.IParamsAdmin;
import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.CTipoCargo;

import com.pp.admin.hibernate.KEmpresas;
import com.pp.admin.hibernate.KRoles;
import com.pp.admin.hibernate.KUsuariosEmpresas;


import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class UsuarioEmpresasWeb extends CRUDWeb{

	
	
	
	private KUsuariosEmpresas usuarioEmpresas;
	
	private SelectItem[] tipoCargos;
	
	private Integer tipoCargoid=0;
	
	private SelectItem[] empresas;
	
	private Integer empresasid=0;
	
	private boolean renderPopupRole=false;
	
	private List<DataTableRole> listRoles;
	
	private List<KRoles> selectedRole;
	
	public List<KRoles> getSelectedRole() {
		return selectedRole;
	}


	public void setSelectedRole(List<KRoles> selectedRole) {
		this.selectedRole = selectedRole;
	}

	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(UsuarioEmpresasWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}


	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}


	public UsuarioEmpresasWeb() {
		usuarioEmpresas=new KUsuariosEmpresas();
	}

	
	public void create(ActionEvent evnt){
		this.usuarioEmpresas=new KUsuariosEmpresas();
		toggleModal(evnt);
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
	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.usuarioEmpresas=userAdmin.getUsuarioEmpresas((Integer)selectData[0]);
		tipoCargoid=this.usuarioEmpresas.getCTipoCargo().getCodigoInternoCargo();
		empresasid=this.usuarioEmpresas.getKEmpresas().getCodigoInternoEmpresa();
		toggleModal(null);
	}
	
	
	public void roles(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.usuarioEmpresas=userAdmin.getUsuarioEmpresas((Integer)selectData[0]);
		selectedRole=paramsAdmin.getRolesByUsuarioEmpresa(usuarioEmpresas.getCodigoInternoUsuario());
		a:
			for (DataTableRole dtr : listRoles) {
				for (KRoles select : selectedRole) {
					if(select.getCodigoInternoRole()==dtr.getCodigoInternoRole()){
						dtr.setSelected(true);
						continue a;
					}
				}
				dtr.setSelected(false);
			}
		toggleModalRole(null);
	}
	
	public void rowSelectionListener(RowSelectorEvent event) {
		selectedRole.clear();
		for (DataTableRole recursoDataTable : listRoles) {
			if(recursoDataTable.isSelected()){
				selectedRole.add(recursoDataTable);
			}
		} 
	}
	
	public List<DataTableRole> getRolesList(){
		if(listRoles==null){
			listRoles=new ArrayList<DataTableRole>();
			List<KRoles> list=userAdmin.getRoles();
			for (KRoles role : list) {
				listRoles.add(new DataTableRole(role.getCodigoInternoRole(),role.getDescripcion()));
			}
		}else{
			return listRoles;
		}
		
		return listRoles;
	}
	
	public SelectItem[] getEmpresas() {
		return empresas;
	}
	

	
	public Integer getEmpresasid() {
		return empresasid;
	}
	
	public Integer getTipoCargoid() {
		return tipoCargoid;
	}

	public SelectItem[] getTipoCargos() {
		return tipoCargos;
	}
	


	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}

	public KUsuariosEmpresas getUsuarioEmpresas() {
		return usuarioEmpresas;
	}




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


	private void initEmpresas(){
		List<KEmpresas> listEmpresas=userAdmin.getEmpresas();
		empresas=new SelectItem[listEmpresas.size()];
		int i=0;
		for (KEmpresas empresa : listEmpresas) {
			empresas[i]=new SelectItem(empresa.getCodigoInternoEmpresa(),empresa.getNroIdentificacion());
			i++;
		}
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


	public void onSaveRoles(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		paramsAdmin.save(selectedRole,usuarioEmpresas, 1, request.getRemoteAddr()); 
		toggleModalRole(evnt);
	}

	public void setEmpresas(SelectItem[] empresas) {
		this.empresas = empresas;
	}




	public void setEmpresasid(Integer empresasid) {
		this.empresasid = empresasid;
	}


	public void setTipoCargoid(Integer tipoCargoid) {
		this.tipoCargoid = tipoCargoid;
	}


	public void setTipoCargos(SelectItem[] tipoCargos) {
		this.tipoCargos = tipoCargos;
	}


	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}


	public void setUsuarioEmpresas(KUsuariosEmpresas usuarioEmpresas) {
		this.usuarioEmpresas = usuarioEmpresas;
	}


	public boolean isRenderPopupRole() {
		return renderPopupRole;
	}


	public void setRenderPopupRole(boolean renderPopupRole) {
		this.renderPopupRole = renderPopupRole;
	}

	public void toggleModalRole(ActionEvent evn){
		this.renderPopupRole=!renderPopupRole;
	}


	
	
	public List<DataTableRole> getListRoles() {
		return listRoles;
	}


	public void setListRoles(List<DataTableRole> listRoles) {
		this.listRoles = listRoles;
	}




	public class DataTableRole extends KRoles{
		private boolean selected;

		public boolean isSelected() {
			return selected;
		}

		public void setSelected(boolean selected) {
			this.selected = selected;
		}
		
		public DataTableRole(int cod,String desc){
			super(cod,desc);
		}
		
	}
	
}
