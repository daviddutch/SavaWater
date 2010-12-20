package factory;

import world.AbstractField;
import world.GridPoint;

public class Herbe extends AbstractElementSavane {
 // public static final String IMG = "src/ressources/savane/herbe.png";
  
  public Herbe(AbstractField field){
    super(field);
    img = "src/ressources/savane/herbe.png";
    letter = "H";
    allowedMoves = new boolean[][] {{true, true, true},{true, true, true}, {true, true, true}};
  }
  @Override
  public void move() {
    
  }

  @Override
  public void evolve() {
    // TODO Auto-generated method stub
    
  }

}
