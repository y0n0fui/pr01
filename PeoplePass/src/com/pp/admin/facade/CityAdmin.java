
package com.pp.admin.facade;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pp.admin.hibernate.CCiudad;




@Repository
@Transactional
public class CityAdmin implements ICityAdmin{
	
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional (readOnly=true)
	@SuppressWarnings("unchecked")
	public List<CCiudad> getCities(){
		Query query=sessionFactory.getCurrentSession().createQuery("select c from CCiudad c");
		List<CCiudad> result=(List<CCiudad>)query.list();
		return result;
	}
	
	public void save(CCiudad city){
		sessionFactory.getCurrentSession().save(city);
	}
}
