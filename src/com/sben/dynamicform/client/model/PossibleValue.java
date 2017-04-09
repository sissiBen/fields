package com.sben.dynamicform.client.model;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public class PossibleValue {
	
	
	private int id;
	private String name;
	
	
	
	public interface PossibleValueInterface{
		
		public int getId();
		
		public String getName() ;

		
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


	interface Factory extends AutoBeanFactory {
		  AutoBean<PossibleValueInterface> instance();
		  
		}
	
	Factory factory = GWT.create(Factory.class);
	 
	PossibleValueInterface instance() {
		    // Construct the AutoBean
		    AutoBean<PossibleValueInterface> model = factory.instance();
		    
		    return model.as();
		  }
	 
	 public PossibleValueInterface deserializeFromJson(String json) {
		    AutoBean<PossibleValueInterface> bean = AutoBeanCodex.decode(factory, PossibleValueInterface.class, json);
		    return bean.as();
		  }

	
	
}
