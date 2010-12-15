package factory;

import java.util.ArrayList;

import world.AbstractField;
import world.GridPoint;

public abstract class AbstractElement {
  protected String img;
  
  public enum Gender {
    FEMALE, MALE, NONE;
  }
  protected AbstractField field;
  protected GridPoint pos;
  protected boolean[][] allowedMoves;
  private   GridPoint[][] moves = new GridPoint[][] {{new GridPoint(-1,+1), new GridPoint(+1,0), new GridPoint(+1,+1)},
                                                     {new GridPoint(-1,0), new GridPoint(0,0), new GridPoint(+1,0)},
                                                     {new GridPoint(-1,-1), new GridPoint(0,-1), new GridPoint(+1,-1)}
                                                     };
  protected Gender gender = Gender.NONE;
  
  public AbstractElement(AbstractField field){
    this.field = field;
  }
  public String getImage(){
    return img;
  }
  public Gender getGender(){
    return gender;
  }
  public abstract void move();
  public abstract void evolve();
  public GridPoint getPosition(){
    return pos.clone();
  }
  public void setPosition(GridPoint point){
    pos = point.clone();
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
          ArrayList<AbstractElement> elems = getElementsAtPos(reachable);
          if (elems.size()>0)
             listElem.addAll(elems);
        }
      }
    }
    return listElem; 
  }
  protected ArrayList<AbstractElement> getElementsAtPos(GridPoint position){
    ArrayList<AbstractElement> elems = new ArrayList<AbstractElement>();
    for (AbstractElement elem : field.getElements()){
      if (elem.getPosition().equals(position)){
        elems.add(elem);
      }
    }
    return elems;
  }
  protected GridPoint getRndFreePoint(){
    GridPoint curPos = getPosition();
    for (int x=0;x<3;x++){
      for (int y=0;y<3;y++){
        if (allowedMoves[x][y]){
          GridPoint reachable = new GridPoint(curPos.getX()+moves[x][y].getX(), curPos.getY()+moves[x][y].getY());
          ArrayList<AbstractElement> elems = getElementsAtPos(reachable);
          if (elems.size()==0)
             return reachable.clone();
        }
      }
    }
    return null;
  }
}
