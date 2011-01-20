package system;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import world.AbstractField;
import world.AbstractFieldCreator;
import world.FieldCreator;
import ihm.AbstractView;
import ihm.AbstractVueFactory;
import ihm.ConcreteViewFactory;
import ihm.StartView;
import command.Command;
import command.Evolve;
import command.Move;
import factory.AbstractElement;
import factory.AbstractElementFactory;
import factory.FactorySavane;
import factory.FactoryWater;

public class SystemControl implements ActionListener {

	private List<AbstractElement> elements;
	private AbstractView av;
	private int nextElement=-1;
	
	public SystemControl() {
		new StartView(this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SystemControl sc = new SystemControl();
	}
	
	/**
	 * TODO
	 */
	public void nextStep(){
  	        nextElement = nextElement<elements.size()-1 ? nextElement+1 : 0;
  		AbstractElement el = elements.get(nextElement);
  		
  		Command move = new Move(el);
  		
  		execute(move);
  		
  		Command evolve = new Evolve(el);
  		
  		execute(evolve);
  		
  		av.updateView(nextElement<elements.size()-1 ? nextElement+1 : 0);
	}
	
	/**
	 * prepare the field, the game and the elements
	 * @param mode between auto/manual
	 * @param type between consol/graphic
	 * @param game between Savana/Water
	 */
	public void startSimulation(String mode, String type, String game){
		// creation of field
		AbstractFieldCreator afc = new FieldCreator();
		AbstractField af = afc.createWorld();
		
		// creation of the view
		AbstractVueFactory avf = new ConcreteViewFactory();
		av = avf.createView(type,af);
		
		av.setSystemControler(this);
		// creation of elements
		AbstractElementFactory aef = null;
		if(game.equals("Savana")){
			aef = new FactorySavane();
		}
		else if(game.equals("Water")) {
			aef = new FactoryWater();
		}
		else {
			System.out.println("Error, unknow world");
			System.exit(0);
		}
		elements = aef.createElements(af);
		
		af.setElements((ArrayList<AbstractElement>) elements);
		
		av.updateView(0);
		// launch game according to the mode
		if(mode.equals("auto")){
			new Timer(1000, this).start();
		}
	}
	
	// TODO
	public void execute(Command cmd){
		cmd.doit();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.nextStep();
	}

}
