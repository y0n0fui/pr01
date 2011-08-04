package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CTipoIdentificacion generated by hbm2java
 */
public class CTipoIdentificacion implements java.io.Serializable {

	private int codIntTipoId;
	private String descripcion;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;
	private Set KEmpresases = new HashSet(0);
	private Set KEmpleadosClienteses = new HashSet(0);
	private Set KMvtoBeneficiadoses = new HashSet(0);
	private Set KBancosTerceroses = new HashSet(0);

	public CTipoIdentificacion() {
	}

	public CTipoIdentificacion(int codIntTipoId, String descripcion) {
		this.codIntTipoId = codIntTipoId;
		this.descripcion = descripcion;
	}

	public CTipoIdentificacion(int codIntTipoId, String descripcion,
			Date fechaInsercion, Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion, Set KEmpresases, Set KEmpleadosClienteses,
			Set KMvtoBeneficiadoses, Set KBancosTerceroses) {
		this.codIntTipoId = codIntTipoId;
		this.descripcion = descripcion;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
		this.KEmpresases = KEmpresases;
		this.KEmpleadosClienteses = KEmpleadosClienteses;
		this.KMvtoBeneficiadoses = KMvtoBeneficiadoses;
		this.KBancosTerceroses = KBancosTerceroses;
	}

	public int getCodIntTipoId() {
		return this.codIntTipoId;
	}

	public void setCodIntTipoId(int codIntTipoId) {
		this.codIntTipoId = codIntTipoId;
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

	public Set getKEmpresases() {
		return this.KEmpresases;
	}

	public void setKEmpresases(Set KEmpresases) {
		this.KEmpresases = KEmpresases;
	}

	public Set getKEmpleadosClienteses() {
		return this.KEmpleadosClienteses;
	}

	public void setKEmpleadosClienteses(Set KEmpleadosClienteses) {
		this.KEmpleadosClienteses = KEmpleadosClienteses;
	}

	public Set getKMvtoBeneficiadoses() {
		return this.KMvtoBeneficiadoses;
	}

	public void setKMvtoBeneficiadoses(Set KMvtoBeneficiadoses) {
		this.KMvtoBeneficiadoses = KMvtoBeneficiadoses;
	}

	public Set getKBancosTerceroses() {
		return this.KBancosTerceroses;
	}

	public void setKBancosTerceroses(Set KBancosTerceroses) {
		this.KBancosTerceroses = KBancosTerceroses;
	}

}
