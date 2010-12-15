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
	/**
	 * Todo : remove this method when tests are over 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException{
		ArrayList<AbstractElement> elemList = new ArrayList<AbstractElement>();
		Field f = (Field) Field.getInstance(elemList);
		
		Gazelle gazelle = new Gazelle(f);
		gazelle.setPosition(new GridPoint(0, 0));
		gazelle.setLetter("G");
		elemList.add(gazelle);
		elemList.add(gazelle);
		
		Lion lion = Lion.getInstance(f);
		lion.setPosition(new GridPoint(0, 1));
		lion.setLetter("L");
		elemList.add(lion);
		
		Orque orque = Orque.getInstance(f);
		orque.setPosition(new GridPoint(0, 2));
		orque.setLetter("O");
		elemList.add(orque);
		
		Pingouin pingouin = new Pingouin(f);
		pingouin.setPosition(new GridPoint(0, 3));
		pingouin.setLetter("P");
		elemList.add(pingouin);
		
		Pygmee pygmee = new Pygmee(f);
		pygmee.setPosition(new GridPoint(0, 4));
		pygmee.setLetter("P");
		elemList.add(pygmee);
		
		Requin requin = new Requin(f);
		requin.setPosition(new GridPoint(0, 5));
		requin.setLetter("R");
		elemList.add(requin);
		
		Banquise banquise = new Banquise(f);
		banquise.setPosition(new GridPoint(0, 0));
		banquise.setLetter("B");
		elemList.add(banquise);
		
		Banquise banquise2 = new Banquise(f);
		banquise2.setPosition(new GridPoint(0, 6));
		banquise2.setLetter("B");
		elemList.add(banquise2);
		
		Herbe herbe = new Herbe(f);
		herbe.setPosition(new GridPoint(0, 1));
		herbe.setLetter("H");
		elemList.add(herbe);
		
		Herbe herbe2 = new Herbe(f);
		herbe2.setPosition(new GridPoint(0, 7));
		herbe2.setLetter("H");
		elemList.add(herbe2);
		
		f = (Field) Field.getInstance(elemList);
		
		ConsolView g = new ConsolView(f);
		while(true){
			g.updateView();
			Thread.sleep(10000);
		}
	}
}
