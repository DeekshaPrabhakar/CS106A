/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run()
	{
		repairArch();
		moveBackToStart();
		while(frontIsClear())
		{
			moveToNextArchNRepair();
		}
	}
	
	private void moveToNextArchNRepair()
	{
		int movedSteps =0;
		for(int i=0; i<4; i++)
		{
			if(frontIsClear())
			{
				move();
				movedSteps++;
			}
		}
		if(movedSteps ==4){
			repairArch();
			moveBackToStart();
		}
	}
	
	private void repairArch()
	{
		if(noBeepersPresent()){
			putBeeper();
		}
		turnLeft();
		while(frontIsClear())
		{
			move();
			if(noBeepersPresent()){
				putBeeper();
			}
		}
	}
	
	private void moveBackToStart()
	{
		turnRight();
		turnRight();
		while(frontIsClear())
		{
			move();
		}
		turnLeft();
	}
}
