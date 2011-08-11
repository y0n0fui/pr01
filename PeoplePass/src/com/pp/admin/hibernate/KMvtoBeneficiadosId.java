package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * KMvtoBeneficiadosId generated by hbm2java
 */
public class KMvtoBeneficiadosId implements java.io.Serializable {

	private int codigoInternoEmpresa;
	private int codigoInternoUsuario;
	private int codigoInternoDefinicion;
	private int codigoInternoEmpleado;
	private Date fechaPago;

	public KMvtoBeneficiadosId() {
	}

	public KMvtoBeneficiadosId(int codigoInternoEmpresa,
			int codigoInternoUsuario, int codigoInternoDefinicion,
			int codigoInternoEmpleado, Date fechaPago) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
		this.codigoInternoUsuario = codigoInternoUsuario;
		this.codigoInternoDefinicion = codigoInternoDefinicion;
		this.codigoInternoEmpleado = codigoInternoEmpleado;
		this.fechaPago = fechaPago;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KMvtoBeneficiadosId))
			return false;
		KMvtoBeneficiadosId castOther = (KMvtoBeneficiadosId) other;

		return (this.getCodigoInternoEmpresa() == castOther
				.getCodigoInternoEmpresa())
				&& (this.getCodigoInternoUsuario() == castOther
						.getCodigoInternoUsuario())
				&& (this.getCodigoInternoDefinicion() == castOther
						.getCodigoInternoDefinicion())
				&& (this.getCodigoInternoEmpleado() == castOther
						.getCodigoInternoEmpleado())
				&& ((this.getFechaPago() == castOther.getFechaPago()) || (this
						.getFechaPago() != null
						&& castOther.getFechaPago() != null && this
						.getFechaPago().equals(castOther.getFechaPago())));
	}

	public int getCodigoInternoDefinicion() {
		return this.codigoInternoDefinicion;
	}

	public int getCodigoInternoEmpleado() {
		return this.codigoInternoEmpleado;
	}

	public int getCodigoInternoEmpresa() {
		return this.codigoInternoEmpresa;
	}

	public int getCodigoInternoUsuario() {
		return this.codigoInternoUsuario;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoInternoEmpresa();
		result = 37 * result + this.getCodigoInternoUsuario();
		result = 37 * result + this.getCodigoInternoDefinicion();
		result = 37 * result + this.getCodigoInternoEmpleado();
		result = 37 * result
				+ (getFechaPago() == null ? 0 : this.getFechaPago().hashCode());
		return result;
	}

	public void setCodigoInternoDefinicion(int codigoInternoDefinicion) {
		this.codigoInternoDefinicion = codigoInternoDefinicion;
	}

	public void setCodigoInternoEmpleado(int codigoInternoEmpleado) {
		this.codigoInternoEmpleado = codigoInternoEmpleado;
	}

	public void setCodigoInternoEmpresa(int codigoInternoEmpresa) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
	}

	public void setCodigoInternoUsuario(int codigoInternoUsuario) {
		this.codigoInternoUsuario = codigoInternoUsuario;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

}
