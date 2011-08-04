package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CTipoCargo generated by hbm2java
 */
public class CTipoCargo implements java.io.Serializable {

	private int codigoInternoCargo;
	private String descripcion;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;
	private Set KUsuariosEmpresases = new HashSet(0);

	public CTipoCargo() {
	}

	public CTipoCargo(int codigoInternoCargo, String descripcion) {
		this.codigoInternoCargo = codigoInternoCargo;
		this.descripcion = descripcion;
	}

	public CTipoCargo(int codigoInternoCargo, String descripcion,
			Date fechaInsercion, Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion, Set KUsuariosEmpresases) {
		this.codigoInternoCargo = codigoInternoCargo;
		this.descripcion = descripcion;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
		this.KUsuariosEmpresases = KUsuariosEmpresases;
	}

	public int getCodigoInternoCargo() {
		return this.codigoInternoCargo;
	}

	public void setCodigoInternoCargo(int codigoInternoCargo) {
		this.codigoInternoCargo = codigoInternoCargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInsercion() {
		return this.fechaInsercion;
	}

	public void setFechaInsercion(Date fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}

	public Integer getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public void setUsuarioInsercion(Integer usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

	public String getIpInsercion() {
		return this.ipInsercion;
	}

	public void setIpInsercion(String ipInsercion) {
		this.ipInsercion = ipInsercion;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public String getIpActualizacion() {
		return this.ipActualizacion;
	}

	public void setIpActualizacion(String ipActualizacion) {
		this.ipActualizacion = ipActualizacion;
	}

	public Set getKUsuariosEmpresases() {
		return this.KUsuariosEmpresases;
	}

	public void setKUsuariosEmpresases(Set KUsuariosEmpresases) {
		this.KUsuariosEmpresases = KUsuariosEmpresases;
	}

}
