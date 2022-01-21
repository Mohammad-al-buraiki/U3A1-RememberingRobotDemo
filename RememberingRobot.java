import java.awt.Color;

import becker.robots.City;
import java.awt.Color;  //imports the java awt color interface
import becker.robots.Direction;
import becker.robots.Intersection;
import becker.robots.Robot;
import becker.robots.RobotSE;

/**
 * RobotTask
 * remembers values of certain actions.
 * @author Mohammad Al-Buraiki
 * @version December 2021
 */
public class RememberingRobot  extends RobotSE { 

	// create a new state for items picked up
	private int itemsPicked;

	private static int blocksMoved;
	// create a new state for blocks moved

	private int iA; //initial avenue 
	private int iS; // inital street

	/**
	 * constructor method - initialize the states of our class
	 * parent class extends RobotSE class capabilities
	 * @param arg0 - city
	 * @param arg1 - initial street
	 * @param arg2 - initial avenue
	 * @param arg3 - initial direction
	 * @param arg4 - initial things robot has
	 */
	public RememberingRobot(City arg0, int arg1, int arg2, Direction arg3, int arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
		//initializes the object
		setItemsPicked(0); //initialize items picked to zero
		//blocksMoved=0; //initialize blocks moved to zero
		iS=arg1;
		iA=arg2;
	}

	/**
	 * r,g,b 0-255 changes colour of robot 
	 */
	protected void changeColor(int r, int g, int b) {
		Color c = new Color(r, g, b);
		this.setColor(c);
	}

	/**
	 * this method moves first before picking thing up
	 * @param n number of blocks to be picked up
	 */
	protected void clearAve(int n) {

		for (int i =0; i<n;i++) {
			move();
			if (this.canPickThing())
				pickThing();
		}
	}
	/**
	 * updates the number of items picked up
	 */
	public void pickThing() {
		super.pickThing();
		setItemsPicked(getItemsPicked() +1);
	}
	/**
	 * @return the stored value of the picked items
	 */
	protected int getItemsPicked() {
		return itemsPicked;
	}
	/**
	 * @param sets the itemsPicked variable in which it can keep the number
	 */
	protected void setItemsPicked(int itemsPicked) {
		this.itemsPicked = itemsPicked;
	}

	/**
	 * overrides move method to change the colour of the robot based on the number of items picked up
	 */
	public void move() {
		super.move();
		blocksMoved++;
		changeColor(0,50*itemsPicked,0);
	}
	/**
	 * @return the stored value of the blocks moved
	 */
	protected int getBlocksMoved() {
		return blocksMoved;
	}

	/**
	 * Resets the number of blocks moved only if robot is at starting position
	 * @param blocksMoved resetting of blocks moved
	 */
	protected void setBlocksMoved(int blocksMoved) {

		if (this.getStreet() == iS && this.getAvenue()==iA )
			this.blocksMoved = blocksMoved;
	}


}
