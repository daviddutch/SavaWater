package world;

import java.util.ArrayList;

import factory.AbstractElement;

public class FieldCreator implements AbstractFieldCreator{
  
  public AbstractField createWorld() {
    return Field.getInstance();
  }

}
