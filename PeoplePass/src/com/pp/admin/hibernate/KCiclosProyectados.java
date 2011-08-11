package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * KCiclosProyectados generated by hbm2java
 */
public class KCiclosProyectados implements java.io.Serializable {

	private KCiclosProyectadosId id;
	private KCiclo KCiclo;
	private KEmpresas KEmpresas;
	private Date fechaDispersion;
	private String descripcionCiclo;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;

	public KCiclosProyectados() {
	}

	public KCiclosProyectados(KCiclosProyectadosId id, KCiclo KCiclo,
			KEmpresas KEmpresas, Date fechaDispersion, String descripcionCiclo) {
		this.id = id;
		this.KCiclo = KCiclo;
		this.KEmpresas = KEmpresas;
		this.fechaDispersion = fechaDispersion;
		this.descripcionCiclo = descripcionCiclo;
	}

	public KCiclosProyectados(KCiclosProyectadosId id, KCiclo KCiclo,
			KEmpresas KEmpresas, Date fechaDispersion, String descripcionCiclo,
			Date fechaInsercion, Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion) {
		this.id = id;
		this.KCiclo = KCiclo;
		this.KEmpresas = KEmpresas;
		this.fechaDispersion = fechaDispersion;
		this.descripcionCiclo = descripcionCiclo;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
	}

	public String getDescripcionCiclo() {
		return this.descripcionCiclo;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public Date getFechaDispersion() {
		return this.fechaDispersion;
	}

	public Date getFechaInsercion() {
		return this.fechaInsercion;
	}

	public KCiclosProyectadosId getId() {
		return this.id;
	}

	public String getIpActualizacion() {
		return this.ipActualizacion;
	}

	public String getIpInsercion() {
		return this.ipInsercion;
	}

	public KCiclo getKCiclo() {
		return this.KCiclo;
	}

	public KEmpresas getKEmpresas() {
		return this.KEmpresas;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public Integer getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public void setDescripcionCiclo(String descripcionCiclo) {
		this.descripcionCiclo = descripcionCiclo;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public void setFechaDispersion(Date fechaDispersion) {
		this.fechaDispersion = fechaDispersion;
	}

	public void setFechaInsercion(Date fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}

	public void setId(KCiclosProyectadosId id) {
		this.id = id;
	}

	public void setIpActualizacion(String ipActualizacion) {
		this.ipActualizacion = ipActualizacion;
	}

	public void setIpInsercion(String ipInsercion) {
		this.ipInsercion = ipInsercion;
	}

	public void setKCiclo(KCiclo KCiclo) {
		this.KCiclo = KCiclo;
	}

	public void setKEmpresas(KEmpresas KEmpresas) {
		this.KEmpresas = KEmpresas;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public void setUsuarioInsercion(Integer usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

}
