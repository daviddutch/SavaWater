package factory;

import java.util.ArrayList;
import java.util.Random;

import world.AbstractField;
import world.GridPoint;

public class Gazelle extends AbstractElementSavane {
  private static final int MAX_LIFE=5;
  private int life=MAX_LIFE;
  private boolean hasEaten=false;
  private static Random rnd   = new Random();
  
  public Gazelle(AbstractField field){
    super(field);
    img = "src/ressources/savane/gazelle.png";
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
    ArrayList<AbstractElement> listElem = getReachableElemAtDist(0);
    
    for (AbstractElement elem : listElem){
      if (elem instanceof Gazelle){
        Gazelle gazelle = (Gazelle)elem;
        setPosition(elem.getPosition());
        if (gender==Gender.MALE && gazelle.gender==Gender.FEMALE){
          GridPoint childPos = getRndFreePoint();
          if (childPos!=null){
            Gazelle child = new Gazelle(field);
            child.setPosition(childPos);
            field.addElement(child);
          }
        }
        return;
      }else if (elem instanceof Herbe){
        life=MAX_LIFE;
        hasEaten=true;
        setPosition(elem.getPosition());
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
    if (life<0) {
      field.removeElement(this);
    }
  }
}
