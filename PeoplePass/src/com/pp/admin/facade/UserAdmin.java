package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pp.admin.hibernate.CTipoCargo;
import com.pp.admin.hibernate.CTipoIdentificacion;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.admin.hibernate.KRoles;
import com.pp.admin.hibernate.KUsuariosEmpresas;
import com.pp.admin.hibernate.KUsuariosFunciones;

@Repository
@Transactional
public class UserAdmin implements IUserAdmin {

	@Autowired
	private SessionFactory sessionFactory;

	public void delete(CTipoCargo tipoCargo) {
		sessionFactory.getCurrentSession().delete(tipoCargo);

	}

	public void delete(CTipoIdentificacion tipoIdentificacion) {
		sessionFactory.getCurrentSession().delete(tipoIdentificacion);

	}

	public void delete(KEmpresas empresa) {
		sessionFactory.getCurrentSession().delete(empresa);
	}

	public void delete(KRoles role) {
		sessionFactory.getCurrentSession().delete(role);

	}

	public void delete(KUsuariosEmpresas usuariosEmpresas) {
		sessionFactory.getCurrentSession().delete(usuariosEmpresas);
	}

	public void delete(KUsuariosFunciones usuariosFunciones) {
		sessionFactory.getCurrentSession().delete(usuariosFunciones);
	}

	@Transactional(readOnly = true)
	public KEmpresas getEmpresa(int idEmpresa) {
		return (KEmpresas) sessionFactory.getCurrentSession().get(
				KEmpresas.class, idEmpresa);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KEmpresas> getEmpresas() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c from KEmpresas c");
		List<KEmpresas> result = (List<KEmpresas>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KRoles> getRoles() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select r from KRoles r");
		List<KRoles> result = (List<KRoles>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KRoles getRoles(int idRole) {
		return (KRoles) sessionFactory.getCurrentSession().get(KRoles.class,
				idRole);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<CTipoCargo> getTipoCargo() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c from CTipoCargo c");
		List<CTipoCargo> result = (List<CTipoCargo>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	public CTipoCargo getTipoCargo(int idTipoCargo) {
		return (CTipoCargo) sessionFactory.getCurrentSession().get(
				CTipoCargo.class, idTipoCargo);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<CTipoIdentificacion> getTipoIdentificacion() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c from CTipoIdentificacion c");
		List<CTipoIdentificacion> result = (List<CTipoIdentificacion>) query
				.list();
		return result;
	}

	@Transactional(readOnly = true)
	public CTipoIdentificacion getTipoIdentificacion(int idTipoIdentificacion) {
		return (CTipoIdentificacion) sessionFactory.getCurrentSession().get(
				CTipoIdentificacion.class, idTipoIdentificacion);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KUsuariosEmpresas> getUsuarioEmpresas() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c from KUsuariosEmpresas c");
		List<KUsuariosEmpresas> result = (List<KUsuariosEmpresas>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KUsuariosEmpresas getUsuarioEmpresas(int idUsuarioEmpresa) {
		return (KUsuariosEmpresas) sessionFactory.getCurrentSession().get(
				KUsuariosEmpresas.class, idUsuarioEmpresa);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KUsuariosEmpresas> getUsuarioEmpresasByEmpresa(int empresaId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select c from KUsuariosEmpresas c where c.KEmpresas.id=:idEmpr");
		query.setParameter("idEmpr", empresaId);
		List<KUsuariosEmpresas> result = (List<KUsuariosEmpresas>) query.list();
		return result;
	}

	@Transactional(readOnly = true)
	public KUsuariosFunciones getUsuarioFunciones(int idUsuarioFunciones) {
		return (KUsuariosFunciones) sessionFactory.getCurrentSession().get(
				KUsuariosFunciones.class, idUsuarioFunciones);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KUsuariosFunciones> getUsuariosFunciones() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select u from KUsuariosFunciones u");
		List<KUsuariosFunciones> result = (List<KUsuariosFunciones>) query
				.list();
		return result;
	}

	public void save(CTipoCargo tipoCargo) {
		sessionFactory.getCurrentSession().saveOrUpdate(tipoCargo);
	}

	public void save(CTipoIdentificacion tipoIdentificacion) {
		sessionFactory.getCurrentSession().saveOrUpdate(tipoIdentificacion);
	}

	public void save(KEmpresas empresa) {
		sessionFactory.getCurrentSession().saveOrUpdate(empresa);
	}

	public void save(KRoles role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	public void save(KUsuariosEmpresas usuarioEmpresas) {
		sessionFactory.getCurrentSession().saveOrUpdate(usuarioEmpresas);
	}

	public void save(KUsuariosFunciones usuarioFunciones) {
		sessionFactory.getCurrentSession().saveOrUpdate(usuarioFunciones);
	}

}
