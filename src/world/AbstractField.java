package world;

import java.util.ArrayList;

import factory.AbstractElement;

public abstract class AbstractField {
  protected ArrayList<AbstractElement> elemList = new ArrayList<AbstractElement>();
    
  public void addElement(AbstractElement elem){
    elemList.add(elem);
  }
  public void removeElement(AbstractElement elem){
    elemList.remove(elem);
  }
  public void setElements(ArrayList<AbstractElement> elemList){
    this.elemList = elemList;
  }
  public ArrayList<AbstractElement> getElements(){
    return elemList;
  }
}
