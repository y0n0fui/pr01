package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * KRolesEmpresas generated by hbm2java
 */
public class KRolesEmpresas implements java.io.Serializable {

	private KRolesEmpresasId id;
	private KEmpresas KEmpresas;
	private KRoles KRoles;
	private KUsuariosEmpresas KUsuariosEmpresas;
	private Date fechaInsercion;
	private BigDecimal usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;

	public KRolesEmpresas() {
	}

	public KRolesEmpresas(KRolesEmpresasId id, KEmpresas KEmpresas,
			KRoles KRoles, KUsuariosEmpresas KUsuariosEmpresas) {
		this.id = id;
		this.KEmpresas = KEmpresas;
		this.KRoles = KRoles;
		this.KUsuariosEmpresas = KUsuariosEmpresas;
	}

	public KRolesEmpresas(KRolesEmpresasId id, KEmpresas KEmpresas,
			KRoles KRoles, KUsuariosEmpresas KUsuariosEmpresas,
			Date fechaInsercion, BigDecimal usuarioInsercion,
			String ipInsercion, Date fechaActualizacion,
			Integer usuarioActualizacion, String ipActualizacion) {
		this.id = id;
		this.KEmpresas = KEmpresas;
		this.KRoles = KRoles;
		this.KUsuariosEmpresas = KUsuariosEmpresas;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public Date getFechaInsercion() {
		return this.fechaInsercion;
	}

	public KRolesEmpresasId getId() {
		return this.id;
	}

	public String getIpActualizacion() {
		return this.ipActualizacion;
	}

	public String getIpInsercion() {
		return this.ipInsercion;
	}

	public KEmpresas getKEmpresas() {
		return this.KEmpresas;
	}

	public KRoles getKRoles() {
		return this.KRoles;
	}

	public KUsuariosEmpresas getKUsuariosEmpresas() {
		return this.KUsuariosEmpresas;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public BigDecimal getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public void setFechaInsercion(Date fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}

	public void setId(KRolesEmpresasId id) {
		this.id = id;
	}

	public void setIpActualizacion(String ipActualizacion) {
		this.ipActualizacion = ipActualizacion;
	}

	public void setIpInsercion(String ipInsercion) {
		this.ipInsercion = ipInsercion;
	}

	public void setKEmpresas(KEmpresas KEmpresas) {
		this.KEmpresas = KEmpresas;
	}

	public void setKRoles(KRoles KRoles) {
		this.KRoles = KRoles;
	}

	public void setKUsuariosEmpresas(KUsuariosEmpresas KUsuariosEmpresas) {
		this.KUsuariosEmpresas = KUsuariosEmpresas;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public void setUsuarioInsercion(BigDecimal usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

}
