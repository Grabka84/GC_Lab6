package gc.lab6;

import java.util.Random;
import java.util.Scanner;

public class GC_Lab6 {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userContinue; // when prompted if user wants to continue, store response in this variable
		
		System.out.println("Welcome to the Grand Circus Casino!");
		System.out.println();
		
		do { // continue while user opts yes; does at least once
			
			// request user input section
			System.out.print("How many dice are you rolling? ");
			int howManyDice = scnr.nextInt(); // ask for integer
			//System.out.println(); // to next line, but not before user input
			scnr.nextLine(); // clear the scanner 
			System.out.print("How many sides would you like your dice to have? ");
			int howManySides = scnr.nextInt();
			scnr.nextLine();
			System.out.println();
			

			// do stuff with user inputs - if using 2 6-sided dice then we're playing craps
				if (howManyDice == 2 && howManySides == 6) {
					DiceRollerApp.diceRollerResult(howManyDice, howManySides, scnr); // go to DiceRollerApp class and use diceRollerResult method
				} else {
					System.out.print("Press any key to roll the dice (or \"n\" to exit immediately): " ); // prompt user to roll the dice
					String rolldice = scnr.nextLine();
					System.out.println();
					if(!(rolldice.equalsIgnoreCase("n"))) { // wait until user hits a key to roll or n to exit
						rollTheDice(howManyDice, howManySides);
					} else {
						break;
					}
				}
			// user opt in or out
			System.out.println();
			System.out.print("Would you like to continue? (y/n) ");
			userContinue = scnr.nextLine();
			System.out.println();
			
		} while (userContinue.charAt(0) =='y' || userContinue.charAt(0) == 'Y');
		
		scnr.close();
	}

	public static int generateRandomDieRoll1(int n) { // method using Math.random - used for odd # dice rolls
		int randomRoll = (int)(Math.random() * n + 1);
		return randomRoll;
	}
	
	public static int generateRandomDieRoll2(int n) { // method using util.Random - used for even # dice rolls
		Random rand = new Random();
		int x = rand.nextInt(n) + 1;
		return x;
	}
	
	public static void rollTheDice(int howManyDice, int howManySides) {
		int result;
		for(int i = 0; i < howManyDice; i++) {
			if(i%2==0) { // even rolls use DieRoll2
				result = generateRandomDieRoll2(howManySides);
			} else { // odd rolls use DieRoll1
				result = generateRandomDieRoll1(howManySides);
			}
			System.out.print("Dice #" + (i+1) + ": " + result);
			System.out.println();
		}
	}
}