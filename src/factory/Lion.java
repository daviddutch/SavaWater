package factory;

import world.GridPoint;

public class Lion extends AbstractElementSavane {
  private static Lion instance;
  
  private Lion(){
    allowedMoves = new boolean[][] {{true, true, true},{true, true, true}, {true, true, true}};
  }
  
  public static Lion getInstance(){
    if (instance==null) instance = new Lion();
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
