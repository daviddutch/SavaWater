package world;

import java.util.ArrayList;

import factory.AbstractElement;

public class Field extends AbstractField {
  private static AbstractField field;
  
  private Field(ArrayList<AbstractElement> elemList){
    this.elemList = elemList;
    
  }
  
  public static AbstractField getInstance(ArrayList<AbstractElement> elemList){
    if(field==null){
      field = new Field(elemList);
    }
    
    return field;
  }
  public static AbstractField getInstance(){
    if(field==null){
      field = new Field(new ArrayList<AbstractElement>());
    }
    
    return field;
  }
}
