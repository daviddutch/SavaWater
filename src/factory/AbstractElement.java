package factory;

import java.util.ArrayList;

import world.AbstractField;
import world.GridPoint;

public abstract class AbstractElement {
  protected String img;
  protected AbstractField field;
  protected GridPoint pos;
  protected boolean[][] allowedMoves;
  private   GridPoint[][] moves = new GridPoint[][] {{new GridPoint(-1,+1), new GridPoint(+1,0), new GridPoint(+1,+1)},
                                                     {new GridPoint(-1,0), new GridPoint(0,0), new GridPoint(+1,0)},
                                                     {new GridPoint(-1,-1), new GridPoint(0,-1), new GridPoint(+1,-1)}
                                                     };
  public abstract void move();
  public abstract void evolve();
  public GridPoint getPosition(){
    return pos.clone();
  }
  public void setPosition(GridPoint point){
    pos = point.clone();
  }
  public String getImage(){
    return img;
  }
  public void setImage(String img){
    this.img = img;
  }
  protected ArrayList<AbstractElement> getReachableElemAtDist(int dist){
    ArrayList<AbstractElement> listElem = new ArrayList<AbstractElement>();
    for (int i=0;i<dist;i++){
      
    }
    GridPoint curPos = getPosition();
    for (int x=0;x<3;x++){
      for (int y=0;y<3;y++){
        if (allowedMoves[x][y]){
          GridPoint reachable = new GridPoint(curPos.getX()+moves[x][y].getX(), curPos.getY()+moves[x][y].getY());
          
        }
      }
    }
    return listElem; 
  }
  private AbstractElement getElementAtPos(GridPoint position){
    return new Herbe();
  }
}
