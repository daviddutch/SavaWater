package ihm;

import system.SystemControl;
import world.Field;

public abstract class AbstractView {

	private String type;
	protected SystemControl sc;
	private Field f;
	
	public void setSystemControler(SystemControl sc){
		this.sc = sc;
	}
	
	public AbstractView(Field f){
		this.f = f;
	}
	
	public abstract void updateView();
	
}
