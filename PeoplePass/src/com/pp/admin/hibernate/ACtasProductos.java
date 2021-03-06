package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * ACtasProductos generated by hbm2java
 */
public class ACtasProductos implements java.io.Serializable {

	private ACtasProductosId id;
	private ACuentasContables ACuentasContables;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;

	public ACtasProductos() {
	}

	public ACtasProductos(ACtasProductosId id,
			ACuentasContables ACuentasContables) {
		this.id = id;
		this.ACuentasContables = ACuentasContables;
	}

	public ACtasProductos(ACtasProductosId id,
			ACuentasContables ACuentasContables, Date fechaInsercion,
			Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion) {
		this.id = id;
		this.ACuentasContables = ACuentasContables;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
	}

	public ACuentasContables getACuentasContables() {
		return this.ACuentasContables;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public Date getFechaInsercion() {
		return this.fechaInsercion;
	}

	public ACtasProductosId getId() {
		return this.id;
	}

	public String getIpActualizacion() {
		return this.ipActualizacion;
	}

	public String getIpInsercion() {
		return this.ipInsercion;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public Integer getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public void setACuentasContables(ACuentasContables ACuentasContables) {
		this.ACuentasContables = ACuentasContables;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public void setFechaInsercion(Date fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}

	public void setId(ACtasProductosId id) {
		this.id = id;
	}

	public void setIpActualizacion(String ipActualizacion) {
		this.ipActualizacion = ipActualizacion;
	}

	public void setIpInsercion(String ipInsercion) {
		this.ipInsercion = ipInsercion;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public void setUsuarioInsercion(Integer usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

}
