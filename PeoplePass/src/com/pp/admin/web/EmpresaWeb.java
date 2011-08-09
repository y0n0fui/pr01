package com.pp.admin.web;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;

import com.pp.admin.facade.IUserAdmin;
import com.pp.admin.hibernate.CTipoIdentificacion;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.util.DataTable;
import com.pp.util.MessageUtil;

public class EmpresaWeb extends CRUDWeb {

	private KEmpresas empresa;

	private SelectItem[] tiposId;

	private Integer idTipo = 0;

	public SelectItem[] getTiposId() {
		return tiposId;
	}

	public void setTiposId(SelectItem[] tiposId) {
		this.tiposId = tiposId;
	}

	public EmpresaWeb() {
		this.tiposId = new SelectItem[0];
		this.empresa = new KEmpresas();
		this.empresa.setTipoIdentificacion(new CTipoIdentificacion());
	}

	/**
	 * Herramienta logger
	 */
	static Logger logger = Logger.getLogger(EmpresaWeb.class);

	@Autowired
	private IUserAdmin userAdmin;

	public void init() {
		dataTable = new DataTable();
		List<KEmpresas> empresas = userAdmin.getEmpresas();
		if (empresas != null)
			for (KEmpresas bussines : empresas) {
				dataTable.addReg(bussines.getCodigoInternoEmpresa(),
						bussines.getNroIdentificacion(),
						bussines.getFechaActualizacion(),
						bussines.getIpActualizacion(),
						bussines.getUsuarioActualizacion(),
						bussines.getFechaInsercion(),
						bussines.getIpInsercion(),
						bussines.getUsuarioInsercion());
			}
		initTiposId();
	}

	private void initTiposId() {
		List<CTipoIdentificacion> listTipoId = userAdmin
				.getTipoIdentificacion();
		tiposId = new SelectItem[listTipoId.size()];
		int i = 0;
		for (CTipoIdentificacion cTipoIdentificacion : listTipoId) {
			tiposId[i] = new SelectItem(cTipoIdentificacion.getCodIntTipoId(),
					cTipoIdentificacion.getDescripcion());
			i++;
		}
	}

	public void onSave(ActionEvent evnt) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		this.empresa.setTipoIdentificacion(userAdmin
				.getTipoIdentificacion(getIdTipo()));
		if (this.empresa.getCodigoInternoEmpresa() == 0) {
			this.empresa.setFechaInsercion(new Date());
			this.empresa.setIpInsercion(request.getRemoteAddr());
			SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			this.empresa.setUsuarioInsercion(1);
		} else {
			this.empresa.setFechaActualizacion(new Date());
			this.empresa.setIpActualizacion(request.getRemoteAddr());
			this.empresa.setUsuarioActualizacion(1);
		}
		userAdmin.save(empresa);
		init();
		toggleModal(evnt);

	}

	public void create(ActionEvent evnt) {
		this.empresa = new KEmpresas();
		toggleModal(evnt);
	}

	public void edit(ActionEvent evnt) {
		selectData = (Object[]) evnt.getComponent().getAttributes().get("row");
		this.empresa = userAdmin.getEmpresa((Integer) selectData[0]);
		idTipo = this.empresa.getTipoIdentificacion().getCodIntTipoId();
		toggleModal(null);
	}

	public void delete(ActionEvent evnt) {
		this.empresa = userAdmin.getEmpresa((Integer) selectData[0]);
		try{
		userAdmin.delete(this.empresa);
		this.empresa = new KEmpresas();
		this.empresa.setTipoIdentificacion(new CTipoIdentificacion());
		this.selectData = null;
		init();
		toggleModalDelete(evnt);
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			logger.error("Error en constrain",e);	
        	FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),  
    				MessageUtil.getMessageStringFaces("adminempresa.empresa.error.delete", context ));
		}
		
	}

	public IUserAdmin getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(IUserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}

	public KEmpresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(KEmpresas empresa) {
		this.empresa = empresa;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

}
