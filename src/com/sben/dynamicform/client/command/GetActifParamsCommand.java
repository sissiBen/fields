package com.sben.dynamicform.client.command;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Command;
import com.sben.dynamicform.client.model.Param;
import com.sben.dynamicform.client.model.PossibleValue;

public class GetActifParamsCommand implements Command{
	
	private OnGetObjectsDatasListener onGetObjectsDatasListener;

	public GetActifParamsCommand(
			OnGetObjectsDatasListener onGetObjectsDatasListener) {
		this.onGetObjectsDatasListener = onGetObjectsDatasListener;
		
	}

	@Override
	public void execute() {
		// TODO Recuperer la liste des parametres
		// ici je vais créer une liste
		List<Param> list = populateParams();
		
		onGetObjectsDatasListener.getObjectDatas(list);
	}

	private List<Param> populateParams() {
		
	   List<Param> list= new ArrayList<Param>();
	   Param param= new Param();
	   param.setId(1);
	   param.setType(Param.STRING_TYPE);
	   param.setName("Name");
	   param.setRequired(true);
	   list.add(param);
	   
	   param= new Param();
	   param.setId(2);
	   param.setType(Param.LIST_TYPE);
	   param.setName("Level");
	   
	   List<PossibleValue> values = new ArrayList<PossibleValue>();
	   PossibleValue value =  new PossibleValue();
	   value.setId(1);
	   value.setName("Level 1");
	   values.add(value);
	   
	   value =  new PossibleValue();
	   value.setId(2);
	   value.setName("Level 2");
	   values.add(value);
	   
	   value =  new PossibleValue();
	   value.setId(3);
	   value.setName("Level 3");
	   values.add(value);
	   
	   param.setValues(values);
	   param.setRequired(false);
	   list.add(param);
	   
	   
	   param= new Param();
	   param.setId(3);
	   param.setType(Param.DATE_TYPE);
	   param.setName("Date");
	   param.setRequired(true);
	   list.add(param);
	   
	   param= new Param();
	   param.setId(5);
	   param.setType(Param.BOOLEAN_TYPE);
	   param.setName("Delivery");
	   list.add(param);
	   
	   return list;
	}

}
