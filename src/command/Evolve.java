package command;

import factory.AbstractElement;

public abstract class Evolve extends Command {

	public void doit() {
	  element.evolve();
	}

	public Evolve(AbstractElement el){
	  element = el;
	}
	
}
