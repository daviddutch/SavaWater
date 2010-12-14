package factory;

import java.util.ArrayList;
import java.util.List;

import world.AbstractField;

public abstract class AbstractElementWater extends AbstractElement {
	
	public List<AbstractElement> createElements(AbstractField field){
		List<AbstractElement> elements = new ArrayList<AbstractElement>();
		// TODO placement des elements, définition du type, set field
		AbstractElement orque = Orque.getInstance();
		elements.add(orque);
		for (int i = 0; i < 5; i++) {
			AbstractElement banquise = new Banquise();
			elements.add(banquise);
		}
		for (int i = 0; i < 15; i++) {
			AbstractElement pingouin = new Pingouin();
			elements.add(pingouin);
		}
		for (int i = 0; i < 5; i++) {
			AbstractElement requin = new Requin();
			elements.add(requin);
		}
		return elements;
	}

}
