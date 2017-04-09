package com.sben.dynamicform.client.view.params;

import java.io.IOException;

import org.gwtbootstrap3.client.ui.DoubleBox;
import org.gwtbootstrap3.client.ui.IntegerBox;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.ValueListBox;

import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.Widget;
import com.sben.dynamicform.client.model.Param;
import com.sben.dynamicform.client.model.PossibleValue;

public class ParamFactory {

		public static Widget getParamWidget(Param param) {
			
			switch (param.getType()) {
				
			case Param.STRING_TYPE:
				return getStringParamWiget(param);
				
			case Param.LIST_TYPE:
				return getListParamWiget(param);
				
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

		private static DoubleBox getDoubleParamWiget(Param param) {
			DoubleBox widget = new DoubleBox() ;
			widget.setAllowBlank(!param.isRequired());
			return widget;
		}

		private static IntegerBox getIntParamWiget(Param param) {
			IntegerBox widget = new IntegerBox() ;
			widget.setAllowBlank(!param.isRequired());
			return widget;
		}
		
		
}
