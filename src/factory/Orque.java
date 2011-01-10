package factory;

import world.AbstractField;
import world.GridPoint;

public class Orque extends AbstractElementWater {
  public Orque(AbstractField field) {
    super(field);
    img = "src/ressources/water/orque.png";
    letter = "O";
  }

  private static Orque instance;
  
  public static Orque getInstance(AbstractField field){
    if (instance==null) instance = new Orque(field);
    return instance;
  }
  
  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void evolve() {
    // TODO Auto-generated method stub
    
  }

}
