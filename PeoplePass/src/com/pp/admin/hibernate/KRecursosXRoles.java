package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * KRecursosXRoles generated by hbm2java
 */
public class KRecursosXRoles implements java.io.Serializable {

	private KRecursosXRolesId id;
	private KRoles KRoles;
	private KDescripcionRecursos KDescripcionRecursos;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;

	public KRecursosXRoles() {
	}

	public KRecursosXRoles(KRecursosXRolesId id, KRoles KRoles,
			KDescripcionRecursos KDescripcionRecursos) {
		this.id = id;
		this.KRoles = KRoles;
		this.KDescripcionRecursos = KDescripcionRecursos;
	}

	public KRecursosXRoles(KRecursosXRolesId id, KRoles KRoles,
			KDescripcionRecursos KDescripcionRecursos, Date fechaInsercion,
			Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion) {
		this.id = id;
		this.KRoles = KRoles;
		this.KDescripcionRecursos = KDescripcionRecursos;
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

	public KRecursosXRolesId getId() {
		return this.id;
	}

	public String getIpActualizacion() {
		return this.ipActualizacion;
	}

	public String getIpInsercion() {
		return this.ipInsercion;
	}

	public KDescripcionRecursos getKDescripcionRecursos() {
		return this.KDescripcionRecursos;
	}

	public KRoles getKRoles() {
		return this.KRoles;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public Integer getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public void setFechaInsercion(Date fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}

	public void setId(KRecursosXRolesId id) {
		this.id = id;
	}

	public void setIpActualizacion(String ipActualizacion) {
		this.ipActualizacion = ipActualizacion;
	}

	public void setIpInsercion(String ipInsercion) {
		this.ipInsercion = ipInsercion;
	}

	public void setKDescripcionRecursos(
			KDescripcionRecursos KDescripcionRecursos) {
		this.KDescripcionRecursos = KDescripcionRecursos;
	}

	public void setKRoles(KRoles KRoles) {
		this.KRoles = KRoles;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public void setUsuarioInsercion(Integer usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

}
