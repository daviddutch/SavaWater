package factory;

import world.GridPoint;

public class Orque extends AbstractElementWater {
  private static Orque instance;
  
  private Orque(){}
  
  public static Orque getInstance(){
    if (instance==null) instance = new Orque();
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
