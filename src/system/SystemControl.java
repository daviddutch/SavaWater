package system;
import ihm.StartView;
import command.Command;

public class SystemControl {

	public SystemControl() {
		StartView sv = new StartView(this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SystemControl sc = new SystemControl();
	}
	
	public void nextStep(){
		
	}
	
	public void startSimulation(String mode, String type, String game){
		
	}
	
	public void execute(Command cmd){
		
	}

}
