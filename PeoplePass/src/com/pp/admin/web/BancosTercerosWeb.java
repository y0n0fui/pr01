package com.pp.admin.web;


import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IParamsAdmin;
import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.CTipoIdentificacion;
import com.pp.admin.hibernate.KBancosTerceros;
import com.pp.util.DataTable;



public class BancosTercerosWeb extends CRUDWeb{

	
	
	private KBancosTerceros bancosTerceros;
	
	private SelectItem[] tiposId;

	private Integer idTipo = 0;
	
	public BancosTercerosWeb() {
		bancosTerceros=new KBancosTerceros();
	}
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(BancosTercerosWeb.class);
	
	@Autowired
	private IParamsAdmin paramsAdmin;

	@Autowired
	private IUserAdmin userAdmin;

	
	public void init(){
		dataTable=new DataTable();
		List<KBancosTerceros> bancosTerceros=paramsAdmin.getBancosTerceros();
		if(bancosTerceros!=null)
		for (KBancosTerceros kbancoTercero : bancosTerceros) {
			dataTable.addReg(kbancoTercero.getCodIntBkoTer(),kbancoTercero.getRazonSocial(),kbancoTercero.getFechaActualizacion(),
					kbancoTercero.getIpActualizacion(),kbancoTercero.getUsuarioActualizacion(),
					kbancoTercero.getFechaInsercion(),kbancoTercero.getIpInsercion(),kbancoTercero.getUsuarioInsercion());
		}
		initTiposId();
	}
	
	private void initTiposId() {
		List<CTipoIdentificacion> listTipoId = userAdmin
				.getTipoIdentificacion();
		tiposId = new SelectItem[listTipoId.size()];
		int i = 0;
		for (CTipoIdentificacion cTipoIdentificacion : listTipoId) {
			tiposId[i] = new SelectItem(cTipoIdentificacion.getCodIntTipoId(),
					cTipoIdentificacion.getDescripcion());
			i++;
		}
	}

	
	
	
	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.bancosTerceros.setCTipoIdentificacion(userAdmin
				.getTipoIdentificacion(getIdTipo()));
		if(this.bancosTerceros.getCodIntBkoTer()==0){
		this.bancosTerceros.setFechaInsercion(new Date());
		this.bancosTerceros.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.bancosTerceros.setUsuarioInsercion(1);
		}else{
		this.bancosTerceros.setFechaActualizacion(new Date());
		this.bancosTerceros.setIpActualizacion(request.getRemoteAddr());
		this.bancosTerceros.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(bancosTerceros);
		init();
		toggleModal(evnt);
		
	}
	

	
	public void create(ActionEvent evnt){
		this.bancosTerceros=new KBancosTerceros();
		toggleModal(evnt);
	}
	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.bancosTerceros=paramsAdmin.getBancosTerceros((Integer)selectData[0]);
		idTipo = this.bancosTerceros.getCTipoIdentificacion().getCodIntTipoId();
		toggleModal(null);
	}

	public void delete(ActionEvent evnt){
		this.bancosTerceros=paramsAdmin.getBancosTerceros((Integer)selectData[0]);
		paramsAdmin.delete(this.bancosTerceros);
		this.bancosTerceros=new KBancosTerceros();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
	}
	


	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}

	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}




	public KBancosTerceros getBancosTerceros() {
		return bancosTerceros;
	}




	public void setBancosTerceros(KBancosTerceros bancosTerceros) {
		this.bancosTerceros = bancosTerceros;
	}




	public SelectItem[] getTiposId() {
		return tiposId;
	}




	public void setTiposId(SelectItem[] tiposId) {
		this.tiposId = tiposId;
	}




	public Integer getIdTipo() {
		return idTipo;
	}




	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}

	

	
}
