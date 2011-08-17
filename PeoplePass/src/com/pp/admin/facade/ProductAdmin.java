package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import com.pp.admin.hibernate.KProductos;

public class ProductAdmin implements IProductAdmin {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KProductos> getProducts() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select p from KProductos p");
		List<KProductos> result = (List<KProductos>) query
				.list();
		return result;
	}

	@Transactional(readOnly = false)
	public void save(KProductos producto) {
		sessionFactory.getCurrentSession().saveOrUpdate(producto);
	}

	@Transactional(readOnly = true)
	public KProductos getProductos(int idProducto) {
		return (KProductos) sessionFactory.getCurrentSession().get(
				KProductos.class, idProducto);
	}

	public void delete(KProductos producto) {
		sessionFactory.getCurrentSession().delete(producto);

	}
}
