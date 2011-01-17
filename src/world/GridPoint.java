package world;

public class GridPoint {
  int x;
  int y;
  
  public GridPoint(int x, int y){
    this.x = x;
    this.y = y;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public GridPoint clone(){
    return new GridPoint(x, y);
  }
  @Override
  public boolean equals(Object gp) {
    GridPoint gp2 = (GridPoint) gp;
    return (x==gp2.getX() && y==gp2.getY());
  }
  public String toString(){
    return "("+x+","+y+")";
  }
}
