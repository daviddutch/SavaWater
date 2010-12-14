package world;



import java.util.List;

import factory.AbstractElement;

public class Field extends AbstractField {
  private static AbstractField field;
  
  private Field(List<AbstractElement> elemList){
    this.elemList = elemList;
  }
  
  private Field(){
  }
  
  public static AbstractField getInstance(List<AbstractElement> elemList){
    if(field==null){
      field = new Field(elemList);
    }
    
    return field;
  }
  public static AbstractField getInstance(){
    if(field==null){
      field = new Field();
    }
    
    return field;
  }
}
