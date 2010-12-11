package command;

import factory.AbstractElement;

public abstract class Command {

	protected AbstractElement element;
	
	public abstract void doit();
	
}
