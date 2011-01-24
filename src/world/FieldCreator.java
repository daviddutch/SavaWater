package world;


public class FieldCreator implements AbstractFieldCreator{
  
  public AbstractField createWorld() {
    return Field.getInstance();
  }

}
