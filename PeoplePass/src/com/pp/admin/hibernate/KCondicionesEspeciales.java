package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * KCondicionesEspeciales generated by hbm2java
 */
public class KCondicionesEspeciales implements java.io.Serializable {

	private int codigoInternoCondicion;
	private KEmpresas KEmpresas;
	private String descripcion;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;

	public KCondicionesEspeciales() {
	}

	public KCondicionesEspeciales(int codigoInternoCondicion,
			KEmpresas KEmpresas, String descripcion) {
		this.codigoInternoCondicion = codigoInternoCondicion;
		this.KEmpresas = KEmpresas;
		this.descripcion = descripcion;
	}

	public KCondicionesEspeciales(int codigoInternoCondicion,
			KEmpresas KEmpresas, String descripcion, Date fechaInsercion,
			Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion) {
		this.codigoInternoCondicion = codigoInternoCondicion;
		this.KEmpresas = KEmpresas;
		this.descripcion = descripcion;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
	}

	public int getCodigoInternoCondicion() {
		return this.codigoInternoCondicion;
	}

	public void setCodigoInternoCondicion(int codigoInternoCondicion) {
		this.codigoInternoCondicion = codigoInternoCondicion;
	}

	public KEmpresas getKEmpresas() {
		return this.KEmpresas;
	}

	public void setKEmpresas(KEmpresas KEmpresas) {
		this.KEmpresas = KEmpresas;
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

}
