package factory;

import world.AbstractField;
import world.GridPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import world.AbstractField;

public abstract class AbstractElementWater extends AbstractElement {
	private Random rnd = new Random();
	public AbstractElementWater(AbstractField field) {
		super(field);
	}

	public GridPoint getFreeRandomPoint() {
		GridPoint point;
		ArrayList<AbstractElement> elems;
		do{
			int case_x = rnd.nextInt(field.SIZE_X);
			int case_y = rnd.nextInt(field.SIZE_Y);
			point = new GridPoint(case_x, case_y);
			elems = getElementsAtPos(point);
		}while(elems.size()!=0);
		return point;
	}
}
