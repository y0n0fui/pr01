
package com.pp.admin.facade;

import java.util.List;

import com.pp.admin.hibernate.CCiudad;


public interface ICityAdmin {
	
	
	public List<CCiudad> getCities();
	
	public void save(CCiudad city);
}
