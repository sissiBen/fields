package com.sben.dynamicform.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public class Param {
	
	public static final String STRING_TYPE = "stringType";
	public static final String LIST_TYPE = "listType";
	
	public static final String ADHERENT_MODEL = "adherentModel";
	public static final String ASSOCIATION_MODEL = "associationModel";
	
	private int id;
	private String name;
	private String modelType;
	private String type;
	private boolean required;
	private List<PossibleValue> values = new ArrayList<PossibleValue>();
	
	
	public interface ParamInterface{
		
		public int getId();
		
		public String getName() ;

		public String getModelType() ;

		public String getType() ;

		public boolean isRequired();

		public List<PossibleValue> getValues() ;
		public void setValues(List<PossibleValue> list) ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public List<PossibleValue> getValues() {
		return values;
	}

	public void setValues(List<PossibleValue> values) {
		this.values = values;
	}



	interface Factory extends AutoBeanFactory {
		  AutoBean<ParamInterface> instance();
		  
		}
	
	Factory factory = GWT.create(Factory.class);
	 
	ParamInterface instance() {
		    // Construct the AutoBean
		    AutoBean<ParamInterface> model = factory.instance();
		    
		    return model.as();
		  }
	 
	 public ParamInterface deserializeFromJson(String json) {
		    AutoBean<ParamInterface> bean = AutoBeanCodex.decode(factory, ParamInterface.class, json);
		    
		   AutoBean<ParamInterface> ccc = AutoBeanCodex.decode(factory, ParamInterface.class, "{\"values\": " + json + "}");
//		    List<PossibleValue> list = ccc.as().getValues();
		   ParamInterface param = ccc.as();
//		   param.setValues(list);
		    return param;
		  }

//	 public List<PossibleValue>  deserializeValuesFromJson(String json) {
//		   List<PossibleValue> list = ((Param) AutoBeanCodex.decode(factory, ParamInterface.class, "{\"values\": " + json + "}")).getValues();
//		   
//		    return list;
//		  }
	
}