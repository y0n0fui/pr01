package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.pp.admin.hibernate.CTipoUbicacion;
import com.pp.admin.hibernate.KBancosTerceros;
import com.pp.admin.hibernate.KConceptosFacturacion;
import com.pp.admin.hibernate.KCondicionesEspeciales;

public interface IParamsAdmin {

	
	public List<KCondicionesEspeciales> getCondicionesEspeciales();
	
	
	public void save(KCondicionesEspeciales condicionesEspeciales);
	
	
	
	public KCondicionesEspeciales getCondicionesEspeciales(int idRole);
	
	
	public void delete(KCondicionesEspeciales condicionesEspeciales);
	
	
	public List<CTipoUbicacion> getTipoUbicacion();


	public void save(CTipoUbicacion tipoUbicacion);

	
	public CTipoUbicacion getTipoUbicacion(int idRole);

	public void delete(CTipoUbicacion tipoUbicacion);
	
	
	public List<KConceptosFacturacion> getConceptoFacturacion();

	
	public void save(KConceptosFacturacion conceptosFacturacion);

	
	public KConceptosFacturacion getConceptoFacturacion(int idRole);
	
	public void delete(KConceptosFacturacion conceptosFacturacion);
	
	//KBancosTerceros
	public List<KBancosTerceros> getBancosTerceros();

	
	public void save(KBancosTerceros bancosTerceros);

	
	public KBancosTerceros getBancosTerceros(int idRole);
	
	public void delete(KBancosTerceros bancosTerceros);
	
}
