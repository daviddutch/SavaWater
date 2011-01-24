package factory;

import java.util.ArrayList;

import factory.AbstractElement.Gender;

import world.AbstractField;
import world.GridPoint;

public class Lion extends AbstractElementSavane {
  private static Lion instance;
  private static final int MAX_LIFE=5;
  private int life=MAX_LIFE;
  
  private Lion(AbstractField field){
    super(field);
    img = "/ressources/savane/lion.png";
    letter = "L";
    allowedMoves = new boolean[][] {{true, true, true},{true, true, true}, {true, true, true}};
  }
  
  public static Lion getInstance(AbstractField field){
    if (instance==null) instance = new Lion(field);
    return instance;
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
      }else if (elem instanceof Pygmee){
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
      }else if (elem instanceof Pygmee){
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
