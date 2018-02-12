/*

Mark Arias	CS 55	Professor Dehkhoda
Project: Calculating future investment value
Program Specifications:
-read in investment amount, annual interest rate, and number of years
-display the future investment value via following formuala:
futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate)^(numberOfYears * 12)

*/

import java.util.Scanner;

// dont forget that all class's must start with capital letter by convention
public class FutureInvestment
{
	public static void main(String [] args)
	{
		// creates an input object of type Scanner
		// inherits all the methods of said class
		Scanner input = new Scanner(System.in);

		// receving user input and setting program variables achevied here 
		System.out.print("Enter investment amount: ");
		double investmentAmount;
		investmentAmount = input.nextDouble();

		System.out.print("Enter annual interest rate: ");
		double annualInterestRate;
		annualInterestRate = input.nextDouble();

		System.out.print("Enter number of years: ");
		double years;
		years = input.nextDouble();

		//-----------------------------------------------------------------------------------
		double accumulatedValue;
		double monthlyInterestRate = (annualInterestRate / 12) / 100;

		accumulatedValue = investmentAmount * Math.pow((1 + monthlyInterestRate), (years * 12));
		// format the answer to two decimal places
		// rounds the last decimal up to the next val
		double roundedVal = Math.round(accumulatedValue * 100) / 100.0;

		System.out.print("Accumulated value is: ");
		System.out.println(roundedVal);
		// program is operational, simply needed to refine it a bit, and fix the final answer output
		// clean up the code and formula used a bit perhaps.



	}


}
