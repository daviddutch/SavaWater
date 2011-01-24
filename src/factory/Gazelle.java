package factory;

import java.util.ArrayList;
import java.util.Random;

import world.AbstractField;
import world.GridPoint;

public class Gazelle extends AbstractElementSavane {
  private static final int MAX_LIFE=5;
  private int life=MAX_LIFE;
  private static Random rnd = new Random();
  
  public Gazelle(AbstractField field){
    super(field);
    img = "/ressources/savane/gazelle.png";
    letter = "G";
    allowedMoves = new boolean[][] {{false, true, false},{true, true, true}, {false, true, false}};
    
    if (rnd.nextBoolean()){
      gender = Gender.MALE;
    }else{
      gender = Gender.FEMALE;
    }
  }
  @Override
  public void move() {
    ArrayList<AbstractElement> listElem = getReachableElemAtDist();
    
    for (AbstractElement elem : listElem){ //for each rechable elements
      ArrayList<AbstractElement> atPos = getElementsAtPos(getPosition());
      if (elem instanceof Gazelle){
        if (atPos.size()<2){
          setPosition(elem.getPosition());
          return;
        }
      }else if (elem instanceof Herbe){
        if (atPos.size()<2){
          setPosition(elem.getPosition());
          return;
        }
      }
    }
    //no reachable element so move randomly
    GridPoint nextPos = getRndFreePoint();
    if (nextPos!=null)
      setPosition(nextPos);
  }
  
  @Override
  public void evolve() {
    ArrayList<AbstractElement> listElem = getElementsAtPos(getPosition());
    
    for (AbstractElement elem : listElem){
      if (elem instanceof Gazelle){
        Gazelle gazelle = (Gazelle)elem;
        if (gender==Gender.MALE && gazelle.gender==Gender.FEMALE){
          GridPoint childPos = getRndFreePoint();
          if (childPos!=null){
            Gazelle child = new Gazelle(field);
            child.setPosition(childPos);
            field.addElement(child);
          }
        }
        break;
      }else if (elem instanceof Herbe){
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
