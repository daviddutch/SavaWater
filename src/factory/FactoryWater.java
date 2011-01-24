package factory;

import java.util.ArrayList;
import java.util.List;

import world.AbstractField;

public class FactoryWater extends AbstractElementFactory {
	
  @Override
  public List<AbstractElement> createElements(AbstractField field){
		List<AbstractElement> elements = new ArrayList<AbstractElement>();
		AbstractElement orque = Orque.getInstance(field);
		orque.setPosition(setInitPosition(elements));
		
		for (int i = 0; i < 3; i++) {
			AbstractElement banquise = new Banquise(field);
			banquise.setPosition(setInitPosition(elements));
			elements.add(banquise);
		}
		for (int i = 0; i < 15; i++) {
			AbstractElement pingouin = new Pingouin(field);
			pingouin.setPosition(setInitPosition(elements));
			elements.add(pingouin);
		}
		for (int i = 0; i < 10; i++) {
			AbstractElement requin = new Requin(field);
			requin.setPosition(setInitPosition(elements));
			elements.add(requin);
		}
		elements.add(0,orque);
		return elements;
	}

}
