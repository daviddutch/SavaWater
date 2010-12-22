package factory;

import world.AbstractField;
import world.GridPoint;

public class Banquise extends AbstractElementWater {

  public Banquise(AbstractField field) {
    super(field);
    img = "src/ressources/water/banquise.png";
    letter = "B";
  }
  @Override
  public void move() {
    //Do not move
  }

  @Override
  public void evolve() {
	  
  }
}
