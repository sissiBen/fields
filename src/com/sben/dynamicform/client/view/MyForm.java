package com.sben.dynamicform.client.view;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.FieldSet;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sben.dynamicform.client.command.GetActifParamsCommand;
import com.sben.dynamicform.client.command.OnGetObjectsDatasListener;
import com.sben.dynamicform.client.model.Param;
import com.sben.dynamicform.client.view.params.ParamView;

public class MyForm extends Composite {
	
	
	@UiField
	FieldSet fieldSet;
	
	
	private List<ParamView> listParamsView = new ArrayList<ParamView>();

	private static MyFormUiBinder uiBinder = GWT
			.create(MyFormUiBinder.class);

	interface MyFormUiBinder extends UiBinder<Widget, MyForm> {
	}

	public MyForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	
	public boolean validate() {
		System.out.println("Additional Infos validate");
		boolean bool = true;
		
		for (int i = 0; i <listParamsView.size(); i++) {
			boolean bool1 = listParamsView.get(i).validate();
			bool = bool && bool1;
		}
		return bool;
	}


	public void init() {
		
		GetActifParamsCommand command = new GetActifParamsCommand(new OnGetObjectsDatasListener() {
			
			@Override
			public void getObjectDatas(List<? extends Object> list) {
				
				System.out.println("GetActifParamsByModelTypeCommand retour list params : " + (List<Param>)list);
				List<Param> params = (List<Param>)list;
				System.err.println("params " + params);
				for (Param param : params) {
					System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> name " +param.getName());
					System.err.println("id " +param.getId());
					System.err.println(" type " +param.getType());
					System.err.println(" values " +param.getValues());
				}
				addParamsWidgets(params);
			}
		});
		command.execute();
		
	}


	protected void addParamsWidgets(List<Param> params) {
		for (Param param : params) {
			
			ParamView paramWidget = new ParamView(param);
			fieldSet.add(paramWidget);
			listParamsView.add(paramWidget);
		}
		
	}


//	public JSONObject getParamaters(JSONObject paramatersMap) {
//		
//		paramatersMap.put("job", combofuntion.getValue()==null ?null: new JSONString(combofuntion.getValue().getId()+""));
//		paramatersMap.put("motherjob", combofuntionM.getValue()==null ?null: new JSONString(combofuntionM.getValue().getId()+""));
//		paramatersMap.put("fatherjob", combofuntionF.getValue()==null ?null: new JSONString(combofuntionF.getValue().getId()+""));
//		paramatersMap.put("studylevel", comboYearStudy.getValue()==null ?null: new JSONString(comboYearStudy.getValue().getId()+""));
//		
//		for (ParamView widget : listParamsView) {
//			System.out.println("widget.getParamId()  " + widget.getParamId());
//			System.out.println("widget.getValue()  " + widget.getValue());
//			
//			paramatersMap.put(widget.getParamId()+"", widget.getValue());
//		}
//		
//		return paramatersMap;
//	}



}
