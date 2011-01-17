package factory;

import java.util.ArrayList;

import factory.AbstractElement.Gender;
import world.AbstractField;
import world.GridPoint;

public class Pingouin extends AbstractElementWater {

  public Pingouin(AbstractField field) {
    super(field);
    allowedMoves = new boolean[][] {{false, true, false},{true, false, true}, {false, true, false}};
    img = "src/ressources/water/pingouin.png";
    letter = "P";
  }

  @Override
  public void move() {
    ArrayList<AbstractElement> listElem = getReachableElemAtDist(0);
    
    for (AbstractElement elem : listElem){
      if (elem instanceof Pingouin){
        GridPoint childPos = getRndFreePoint();
        if (childPos!=null){
          Pingouin child = new Pingouin(field);
          child.setPosition(childPos);
          field.addElement(child);
        }
        GridPoint nextPos = getRndFreePoint();
        if (nextPos!=null)
          setPosition(nextPos);
        return;
      }else if (elem instanceof Banquise){
        setPosition(elem.pos);
        return;
      }
    }
    GridPoint nextPos = getRndFreePoint();
    if (nextPos!=null)
      setPosition(nextPos);
    
  }

  @Override
  public void evolve() {
    // TODO Auto-generated method stub
    
  }

}
