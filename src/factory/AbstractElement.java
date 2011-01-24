package factory;

import java.util.ArrayList;
import java.util.Collections;

import world.AbstractField;
import world.GridPoint;

public abstract class AbstractElement {
  protected String img;
  protected String letter;
  
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
  public String getLetter() {
    return letter;
  }
  
  public void setLetter(String letter) {
      this.letter = letter;
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
          if (reachable.getX()<0 || reachable.getX()>=AbstractField.SIZE_X) continue;
          if (reachable.getY()<0 || reachable.getY()>=AbstractField.SIZE_Y) continue;
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
      if (elem.getPosition().equals(position) && elem!=this){
        elems.add(elem);
      }
    }
    Collections.shuffle(elems); //add random to the list
    return elems;
  }
  protected GridPoint getRndFreePoint(){
    ArrayList<GridPoint> freePoints = new ArrayList<GridPoint>();
    GridPoint curPos = getPosition();
    for (int x=0;x<3;x++){
      for (int y=0;y<3;y++){
        if (allowedMoves[x][y]){
          GridPoint reachable = new GridPoint(curPos.getX()+moves[x][y].getX(), curPos.getY()+moves[x][y].getY());
          if (reachable.getX()<0 || reachable.getX()>=AbstractField.SIZE_X) continue;
          if (reachable.getY()<0 || reachable.getY()>=AbstractField.SIZE_Y) continue;
          ArrayList<AbstractElement> elems = getElementsAtPos(reachable);
          if (elems.size()==0 || (elems.size()==1 && elems.get(0) instanceof Banquise))
            freePoints.add(reachable);
        }
      }
    }
    Collections.shuffle(freePoints);
    if (freePoints.size()!=0)
      return freePoints.get(0);
    return null;
  }
  public String toString(){
    return letter+" "+gender+" Position : "+pos.toString();
  }
}
