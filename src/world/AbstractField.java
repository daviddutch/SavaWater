package world;

import java.util.List;

import factory.AbstractElement;

public abstract class AbstractField {
  protected List<AbstractElement> elemList;
    
  public void addElement(AbstractElement elem){
    elemList.add(elem);
  }
  public void removeElement(AbstractElement elem){
    elemList.remove(elem);
  }
  public void setElements(List<AbstractElement> elemList){
    this.elemList = elemList;
  }
  public List<AbstractElement> getElements(){
    return elemList;
  }
}
