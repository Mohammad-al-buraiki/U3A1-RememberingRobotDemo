import becker.robots.*;

/**
 * RobotTask
 * remembers values of certain actions.
 * @author Mohammad Al-Buraiki
 * @version December 2021
 */
 
public class RobotTask {
	/**
	 * creates the robot
	 */
	public void run() {

		int blocks; // keeps track of number of blocks moved

		City Waterloo = new City("Remembering.wld"); // new city
		Waterloo.showThingCounts(true);

		RememberingRobot rbP = new RememberingRobot(Waterloo, 6, 0, Direction.NORTH, 30);
		rbP.setItemsPicked(0);
		rbP.clearAve(4);
		rbP.getColor();
		
		RememberingRobot rbP2 = new RememberingRobot(Waterloo, 6, 1, Direction.NORTH, 30);
		rbP2.clearAve(3);
		
		System.out.println("Final States of Robot 1:");
		System.out.println("Avenue: " +rbP.getAvenue());
		System.out.println("Street: " +rbP.getStreet());
		System.out.println("Direction: " +rbP.getDirection());
		System.out.println("Items picked up: " +rbP.getItemsPicked());
		System.out.println("Blocks Moved: " +rbP.getBlocksMoved());
		System.out.println("Color: " +rbP.getColor());
		
		System.out.println("Final States of Robot2:");
		System.out.println("Avenue: " +rbP2.getAvenue());
		System.out.println("Street: " +rbP2.getStreet());
		System.out.println("Direction: " +rbP2.getDirection());
		System.out.println("Items picked up: " +rbP2.getItemsPicked());
		System.out.println("Blocks Moved: " +rbP2.getBlocksMoved());
		System.out.println("Color: " +rbP2.getColor());
	}
}
