package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

/**
 * KFacturasId generated by hbm2java
 */
public class KFacturasId implements java.io.Serializable {

	private int pedido;
	private int codigoInternoEmpresa;
	private int codigoInternoDefinicion;

	public KFacturasId() {
	}

	public KFacturasId(int pedido, int codigoInternoEmpresa,
			int codigoInternoDefinicion) {
		this.pedido = pedido;
		this.codigoInternoEmpresa = codigoInternoEmpresa;
		this.codigoInternoDefinicion = codigoInternoDefinicion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KFacturasId))
			return false;
		KFacturasId castOther = (KFacturasId) other;

		return (this.getPedido() == castOther.getPedido())
				&& (this.getCodigoInternoEmpresa() == castOther
						.getCodigoInternoEmpresa())
				&& (this.getCodigoInternoDefinicion() == castOther
						.getCodigoInternoDefinicion());
	}

	public int getCodigoInternoDefinicion() {
		return this.codigoInternoDefinicion;
	}

	public int getCodigoInternoEmpresa() {
		return this.codigoInternoEmpresa;
	}

	public int getPedido() {
		return this.pedido;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPedido();
		result = 37 * result + this.getCodigoInternoEmpresa();
		result = 37 * result + this.getCodigoInternoDefinicion();
		return result;
	}

	public void setCodigoInternoDefinicion(int codigoInternoDefinicion) {
		this.codigoInternoDefinicion = codigoInternoDefinicion;
	}

	public void setCodigoInternoEmpresa(int codigoInternoEmpresa) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

}
