package com.pp.admin.hibernate;

// Generated Jul 25, 2011 11:41:25 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * KEmpresas generated by hbm2java
 */
public class KEmpresas implements java.io.Serializable {

	private int codigoInternoEmpresa;
	private CTipoIdentificacion tipoIdentificacion;
	private String nroIdentificacion;
	private String telefono;
	private String direccion;
	private String correoElectronico;
	private BigDecimal cupoSobregiro;
	private String facturaImpresa;
	private int umbralDiasAviso;
	private Date fechaPagoActual;
	private Date fechaInsercion;
	private Integer usuarioInsercion;
	private String ipInsercion;
	private Date fechaActualizacion;
	private Integer usuarioActualizacion;
	private String ipActualizacion;
	private Set KCondicionesEspecialeses = new HashSet(0);
	private Set KUsuariosEmpresases = new HashSet(0);
	private Set KDefinicionProductoses = new HashSet(0);
	private KSaldosXEmpresas KSaldosXEmpresas;
	private Set KPivotGteCuentaEmpresases = new HashSet(0);
	private Set KPivotCoorPros = new HashSet(0);
	private Set KCiclosProyectadoses = new HashSet(0);
	private Set KMovimientoSaldoClienteses = new HashSet(0);
	private Set KMvtoBeneficiadoses = new HashSet(0);
	private Set KRolesEmpresases = new HashSet(0);
	private Set KFacturases = new HashSet(0);

	public KEmpresas() {
	}

