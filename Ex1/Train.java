/******************************
ID: 204894281

Train.java
This java program receives from the user the velocity and time for 2 trains,
and calculates the distance between them. 
*******************************/

import java.util.Scanner;
public class Train
{
	public static void main (String [] args)
	{
		final int NUMBER_OF_MINUTES_IN_AN_HOUR = 60; 
		Scanner scan = new Scanner (System.in);
		System.out.println ("Please enter 4 integers ");
		System.out.println ("Please enter the speed of train 1:");
		int velocity1 = scan.nextInt();
		System.out.println ("Please enter the time of train 1:");
		int time1 = scan.nextInt();
		System.out.println ("Please enter the speed of train 2:");
		int velocity2 = scan.nextInt();
		System.out.println ("Please enter the time of train 2:");
		int time2 = scan.nextInt();
		double distance1 = (double) velocity1*time1/NUMBER_OF_MINUTES_IN_AN_HOUR; //Calculation of the real distance traveled by the first train.
		double distance2 = (double) velocity2*time2/NUMBER_OF_MINUTES_IN_AN_HOUR; //Calculation of the real distance traveled by the second train.
		double distanceBetweenTrains = Math.abs(distance1-distance2); //Calculation + Ensuring a positive distance.
		System.out.println("The distance between the trains is " + distanceBetweenTrains + " km.");
	} // end of method main
} //end of class Train