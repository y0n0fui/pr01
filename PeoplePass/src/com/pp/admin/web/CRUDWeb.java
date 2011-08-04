package com.pp.admin.web;


import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.pp.admin.facade.ICityAdmin;
import com.pp.admin.hibernate.CCiudad;
import com.pp.admin.hibernate.KRoles;
import com.pp.util.DataTable;



public abstract class CRUDWeb {

	
	
	
	protected DataTable dataTable;
	
	protected Object selectData[];
	
	protected boolean rederPopup=false;
	
	protected boolean renderDeleteAlert=false;
	
	
	
	protected abstract void init();
	
	
	public DataTable getDataTable() {
		if(dataTable==null){
			init();
		}
		return dataTable;
	}
	
	
	


	

	public boolean isRederPopup() {
		return rederPopup;
	}

	public void setRederPopup(boolean rederPopup) {
		this.rederPopup = rederPopup;
	}

	
	public void toggleModal(ActionEvent evn){
		rederPopup=!rederPopup;
	}
	
	
	public void toggleModalDelete(ActionEvent evn){
		renderDeleteAlert=!renderDeleteAlert;
	}

	
	public void prepareToDelete(ActionEvent evn){
		selectData = (Object[])evn.getComponent().getAttributes().get("row");
		renderDeleteAlert=true;
	}

	public boolean isRenderDeleteAlert() {
		return renderDeleteAlert;
	}


	public void setRenderDeleteAlert(boolean renderDeleteAlert) {
		this.renderDeleteAlert = renderDeleteAlert;
	}


	public Object[] getSelectData() {
		return selectData;
	}


	public void setSelectData(Object[] selectData) {
		this.selectData = selectData;
	}
	
	
	
	
}
