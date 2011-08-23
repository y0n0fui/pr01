package com.pp.admin.web;


import javax.faces.event.ActionEvent;

import com.pp.util.DataTable;



public abstract class CRUDWeb {

	
	
	
	protected DataTable dataTable;
	
	protected Object selectData[];
	
	protected boolean rederPopup=false;
	
	
	
	
	protected boolean renderDeleteAlert=false;
	
	
	
	public DataTable getDataTable() {
		if(dataTable==null){
			init();
		}
		return dataTable;
	}
	
	
	public Object[] getSelectData() {
		return selectData;
	}
	
	
	


	

	protected abstract void init();

	public boolean isRederPopup() {
		return rederPopup;
	}

	
	public boolean isRenderDeleteAlert() {
		return renderDeleteAlert;
	}
	
	
	public void prepareToDelete(ActionEvent evn){
		selectData = (Object[])evn.getComponent().getAttributes().get("row");
		renderDeleteAlert=true;
	}

	
	public void setRederPopup(boolean rederPopup) {
		this.rederPopup = rederPopup;
	}

	public void setRenderDeleteAlert(boolean renderDeleteAlert) {
		this.renderDeleteAlert = renderDeleteAlert;
	}


	public void setSelectData(Object[] selectData) {
		this.selectData = selectData;
	}


	public void toggleModal(ActionEvent evn){
		rederPopup=!rederPopup;
	}


	public void toggleModalDelete(ActionEvent evn){
		renderDeleteAlert=!renderDeleteAlert;
	}
	
	
	
	
}
