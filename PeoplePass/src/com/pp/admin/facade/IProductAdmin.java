package com.pp.admin.facade;

import java.util.List;



import com.pp.admin.hibernate.KProductos;

public interface IProductAdmin {

	public List<KProductos> getProducts();


	public void save(KProductos producto);

	
	public KProductos getProductos(int idProducto);

	public void delete(KProductos producto);
}
