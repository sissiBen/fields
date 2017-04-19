package com.sben.dynamicform.client.model;


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
	
}
