package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

/**
 * KProductosDeduccionesId generated by hbm2java
 */
public class KProductosDeduccionesId implements java.io.Serializable {

	private int codigoInternoDeduccion;
	private int codigoInternoDefinicion;

	public KProductosDeduccionesId() {
	}

	public KProductosDeduccionesId(int codigoInternoDeduccion,
			int codigoInternoDefinicion) {
		this.codigoInternoDeduccion = codigoInternoDeduccion;
		this.codigoInternoDefinicion = codigoInternoDefinicion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KProductosDeduccionesId))
			return false;
		KProductosDeduccionesId castOther = (KProductosDeduccionesId) other;

		return (this.getCodigoInternoDeduccion() == castOther
				.getCodigoInternoDeduccion())
				&& (this.getCodigoInternoDefinicion() == castOther
						.getCodigoInternoDefinicion());
	}

	public int getCodigoInternoDeduccion() {
		return this.codigoInternoDeduccion;
	}

	public int getCodigoInternoDefinicion() {
		return this.codigoInternoDefinicion;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoInternoDeduccion();
		result = 37 * result + this.getCodigoInternoDefinicion();
		return result;
	}

	public void setCodigoInternoDeduccion(int codigoInternoDeduccion) {
		this.codigoInternoDeduccion = codigoInternoDeduccion;
	}

	public void setCodigoInternoDefinicion(int codigoInternoDefinicion) {
		this.codigoInternoDefinicion = codigoInternoDefinicion;
	}

}
