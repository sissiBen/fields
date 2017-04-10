package com.sben.dynamicform.client;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.DoubleBox;
import org.gwtbootstrap3.client.ui.IntegerBox;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.ValueListBox;

import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.Widget;
import com.sben.dynamicform.client.extra.MyDatePicker;
import com.sben.dynamicform.client.model.Param;
import com.sben.dynamicform.client.model.PossibleValue;

public class ParamFactory {

		public static Widget getParamWidget(Param param) {
			
			switch (param.getType()) {
				
			case Param.STRING_TYPE:
				return getStringParamWiget(param);
				
			case Param.LIST_TYPE:
				return getListParamWiget(param);
				
			case Param.DATE_TYPE:
				return getDateParamWiget(param);
				
			case Param.BOOLEAN_TYPE:
				return getBooleanParamWiget(param);
				
			default:
				return null;
			}
		}


		private static ValueListBox<PossibleValue> getListParamWiget(Param param) {
			ValueListBox<PossibleValue> widget = new ValueListBox<PossibleValue>(new Renderer<PossibleValue>() {

				@Override
				public String render(PossibleValue object) {
					// TODO Auto-generated method stub
					 return object == null ? "" : object.getName();
				
					  }

					  public void render(PossibleValue object, Appendable appendable) throws IOException {

					      appendable.append(render(object));
					  }
					});
			widget.setAcceptableValues(param.getValues());
			widget.setAllowBlank(!param.isRequired());
			
			return widget;
		}

		private static TextBox getStringParamWiget(Param param) {
			TextBox widget = new TextBox() ;
			widget.setAllowBlank(!param.isRequired());
			return widget;
		}


		
		private static MyDatePicker getDateParamWiget(Param param) {
			MyDatePicker widget = new MyDatePicker() ;
			widget.setAllowBlank(!param.isRequired());
			return widget;
		}

		private static CheckBox getBooleanParamWiget(Param param) {
			CheckBox widget = new CheckBox() ;
			return widget;
		}

		
		
		
}
