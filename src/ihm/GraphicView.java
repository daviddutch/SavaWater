package ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import factory.AbstractElement;

import world.Field;
import world.GridPoint;

public class GraphicView extends AbstractView implements ActionListener{
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 700;
	private static final int GRAPHIC_PANEL_WIDTH = 587;
	private static final int GRAPHIC_PANEL_HEIGHT = 587;
	private static final int BUTTONS_PANEL_WIDTH = 600;
	private static final int BUTTONS_PANEL_HEIGHT = 100;
	private static final Paint GRID_COLOR = Color.BLACK;
	private static final float GRID_STROKE = 2;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	private static final String NEXT_BUTTON_VALUE = "next step";
	private static final String FRAME_NAME = "Frame name";
	private final int NB_CASE_Y = 10;
	private final int BORDER = 10;
	private final int CASE_SIZE_X;
	private final int CASE_SIZE_Y;
	private final int NB_CASE_X = 10;
	private JFrame frame;
	private Field field;
	private JPanel graphicPanel;
	private JPanel buttonsPanel;
	private JButton nextButton;
	public GraphicView(Field f) {
		super(f);
		this.field = f;
		frame = new JFrame(FRAME_NAME);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLayout(null);
		graphicPanel = new JPanel();
		graphicPanel.setSize(GRAPHIC_PANEL_WIDTH,GRAPHIC_PANEL_HEIGHT);
		graphicPanel.setLocation(0, 0);
		graphicPanel.setPreferredSize(new Dimension(GRAPHIC_PANEL_WIDTH, GRAPHIC_PANEL_WIDTH));
		buttonsPanel = new JPanel();
		buttonsPanel.setSize(BUTTONS_PANEL_WIDTH, BUTTONS_PANEL_HEIGHT);
		buttonsPanel.setLocation(0, 600);
		buttonsPanel.setLayout(new GridLayout(1,1));
		buttonsPanel.setPreferredSize(new Dimension(BUTTONS_PANEL_WIDTH,BUTTONS_PANEL_HEIGHT));
		nextButton = new JButton(NEXT_BUTTON_VALUE);
		nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonsPanel.add(nextButton);
		frame.add(graphicPanel);
		frame.add(buttonsPanel);
		CASE_SIZE_X = (GRAPHIC_PANEL_WIDTH - (BORDER * 2))/NB_CASE_X;
		CASE_SIZE_Y = (GRAPHIC_PANEL_HEIGHT - (BORDER * 2))/NB_CASE_Y;
		frame.setVisible(true);
	}

	public void updateView() {
		Graphics2D g2d = (Graphics2D) graphicPanel.getGraphics();
		graphicPanel.setBackground(BACKGROUND_COLOR);
		drawGrid(g2d);
		
	}
	private Point getCoordinateCase(GridPoint p) {
		int x = CASE_SIZE_X * p.getX() + BORDER;
		int y = CASE_SIZE_Y * p.getY() + BORDER;

		Point down_left_corner = new Point();
		down_left_corner.x = x;
		down_left_corner.y = y;
		return down_left_corner;
	}
	public GridPoint getCaseFromPosition(Point p) throws ArrayIndexOutOfBoundsException{
		int x = p.x - BORDER;
		int y = p.y - BORDER;
		int case_x = x / CASE_SIZE_X;
		int case_y = y / CASE_SIZE_Y;
		if (case_x < 0 || case_x >= NB_CASE_X || case_y < 0
				|| case_y >= NB_CASE_Y) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return new GridPoint(case_x, case_y);
	}
	
	private Stroke g2dStroke;
	private Color g2dColor;
	private Composite g2dComposite;
	private void saveG2dState(Graphics2D g2d) {
		g2dStroke = g2d.getStroke();
		g2dColor = g2d.getColor();
		g2dComposite = g2d.getComposite();
	}

	private void retriveG2dState(Graphics2D g2d) {
		g2d.setStroke(g2dStroke);
		g2d.setColor(g2dColor);
		g2d.setComposite(g2dComposite);
	}
	private void drawGrid(Graphics2D g2d) {
		saveG2dState(g2d);
		g2d.setPaint(GRID_COLOR);
		g2d.setStroke(new BasicStroke(GRID_STROKE));
		Line2D.Float line;
		for (int i = 0; i < NB_CASE_Y + 1; i++) {
			int pos_y = BORDER + (i * CASE_SIZE_Y);
			line = new Line2D.Float(BORDER, pos_y, CASE_SIZE_X * NB_CASE_X
					+ BORDER, pos_y);
			g2d.draw(line);
		}
		for (int i = 0; i < NB_CASE_X + 1; i++) {
			int pos_x = BORDER + (i * CASE_SIZE_X);
			line = new Line2D.Float(pos_x, BORDER, pos_x, CASE_SIZE_Y
					* NB_CASE_Y + BORDER);
			g2d.draw(line);
		}
		retriveG2dState(g2d);
	}
	public static void main(String[] args) throws InterruptedException{
		ArrayList<AbstractElement> elemList = new ArrayList<AbstractElement>();
		Field f = (Field) Field.getInstance(elemList);
		GraphicView g = new GraphicView(f);
		while(true){
			Thread.sleep(1000);
			g.updateView();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		super.sc.nextStep();
	}
}
