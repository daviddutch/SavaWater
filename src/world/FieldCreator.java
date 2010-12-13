package world;

import java.util.ArrayList;

import factory.AbstractElement;

public class FieldCreator implements AbstractFieldCreator{

  @Override
  public AbstractField createWorld(ArrayList<AbstractElement> elemList) {
    return Field.getInstance(elemList);
  }
  
  public AbstractField createWorld() {
    return Field.getInstance();
  }

}
