package world;

import java.util.ArrayList;

import factory.AbstractElement;

public interface AbstractFieldCreator {
  public AbstractField createWorld(ArrayList<AbstractElement> elemList);
  public AbstractField createWorld();
}
