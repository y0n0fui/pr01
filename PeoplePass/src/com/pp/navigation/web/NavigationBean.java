package com.pp.navigation.web;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.security.context.SecurityContextHolder;




/**
 * NavigationBean class es la responsable de almacenar
 * el estado del panel stacks que despliega el contenido dinamico. 
 * 
 * @version 1.0
 */
public class NavigationBean {

   /**
    * Panel actualmente seleccionado.
    */
    private String selectedPanel = "userPanel";

   
    
    /**
     * Obtener el panel actualmente seleccionado
     * @return String nombre del panel seleccionado
     */
    public String getSelectedPanel() {
        return selectedPanel;
    }

    /**
	 * @return the user
	 */
	public org.springframework.security.userdetails.User getUser() {
		org.springframework.security.userdetails.User user = null;
		try{
		user = (org.springframework.security.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) { //no se encuentra en un contexto de seguridad, entonces debe retornar null
			user = null;
		}
		return user;  
	}

    /**
     * Evento realizado en el cambio de stack
     *
     * @param event JSF Action Event.
     */
    public void navigationStackChange(ActionEvent event){

        // get from the context panel stack item to show as well
        // as the title associated with the link.
        FacesContext context = FacesContext.getCurrentInstance();
       
        Map<String,String> map = context.getExternalContext().getRequestParameterMap();
        selectedPanel = (String) map.get("stackName");
    }

	/**
     * Asginar el nombre del panel seleccionado.
     * @param selectedPanel nombre del panel seleccionado
     */
    public void setSelectedPanel(String selectedPanel) {
        this.selectedPanel = selectedPanel;
    }

    public String getResources(){
    	return "rolePanel";
    }
}
