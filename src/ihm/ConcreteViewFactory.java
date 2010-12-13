package ihm;

import world.AbstractField;

public class ConcreteViewFactory extends AbstractVueFactory {

	public AbstractView createView(String type, AbstractField field) {
		if(type.equals("consol")){
			return new ConsolView(field);
		}
		else if(type.equals("graphic")){
			return new GraphicView(field);
		}
		else {
			System.out.println("Error, unknow view.");
			return null;
		}
	}

}
