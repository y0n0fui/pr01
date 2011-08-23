package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;



import com.pp.admin.hibernate.KDefinicionProductos;
import com.pp.admin.hibernate.KProductos;

public interface IProductAdmin {

	
	
	public List<KDefinicionProductos> getDefProductsByEmpresa(int codEmpresa);
	
	
	public void save(KDefinicionProductos defProducto);

	
	public KDefinicionProductos getDefProduct(int idDefProduct);
	
	
	public void delete(KDefinicionProductos defProduct);
	
	
	public List<KProductos> getProducts();


	public void save(KProductos producto);

	
	public KProductos getProductos(int idProducto);

	public void delete(KProductos producto);
}
