package com.pp.admin.facade;


import java.math.BigDecimal;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pp.admin.hibernate.CTipoUbicacion;
import com.pp.admin.hibernate.KBancosTerceros;
import com.pp.admin.hibernate.KCiclo;
import com.pp.admin.hibernate.CCiudad;
import com.pp.admin.hibernate.KConceptosFacturacion;
import com.pp.admin.hibernate.KCondicionesEspeciales;
import com.pp.admin.hibernate.KDefinicionDeducciones;
import com.pp.admin.hibernate.KDescripcionRecursos;
import com.pp.admin.hibernate.KEmpresaCorreo;
import com.pp.admin.hibernate.KRoles;
import com.pp.admin.hibernate.KRolesEmpresas;
import com.pp.admin.hibernate.KRolesEmpresasId;
import com.pp.admin.hibernate.KUsuariosEmpresas;

import com.pp.admin.hibernate.KRecursosXRoles;
import com.pp.admin.hibernate.KRecursosXRolesId;


@Repository
@Transactional
public class ParamsAdmin implements IParamsAdmin {

	@Autowired
	private SessionFactory sessionFactory;

	public void delete(CTipoUbicacion tipoUbicacion) {
		sessionFactory.getCurrentSession().delete(tipoUbicacion);

	}

	public void delete(KCiclo ciclo) {
		sessionFactory.getCurrentSession().delete(ciclo);

	}

	public void delete(KConceptosFacturacion conceptosFacturacion) {
		sessionFactory.getCurrentSession().delete(conceptosFacturacion);

	}

	public void delete(KCondicionesEspeciales condicionesEspeciales) {
		sessionFactory.getCurrentSession().delete(condicionesEspeciales);

	}

	public void delete(KDefinicionDeducciones def) {
		sessionFactory.getCurrentSession().delete(def);

	}

