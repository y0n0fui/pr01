package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * KProductos generated by hbm2java
 */
public class KProductos implements java.io.Serializable {

	private int codigoInternoProducto;
	private String descripcionProducto;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;
	private Set KDefinicionProductoses = new HashSet(0);

	public KProductos() {
	}

	public KProductos(int codigoInternoProducto, String descripcionProducto) {
		this.codigoInternoProducto = codigoInternoProducto;
		this.descripcionProducto = descripcionProducto;
	}

	public KProductos(int codigoInternoProducto, String descripcionProducto,
			Date fechaInsercion, Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion, Set KDefinicionProductoses) {
		this.codigoInternoProducto = codigoInternoProducto;
		this.descripcionProducto = descripcionProducto;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
		this.KDefinicionProductoses = KDefinicionProductoses;
	}

	public int getCodigoInternoProducto() {
		return this.codigoInternoProducto;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
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

	public Set getKDefinicionProductoses() {
		return this.KDefinicionProductoses;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public Integer getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public void setCodigoInternoProducto(int codigoInternoProducto) {
		this.codigoInternoProducto = codigoInternoProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
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

	public void setKDefinicionProductoses(Set KDefinicionProductoses) {
		this.KDefinicionProductoses = KDefinicionProductoses;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public void setUsuarioInsercion(Integer usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

}
