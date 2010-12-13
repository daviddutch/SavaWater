package ihm;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import system.SystemControl;

public class StartView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	SystemControl ctrl;
	public StartView(SystemControl ctrl){
		setSize(200,400);
		this.ctrl=ctrl;
		initView();
		setVisible(true);
	}
	JRadioButton buttonAuto;
	JRadioButton buttonConsole;
	JRadioButton buttonSava;
	private void initView() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 1));
		JPanel mode = new JPanel(new GridLayout(3, 1));
		buttonAuto = new JRadioButton("Mode Automatic");
		JRadioButton buttonManu = new JRadioButton("Mode Manual");
		ButtonGroup modeGroup = new ButtonGroup();
		modeGroup.add(buttonAuto);
		modeGroup.add(buttonManu);
		buttonAuto.setSelected(true);
		mode.add(new Label("Choisiez le mode de simulation : "));
		mode.add(buttonAuto);
		mode.add(buttonManu);
		
		JPanel type = new JPanel(new GridLayout(3, 1));
		buttonConsole = new JRadioButton("Mode Console");
		JRadioButton buttonGraphics = new JRadioButton("Mode Graphic");
		ButtonGroup typeGroup = new ButtonGroup();
		typeGroup.add(buttonGraphics);
		typeGroup.add(buttonConsole);
		buttonGraphics.setSelected(true);
		type.add(new Label("Choisiez le mode d'affichage : "));
		type.add(buttonConsole);
		type.add(buttonGraphics);
		
		JPanel gameType = new JPanel(new GridLayout(3, 1));
		buttonSava = new JRadioButton("Savane Life");
		JRadioButton buttonWater = new JRadioButton("Water Life");
		ButtonGroup gameTypeGroup = new ButtonGroup();
		gameTypeGroup.add(buttonSava);
		gameTypeGroup.add(buttonWater);
		buttonWater.setSelected(true);
		gameType.add(new Label("Choisiez le type de jeu : "));
		gameType.add(buttonSava);
		gameType.add(buttonWater);
		
		JButton start = new JButton("Start Simulation");
		start.addActionListener(this);
		add(mode);
		add(type);
		add(gameType);
		add(start);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String mode = (buttonAuto.isSelected()) ? "auto" : "manual";
		String type = (buttonConsole.isSelected()) ? "consol" : "graphic";
		String game = (buttonSava.isSelected()) ? "Savana" : "Water";
		//TODO ctrl.startSimulation(mode,type,game);
		setVisible(false);
	}
}
