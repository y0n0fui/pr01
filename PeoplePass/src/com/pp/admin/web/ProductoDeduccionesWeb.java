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
import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.KProductosDeducciones;
import com.pp.admin.hibernate.KProductosDeduccionesId;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class ProductoDeduccionesWeb extends CRUDWeb{

	
	
	private KProductosDeducciones productosDeducciones;
	
	
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(ProductoDeduccionesWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;
	
	@Autowired
	private IProductAdmin productAdmin;
	
	public ProductoDeduccionesWeb() {
		productosDeducciones=new KProductosDeducciones();
	}

	
	public void create(ActionEvent evnt){
		this.productosDeducciones=new KProductosDeducciones();
		toggleModal(evnt);
	}
	
	
	
	
	public void delete(ActionEvent evnt){
		KProductosDeduccionesId id = new KProductosDeduccionesId((Integer)selectData[0], (Integer)selectData[1]);
		this.productosDeducciones=productAdmin.getProductsDeducciones(id);
		try{
			productAdmin.delete(this.productosDeducciones);
		this.productosDeducciones=new KProductosDeducciones();
		this.selectData=null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("admintipoid.tipoid.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		KProductosDeduccionesId id = new KProductosDeduccionesId((Integer)selectData[0], (Integer)selectData[1]);
		this.productosDeducciones=productAdmin.getProductsDeducciones(id);
		toggleModal(null);
	}
	
	public KProductosDeducciones getTipoIdentificacion() {
		return productosDeducciones;
	}

	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}
	


	public void init(){
		dataTable=new DataTable();
		List<KProductosDeducciones> productosDeducciones=productAdmin.getProductsDeducciones();
		if(productosDeducciones!=null)
		for (KProductosDeducciones prodDed : productosDeducciones) {
			dataTable.addReg(prodDed.getKDefinicionProductos().getCodigoInternoDefinicion(),
					prodDed.getKDefinicionDeducciones().getCodigoInternoDeduccion(),
					prodDed.getKDefinicionProductos().getDescripcionProducto(),
					prodDed.getKDefinicionDeducciones().getDescripcion(),prodDed.getFechaActualizacion(),
					prodDed.getIpActualizacion(),prodDed.getUsuarioActualizacion(),
					prodDed.getFechaInsercion(),prodDed.getIpInsercion(),prodDed.getUsuarioInsercion());
		}
	}

	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(this.productosDeducciones.getId().getCodigoInternoDeduccion()==0&&this.productosDeducciones.getId().getCodigoInternoDefinicion()==0){
		this.productosDeducciones.setFechaInsercion(new Date());
		this.productosDeducciones.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.productosDeducciones.setUsuarioInsercion(1);
		}else{
		this.productosDeducciones.setFechaActualizacion(new Date());
		this.productosDeducciones.setIpActualizacion(request.getRemoteAddr());
		this.productosDeducciones.setUsuarioActualizacion(1);
		}
		productAdmin.save(productosDeducciones);
		init();
		toggleModal(evnt);
		
	}


	public KProductosDeducciones getProductosDeducciones() {
		return productosDeducciones;
	}


	public void setProductosDeducciones(KProductosDeducciones productosDeducciones) {
		this.productosDeducciones = productosDeducciones;
	}


	public IProductAdmin getProductAdmin() {
		return productAdmin;
	}


	public void setProductAdmin(IProductAdmin productAdmin) {
		this.productAdmin = productAdmin;
	}


	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}

	
	
}
