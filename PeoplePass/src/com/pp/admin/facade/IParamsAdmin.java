package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.pp.admin.hibernate.CTipoUbicacion;
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

}
