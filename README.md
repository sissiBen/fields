# fields
create a form and fill it with dynamic fields according to a parameters list
using GWT, Uibinder, GwtBootstrap

A parameter can be a title, a date, a boolean, a list of titles (to choose)

the types are listed in Param.java :
  public static final String STRING_TYPE = "stringType";
	public static final String LIST_TYPE = "listType";
	public static final String DATE_TYPE = "dateType";
	public static final String BOOLEAN_TYPE = "booleanType";

MyForm is the main view, we add feilds (paramView ) into it Dynamically using a factory (ParamFactory.java) to add 
the right GWTBootstrap widget (textBox , DatePicker, ValueListBox, Checkbox)

some paramaters are used as example (the 4 types) in the class GetActifParamsCommand,
you can add others paramaters, delete ... to test 

Here is a simple example to add one :
  Param param= new Param();
	param.setId(1);
	param.setType(Param.STRING_TYPE);
	param.setName("Name");
	param.setRequired(true);
	list.add(param);



