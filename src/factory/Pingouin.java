package factory;

import world.AbstractField;
import world.GridPoint;

public class Pingouin extends AbstractElementWater {

  public Pingouin(AbstractField field) {
    super(field);
    img = "src/ressources/water/pingouin.png";
    letter = "P";
  }

  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void evolve() {
    // TODO Auto-generated method stub
    
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
