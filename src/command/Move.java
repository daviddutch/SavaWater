package command;

import factory.AbstractElement;

public abstract class Move extends Command {

	public void doit() {
	  element.move();
	}

	public Move(AbstractElement el){
	  element = el;
	}
	
}
