package factory;

import world.AbstractField;
import world.GridPoint;

public class Herbe extends AbstractElementSavane {
  private static final int MAX_HEIGHT=5;
  private int height=3;
  private static final int MAX_ROUNDS=2; //number of rounds before creating a new square of grass
  private int rounds=0; //current number of rounds at max height
  
  public Herbe(AbstractField field){
    super(field);
    img = "/ressources/savane/herbe.png";
    letter = "H";
    allowedMoves = new boolean[][] {{true, true, true},{true, true, true}, {true, true, true}};
  }
  @Override
  public void move() {
    //Grass doesn't move ;-)
  }

  @Override
  public void evolve() {
    if (height==MAX_HEIGHT){
      rounds++;
      if (rounds==MAX_ROUNDS){
        rounds = 0;
        GridPoint childPos = getRndFreePoint();
        if (childPos!=null){
          Herbe child = new Herbe(field);
          child.setPosition(childPos);
          field.addElement(child);
        }
      }
      height--;
    }
    height++;
  }

}
