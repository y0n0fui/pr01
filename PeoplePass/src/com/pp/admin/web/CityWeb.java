package com.pp.admin.web;


import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pp.admin.facade.ICityAdmin;
import com.pp.admin.hibernate.CCiudad;
import com.pp.util.DataTable;



public class CityWeb extends CRUDWeb{

	
	
	private CCiudad ciudad;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(CityWeb.class);
	
	@Autowired
	private ICityAdmin cityAdmin;
	
	public CityWeb() {
		ciudad=new CCiudad();
	}

	
	public void create(ActionEvent evnt){
		this.ciudad=new CCiudad();
		toggleModal(evnt);
	}
	
	
	
	
	public ICityAdmin getCityAdmin() {
		return cityAdmin;
	}
	
	
	public CCiudad getCiudad() {
		return ciudad;
	}
	
	public void init(){
		dataTable=new DataTable();
		List<CCiudad> cities=cityAdmin.getCities();
		if(cities!=null)
		for (CCiudad cCiudad : cities) {
			dataTable.addReg(cCiudad.getCodigoInternoCiudad(),cCiudad.getDescripcion(),cCiudad.getFechaActualizacion(),
					cCiudad.getIpActualizacion(),cCiudad.getUsuarioActualizacion(),
					cCiudad.getFechaInsercion(),cCiudad.getIpInsercion(),cCiudad.getUsuarioInsercion());
		}
	}


	public void onSave(ActionEvent evnt){
		if(this.ciudad.getCodigoInternoCiudad()!=-1){
		this.ciudad.setFechaInsercion(new Date());
		this.ciudad.setIpInsercion("100.100.100");
		this.ciudad.setUsuarioInsercion(1);
		}else{
		this.ciudad.setFechaActualizacion(new Date());
		this.ciudad.setIpActualizacion("100.100.100");
		this.ciudad.setUsuarioActualizacion(1);
		}
		cityAdmin.save(ciudad);
		init();
		toggleModal(evnt);
		
	}


	


	public void setCityAdmin(ICityAdmin cityAdmin) {
		this.cityAdmin = cityAdmin;
	}


	public void setCiudad(CCiudad ciudad) {
		this.ciudad = ciudad;
	}

	
	
	
	
	
}
