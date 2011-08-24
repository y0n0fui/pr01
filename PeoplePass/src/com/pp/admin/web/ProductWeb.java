package com.pp.admin.web;


import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IProductAdmin;

import com.pp.admin.hibernate.KProductos;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class ProductWeb extends CRUDWeb{

	
	
	private KProductos product;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(ProductWeb.class);
	
	@Autowired
	private IProductAdmin productAdmin;
	
	public ProductWeb() {
		product=new KProductos();
	}

	
	public void create(ActionEvent evnt){
		this.product=new KProductos();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		this.product=productAdmin.getProductos((Integer)selectData[0]);
		try{
		productAdmin.delete(this.product);
		this.product=new KProductos();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("adminproduct.product.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.product=productAdmin.getProductos((Integer)selectData[0]);
		toggleModal(null);
	}
	
	
	


	public void init(){
		dataTable=new DataTable();
		List<KProductos> products=productAdmin.getProducts();
		if(products!=null)
		for (KProductos product : products) {
			dataTable.addReg(product.getCodigoInternoProducto(),product.getDescripcionProducto(),product.getFechaActualizacion(),
					product.getIpActualizacion(),product.getUsuarioActualizacion(),
					product.getFechaInsercion(),product.getIpInsercion(),product.getUsuarioInsercion());
		}
	}


	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.product.getCodigoInternoProducto()==0){
		this.product.setFechaInsercion(new Date());
		this.product.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.product.setUsuarioInsercion(1);
		}else{
		this.product.setFechaActualizacion(new Date());
		this.product.setIpActualizacion(request.getRemoteAddr());
		this.product.setUsuarioActualizacion(1);
		}
		productAdmin.save(product);
		init();
		toggleModal(evnt);
		
	}


	public KProductos getProduct() {
		return product;
	}


	public void setProduct(KProductos product) {
		this.product = product;
	}


	public IProductAdmin getProductAdmin() {
		return productAdmin;
	}


	public void setProductAdmin(IProductAdmin productAdmin) {
		this.productAdmin = productAdmin;
	}

	
	
	
	
}
