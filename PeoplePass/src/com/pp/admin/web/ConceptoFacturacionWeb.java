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
import com.pp.admin.hibernate.KConceptosFacturacion;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;

public class ConceptoFacturacionWeb extends CRUDWeb {

	private KConceptosFacturacion conceptoFacturacion;

	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(ConceptoFacturacionWeb.class);

	@Autowired
	private IParamsAdmin paramsAdmin;

	public ConceptoFacturacionWeb() {
		conceptoFacturacion = new KConceptosFacturacion();
	}

	public void create(ActionEvent evnt) {
		this.conceptoFacturacion = new KConceptosFacturacion();
		toggleModal(evnt);
	}

	public void delete(ActionEvent evnt) {
		this.conceptoFacturacion = paramsAdmin
				.getConceptoFacturacion((Integer) selectData[0]);
		try{
		paramsAdmin.delete(this.conceptoFacturacion);
		this.conceptoFacturacion = new KConceptosFacturacion();
		this.selectData = null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("adminconcepfacturacion.concepfac.error.delete", context ));
		}
	}

	public void edit(ActionEvent evnt) {
		selectData = (Object[]) evnt.getComponent().getAttributes().get("row");
		this.conceptoFacturacion = paramsAdmin
				.getConceptoFacturacion((Integer) selectData[0]);
		toggleModal(null);
	}

	public KConceptosFacturacion getConceptoFacturacion() {
		return conceptoFacturacion;
	}

	public IParamsAdmin getParamsAdmin() {
		return paramsAdmin;
	}

	public void init() {
		dataTable = new DataTable();
		List<KConceptosFacturacion> roles = paramsAdmin
				.getConceptoFacturacion();
		if (roles != null)
			for (KConceptosFacturacion kRole : roles) {
				dataTable.addReg(kRole.getCodIntConcepto(),
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
		if (this.conceptoFacturacion.getCodIntConcepto() == 0) {
			this.conceptoFacturacion.setFechaInsercion(new Date());
			this.conceptoFacturacion.setIpInsercion(request.getRemoteAddr());
			SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			this.conceptoFacturacion.setUsuarioInsercion(1);
		} else {
			this.conceptoFacturacion.setFechaActualizacion(new Date());
			this.conceptoFacturacion
					.setIpActualizacion(request.getRemoteAddr());
			this.conceptoFacturacion.setUsuarioActualizacion(1);
		}
		paramsAdmin.save(conceptoFacturacion);
		init();
		toggleModal(evnt);

	}

	public void setConceptoFacturacion(KConceptosFacturacion conceptoFacturacion) {
		this.conceptoFacturacion = conceptoFacturacion;
	}

	public void setParamsAdmin(IParamsAdmin paramsAdmin) {
		this.paramsAdmin = paramsAdmin;
	}

}
