/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run(){
		int i=1;
		fillEvenColumn();
		moveBackToStart();
		while(frontIsClear()){
			move();
			if(i%2 == 0)
			{
				fillEvenColumn();
			}
			else
			{
				fillOddColumn();
			}
			moveBackToStart();
			i++;
		}
	}
	
	private void fillEvenColumn(){
		turnLeft();
		putBeeper();	
		int i=0;
		while(frontIsClear()){
			move();
			i++;
			if(i==2){
				i = 0;
				putBeeper();
			}
		}
	}
	
	private void fillOddColumn(){
		turnLeft();
		if(frontIsClear()){
		move();
		putBeeper();	
		}
		int i=0;
		while(frontIsClear()){
			move();
			i++;
			if(i==2){
				i = 0;
				putBeeper();
			}
		}
	}
	
	private void moveBackToStart()
	{
		turnAround();
		while(frontIsClear())
		{
			move();
		}
		turnLeft();
	}


}
