
package com.pp.exceptions;

import java.io.Serializable;


public class ApplicationException  extends RuntimeException {

	
	/**
	 * Serial para Serializable 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException(String strE){
		super(strE);
	}
	
	public ApplicationException(String strE,Throwable t){
		super(strE,t);
	}
	
	
}
