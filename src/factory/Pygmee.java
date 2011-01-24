package factory;

import java.util.ArrayList;

import world.AbstractField;
import world.GridPoint;

public class Pygmee extends AbstractElementSavane {
  private static final int MAX_LIFE=5;
  private int life=MAX_LIFE;
  
  public Pygmee(AbstractField field){
    super(field);
    img = "/ressources/savane/pygmee.png";
    letter = "P";
    allowedMoves = new boolean[][] {{true, false, true},{false, true, false}, {true, false, true}};
  }
  @Override
  public void move() {
    ArrayList<AbstractElement> listElem = getReachableElemAtDist();
    for (AbstractElement elem : listElem){
      ArrayList<AbstractElement> atPos = getElementsAtPos(getPosition());
      if (elem instanceof Gazelle){
        if (atPos.size()<2){
          setPosition(elem.getPosition());
          return;
        }
      }
    }
    GridPoint nextPos = getRndFreePoint();
    if (nextPos!=null)
      setPosition(nextPos);
  }
  @Override
  public void evolve() {
    ArrayList<AbstractElement> listElem = getElementsAtPos(getPosition());
    for (AbstractElement elem : listElem){
      if (elem instanceof Gazelle){
        field.removeElement(elem);
        life=MAX_LIFE;
        return;
      }
    }
    life--;
    if (life<0) {
      field.removeElement(this);
    }
  }
}
