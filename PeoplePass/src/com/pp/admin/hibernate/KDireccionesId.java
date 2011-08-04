package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

/**
 * KDireccionesId generated by hbm2java
 */
public class KDireccionesId implements java.io.Serializable {

	private int codigoInternoCliente;
	private int tipoUbicacion;

	public KDireccionesId() {
	}

	public KDireccionesId(int codigoInternoCliente, int tipoUbicacion) {
		this.codigoInternoCliente = codigoInternoCliente;
		this.tipoUbicacion = tipoUbicacion;
	}

	public int getCodigoInternoCliente() {
		return this.codigoInternoCliente;
	}

	public void setCodigoInternoCliente(int codigoInternoCliente) {
		this.codigoInternoCliente = codigoInternoCliente;
	}

	public int getTipoUbicacion() {
		return this.tipoUbicacion;
	}

	public void setTipoUbicacion(int tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KDireccionesId))
			return false;
		KDireccionesId castOther = (KDireccionesId) other;

		return (this.getCodigoInternoCliente() == castOther
				.getCodigoInternoCliente())
				&& (this.getTipoUbicacion() == castOther.getTipoUbicacion());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoInternoCliente();
		result = 37 * result + this.getTipoUbicacion();
		return result;
	}

}
