package com.pp.util.validator;


import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.pp.util.MessageUtil;

public class EmailValidator implements Validator {

	public void validate(FacesContext context, UIComponent validate, Object value)
			throws ValidatorException {
		String email = (String)value;

        if(email.indexOf('@')==-1){
            ((UIInput)validate).setValid(false);
            context.addMessage(validate.getClientId(context), MessageUtil.getMessageStringFaces("com.pp.util.validator.emailvalidator.email.error", context ));
        }

	}

}
