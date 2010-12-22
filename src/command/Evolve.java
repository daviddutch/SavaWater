package command;

import factory.AbstractElement;

public class Evolve extends Command {

	public void doit() {
	  element.evolve();
	}

	public Evolve(AbstractElement el){
	  element = el;
	}
	
}
