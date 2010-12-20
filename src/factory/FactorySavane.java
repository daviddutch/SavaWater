package factory;

import java.util.ArrayList;
import java.util.List;

import world.AbstractField;

public class FactorySavane extends AbstractElementFactory {

	@Override
	public List<AbstractElement> createElements(AbstractField field) {
		List<AbstractElement> elements = new ArrayList<AbstractElement>();
		AbstractElement lion = Lion.getInstance(field);
		lion.setPosition(setInitPosition(elements));
		elements.add(lion);
		for (int i = 0; i < 8; i++) {
			AbstractElement herbe = new Herbe(field);
			herbe.setPosition(setInitPosition(elements));
			elements.add(herbe);
		}
		for (int i = 0; i < 5; i++) {
			AbstractElement pygmee = new Pygmee(field);
			pygmee.setPosition(setInitPosition(elements));
			elements.add(pygmee);
		}
		for (int i = 0; i < 15; i++) {
			AbstractElement gazelle = new Gazelle(field);
			gazelle.setPosition(setInitPosition(elements));
			elements.add(gazelle);
		}
		return elements;
	}

}
