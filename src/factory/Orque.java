package factory;

import java.util.ArrayList;

import world.AbstractField;
import world.GridPoint;

public class Orque extends AbstractElementWater {
  public Orque(AbstractField field) {
    super(field);
    allowedMoves = new boolean[][] {{false, true, false},{true, true, true}, {false, true, false}};
    img = "src/ressources/water/orque.png";
    letter = "O";
  }

  private static Orque instance;
  
  public static Orque getInstance(AbstractField field){
    if (instance==null) instance = new Orque(field);
    return instance;
  }
  
  @Override
  public void move() {
    GridPoint nextPos = getRndFreePoint();
    if (nextPos!=null)
      setPosition(nextPos);
  }
  
  @Override
  public void evolve() {
	  allowedMoves = new boolean[][] {{true, true, true},{true, true, true}, {true, true, true}};
	  ArrayList<AbstractElement> listElem = getReachableElemAtDist(0);
	  for (AbstractElement elem : listElem){
	     if (elem instanceof Banquise){
	        field.removeElement(elem);
	        return;
	      }
	    }
	    allowedMoves = new boolean[][] {{false, true, false},{true, true, true}, {false, true, false}};
  }

}
