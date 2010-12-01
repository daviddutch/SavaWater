package command;

import world.AbstractField;
import factory.AbstractElement;

public abstract class Command {

	private AbstractField f;
	private AbstractElement element;
	
	public abstract void doit();
	
}
