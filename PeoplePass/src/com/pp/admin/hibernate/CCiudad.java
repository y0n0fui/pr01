package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CCiudad generated by hbm2java
 */
public class CCiudad implements java.io.Serializable {

	private int codigoInternoCiudad;
	private String descripcion;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;
	private Set KDireccioneses = new HashSet(0);

	public CCiudad() {
	}

	public CCiudad(int codigoInternoCiudad, String descripcion) {
		this.codigoInternoCiudad = codigoInternoCiudad;
		this.descripcion = descripcion;
	}

	public CCiudad(int codigoInternoCiudad, String descripcion,
			Date fechaInsercion, Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion, Set KDireccioneses) {
		this.codigoInternoCiudad = codigoInternoCiudad;
		this.descripcion = descripcion;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
		this.KDireccioneses = KDireccioneses;
	}

	public int getCodigoInternoCiudad() {
		return this.codigoInternoCiudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public Date getFechaInsercion() {
		return this.fechaInsercion;
	}

	public String getIpActualizacion() {
		return this.ipActualizacion;
	}

	public String getIpInsercion() {
		return this.ipInsercion;
	}

	public Set getKDireccioneses() {
		return this.KDireccioneses;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public Integer getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public void setCodigoInternoCiudad(int codigoInternoCiudad) {
		this.codigoInternoCiudad = codigoInternoCiudad;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public void setFechaInsercion(Date fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}

	public void setIpActualizacion(String ipActualizacion) {
		this.ipActualizacion = ipActualizacion;
	}

	public void setIpInsercion(String ipInsercion) {
		this.ipInsercion = ipInsercion;
	}

	public void setKDireccioneses(Set KDireccioneses) {
		this.KDireccioneses = KDireccioneses;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public void setUsuarioInsercion(Integer usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

}
