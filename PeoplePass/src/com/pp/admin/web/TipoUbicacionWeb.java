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

import com.pp.admin.facade.IParamsAdmin;

import com.pp.admin.hibernate.CTipoUbicacion;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;

/**
 * 
 * @author Fredy Sierra
 *
 */
public class TipoUbicacionWeb extends CRUDWeb {

	private CTipoUbicacion tipoUbicacion;

	public TipoUbicacionWeb() {
		tipoUbicacion = new CTipoUbicacion();
	}

	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(TipoUbicacionWeb.class);

	@Autowired
	private IParamsAdmin paramsAdmin;

	public void init() {
		dataTable = new DataTable();
		List<CTipoUbicacion> roles = paramsAdmin.getTipoUbicacion();
		if (roles != null)
			for (CTipoUbicacion kRole : roles) {
				dataTable.addReg(kRole.getCodigoInternoUbicacion(),
						kRole.getDescripcion(), kRole.getFechaActualizacion(),
						kRole.getIpActualizacion(),
						kRole.getUsuarioActualizacion(),
						kRole.getFechaInsercion(), kRole.getIpInsercion(),
						kRole.getUsuarioInsercion());
			}
	}

	public void onSave(ActionEvent evnt) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if (this.tipoUbicacion.getCodigoInternoUbicacion() == 0) {
			this.tipoUbicacion.setFechaInsercion(new Date());
			this.tipoUbicacion.setIpInsercion(request.getRemoteAddr());
			SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			this.tipoUbicacion.setUsuarioInsercion(1);
		} else {
			this.tipoUbicacion.setFechaActualizacion(new Date());
			this.tipoUbicacion.setIpActualizacion(request.getRemoteAddr());
			this.tipoUbicacion.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(tipoUbicacion);
		init();
		toggleModal(evnt);

	}

	public void create(ActionEvent evnt) {
		this.tipoUbicacion = new CTipoUbicacion();
		toggleModal(evnt);
	}

	public void edit(ActionEvent evnt) {
		selectData = (Object[]) evnt.getComponent().getAttributes().get("row");
		this.tipoUbicacion = paramsAdmin
				.getTipoUbicacion((Integer) selectData[0]);
		toggleModal(null);
	}

	public void delete(ActionEvent evnt) {
		this.tipoUbicacion = paramsAdmin
				.getTipoUbicacion((Integer) selectData[0]);
		try{
		paramsAdmin.delete(this.tipoUbicacion);
		this.tipoUbicacion = new CTipoUbicacion();
		this.selectData = null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("admintipoubicacion.tipoubic.error.delete", context ));
		}
	}

	public CTipoUbicacion getTipoUbicacion() {
		return tipoUbicacion;
	}

	public void setTipoUbicacion(CTipoUbicacion tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}

	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}

	public CTipoUbicacion getTipoCargo() {
		return tipoUbicacion;
	}

	public void setTipoCargo(CTipoUbicacion tipoCargo) {
		this.tipoUbicacion = tipoCargo;
	}

}
