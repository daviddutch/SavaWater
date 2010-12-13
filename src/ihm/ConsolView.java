package ihm;

import java.util.ArrayList;

import factory.AbstractElement;

import world.AbstractField;
import world.Field;
import world.GridPoint;

public class ConsolView extends AbstractView {
  private final int NB_CASE_X = 10;
  private final int NB_CASE_Y = 10;
  
  private ArrayList<AbstractElement> listElems;

  public ConsolView(AbstractField f) {
    super(f);
      	  
  }

  public void updateView() {
    listElems = f.getElements();
    String border = "";
    String content = "";
    String result = "";
    for(int i=0;i<NB_CASE_X;i++){
      border+="+ - ";
    }
    border+="+";
    
    for(int i=0;i<NB_CASE_Y;i++){
      result +=border+"\n";
      content="";
      for(int j=0;j<NB_CASE_X;j++){
        content+="| "+getElem(new GridPoint(j, i))+" ";
      }
      content+="|";
      result+=content+"\n";
    }
    
    result+=border+"\n";
    System.out.println(result);
  }
  
  public char getElem(GridPoint pt){
    char c = ' ';
    for(int i=0;i<listElems.size();i++){
      if(listElems.get(i).getPosition().equals(pt)){
        c='a';
      }
    }
    
    return c;
  }
}
