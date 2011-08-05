package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pp.admin.hibernate.CTipoUbicacion;
import com.pp.admin.hibernate.KBancosTerceros;
import com.pp.admin.hibernate.KConceptosFacturacion;
import com.pp.admin.hibernate.KCondicionesEspeciales;

@Repository
@Transactional
public class ParamsAdmin implements IParamsAdmin {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<KCondicionesEspeciales> getCondicionesEspeciales() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select ce from KCondicionesEspeciales ce");
		List<KCondicionesEspeciales> result = (List<KCondicionesEspeciales>) query
				.list();
		return result;
	}

	@Transactional(readOnly = false)
	public void save(KCondicionesEspeciales condicionesEspeciales) {
		sessionFactory.getCurrentSession().saveOrUpdate(condicionesEspeciales);
	}

	@Transactional(readOnly = true)
	public KCondicionesEspeciales getCondicionesEspeciales(int idRole) {
		return (KCondicionesEspeciales) sessionFactory.getCurrentSession().get(
				KCondicionesEspeciales.class, idRole);
	}

	public void delete(KCondicionesEspeciales condicionesEspeciales) {
		sessionFactory.getCurrentSession().delete(condicionesEspeciales);

	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<CTipoUbicacion> getTipoUbicacion() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select ce from CTipoUbicacion ce");
		List<CTipoUbicacion> result = (List<CTipoUbicacion>) query.list();
		return result;
	}

	@Transactional(readOnly = false)
	public void save(CTipoUbicacion tipoUbicacion) {
		sessionFactory.getCurrentSession().saveOrUpdate(tipoUbicacion);
	}

	@Transactional(readOnly = true)
	public CTipoUbicacion getTipoUbicacion(int idRole) {
		return (CTipoUbicacion) sessionFactory.getCurrentSession().get(
				CTipoUbicacion.class, idRole);
	}

	public void delete(CTipoUbicacion tipoUbicacion) {
		sessionFactory.getCurrentSession().delete(tipoUbicacion);

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

	@Transactional(readOnly = false)
	public void save(KConceptosFacturacion conceptosFacturacion) {
		sessionFactory.getCurrentSession().saveOrUpdate(conceptosFacturacion);
	}

	@Transactional(readOnly = true)
	public KConceptosFacturacion getConceptoFacturacion(int idRole) {
		return (KConceptosFacturacion) sessionFactory.getCurrentSession().get(
				KConceptosFacturacion.class, idRole);
	}

	public void delete(KConceptosFacturacion conceptosFacturacion) {
		sessionFactory.getCurrentSession().delete(conceptosFacturacion);

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
	
}
