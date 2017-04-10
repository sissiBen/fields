package com.sben.dynamicform.client.extra;


import java.util.Date;
import java.util.List;

import org.gwtbootstrap3.client.ui.base.mixin.BlankValidatorMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ErrorHandlerMixin;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandler;
import org.gwtbootstrap3.client.ui.form.error.ErrorHandlerType;
import org.gwtbootstrap3.client.ui.form.error.HasErrorHandler;
import org.gwtbootstrap3.client.ui.form.validator.HasBlankValidator;
import org.gwtbootstrap3.client.ui.form.validator.HasValidators;
import org.gwtbootstrap3.client.ui.form.validator.ValidationChangedEvent.ValidationChangedHandler;
import org.gwtbootstrap3.client.ui.form.validator.Validator;
import org.gwtbootstrap3.extras.datepicker.client.ui.DatePicker;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.HandlerRegistration;



public class MyDatePicker extends DatePicker implements HasValidators<Date>, HasEditorErrors<Date>, HasErrorHandler,
HasBlankValidator<Date>,HasValue<Date>, Editor<Date> {
	
	 private final ErrorHandlerMixin<Date> errorHandlerMixin = new ErrorHandlerMixin<Date>(this);

	    private final BlankValidatorMixin<MyDatePicker, Date> validatorMixin = new BlankValidatorMixin<MyDatePicker, Date>(this,
	        errorHandlerMixin.getErrorHandler());
	@Override
	public HandlerRegistration addValidationChangedHandler(
			ValidationChangedHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addValidator(Validator<Date> validator) {
		 validatorMixin.addValidator(validator);
		
	}

	@Override
	public boolean getValidateOnBlur() {
		return validatorMixin.getValidateOnBlur();
	}

	@Override
	public void reset() {
		 setValue(null);
	     validatorMixin.reset();
		
	}

	@Override
	public void setValidateOnBlur(boolean validateOnBlur) {
		validatorMixin.setValidateOnBlur(validateOnBlur);
		
	}

	@Override
	public void setValidators(Validator<Date>... validators) {
		validatorMixin.setValidators(validators);
		
	}

	 @Override
	    public boolean validate() {
	        return validatorMixin.validate();
	    }

	    @Override
	    public boolean validate(boolean show) {
	        return validatorMixin.validate(show);
	    }

	@Override
	public boolean getAllowBlank() {
		return validatorMixin.getAllowBlank();
	}

	@Override
	public void setAllowBlank(boolean allowBlank) {
		validatorMixin.setAllowBlank(allowBlank);
		
	}
	/** {@inheritDoc} */
    @Override
    public void showErrors(List<EditorError> errors) {
        errorHandlerMixin.showErrors(errors);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandler getErrorHandler() {
        return errorHandlerMixin.getErrorHandler();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandlerMixin.setErrorHandler(handler);
    }

    /** {@inheritDoc} */
    @Override
    public ErrorHandlerType getErrorHandlerType() {
        return errorHandlerMixin.getErrorHandlerType();
    }

    /** {@inheritDoc} */
    @Override
    public void setErrorHandlerType(ErrorHandlerType type) {
        errorHandlerMixin.setErrorHandlerType(type);
    }

	
}