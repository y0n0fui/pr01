package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.pp.admin.hibernate.KDefinicionProductos;
import com.pp.admin.hibernate.KProductos;


@Repository
@Transactional
public class ProductAdmin implements IProductAdmin {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KDefinicionProductos> getDefProductsByEmpresa(int codEmpresa) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select p from KDefinicionProductos p where p.KEmpresas.codigoInternoEmpresa=:codEmpresa");
		query.setParameter("codEmpresa", codEmpresa);
		List<KDefinicionProductos> result = (List<KDefinicionProductos>) query
				.list();
		return result;
	}

	@Transactional(readOnly = false)
	public void save(KDefinicionProductos defProducto) {
		sessionFactory.getCurrentSession().saveOrUpdate(defProducto);
	}

	@Transactional(readOnly = true)
	public KDefinicionProductos getDefProduct(int idDefProduct) {
		return (KDefinicionProductos) sessionFactory.getCurrentSession().get(
				KDefinicionProductos.class, idDefProduct);
	}

	public void delete(KDefinicionProductos defProduct) {
		sessionFactory.getCurrentSession().delete(defProduct);

	}
	
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