	public KEmpresas(int codigoInternoEmpresa,
			CTipoIdentificacion tipoIdentificacion, String nroIdentificacion,
			String facturaImpresa, int umbralDiasAviso) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nroIdentificacion = nroIdentificacion;
		this.facturaImpresa = facturaImpresa;
		this.umbralDiasAviso = umbralDiasAviso;
	}

	public KEmpresas(int codigoInternoEmpresa,
			CTipoIdentificacion tipoIdentificacion, String nroIdentificacion,
			String telefono, String direccion, String correoElectronico,
			BigDecimal cupoSobregiro, String facturaImpresa,
			int umbralDiasAviso, Date fechaPagoActual, Date fechaInsercion,
			Integer usuarioInsercion, String ipInsercion,
			Date fechaActualizacion, Integer usuarioActualizacion,
			String ipActualizacion, Set KCondicionesEspecialeses,
			Set KUsuariosEmpresases, Set KDefinicionProductoses,
			KSaldosXEmpresas KSaldosXEmpresas, Set KPivotGteCuentaEmpresases,
			Set KPivotCoorPros, Set KCiclosProyectadoses,
			Set KMovimientoSaldoClienteses, Set KMvtoBeneficiadoses,
			Set KRolesEmpresases, Set KFacturases) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nroIdentificacion = nroIdentificacion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.cupoSobregiro = cupoSobregiro;
		this.facturaImpresa = facturaImpresa;
		this.umbralDiasAviso = umbralDiasAviso;
		this.fechaPagoActual = fechaPagoActual;
		this.fechaInsercion = fechaInsercion;
		this.usuarioInsercion = usuarioInsercion;
		this.ipInsercion = ipInsercion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioActualizacion = usuarioActualizacion;
		this.ipActualizacion = ipActualizacion;
		this.KCondicionesEspecialeses = KCondicionesEspecialeses;
		this.KUsuariosEmpresases = KUsuariosEmpresases;
		this.KDefinicionProductoses = KDefinicionProductoses;
		this.KSaldosXEmpresas = KSaldosXEmpresas;
		this.KPivotGteCuentaEmpresases = KPivotGteCuentaEmpresases;
		this.KPivotCoorPros = KPivotCoorPros;
		this.KCiclosProyectadoses = KCiclosProyectadoses;
		this.KMovimientoSaldoClienteses = KMovimientoSaldoClienteses;
		this.KMvtoBeneficiadoses = KMvtoBeneficiadoses;
		this.KRolesEmpresases = KRolesEmpresases;
		this.KFacturases = KFacturases;
	}

	public int getCodigoInternoEmpresa() {
		return this.codigoInternoEmpresa;
	}

	public void setCodigoInternoEmpresa(int codigoInternoEmpresa) {
		this.codigoInternoEmpresa = codigoInternoEmpresa;
	}

	public CTipoIdentificacion getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(CTipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNroIdentificacion() {
		return this.nroIdentificacion;
	}

	public void setNroIdentificacion(String nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public BigDecimal getCupoSobregiro() {
		return this.cupoSobregiro;
	}

	public void setCupoSobregiro(BigDecimal cupoSobregiro) {
		this.cupoSobregiro = cupoSobregiro;
	}

	public String getFacturaImpresa() {
		return this.facturaImpresa;
	}

	public void setFacturaImpresa(String facturaImpresa) {
		this.facturaImpresa = facturaImpresa;
	}

	public int getUmbralDiasAviso() {
		return this.umbralDiasAviso;
	}

	public void setUmbralDiasAviso(int umbralDiasAviso) {
		this.umbralDiasAviso = umbralDiasAviso;
	}

	public Date getFechaPagoActual() {
		return this.fechaPagoActual;
	}

	public void setFechaPagoActual(Date fechaPagoActual) {
		this.fechaPagoActual = fechaPagoActual;
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

	public Set getKCondicionesEspecialeses() {
		return this.KCondicionesEspecialeses;
	}

	public void setKCondicionesEspecialeses(Set KCondicionesEspecialeses) {
		this.KCondicionesEspecialeses = KCondicionesEspecialeses;
	}

	public Set getKUsuariosEmpresases() {
		return this.KUsuariosEmpresases;
	}

	public void setKUsuariosEmpresases(Set KUsuariosEmpresases) {
		this.KUsuariosEmpresases = KUsuariosEmpresases;
	}

	public Set getKDefinicionProductoses() {
		return this.KDefinicionProductoses;
	}

	public void setKDefinicionProductoses(Set KDefinicionProductoses) {
		this.KDefinicionProductoses = KDefinicionProductoses;
	}

	public KSaldosXEmpresas getKSaldosXEmpresas() {
		return this.KSaldosXEmpresas;
	}

	public void setKSaldosXEmpresas(KSaldosXEmpresas KSaldosXEmpresas) {
		this.KSaldosXEmpresas = KSaldosXEmpresas;
	}

	public Set getKPivotGteCuentaEmpresases() {
		return this.KPivotGteCuentaEmpresases;
	}

	public void setKPivotGteCuentaEmpresases(Set KPivotGteCuentaEmpresases) {
		this.KPivotGteCuentaEmpresases = KPivotGteCuentaEmpresases;
	}

	public Set getKPivotCoorPros() {
		return this.KPivotCoorPros;
	}

	public void setKPivotCoorPros(Set KPivotCoorPros) {
		this.KPivotCoorPros = KPivotCoorPros;
	}

	public Set getKCiclosProyectadoses() {
		return this.KCiclosProyectadoses;
	}

	public void setKCiclosProyectadoses(Set KCiclosProyectadoses) {
		this.KCiclosProyectadoses = KCiclosProyectadoses;
	}

	public Set getKMovimientoSaldoClienteses() {
		return this.KMovimientoSaldoClienteses;
	}

	public void setKMovimientoSaldoClienteses(Set KMovimientoSaldoClienteses) {
		this.KMovimientoSaldoClienteses = KMovimientoSaldoClienteses;
	}

	public Set getKMvtoBeneficiadoses() {
		return this.KMvtoBeneficiadoses;
	}

	public void setKMvtoBeneficiadoses(Set KMvtoBeneficiadoses) {
		this.KMvtoBeneficiadoses = KMvtoBeneficiadoses;
	}

	public Set getKRolesEmpresases() {
		return this.KRolesEmpresases;
	}

	public void setKRolesEmpresases(Set KRolesEmpresases) {
		this.KRolesEmpresases = KRolesEmpresases;
	}

	public Set getKFacturases() {
		return this.KFacturases;
	}

	public void setKFacturases(Set KFacturases) {
		this.KFacturases = KFacturases;
	}

}
