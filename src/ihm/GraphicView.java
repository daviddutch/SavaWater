package ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import java.util.List;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import factory.*;
import factory.AbstractElement.Gender;

import world.AbstractField;
import world.GridPoint;
/**
 * Graphics view of the game
 * @author Roubaty Jose
 *
 */
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
	private static final double IMAGE_SIZE = 400;
	private final int NB_CASE_Y = 10;
	private final int BORDER = 10;
	private final int CASE_SIZE_X;
	private final int CASE_SIZE_Y;
	private final int NB_CASE_X = 10;
	private JFrame frame;
	private AbstractField field;
	private JPanel graphicPanel;
	private JPanel buttonsPanel;
	private JButton nextButton;
	/**
	 * Constructor
	 * @param f AbstractField
	 */
	public GraphicView(AbstractField f) {
		super(f);
		this.field = f;
		frame = new JFrame(FRAME_NAME);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		nextButton.addActionListener(this);
		buttonsPanel.add(nextButton);
		frame.add(graphicPanel);
		frame.add(buttonsPanel);
		CASE_SIZE_X = (GRAPHIC_PANEL_WIDTH - (BORDER * 2))/NB_CASE_X;
		CASE_SIZE_Y = (GRAPHIC_PANEL_HEIGHT - (BORDER * 2))/NB_CASE_Y;
		frame.setVisible(true);
	}
	/**
	 * Update the graphics contant
	 */
	public void updateView(int nextElemIndex) {
		Graphics2D g2d = (Graphics2D) graphicPanel.getGraphics();
		Image image;
		image = new BufferedImage(GRAPHIC_PANEL_WIDTH,GRAPHIC_PANEL_WIDTH,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2dBuffer = (Graphics2D) image.getGraphics();
		saveG2dState(g2dBuffer);
		g2dBuffer.setColor(BACKGROUND_COLOR);
		g2dBuffer.fill(new Rectangle(0, 0, graphicPanel.getWidth(), graphicPanel.getHeight()));
		retriveG2dState(g2dBuffer);
		drawElements(g2dBuffer);
		drawGrid(g2dBuffer);
		drawFocus(nextElemIndex, g2dBuffer);
		g2d.drawImage(image, 0, 0, null);
	}
	private void drawFocus(int nextElemIndex, Graphics2D g2dBuffer) {
	  saveG2dState(g2dBuffer);
	  g2dBuffer.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER,.3f));
          GridPoint gp = field.getElements().get(nextElemIndex).getPosition();
          Point pos = getCoordinateCase(gp);
          g2dBuffer.setColor(Color.RED);
          g2dBuffer.fillRect(pos.x, pos.y, CASE_SIZE_X, CASE_SIZE_Y);
          retriveG2dState(g2dBuffer);
          
        }
  /**
	 * Get the local point in the panel of the corner left down of a gridPoint
	 * @param p GridPoint
	 * @return local location Point
	 */
	private Point getCoordinateCase(GridPoint p) {
		int x = CASE_SIZE_X * p.getX() + BORDER;
		int y = CASE_SIZE_Y * p.getY() + BORDER;

		Point down_left_corner = new Point();
		down_left_corner.x = x;
		down_left_corner.y = y;
		return down_left_corner;
	}
	/**
	 * get the case of a local point the grid
	 * @param p local point in the grid
	 * @return GridPoint
	 * @throws ArrayIndexOutOfBoundsException
	 */
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
	/**
	 * Save the g2d state - you can then use retriveG2dState to retrieve it
	 * @param g2d Graphics2D to save state
	 */ 
	private void saveG2dState(Graphics2D g2d) {
		g2dStroke = g2d.getStroke();
		g2dColor = g2d.getColor();
		g2dComposite = g2d.getComposite();
	}
	/**
	 * Retrieve the g2d state - you have to call saveG2dState before this one
	 * @param g2d Graphics2D to retrieve save state on
	 */
	private void retriveG2dState(Graphics2D g2d) {
		g2d.setStroke(g2dStroke);
		g2d.setColor(g2dColor);
		g2d.setComposite(g2dComposite);
	}
	/**
	 * Draw the field grid
	 * @param g2d Graphics2D to draw on
	 */
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
	/**
	 * Draw all elements use drawAElement method
	 * @param g2d Graphics2D to draw on
	 */
	private void drawElements(Graphics2D g2d){
		saveG2dState(g2d);
		// the local grid coordinate
		List<AbstractElement> list = field.getElements();
		for (AbstractElement el : list) {
			if(isBackgroundElement(el)){
				drawAElement(el, g2d);
			}
		}
		for (AbstractElement el : list) {
			if(!isBackgroundElement(el)){
				drawAElement(el, g2d);
			}
		}
		retriveG2dState(g2d);
	}
	/**
	 * Tell if the element is a background element or not
	 * @param el AbstractElement
	 * @return boolean true if the element is a background element
	 */
	private boolean isBackgroundElement(AbstractElement el){
		return (el instanceof Banquise) || (el instanceof Herbe);
	}
	
	/**
	 * Draw an element
	 * @param el AbstractElement to be draw
	 * @param g2d Graphics2D to draw on
	 */
	private void drawAElement(AbstractElement el, Graphics2D g2d){
		if(el instanceof Gazelle){
			drawAGazelle((Gazelle)el, g2d);
			return;
		}
			
		Point p = getCoordinateCase(el.getPosition());
		// calculate the position and size at disposition on the grid
		int x = p.x;
		int y = p.y;

		// calculate the scale to concatenate the image
		double scale_x = CASE_SIZE_X / (double) IMAGE_SIZE;
		double scale_y = CASE_SIZE_Y / (double) IMAGE_SIZE;
		
		// Translate the image position
		AffineTransform af = AffineTransform.getTranslateInstance(x, y);
		// concatenate the image the right size
		af.concatenate(AffineTransform.getScaleInstance(scale_x, scale_y));
		// Draw the image with the transformation
		URL urlImage = getClass().getResource(el.getImage());
		Image img = Toolkit.getDefaultToolkit().getImage(urlImage);
		g2d.drawImage(img, af, null);
	}
	
	private void drawAGazelle(Gazelle el, Graphics2D g2d){
		Point p = getCoordinateCase(el.getPosition());
		// calculate the position and size at disposition on the grid
		int x = p.x;
		int y = p.y;
		
		// calculate the scale to concatenate the image
		double scale_x = CASE_SIZE_X / (double) IMAGE_SIZE;
		double scale_y = CASE_SIZE_Y / (double) IMAGE_SIZE;
		if(el.getGender()==Gender.FEMALE){
			scale_x *= -1;
			x+=CASE_SIZE_X;
		}
		// Translate the image position
		AffineTransform af = AffineTransform.getTranslateInstance(x, y);
		// concatenate the image the right size
		af.concatenate(AffineTransform.getScaleInstance(scale_x, scale_y));
		
		// Draw the image with the transformation
		URL urlImage = getClass().getResource(el.getImage());
		Image img = Toolkit.getDefaultToolkit().getImage(urlImage);
		g2d.drawImage(img, af, null);
	}


	/**
	 * Action performed on the next step button
	 */
	public void actionPerformed(ActionEvent arg0) {
		super.sc.nextStep();
	}
}
