package ihm;

import system.SystemControl;
import world.AbstractField;

public abstract class AbstractView {

	protected String type;
	protected SystemControl sc;
	protected AbstractField f;
	
	public void setSystemControler(SystemControl sc){
		this.sc = sc;
	}
	
	public AbstractView(AbstractField f){
		this.f = f;
	}
	
	public abstract void updateView();
	
}
