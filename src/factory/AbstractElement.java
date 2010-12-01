package factory;

import world.GridPoint;

public abstract class AbstractElement {
  protected String img;
  
  public abstract void move();
  public abstract void evolve();
  public abstract GridPoint getPosition();
  public abstract void setPosition(GridPoint point);
  public String getImage(){
    return img;
  }
  public void setImage(String img){
    this.img = img;
  }
}
