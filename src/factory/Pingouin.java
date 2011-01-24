package factory;

import java.util.ArrayList;

import factory.AbstractElement.Gender;
import world.AbstractField;
import world.GridPoint;

public class Pingouin extends AbstractElementWater {

  public Pingouin(AbstractField field) {
    super(field);
    allowedMoves = new boolean[][] { { false, true, false },
        { true, false, true }, { false, true, false } };
    img = "/ressources/water/pingouin.png";
    letter = "P";
  }

  @Override
  public void move() {
    GridPoint nextPos = getRndFreePoint();
    if (nextPos != null)
      setPosition(nextPos);
    return;
  }

  @Override
  public void evolve() {
    ArrayList<AbstractElement> listElem = getReachableElemAtDist();
    for (AbstractElement elem : listElem) {
      if (elem instanceof Pingouin) {
        GridPoint childPos = getFreeRandomPoint();
        if (childPos != null) {
          Pingouin child = new Pingouin(field);
          child.setPosition(childPos);
          field.addElement(child);
          return;
        }
      }
    }
  }

}
