package com.sben.dynamicform.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public class Param {
	
	// param types
	public static final String STRING_TYPE = "stringType";
	public static final String LIST_TYPE = "listType";
	public static final String DATE_TYPE = "dateType";
	public static final String BOOLEAN_TYPE = "booleanType";
	
	private int id;
	private String name;
	private String type;
	private boolean required;
	
	// values to select in case of a list type
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

}