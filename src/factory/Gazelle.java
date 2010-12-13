package factory;

import world.GridPoint;

public class Gazelle extends AbstractElementSavane {

  public Gazelle(){
    allowedMoves = new boolean[][] {{false, true, false},{true, true, true}, {false, true, false}};
  }
  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void evolve() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public GridPoint getPosition() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setPosition(GridPoint point) {
    // TODO Auto-generated method stub
    
  }

}
