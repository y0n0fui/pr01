
package com.pp.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Clase que permite el manejo de Bundle de mensajes
 * @author Fredy Sierra
 */
public class MessageUtil {
	
	
	
	/**
	 * Obtener un mensaje para faces.
	 * @param keyString Key del mensaje
	 * @param context Contexto de faces 
	 * @return String
	 */
	public static String getMessageString(String keyString, 
			FacesContext context){
			String text = MessageUtil.getMessageString(keyString,
				context.getViewRoot().getLocale()
				, context.getApplication().getMessageBundle()); 
			return text;
	}
	
	/**
	 * Obtener un mensaje dado un key
	 * @param keyMsg key
	 * @param locale location
	 * @param bundleName Nombre del bundle
	 * @return text del mensaje
	 */
	public static String getMessageString(String keyMsg, Locale locale, String bundleName){
		String text = null;
		
		ResourceBundle bundle = 
				ResourceBundle.getBundle(bundleName, locale);
		
		try{
			text = bundle.getString(keyMsg);
		}catch (MissingResourceException e) {
			text = "?? key " + keyMsg + " not found ??";
		}
		return text;
	}	
	
	/**
	 * Obtener un mensaje para faces.
	 * @param keyString Key del mensaje
	 * @param context Contexto de faces 
	 * @return FacesMessage
	 */
	public static FacesMessage getMessageStringFaces(String keyString, 
			FacesContext context){
			String text = MessageUtil.getMessageString(keyString,
				context.getViewRoot().getLocale()
				, context.getApplication().getMessageBundle()); 
			return new FacesMessage(text);
	}	

}
