/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run(){
		if(frontIsBlocked()){
			turnLeft();
		}
		fillAllPoints();
		
		while(beepersPresent()){
			moveFrontOrBack();
		}
		turnAround();
		move();
		putBeeper();
		turnAround();
		moveBackToHome();
	}
	
	private void fillAllPoints(){
		putBeeper();
		while(frontIsClear()){
			move();
			putBeeper();
		}
	}
	
	private void moveFrontOrBack(){
		while(frontIsClear()){
			move();
		}
		turnAround();
		while(noBeepersPresent()){
			move();
		}
		pickBeeper();
		move();
	}
	
	private void moveBackToHome(){
		while(frontIsClear()){
			move();
		}
		turnAround();
		if(frontIsBlocked()){
			while(frontIsClear()){
				move();
			}
			turnAround();
		}
	}
}
