package com.pp.admin.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.pp.admin.facade.IParamsAdmin;
import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.KDescripcionRecursos;
import com.pp.admin.hibernate.KRoles;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class RoleWeb extends CRUDWeb{

	
	
	private KRoles role;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(RoleWeb.class);
	
	private List<KDescripcionRecursos> selectedResources;
	
	private List<RecursoDataTable> listResources;
	
	
	@Autowired
	private IUserAdmin userAdmin;
	
	@Autowired
	private IParamsAdmin paramsAdmin;

	protected boolean renderPopupRecursos;
	
	public RoleWeb() {
		role=new KRoles();
		selectedResources=new ArrayList<KDescripcionRecursos>();
	}

	
	public void create(ActionEvent evnt){
		this.role=new KRoles();
		toggleModal(evnt);
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
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.role=userAdmin.getRoles((Integer)selectData[0]);
		toggleModal(null);
	}
	
	
	public void recursos(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.role=userAdmin.getRoles((Integer)selectData[0]);
		selectedResources=paramsAdmin.getRecursosByRole(this.role.getCodigoInternoRole());
		a:
		for (RecursoDataTable rdt : listResources) {
			for (KDescripcionRecursos select : selectedResources) {
				if(select.getCodigoInternoRecurso()==rdt.getCodigoInternoRecurso()){
					rdt.setSelected(true);
					continue a;
				}
			}
			rdt.setSelected(false);
		}
		toggleModalRecursos(null);
	}
	
	public List<RecursoDataTable> getDescripcionRecursos(){
		if(listResources==null){
			listResources=new ArrayList<RoleWeb.RecursoDataTable>();
			List<KDescripcionRecursos> list=paramsAdmin.getDescripcionRecursos();
			for (KDescripcionRecursos kDescripcionRecursos : list) {
				listResources.add(new RecursoDataTable(kDescripcionRecursos));
			}
		}else{
			return listResources;
		}
		
		return listResources;
	}
	
	
	public KRoles getRole() {
		return role;
	}

	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}
	


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

	
	public void onSaveResources(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		paramsAdmin.save(selectedResources,role, 1, request.getRemoteAddr()); 
		toggleModalRecursos(evnt);
	}
	
	
	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}


	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}


	public void rowSelectionListener(RowSelectorEvent event) {
		selectedResources.clear();
		for (RecursoDataTable recursoDataTable : listResources) {
			if(recursoDataTable.isSelected()){
				selectedResources.add(recursoDataTable);
			}
		} 
	}

	public void setRole(KRoles role) {
		this.role = role;
	}


	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}

	public void toggleModalRecursos(ActionEvent evn){
		renderPopupRecursos=!renderPopupRecursos;
	}


	public boolean isRenderPopupRecursos() {
		return renderPopupRecursos;
	}


	public void setRenderPopupRecursos(boolean renderPopupRecursos) {
		this.renderPopupRecursos = renderPopupRecursos;
	}
	
	public List<KDescripcionRecursos> getSelectedResources() {
		return selectedResources;
	}


	public void setSelectedResources(List<KDescripcionRecursos> selectedResources) {
		this.selectedResources = selectedResources;
	}




	public class RecursoDataTable extends KDescripcionRecursos{
		
		private boolean selected=false;
		
		
		public RecursoDataTable(){
			super();
		}
		
		
		public RecursoDataTable(KDescripcionRecursos recurso){
			super(recurso.getCodigoInternoRecurso(),recurso.getDescripcion());
		}


		public boolean isSelected() {
			return selected;
		}


		public void setSelected(boolean selected) {
			this.selected = selected;
		}
		
		
	}
	
}
