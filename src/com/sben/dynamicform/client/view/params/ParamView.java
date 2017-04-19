package com.sben.dynamicform.client.view.params;

import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.ValueListBox;
import org.gwtbootstrap3.client.ui.base.ValueBoxBase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sben.dynamicform.client.ParamFactory;
import com.sben.dynamicform.client.extra.MyDatePicker;
import com.sben.dynamicform.client.model.Param;
import com.sben.dynamicform.client.model.PossibleValue;


/**
 * a view containing one paramater widget to add dynamically
 *
 */
public class ParamView extends Composite {

	private static ParamViewUiBinder uiBinder = GWT
			.create(ParamViewUiBinder.class);

	interface ParamViewUiBinder extends UiBinder<Widget, ParamView> {
	}

	@UiField
	FlowPanel flowPanel;
	
	@UiField
	FormLabel label;
	
	private Widget paramWidget;

	private Param param;

	public ParamView(Param param) {
		
		//get the param widget(textbox/ datePicker ...)
		paramWidget =  ParamFactory.getParamWidget(param);
		
		initWidget(uiBinder.createAndBindUi(this));
		
		// paramater name
		label.setText(param.getName());
		
		flowPanel.add(paramWidget);
		
		this.param = param;
	}

	public boolean validate() {
		
		if(paramWidget instanceof ValueBoxBase){
			return ((ValueBoxBase)paramWidget).validate();
		}else if(paramWidget instanceof ValueListBox){
			return ((ValueListBox)paramWidget).validate();
		}
		else if(paramWidget instanceof MyDatePicker){
			return ((MyDatePicker)paramWidget).validate();
		}
		else if(paramWidget instanceof CheckBox){
			return true;
		}
		
		return false;
	}

	public JSONString getValue(){
		
		 DateTimeFormat dtf = DateTimeFormat.getFormat("MM-dd-yyyy");
		
		if(paramWidget instanceof ValueBoxBase){
			return new JSONString(((ValueBoxBase)paramWidget).getValue()+"");
		}else if(paramWidget instanceof ValueListBox){
			return  ((ValueListBox<PossibleValue>) paramWidget).getValue()==null ?null: new JSONString(((ValueListBox<PossibleValue>) paramWidget).getValue().getId()+"");
		}
		else if(paramWidget instanceof MyDatePicker){
			return new JSONString(((MyDatePicker) paramWidget).getValue()== null? null : dtf.format(((MyDatePicker) paramWidget).getValue()));
		}
		else if(paramWidget instanceof CheckBox){
			return new JSONString(((CheckBox) paramWidget).getValue()+"");
		}
		return null;
	}

	public Param getParam() {
		return param;
	}


}
