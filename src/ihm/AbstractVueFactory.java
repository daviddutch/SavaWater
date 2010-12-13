package ihm;

import world.AbstractField;

public abstract class AbstractVueFactory {

	public abstract AbstractView createView(String type, AbstractField field);
	
}
