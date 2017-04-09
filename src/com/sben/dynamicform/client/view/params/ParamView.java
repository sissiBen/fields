package com.sben.dynamicform.client.view.params;

import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.ValueListBox;
import org.gwtbootstrap3.client.ui.base.ValueBoxBase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sben.dynamicform.client.model.Param;
import com.sben.dynamicform.client.model.PossibleValue;

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
		paramWidget =  ParamFactory.getParamWidget(param);
		initWidget(uiBinder.createAndBindUi(this));
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
		return false;
	}

	public JSONString getValue(){
		
		if(paramWidget instanceof ValueBoxBase){
			if(((ValueBoxBase<PossibleValue>) paramWidget).getValue()==null ){
				System.out.println( "valueboxbase getvalue nulll" );
			}
			else{
			System.out.println( "valueboxbase getvalue " +((ValueBoxBase) paramWidget).getValue()+"");
			}
			return new JSONString(((ValueBoxBase)paramWidget).getValue()+"");
		}else if(paramWidget instanceof ValueListBox){
			System.out.println( "ValueListBox getvalue " + ((ValueListBox)paramWidget).getValue()+"");
//			return ((ValueListBox<String>)paramWidget).getValue();
			return  ((ValueListBox<PossibleValue>) paramWidget).getValue()==null ?null: new JSONString(((ValueListBox<PossibleValue>) paramWidget).getValue().getId()+"");
			
		}
		return null;
	}
	
	public int getParamId() {
		return param.getId();
	}

}
