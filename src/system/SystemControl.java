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
import factory.AbstractElement;
import factory.AbstractElementFactory;
import factory.FactorySavane;
import factory.FactoryWater;

public class SystemControl implements ActionListener {

	List<AbstractElement> elements;
	
	public SystemControl() {
		StartView sv = new StartView(this);
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
		
	}
	
	/**
	 * prepare the field, the game and the elements
	 * @param mode between auto/manual
	 * @param type between consol/graphic
	 * @param game between Savana/Water
	 */
	public void startSimulation(String mode, String type, String game){
		// creation of the view
		AbstractVueFactory avf = new ConcreteViewFactory();
		AbstractView av = avf.createView(type);
		
		// creation of field
		AbstractFieldCreator afc = new FieldCreator();
		AbstractField af = afc.createWorld();
		
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
		
		// launch game according to the mode
		if(mode.equals("auto")){
			new Timer(1000, this).start();
		}
	}
	
	// TODO
	public void execute(Command cmd){
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.nextStep();
	}

}
