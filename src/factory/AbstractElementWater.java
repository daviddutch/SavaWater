package factory;

import world.AbstractField;
import world.GridPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public abstract class AbstractElementWater extends AbstractElement {
	private Random rnd = new Random();
	protected   GridPoint[][] moves = new GridPoint[][] {{new GridPoint(-1,-1), new GridPoint(-1,0), new GridPoint(-1,+1)},
            {new GridPoint(0,-1), new GridPoint(0,0), new GridPoint(0,+1)},
            {new GridPoint(+1,-1), new GridPoint(+1,0), new GridPoint(+1,+1)}
            };
	public AbstractElementWater(AbstractField field) {
		super(field);
	}

	public GridPoint getFreeRandomPoint() {
		GridPoint point;
		ArrayList<AbstractElement> elems;
		int number_try=4;
		do{
			int case_x = rnd.nextInt(AbstractField.SIZE_X);
			int case_y = rnd.nextInt(AbstractField.SIZE_Y);
			point = new GridPoint(case_x, case_y);
			elems = getElementsAtPos(point);
			number_try--;
		}while(elems.size()!=0 && !(elems.size()==1 && elems.get(0) instanceof Banquise) && number_try!=0);
		if(number_try!=0)
			return point;
		return null;
	}
	protected GridPoint getRndFreePointPinguin(){
	    ArrayList<GridPoint> freePoints = new ArrayList<GridPoint>();
	    GridPoint curPos = getPosition();
	    for (int x=0;x<3;x++){
	      for (int y=0;y<3;y++){
	        if (allowedMoves[x][y]){
	        	if(x==1 && y==1) continue;
	          GridPoint reachable = new GridPoint(curPos.getX()+moves[x][y].getX(), curPos.getY()+moves[x][y].getY());
	          if (reachable.getX()<0 || reachable.getX()>=AbstractField.SIZE_X) continue;
	          if (reachable.getY()<0 || reachable.getY()>=AbstractField.SIZE_Y) continue;
	          ArrayList<AbstractElement> elems = getElementsAtPos(reachable);
	          if (elems.size()==0 || (elems.size()==1 && elems.get(0) instanceof Banquise))
	            freePoints.add(reachable);
	        }
	      }
	    }
	    Collections.shuffle(freePoints);
	    if (freePoints.size()!=0)
	      return freePoints.get(0);
	    return null;
	  }
	protected GridPoint getRndFreePointBanquise(){
	    ArrayList<GridPoint> freePoints = new ArrayList<GridPoint>();
	    GridPoint curPos = getPosition();
	    for (int x=0;x<3;x++){
	      for (int y=0;y<3;y++){
	        if (allowedMoves[x][y]){
	          if(x==1 && y==1) continue;
	          GridPoint reachable = new GridPoint(curPos.getX()+moves[x][y].getX(), curPos.getY()+moves[x][y].getY());
	          if (reachable.getX()<0 || reachable.getX()>=AbstractField.SIZE_X) continue;
	          if (reachable.getY()<0 || reachable.getY()>=AbstractField.SIZE_Y) continue;
	          ArrayList<AbstractElement> elems = getElementsAtPos(reachable);
	          if (elems.size()==0 || (elems.size()==1 && !(elems.get(0) instanceof Banquise)))
	            freePoints.add(reachable);
	        }
	      }
	    }
	    Collections.shuffle(freePoints);
	    if (freePoints.size()!=0)
	      return freePoints.get(0);
	    return null;
	  }
	protected ArrayList<AbstractElement> getReachableElemAtDist(){
	    ArrayList<AbstractElement> listElem = new ArrayList<AbstractElement>();
	    GridPoint curPos = getPosition();
	    for (int x=0;x<3;x++){
	      for (int y=0;y<3;y++){
	    	if(x==1 && y==1) continue;
	        if (allowedMoves[x][y]){
	        	if(x==1 && y==1) continue;
	          GridPoint reachable = new GridPoint(curPos.getX()+moves[x][y].getX(), curPos.getY()+moves[x][y].getY());
	          if (reachable.getX()<0 || reachable.getX()>=AbstractField.SIZE_X) continue;
	          if (reachable.getY()<0 || reachable.getY()>=AbstractField.SIZE_Y) continue;
	          ArrayList<AbstractElement> elems = getElementsAtPos(reachable);
	          if (elems.size()>0)
	             listElem.addAll(elems);
	        }
	      }
	    }
	    return listElem; 
	  }
}
