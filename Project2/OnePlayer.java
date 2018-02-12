// Mark Arias	CS 55	Professor Dehkhoda

// Program Purpose:
// ask user to input amount and store in it variable named balance
// ask user for the bet amount
// if( betAmount <= balance amount)
// then rolldice
// two 'dice' need to be rolled
// and then summed
// if sum of roll == 7 or 11 the player wins 3 times the bet
// else player loses bet(and loses the money bet)
// as long as player has money in balance, can keep betting
// else player is broke( debt collectors come for them)

import java.util.Scanner;		// Scanner is in the java.util package
import java.util.Random;		// for the random generator

public class OnePlayer
{
	public static void main(String [] args)
	{
		// This section of code creates and initializes the variables used in the rest of the program
		// also creates and initializes the Scanner object input
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the amount of money you would like to play with:  ");
		double tempBalance = input.nextDouble();
		double balance = Math.abs(tempBalance);	// to prevent the user from entering negative numbers
		double reward = 0.0;

		while( balance > 0)
		{
		System.out.println("Current Funds: $" + balance);
		System.out.print("Enter bet: $");
		double tempbetAmount = input.nextDouble();
		double betAmount = Math.abs(tempbetAmount);	// ensures only positive bets are made



		// this statement is a catch, that should end program execution if 
		// amount betted is larger than available funds
		if (betAmount > balance)
		{
			System.out.println("Invalid input:" +
					"\nEnter a bet amount within available funds");
			tempbetAmount = input.nextDouble();
			betAmount = Math.abs(tempbetAmount);
		}

		// This code block does the work of calling the diceRoll functions
		// and determining whether or not the user won the bet
		if( betAmount <= balance)
		{
			int roll1 = diceRoll();
			int roll2 = diceRoll();
			int sum = roll1 + roll2;
			if(sum == 7 || sum == 11)	// player wins the bet
			{
				reward = betAmount * 3;
				balance += reward;		// update the player's balance to reflect sum won
				System.out.println("Dice Roll: " + roll1 + " " + roll2);
				System.out.println("You won $" + reward);
			}
			else
			{
				balance -= betAmount;
				System.out.println("Dice Roll: " + roll1 + " " + roll2);
				System.out.println("You lost the round.");
			}

		}
		else
		{
			System.out.println("Out of funds");
			System.out.println("Thanks for playing!");
			System.exit(0);
		}

		}

	}


	// I encapuslated the diceRoll functionality, to make this code more modular 
	// and reusable. Calling this function returns a randomly generated number 
	// within the range 1-6
	public static int diceRoll()
	{
		Random rand = new Random();
		int roll = rand.nextInt(6) + 1;
		return roll;
	}





}