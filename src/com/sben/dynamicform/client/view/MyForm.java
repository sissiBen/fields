package com.sben.dynamicform.client.view;

import java.util.List;

import org.gwtbootstrap3.client.ui.FieldSet;
import org.gwtbootstrap3.client.ui.Form;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sben.dynamicform.client.command.GetActifParamsCommand;
import com.sben.dynamicform.client.command.OnGetObjectsDatasListener;
import com.sben.dynamicform.client.model.Param;
import com.sben.dynamicform.client.view.params.ParamView;

/**
 * the main view, where we add paramaters widget
 *
 */
public class MyForm extends Composite {
	
	@UiField
	Form form;
	
	@UiField
	FieldSet fieldSet;
	
	
	private static MyFormUiBinder uiBinder = GWT
			.create(MyFormUiBinder.class);

	interface MyFormUiBinder extends UiBinder<Widget, MyForm> {
	}

	public MyForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	
	public boolean validate() {
		boolean bool = true;
		
		for (int i = 0; i <fieldSet.getWidgetCount(); i++) {
			boolean bool1 = ((ParamView) fieldSet.getWidget(i)).validate();
			bool = bool && bool1;
		}
		return bool;
	}


	public void init() {
		//getting list paramaters 
		GetActifParamsCommand command = new GetActifParamsCommand(new OnGetObjectsDatasListener() {
			
			@Override
			public void getObjectDatas(List<? extends Object> list) {
				
				List<Param> params = (List<Param>)list;
				addParamsWidgets(params);
			}
		});
		command.execute();
		
	}


	protected void addParamsWidgets(List<Param> params) {
		// add widgets 
		for (Param param : params) {
			
			ParamView paramWidget = new ParamView(param);
			fieldSet.add(paramWidget);
		}
		
	}
	
	@UiHandler("validatebt")
	void handleClick(ClickEvent e) {
		boolean valid =  validate();
	    if(valid){
	    	getData();
	    }
	    
	  }

	public JSONObject getData() {
		
		JSONObject paramatersMap = new JSONObject();
		String toDisplay = "values >>>> ";
			
		for (int i = 0; i <fieldSet.getWidgetCount(); i++) {
				ParamView widget = (ParamView) fieldSet.getWidget(i);
				paramatersMap.put(widget.getParam().getId()+"", widget.getValue());
				toDisplay = toDisplay + " ---- "+widget.getParam().getName() + ":" + widget.getValue();
			}
			System.out.println("Data on validate : " + paramatersMap.toString());
			Window.alert(toDisplay);
			return paramatersMap;
	}
	
}
