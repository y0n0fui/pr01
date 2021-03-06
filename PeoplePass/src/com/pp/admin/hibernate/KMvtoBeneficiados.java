package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * KMvtoBeneficiados generated by hbm2java
 */
public class KMvtoBeneficiados implements java.io.Serializable {

	private KMvtoBeneficiadosId id;
	private KEmpresas KEmpresas;
	private KEmpleadosClientes KEmpleadosClientes;
	private KDefinicionProductos KDefinicionProductos;
	private CTipoIdentificacion CTipoIdentificacion;
	private String nroIdentificacionEmpleado;
	private Date fechaDispersion;
	private BigDecimal valorTransaccion;
	private String naturaleza;
	private String abreviadoTransaccion;
	private int pedido;
	private Integer factura;
	private String procesado;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;

	public KMvtoBeneficiados() {
	}

	public KMvtoBeneficiados(KMvtoBeneficiadosId id, KEmpresas KEmpresas,
			KEmpleadosClientes KEmpleadosClientes,
			KDefinicionProductos KDefinicionProductos,
			CTipoIdentificacion CTipoIdentificacion,
			String nroIdentificacionEmpleado, BigDecimal valorTransaccion,
			String naturaleza, String abreviadoTransaccion, int pedido) {
		this.id = id;
		this.KEmpresas = KEmpresas;
		this.KEmpleadosClientes = KEmpleadosClientes;
		this.KDefinicionProductos = KDefinicionProductos;
		this.CTipoIdentificacion = CTipoIdentificacion;
		this.nroIdentificacionEmpleado = nroIdentificacionEmpleado;
		this.valorTransaccion = valorTransaccion;
		this.naturaleza = naturaleza;
		this.abreviadoTransaccion = abreviadoTransaccion;
		this.pedido = pedido;
	}

	public KMvtoBeneficiados(KMvtoBeneficiadosId id, KEmpresas KEmpresas,
			KEmpleadosClientes KEmpleadosClientes,
			KDefinicionProductos KDefinicionProductos,
			CTipoIdentificacion CTipoIdentificacion,
			String nroIdentificacionEmpleado, Date fechaDispersion,
			BigDecimal valorTransaccion, String naturaleza,
			String abreviadoTransaccion, int pedido, Integer factura,
			String procesado, Date fechaInsercion, Integer usuarioInsercion,
			String ipInsercion, Date fechaActualizacion,
			Integer usuarioActualizacion, String ipActualizacion) {
		this.id = id;
		this.KEmpresas = KEmpresas;
		this.KEmpleadosClientes = KEmpleadosClientes;
		this.KDefinicionProductos = KDefinicionProductos;
		this.CTipoIdentificacion = CTipoIdentificacion;
		this.nroIdentificacionEmpleado = nroIdentificacionEmpleado;
		this.fechaDispersion = fechaDispersion;
		this.valorTransaccion = valorTransaccion;
		this.naturaleza = naturaleza;
		this.abreviadoTransaccion = abreviadoTransaccion;
		this.pedido = pedido;
		this.factura = factura;
		this.procesado = procesado;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
	}

	public String getAbreviadoTransaccion() {
		return this.abreviadoTransaccion;
	}

	public CTipoIdentificacion getCTipoIdentificacion() {
		return this.CTipoIdentificacion;
	}

	public Integer getFactura() {
		return this.factura;
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

	public KMvtoBeneficiadosId getId() {
		return this.id;
	}

	public String getIpActualizacion() {
		return this.ipActualizacion;
	}

	public String getIpInsercion() {
		return this.ipInsercion;
	}

	public KDefinicionProductos getKDefinicionProductos() {
		return this.KDefinicionProductos;
	}

	public KEmpleadosClientes getKEmpleadosClientes() {
		return this.KEmpleadosClientes;
	}

	public KEmpresas getKEmpresas() {
		return this.KEmpresas;
	}

	public String getNaturaleza() {
		return this.naturaleza;
	}

	public String getNroIdentificacionEmpleado() {
		return this.nroIdentificacionEmpleado;
	}

	public int getPedido() {
		return this.pedido;
	}

	public String getProcesado() {
		return this.procesado;
	}

	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public Integer getUsuarioInsercion() {
		return this.usuarioInsercion;
	}

	public BigDecimal getValorTransaccion() {
		return this.valorTransaccion;
	}

	public void setAbreviadoTransaccion(String abreviadoTransaccion) {
		this.abreviadoTransaccion = abreviadoTransaccion;
	}

	public void setCTipoIdentificacion(CTipoIdentificacion CTipoIdentificacion) {
		this.CTipoIdentificacion = CTipoIdentificacion;
	}

	public void setFactura(Integer factura) {
		this.factura = factura;
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

	public void setId(KMvtoBeneficiadosId id) {
		this.id = id;
	}

	public void setIpActualizacion(String ipActualizacion) {
		this.ipActualizacion = ipActualizacion;
	}

	public void setIpInsercion(String ipInsercion) {
		this.ipInsercion = ipInsercion;
	}

	public void setKDefinicionProductos(
			KDefinicionProductos KDefinicionProductos) {
		this.KDefinicionProductos = KDefinicionProductos;
	}

	public void setKEmpleadosClientes(KEmpleadosClientes KEmpleadosClientes) {
		this.KEmpleadosClientes = KEmpleadosClientes;
	}

	public void setKEmpresas(KEmpresas KEmpresas) {
		this.KEmpresas = KEmpresas;
	}

	public void setNaturaleza(String naturaleza) {
		this.naturaleza = naturaleza;
	}

	public void setNroIdentificacionEmpleado(String nroIdentificacionEmpleado) {
		this.nroIdentificacionEmpleado = nroIdentificacionEmpleado;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public void setProcesado(String procesado) {
		this.procesado = procesado;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public void setUsuarioInsercion(Integer usuarioInsercion) {
		this.usuarioInsercion = usuarioInsercion;
	}

	public void setValorTransaccion(BigDecimal valorTransaccion) {
		this.valorTransaccion = valorTransaccion;
	}

}
