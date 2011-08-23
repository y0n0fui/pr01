package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;



import com.pp.admin.hibernate.KProductos;
import com.pp.admin.hibernate.KProductosDeducciones;
import com.pp.admin.hibernate.KProductosDeduccionesId;

public interface IProductAdmin {

	public List<KProductos> getProducts();


	public void save(KProductos producto);

	
	public KProductos getProductos(int idProducto);

	public void delete(KProductos producto);
	

	public List<KProductosDeducciones> getProductsDeducciones();

	
	public void save(KProductosDeducciones productoDeduccion);
	
	
	public KProductosDeducciones getProductsDeducciones(KProductosDeduccionesId idProductoDeduccion);
	

	public void delete(KProductosDeducciones productoDeduccion);
}
