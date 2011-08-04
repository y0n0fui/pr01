
package com.pp.admin.facade;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;



import com.pp.admin.hibernate.CTipoCargo;
import com.pp.admin.hibernate.CTipoIdentificacion;
import com.pp.admin.hibernate.KEmpresas;
import com.pp.admin.hibernate.KRoles;
import com.pp.admin.hibernate.KUsuariosEmpresas;
import com.pp.admin.hibernate.KUsuariosFunciones;


public interface IUserAdmin {
	
	
	
	public List<KRoles> getRoles();
	
	
	public void save(KRoles role);
	
	
	
	
	public KRoles getRoles(int idRole);
	
	public void delete(KRoles role);
	
	
	
	public List<CTipoCargo> getTipoCargo();
	
	
	public void save(CTipoCargo tipoCargo);
	
	
	public CTipoCargo getTipoCargo(int idTipoCargo);
	
	
	public void delete(CTipoCargo tipoCargo);
	
	
	
	public List<CTipoIdentificacion> getTipoIdentificacion();
	
	
	public void save(CTipoIdentificacion tipoIdentificacion);
	
	
	public CTipoIdentificacion getTipoIdentificacion(int idTipoIdentificacion);
	
	
	public void delete(CTipoIdentificacion tipoIdentificacion);
	
	
	public List<KEmpresas> getEmpresas();
	
	
	public void save(KEmpresas empresa);
	
	
	public KEmpresas getEmpresa(int idEmpresa);
	
	
	public void delete(KEmpresas empresa);
	
	
	public List<KUsuariosEmpresas> getUsuarioEmpresas();
	
	
	public void save(KUsuariosEmpresas usuarioEmpresas);
	

	public KUsuariosEmpresas getUsuarioEmpresas(int idUsuarioEmpresa);
	
	
	public void delete(KUsuariosEmpresas usuariosEmpresas);
	
	
	public List<KUsuariosFunciones> getUsuariosFunciones();
	
	
	public void save(KUsuariosFunciones usuarioFunciones);
	
	
	public KUsuariosFunciones getUsuarioFunciones(int idUsuarioFunciones);
	
	
	public void delete(KUsuariosFunciones usuariosFunciones);
	
	
	public List<KUsuariosEmpresas> getUsuarioEmpresasByEmpresa(int empresaId);
	
	
}
