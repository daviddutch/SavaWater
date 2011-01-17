package factory;

import java.util.ArrayList;

import world.AbstractField;
import world.GridPoint;

public class Requin extends AbstractElementWater {
  private static final int MAX_LIFE=8;
  private int life=MAX_LIFE;
  private boolean hasEaten=false;
  
  public Requin(AbstractField field) {
    super(field);
    img = "src/ressources/water/requin.png";
    letter = "R";
    allowedMoves = new boolean[][] {{false, true, false},{true, true, true}, {false, true, false}};
  }

  @Override
  public void move() {
    ArrayList<AbstractElement> listElem = getReachableElemAtDist(0);
    for (AbstractElement elem : listElem){
      if (elem instanceof Pingouin){
        life     = MAX_LIFE;
        hasEaten = true;
        field.removeElement(elem);
        return;
      }
    }
    GridPoint nextPos = getRndFreePoint();
    if (nextPos!=null)
      setPosition(nextPos);
  }

  @Override
  public void evolve() {
    if (!hasEaten) life--;
    hasEaten=false;
    if (life<0) field.removeElement(this);
  }
/*
  @Override
  public GridPoint getPosition() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setPosition(GridPoint point) {
    // TODO Auto-generated method stub
    
  }*/

}
