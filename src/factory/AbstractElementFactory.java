package factory;

import java.util.List;

import world.AbstractField;

public interface AbstractElementFactory {
  public List<AbstractElement> createElements(AbstractField field);
}
