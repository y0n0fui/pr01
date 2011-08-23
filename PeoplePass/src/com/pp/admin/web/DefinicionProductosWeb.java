package com.pp.admin.web;


import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IParamsAdmin;
import com.pp.admin.facade.IProductAdmin;
import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.KBancosTerceros;
import com.pp.admin.hibernate.KDefinicionProductos;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.admin.hibernate.KProductos;

import com.pp.util.DataTable;
import com.pp.util.MessageUtil;



public class DefinicionProductosWeb extends CRUDWeb{

	
	
	private KDefinicionProductos defProduct;
	
	private SelectItem[]  listEmpresas;
	
	private Integer idEmpresa;
	
	private SelectItem[]  listProductos;
	
	private Integer idProducto;
	
	private SelectItem[]  listBancosTerceros;
	
	private Integer idBancosTerceros;
	
	
	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(DefinicionProductosWeb.class);
	
	@Autowired
	private IUserAdmin userAdmin;
	
	@Autowired
	private IProductAdmin productAdmin;
	
	@Autowired
	private IParamsAdmin paramsAdmin;
	
	public DefinicionProductosWeb() {
		defProduct=new KDefinicionProductos();
		listEmpresas= new SelectItem[0];
	}

	
	public void create(ActionEvent evnt){
		this.defProduct=new KDefinicionProductos();
		loadBancosTerceros();
		loadProductos();
		toggleModal(evnt);
	}
	
	
	public void delete(ActionEvent evnt){
		this.defProduct=productAdmin.getDefProduct((Integer)selectData[0]);
		try{
			productAdmin.delete(this.defProduct);
		this.defProduct=new KDefinicionProductos();
		this.selectData=null;
		loadDefinicionProductos(idEmpresa);
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("admindefproduct.defproduct.error.delete", context ));
		}
	}
	

	
	public void edit(ActionEvent evnt){
		selectData = (Object[])evnt.getComponent().getAttributes().get("row"); 
		this.defProduct=productAdmin.getDefProduct((Integer)selectData[0]);
		loadBancosTerceros();
		loadProductos();
		toggleModal(null);
	}
	
	public KDefinicionProductos getTipoIdentificacion() {
		return defProduct;
	}

	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}
	

	public void loadDefinicionProductos(int codEmpresa){
		dataTable=new DataTable();
		List<KDefinicionProductos> defpducts=productAdmin.getDefProductsByEmpresa(codEmpresa);
		if(defpducts!=null)
		for (KDefinicionProductos dp : defpducts) {
			dataTable.addReg(dp.getCodigoInternoDefinicion(),dp.getDescripcionProducto(),dp.getFechaActualizacion(),
					dp.getIpActualizacion(),dp.getUsuarioActualizacion(),
					dp.getFechaInsercion(),dp.getIpInsercion(),dp.getUsuarioInsercion());
		}
	}
	
	
	
	public void loadEmpresas(){
		List<KEmpresas> empresas=userAdmin.getEmpresas();
		listEmpresas=new SelectItem[empresas.size()];
		int i=0;
		for (KEmpresas e : empresas) {
			listEmpresas[i]=new SelectItem(e.getCodigoInternoEmpresa(), e.getNroIdentificacion());
			i++;
		}
	}
	
	public void loadProductos(){
		List<KProductos> products=productAdmin.getProducts();
		listProductos=new SelectItem[products.size()];
		int i=0;
		for (KProductos e : products) {
			listProductos[i]=new SelectItem(e.getCodigoInternoProducto(), e.getDescripcionProducto());
			i++;
		}
	}
	
	public void loadBancosTerceros(){
		List<KBancosTerceros> bancosTerceros=paramsAdmin.getBancosTerceros();
		listBancosTerceros=new SelectItem[bancosTerceros.size()];
		int i=0;
		for (KBancosTerceros e : bancosTerceros) {
			listBancosTerceros[i]=new SelectItem(e.getCodIntBkoTer(), e.getRazonSocial());
			i++;
		}
	}
	
	public void init(){
		
		
	}

		
	public DataTable getDataTable() {
		
		return dataTable;
	}
	
	public void loadDefinicionProducts(ValueChangeEvent valueChangeEvent){
		Integer newValue=(Integer)valueChangeEvent.getNewValue();
		loadDefinicionProductos(newValue);
	}
	
	public void onSave(ActionEvent evnt){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.defProduct.setKEmpresas(userAdmin.getEmpresa(idEmpresa));	
		this.defProduct.setKProductos(productAdmin.getProductos(idProducto));
		this.defProduct.setKBancosTerceros(paramsAdmin.getBancosTerceros(idBancosTerceros));
		if(this.defProduct.getCodigoInternoDefinicion()==0){
		this.defProduct.setFechaInsercion(new Date());
		this.defProduct.setIpInsercion(request.getRemoteAddr());
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.defProduct.setUsuarioInsercion(1);
		}else{
		
		this.defProduct.setFechaActualizacion(new Date());
		this.defProduct.setIpActualizacion(request.getRemoteAddr());
		this.defProduct.setUsuarioActualizacion(1);
		}
		productAdmin.save(defProduct);
		loadDefinicionProductos(idEmpresa);
		toggleModal(evnt);
		
	}


	public void setTipoIdentificacion(KDefinicionProductos defProduct) {
		this.defProduct = defProduct;
	}

	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}


	public KDefinicionProductos getDefProduct() {
		return defProduct;
	}


	public void setDefProduct(KDefinicionProductos defProduct) {
		this.defProduct = defProduct;
	}


	public SelectItem[] getListEmpresas() {
		if(listEmpresas==null||listEmpresas.length==0){
			loadEmpresas();
		}
		return listEmpresas;
	}


	public void setListEmpresas(SelectItem[] listEmpresas) {
		this.listEmpresas = listEmpresas;
	}


	public SelectItem[] getListProductos() {
		return listProductos;
	}


	public void setListProductos(SelectItem[] listProductos) {
		this.listProductos = listProductos;
	}


	public SelectItem[] getListBancosTerceros() {
		return listBancosTerceros;
	}


	public void setListBancosTerceros(SelectItem[] listBancosTerceros) {
		this.listBancosTerceros = listBancosTerceros;
	}


	public IProductAdmin getProductAdmin() {
		return productAdmin;
	}


	public void setProductAdmin(IProductAdmin productAdmin) {
		this.productAdmin = productAdmin;
	}


	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}


	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}


	public Integer getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public Integer getIdBancosTerceros() {
		return idBancosTerceros;
	}


	public void setIdBancosTerceros(Integer idBancosTerceros) {
		this.idBancosTerceros = idBancosTerceros;
	}


	
	
}
