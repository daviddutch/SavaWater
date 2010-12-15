package factory;

import world.AbstractField;

import java.util.ArrayList;
import java.util.List;

import world.AbstractField;

public abstract class AbstractElementSavane extends AbstractElement {

  public AbstractElementSavane(AbstractField field) {
    super(field);
    // TODO Auto-generated constructor stub
  }

	public List<AbstractElement> createElements(AbstractField field){
		List<AbstractElement> elements = new ArrayList<AbstractElement>();
		AbstractElement lion = Lion.getInstance(field);
		elements.add(lion);
		for (int i = 0; i < 8; i++) {
			AbstractElement herbe = new Herbe(field);
			elements.add(herbe);
		}
		for (int i = 0; i < 5; i++) {
			AbstractElement pygmee = new Pygmee(field);
			elements.add(pygmee);
		}
		for (int i = 0; i < 15; i++) {
			AbstractElement gazelle = new Gazelle(field);
			elements.add(gazelle);
		}
		return elements;
	}
	
}