	public void delete(KEmpresaCorreo empresaCorreo) {
		sessionFactory.getCurrentSession().delete(empresaCorreo);

	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KCiclo> getCiclo() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c from KCiclo c");
		List<KCiclo> result = (List<KCiclo>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KCiclo getCiclo(int idCiclo) {
		return (KCiclo) sessionFactory.getCurrentSession().get(KCiclo.class,
				idCiclo);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KConceptosFacturacion> getConceptoFacturacion() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select cf from KConceptosFacturacion cf");
		List<KConceptosFacturacion> result = (List<KConceptosFacturacion>) query
				.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KConceptosFacturacion getConceptoFacturacion(int idRole) {
		return (KConceptosFacturacion) sessionFactory.getCurrentSession().get(
				KConceptosFacturacion.class, idRole);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KCondicionesEspeciales> getCondicionesEspeciales() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select ce from KCondicionesEspeciales ce");
		List<KCondicionesEspeciales> result = (List<KCondicionesEspeciales>) query
				.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KCondicionesEspeciales getCondicionesEspeciales(int idRole) {
		return (KCondicionesEspeciales) sessionFactory.getCurrentSession().get(
				KCondicionesEspeciales.class, idRole);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KDefinicionDeducciones> getDefinicionDeducciones() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c from KDefinicionDeducciones c");
		List<KDefinicionDeducciones> result = (List<KDefinicionDeducciones>) query
				.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KDefinicionDeducciones getDefinicionDeducciones(int idDef) {
		return (KDefinicionDeducciones) sessionFactory.getCurrentSession().get(
				KDefinicionDeducciones.class, idDef);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KEmpresaCorreo> getEmpresaCorreo() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c from KEmpresaCorreo c");
		List<KEmpresaCorreo> result = (List<KEmpresaCorreo>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KEmpresaCorreo getEmpresaCorreo(int id) {
		return (KEmpresaCorreo) sessionFactory.getCurrentSession().get(
				KEmpresaCorreo.class, id);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<CTipoUbicacion> getTipoUbicacion() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select ce from CTipoUbicacion ce");
		List<CTipoUbicacion> result = (List<CTipoUbicacion>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	public CTipoUbicacion getTipoUbicacion(int idRole) {
		return (CTipoUbicacion) sessionFactory.getCurrentSession().get(
				CTipoUbicacion.class, idRole);
	}

	@Transactional(readOnly = false)
	public void save(CTipoUbicacion tipoUbicacion) {
		sessionFactory.getCurrentSession().saveOrUpdate(tipoUbicacion);
	}

	@Transactional(readOnly = false)
	public void save(KCiclo ciclo) {
		sessionFactory.getCurrentSession().saveOrUpdate(ciclo);
	}

	@Transactional(readOnly = false)
	public void save(KConceptosFacturacion conceptosFacturacion) {
		sessionFactory.getCurrentSession().saveOrUpdate(conceptosFacturacion);
	}

	@Transactional(readOnly = false)
	public void save(KCondicionesEspeciales condicionesEspeciales) {
		sessionFactory.getCurrentSession().saveOrUpdate(condicionesEspeciales);
	}

	@Transactional(readOnly = false)
	public void save(KDefinicionDeducciones definicionDeducciones) {
		sessionFactory.getCurrentSession().saveOrUpdate(definicionDeducciones);
	}

	@Transactional(readOnly = false)
	public void save(KEmpresaCorreo empresaCorreo) {
		sessionFactory.getCurrentSession().saveOrUpdate(empresaCorreo);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KBancosTerceros> getBancosTerceros() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select cf from KBancosTerceros cf");
		List<KBancosTerceros> result = (List<KBancosTerceros>) query
				.list();
		return result;
	}

	@Transactional(readOnly = false)
	public void save(KBancosTerceros bancosTerceros) {
		sessionFactory.getCurrentSession().saveOrUpdate(bancosTerceros);
	}

	@Transactional(readOnly = true)
	public KBancosTerceros getBancosTerceros(int idRole) {
		return (KBancosTerceros) sessionFactory.getCurrentSession().get(
				KBancosTerceros.class, idRole);
	}

	public void delete(KBancosTerceros bancosTerceros) {
		sessionFactory.getCurrentSession().delete(bancosTerceros);

	}
	
	//Ciudad
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<CCiudad> getCiudad() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select cf from CCiudad cf");
		List<CCiudad> result = (List<CCiudad>) query
				.list();
		return result;
	}

	@Transactional(readOnly = false)
	public void save(CCiudad ciudad) {
		sessionFactory.getCurrentSession().saveOrUpdate(ciudad);
	}

	@Transactional(readOnly = true)
	public CCiudad getCiudad(int idRole) {
		return (CCiudad) sessionFactory.getCurrentSession().get(
				CCiudad.class, idRole);
	}

	public void delete(CCiudad ciudad) {
		sessionFactory.getCurrentSession().delete(ciudad);

	}
	
	

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KRoles> getRolesByUsuarioEmpresa(int usuarioEmpresa) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select re.KRoles from KRolesEmpresas re where re.KUsuariosEmpresas.codigoInternoUsuario=:uEmpresa");
		query.setParameter("uEmpresa", usuarioEmpresa);
		List<KRoles> result = (List<KRoles>) query
				.list();
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public void save(List<KRoles> roles,KUsuariosEmpresas usuariosEmpresas, int user, String ipAddress) {
		KRolesEmpresas kRolesEmpresas =null;
		KRolesEmpresasId id = null;
		//eliminar las relaciones roles x recursos
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete from KRolesEmpresas  re where re.KUsuariosEmpresas.codigoInternoUsuario=:uEmpresa");
		query.setParameter("uEmpresa", usuariosEmpresas.getCodigoInternoUsuario());
		query.executeUpdate();
		//poner las nuevas
		for (KRoles rol : roles) {
			kRolesEmpresas= new KRolesEmpresas();
			kRolesEmpresas.setKRoles(rol);
			kRolesEmpresas.setKUsuariosEmpresas(usuariosEmpresas);
			kRolesEmpresas.setKEmpresas(usuariosEmpresas.getKEmpresas());
			kRolesEmpresas.setFechaInsercion(new Date());
			kRolesEmpresas.setIpInsercion(ipAddress);
			kRolesEmpresas.setUsuarioInsercion(new BigDecimal(user));
			id=new KRolesEmpresasId();
			id.setCodigoInternoRole(rol.getCodigoInternoRole());
			id.setCodigoInternoUsuario(usuariosEmpresas.getCodigoInternoUsuario());
			id.setCodigoInternoEmpresa(usuariosEmpresas.getKEmpresas().getCodigoInternoEmpresa());
			kRolesEmpresas.setId(id);
			sessionFactory.getCurrentSession().save(kRolesEmpresas);
		}
		
	}


	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KDescripcionRecursos> getDescripcionRecursos() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select cf from KDescripcionRecursos cf");
		List<KDescripcionRecursos> result = (List<KDescripcionRecursos>) query
				.list();
		return result;
	}

	@Transactional(readOnly = false)
	public void save(KDescripcionRecursos descripcionRecursos) {
		sessionFactory.getCurrentSession().saveOrUpdate(descripcionRecursos);
	}

	@Transactional(readOnly = true)
	public KDescripcionRecursos getDescripcionRecursos(int idDesc) {
		return (KDescripcionRecursos) sessionFactory.getCurrentSession().get(
				KDescripcionRecursos.class, idDesc);
	}

	public void delete(KDescripcionRecursos descripcionRecursos) {
		sessionFactory.getCurrentSession().delete(descripcionRecursos);

	}

	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KDescripcionRecursos> getRecursosByRole(int roleId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select rr.KDescripcionRecursos from KRecursosXRoles rr where rr.KRoles.codigoInternoRole=:cRole");
		query.setParameter("cRole", roleId);
		List<KDescripcionRecursos> result = (List<KDescripcionRecursos>) query
				.list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void save(List<KDescripcionRecursos> descr,KRoles roles, int user, String ipAddress) {
		KRecursosXRoles kRecursosXRoles =null;
		KRecursosXRolesId id = null;
		//eliminar las relaciones roles x recursos
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete from KRecursosXRoles rr where rr.KRoles.codigoInternoRole=:cRole");
		query.setParameter("cRole", roles.getCodigoInternoRole());
		query.executeUpdate();
		//poner las nuevas
		for (KDescripcionRecursos kDescripcionRecursos : descr) {
			kRecursosXRoles= new KRecursosXRoles();
			kRecursosXRoles.setKRoles(roles);
			kRecursosXRoles.setKDescripcionRecursos(kDescripcionRecursos);
			kRecursosXRoles.setFechaInsercion(new Date());
			kRecursosXRoles.setIpInsercion(ipAddress);
			kRecursosXRoles.setUsuarioInsercion(user);
			id=new KRecursosXRolesId();
			id.setCodigoInternoRecurso(kDescripcionRecursos.getCodigoInternoRecurso());
			id.setCodigoInternoRole(roles.getCodigoInternoRole());
			kRecursosXRoles.setId(id);
			sessionFactory.getCurrentSession().save(kRecursosXRoles);
		}
		
	}

}
