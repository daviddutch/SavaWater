package factory;

import java.util.ArrayList;

import world.AbstractField;
import world.GridPoint;

public class Lion extends AbstractElementSavane {
  private static Lion instance;
  private static final int MAX_LIFE=5;
  private int life=MAX_LIFE;
  private boolean hasEaten=false;
  public static final String IMG = "src/ressources/savane/lion.png";
  
  private Lion(AbstractField field){
    super(field);
    allowedMoves = new boolean[][] {{true, true, true},{true, true, true}, {true, true, true}};
  }
  
  public static Lion getInstance(AbstractField field){
    if (instance==null) instance = new Lion(field);
    return instance;
  }
  
  @Override
  public void move() {
    ArrayList<AbstractElement> listElem = getReachableElemAtDist(0);
    for (AbstractElement elem : listElem){
      if (elem instanceof Gazelle){
        field.removeElement(elem);
        life=MAX_LIFE;
        hasEaten=true;
        setPosition(elem.getPosition());
      }else if (elem instanceof Pygmee){
        life=MAX_LIFE;
        hasEaten=true;
        setPosition(elem.getPosition());
      }else{
        GridPoint nextPos = getRndFreePoint();
        if (nextPos!=null)
          setPosition(nextPos);
      }
    }
  }
  
  @Override
  public void evolve() {
    if (!hasEaten) life--;
    hasEaten=false;
    if (life<0) field.removeElement(this);
  }
}
