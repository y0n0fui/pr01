package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

/**
 * KMovimientoSaldoClientesId generated by hbm2java
 */
public class KMovimientoSaldoClientesId implements java.io.Serializable {

	private int codigoInternoEmpresa;
	private String facturaAbono;

	public KMovimientoSaldoClientesId() {
	}

	public KMovimientoSaldoClientesId(int codigoInternoEmpresa,
			String facturaAbono) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
		this.facturaAbono = facturaAbono;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KMovimientoSaldoClientesId))
			return false;
		KMovimientoSaldoClientesId castOther = (KMovimientoSaldoClientesId) other;

		return (this.getCodigoInternoEmpresa() == castOther
				.getCodigoInternoEmpresa())
				&& ((this.getFacturaAbono() == castOther.getFacturaAbono()) || (this
						.getFacturaAbono() != null
						&& castOther.getFacturaAbono() != null && this
						.getFacturaAbono().equals(castOther.getFacturaAbono())));
	}

	public int getCodigoInternoEmpresa() {
		return this.codigoInternoEmpresa;
	}

	public String getFacturaAbono() {
		return this.facturaAbono;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoInternoEmpresa();
		result = 37
				* result
				+ (getFacturaAbono() == null ? 0 : this.getFacturaAbono()
						.hashCode());
		return result;
	}

	public void setCodigoInternoEmpresa(int codigoInternoEmpresa) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
	}

	public void setFacturaAbono(String facturaAbono) {
		this.facturaAbono = facturaAbono;
	}

}
