package factory;

import world.AbstractField;
import world.GridPoint;

public class Banquise extends AbstractElementWater {
  private static final int MAX_ROUNDS=2;
  private int rounds=0;
  
  public Banquise(AbstractField field) {
    super(field);
    img = "/ressources/water/banquise.png";
    letter = "B";
    allowedMoves = new boolean[][] {{true, true, true},{true, true, true}, {true, true, true}};
  }
  @Override
  public void move() {
    //Does not move
  }

  @Override
  public void evolve() {
    if (rounds==MAX_ROUNDS){
      GridPoint childPos = getRndFreePointBanquise();
      if (childPos!=null){
        Banquise child = new Banquise(field);
        child.setPosition(childPos);
        field.addElement(child);
      }
      rounds=0;
    }
    rounds++;
  }
}
