package ihm;


import java.util.ArrayList;
import java.util.List;

import factory.AbstractElement;
import factory.AbstractElementSavane;
import factory.AbstractElementWater;
import factory.Banquise;
import factory.Gazelle;
import factory.Herbe;
import factory.Lion;
import factory.Orque;
import factory.Pingouin;
import factory.Pygmee;
import factory.Requin;

import world.AbstractField;
import world.Field;
import world.GridPoint;

public class ConsolView extends AbstractView {
  private final int NB_CASE_X = 10;
  private final int NB_CASE_Y = 10;
  
  private List<AbstractElement> listElems;

  public ConsolView(AbstractField f) {
    super(f);
  }

  public void updateView(int nextElemIndex) {
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
        content+="|"+getElem(new GridPoint(j, i));
      }
      content+="|";
      result+=content+"\n";
    }
    
    result+=border+"\n";
    System.out.println(result);
    printLabels();
  }
  
  private String getElem(GridPoint pt){
    String c = "";
    for (AbstractElement i : listElems) {
    	if(i.getPosition().equals(pt)){
    		c+=i.getLetter();
    	}
    }
    switch (c.length()) {
		case 0:c=" ";
		case 1:c=" "+c;
		case 2:c+=" ";
		default:
	}
    return c;
  }
  private void printLabels(){
	  if(f.getElements().get(0) instanceof AbstractElementSavane){
		  System.out.println("+-------------+");
		  System.out.println("| L : lion    |");
		  System.out.println("| G : Gazelle |");
		  System.out.println("| P : Pygmée  |");
		  System.out.println("| H : Herbe   |");
		  System.out.println("+-------------+");
	  }
	  if(f.getElements().get(0) instanceof AbstractElementWater){
		  System.out.println("+-------------+");
		  System.out.println("| R : requin  |");
		  System.out.println("| O : orque   |");
		  System.out.println("| P : pingouin|");
		  System.out.println("| B : banquise|");
		  System.out.println("+-------------+");
	  }
  }
 }
