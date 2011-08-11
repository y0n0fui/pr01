package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

/**
 * KPivotCoorProId generated by hbm2java
 */
public class KPivotCoorProId implements java.io.Serializable {

	private int codigoInternoEmpresa;
	private int codigoInternoFuncionario;
	private int codigoInternoDefinicion;

	public KPivotCoorProId() {
	}

	public KPivotCoorProId(int codigoInternoEmpresa,
			int codigoInternoFuncionario, int codigoInternoDefinicion) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
		this.codigoInternoFuncionario = codigoInternoFuncionario;
		this.codigoInternoDefinicion = codigoInternoDefinicion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KPivotCoorProId))
			return false;
		KPivotCoorProId castOther = (KPivotCoorProId) other;

		return (this.getCodigoInternoEmpresa() == castOther
				.getCodigoInternoEmpresa())
				&& (this.getCodigoInternoFuncionario() == castOther
						.getCodigoInternoFuncionario())
				&& (this.getCodigoInternoDefinicion() == castOther
						.getCodigoInternoDefinicion());
	}

	public int getCodigoInternoDefinicion() {
		return this.codigoInternoDefinicion;
	}

	public int getCodigoInternoEmpresa() {
		return this.codigoInternoEmpresa;
	}

	public int getCodigoInternoFuncionario() {
		return this.codigoInternoFuncionario;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodigoInternoEmpresa();
		result = 37 * result + this.getCodigoInternoFuncionario();
		result = 37 * result + this.getCodigoInternoDefinicion();
		return result;
	}

	public void setCodigoInternoDefinicion(int codigoInternoDefinicion) {
		this.codigoInternoDefinicion = codigoInternoDefinicion;
	}

	public void setCodigoInternoEmpresa(int codigoInternoEmpresa) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
	}

	public void setCodigoInternoFuncionario(int codigoInternoFuncionario) {
		this.codigoInternoFuncionario = codigoInternoFuncionario;
	}

}
