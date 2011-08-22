package com.pp.admin.facade;

import java.util.List;

import com.pp.admin.hibernate.CTipoUbicacion;
import com.pp.admin.hibernate.KBancosTerceros;

import com.pp.admin.hibernate.KCiclo;

import com.pp.admin.hibernate.KConceptosFacturacion;
import com.pp.admin.hibernate.KCondicionesEspeciales;
import com.pp.admin.hibernate.KDefinicionDeducciones;
import com.pp.admin.hibernate.KEmpresaCorreo;
import com.pp.admin.hibernate.KRoles;
import com.pp.admin.hibernate.KUsuariosEmpresas;

public interface IParamsAdmin {

	

	public void delete(CTipoUbicacion tipoUbicacion);

	public void delete(KCiclo ciclo);

	

	public void delete(KCondicionesEspeciales condicionesEspeciales);

	public void delete(KDefinicionDeducciones def);

	public void delete(KEmpresaCorreo empresaCorreo);

	public List<KCiclo> getCiclo();

	public KCiclo getCiclo(int idCiclo);

	public List<KConceptosFacturacion> getConceptoFacturacion();

	

	public List<KCondicionesEspeciales> getCondicionesEspeciales();

	public KCondicionesEspeciales getCondicionesEspeciales(int idRole);

	public List<KDefinicionDeducciones> getDefinicionDeducciones();

	public KDefinicionDeducciones getDefinicionDeducciones(int idDef);

	public List<KEmpresaCorreo> getEmpresaCorreo();

	public KEmpresaCorreo getEmpresaCorreo(int id);
	
	public List<CTipoUbicacion> getTipoUbicacion();

	public CTipoUbicacion getTipoUbicacion(int idRole);

	public void save(CTipoUbicacion tipoUbicacion);

	public void save(KCiclo ciclo);
	
	
	public void save(KConceptosFacturacion conceptosFacturacion);

	public void save(KCondicionesEspeciales condicionesEspeciales);

	
	public void save(KDefinicionDeducciones definicionDeducciones);

	public void save(KEmpresaCorreo empresaCorreo);
	
	public KConceptosFacturacion getConceptoFacturacion(int idRole);
	
	public void delete(KConceptosFacturacion conceptosFacturacion);
	
	//KBancosTerceros
	public List<KBancosTerceros> getBancosTerceros();

	
	public void save(KBancosTerceros bancosTerceros);

	
	public KBancosTerceros getBancosTerceros(int idRole);
	
	public void delete(KBancosTerceros bancosTerceros);
	
	public List<KRoles> getRolesByUsuarioEmpresa(int usuarioEmpresa);
	public void save(List<KRoles> roles,KUsuariosEmpresas usuariosEmpresas, int user, String ipAddress);
	
}
