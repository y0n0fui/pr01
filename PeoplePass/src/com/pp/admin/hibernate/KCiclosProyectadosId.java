package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * KCiclosProyectadosId generated by hbm2java
 */
public class KCiclosProyectadosId implements java.io.Serializable {

	private int codigoInternoEmpresa;
	private int codigoInternoCiclo;
	private Date fechaPago;

	public KCiclosProyectadosId() {
	}

	public KCiclosProyectadosId(int codigoInternoEmpresa,
			int codigoInternoCiclo, Date fechaPago) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
		this.codigoInternoCiclo = codigoInternoCiclo;
		this.fechaPago = fechaPago;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KCiclosProyectadosId))
			return false;
		KCiclosProyectadosId castOther = (KCiclosProyectadosId) other;

		return (this.getCodigoInternoEmpresa() == castOther
				.getCodigoInternoEmpresa())
				&& (this.getCodigoInternoCiclo() == castOther
						.getCodigoInternoCiclo())
				&& ((this.getFechaPago() == castOther.getFechaPago()) || (this
						.getFechaPago() != null
						&& castOther.getFechaPago() != null && this
						.getFechaPago().equals(castOther.getFechaPago())));
	}

	public int getCodigoInternoCiclo() {
		return this.codigoInternoCiclo;
	}

	public int getCodigoInternoEmpresa() {
		return this.codigoInternoEmpresa;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoInternoEmpresa();
		result = 37 * result + this.getCodigoInternoCiclo();
		result = 37 * result
				+ (getFechaPago() == null ? 0 : this.getFechaPago().hashCode());
		return result;
	}

	public void setCodigoInternoCiclo(int codigoInternoCiclo) {
		this.codigoInternoCiclo = codigoInternoCiclo;
	}

	public void setCodigoInternoEmpresa(int codigoInternoEmpresa) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

}
