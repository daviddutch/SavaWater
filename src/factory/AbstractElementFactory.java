package factory;

import java.util.List;
import java.util.Random;

import world.AbstractField;
import world.GridPoint;

public abstract class AbstractElementFactory {
  public abstract List<AbstractElement> createElements(AbstractField field);
  private Random rnd = new Random();
  protected GridPoint setInitPosition(List<AbstractElement> l) {
	  boolean position_ok;
	  int x;
	  int y;
	  do{
		  position_ok=true;
		  x = rnd.nextInt(AbstractField.SIZE_X);
		  y = rnd.nextInt(AbstractField.SIZE_Y);
		  for (AbstractElement el : l) {
			if(el.getPosition().getX()==x && el.getPosition().getY()==y)
				position_ok=false;
		}
	  }while(!position_ok);
	  return new GridPoint(x, y);
}
}
