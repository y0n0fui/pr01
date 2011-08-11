
package com.pp.admin.facade;

import java.util.List;

import com.pp.admin.hibernate.CTipoCargo;
import com.pp.admin.hibernate.CTipoIdentificacion;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.admin.hibernate.KRoles;
import com.pp.admin.hibernate.KUsuariosEmpresas;
import com.pp.admin.hibernate.KUsuariosFunciones;


public interface IUserAdmin {
	
	
	
	public void delete(CTipoCargo tipoCargo);
	
	
	public void delete(CTipoIdentificacion tipoIdentificacion);
	
	
	
	
	public void delete(KEmpresas empresa);
	
	public void delete(KRoles role);
	
	
	
	public void delete(KUsuariosEmpresas usuariosEmpresas);
	
	
	public void delete(KUsuariosFunciones usuariosFunciones);
	
	
	public KEmpresas getEmpresa(int idEmpresa);
	
	
	public List<KEmpresas> getEmpresas();
	
	
	
	public List<KRoles> getRoles();
	
	
	public KRoles getRoles(int idRole);
	
	
	public List<CTipoCargo> getTipoCargo();
	
	
	public CTipoCargo getTipoCargo(int idTipoCargo);
	
	
	public List<CTipoIdentificacion> getTipoIdentificacion();
	
	
	public CTipoIdentificacion getTipoIdentificacion(int idTipoIdentificacion);
	
	
	public List<KUsuariosEmpresas> getUsuarioEmpresas();
	
	
	public KUsuariosEmpresas getUsuarioEmpresas(int idUsuarioEmpresa);
	
	
	public List<KUsuariosEmpresas> getUsuarioEmpresasByEmpresa(int empresaId);
	
	
	public KUsuariosFunciones getUsuarioFunciones(int idUsuarioFunciones);
	

	public List<KUsuariosFunciones> getUsuariosFunciones();
	
	
	public void save(CTipoCargo tipoCargo);
	
	
	public void save(CTipoIdentificacion tipoIdentificacion);
	
	
	public void save(KEmpresas empresa);
	
	
	public void save(KRoles role);
	
	
	public void save(KUsuariosEmpresas usuarioEmpresas);
	
	
	public void save(KUsuariosFunciones usuarioFunciones);
	
	
}
