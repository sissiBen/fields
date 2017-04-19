package com.sben.dynamicform.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sben.dynamicform.client.view.MyForm;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Dynamicform implements EntryPoint {
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		MyForm form = new MyForm();
		form.init();
		RootPanel.get().add(form);}
}
