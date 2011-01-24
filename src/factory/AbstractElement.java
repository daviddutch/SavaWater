
package factory;

import java.util.ArrayList;
import java.util.Collections;

import world.AbstractField;
import world.GridPoint;

/**
 * The Class AbstractElement.
 * 
 * @author David Dutch
 */
public abstract class AbstractElement {
  
  /** The img name for the GUI. */
  protected String img;
  
  /** The letter for the consolue UI. */
  protected String letter;
  
  /**
   * The Enum Gender for an element
   */
  public enum Gender {
      FEMALE, 
     MALE, 
     NONE;
  }
  
  /** The field. */
  protected AbstractField field;

  /** The position of the element. */
  protected GridPoint pos;
  
  /** The allowed moves an element can do. */
  protected boolean[][] allowedMoves;
  
  /** The weight of the moves. */
  private   GridPoint[][] moves = new GridPoint[][] {{new GridPoint(-1,+1), new GridPoint(0,+1), new GridPoint(+1,+1)},
                                                     {new GridPoint(-1,0), new GridPoint(0,0), new GridPoint(+1,0)},
                                                     {new GridPoint(-1,-1), new GridPoint(0,-1), new GridPoint(+1,-1)}
                                                     };
  
  /** The gender of the current element. */
  protected Gender gender = Gender.NONE;

  /**
   * Instantiates a new element.
   *
   * @param field the field
   */
  public AbstractElement(AbstractField field){
    this.field = field;
  }
  
  /**
   * Gets the image.
   *
   * @return the image
   */
  public String getImage(){
    return img;
  }
  
  /**
   * Gets the gender.
   *
   * @return the gender
   */
  public Gender getGender(){
    return gender;
  }
  
  /**
   * Gets the letter.
   *
   * @return the letter
   */
  public String getLetter() {
    return letter;
  }
  
  /**
   * Sets the letter.
   *
   * @param letter the new letter
   */
  public void setLetter(String letter) {
      this.letter = letter;
  }
  
  /**
   * Move. The element can here decide were he goes
   */
  public abstract void move();
  
  /**
   * Evolve. The element can here decide what to do and is life evolves
   */
  public abstract void evolve();
  
  /**
   * Gets the position.
   *
   * @return the position
   */
  public GridPoint getPosition(){
    return pos.clone();
  }
  
  /**
   * Sets the position.
   *
   * @param point the new position
   */
  public void setPosition(GridPoint point){
    pos = point.clone();
  }
  
  /**
   * Gets the reachable elements with the allowed moves.
   *
   * @return The list of the reachable elements
   */
  protected ArrayList<AbstractElement> getReachableElemAtDist(){
    ArrayList<AbstractElement> listElem = new ArrayList<AbstractElement>();
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
  
  /**
   * Gets the elements at a given position.
   *
   * @param position the position
   * @return the elements at pos
   */
  protected ArrayList<AbstractElement> getElementsAtPos(GridPoint position){
    ArrayList<AbstractElement> elems = new ArrayList<AbstractElement>();
    for (AbstractElement elem : field.getElements()){
      if (elem.getPosition().equals(position) && elem!=this){
        elems.add(elem);
      }
    }
    Collections.shuffle(elems); //adds random to the list
    return elems;
  }
  
  /**
   * Gets the a rnd rechable free point.
   *
   * @return the rnd free point
   */
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
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString(){
    return letter+" "+gender+" Position : "+pos.toString();
  }
}
