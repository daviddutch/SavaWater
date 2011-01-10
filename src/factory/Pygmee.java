package factory;

import java.util.ArrayList;

import world.AbstractField;
import world.GridPoint;

public class Pygmee extends AbstractElementSavane {
  public static final String IMG = "src/ressources/savane/pygmee.png";
  
  private static final int MAX_LIFE=5;
  private int life=MAX_LIFE;
  private boolean hasEaten=false;
  
  public Pygmee(AbstractField field){
    super(field);
    img = "src/ressources/savane/pygmee.png";
    letter = "P";
    allowedMoves = new boolean[][] {{true, false, true},{false, true, false}, {true, false, true}};
  }
  @Override
  public void move() {
    ArrayList<AbstractElement> listElem = getReachableElemAtDist(0);
    for (AbstractElement elem : listElem){
      if (elem instanceof Gazelle){
        Gazelle gazelle = (Gazelle)elem;
        life     = MAX_LIFE;
        hasEaten = true;
        setPosition(elem.getPosition());
        return;
      }else if (elem instanceof Herbe || isOnGrass()){
        life++;
        hasEaten = true;
        setPosition(elem.getPosition());
        return;
      }
    }
    GridPoint nextPos = getRndFreePoint();
    if (nextPos!=null)
      setPosition(nextPos);
  }
  private boolean isOnGrass(){
    ArrayList<AbstractElement> listElem = getElementsAtPos(getPosition());
    for (AbstractElement elem : listElem){
      if (elem instanceof Herbe) return true;
    }
    return false;
  }
  @Override
  public void evolve() {
    if (!hasEaten) life--;
    hasEaten=false;
    if (life<0) field.removeElement(this);
  }
}
