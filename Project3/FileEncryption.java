// Mark Arias
// File Encryption Program
// CS 55
// Professor Dehkhoda
// Program Purpose:
// this program is supposed to use an encryption key pattern to encrypt a given input file
// into a cipher
// this program should then be able to also decrypt this message

/* Program Bugs/ Notes
 * Program must be fed a valid file name for correct operation otherwise an exception gets thrown
 * Program also requires that you specify full path to file on your system:
 * On my mac, I used:
 * /Users/marksarias/Desktop/inputfile.txt
 * for instance. Made this change to make this program able to run under different system directories
 * 
 * Also made this program have two operating states, encryption mode, and decryption mode
 * depending on what work user needs to perform
 */


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileEncryption
{


	public static void main(String[] args) throws Exception
	{
		
		System.out.println("File Encryption/Decryption Program");
		String letters = "abcdefghijklmnopqrstuvwxyz";
		String enc = "kngcadsxbvfhjtiumylzqropwe";
		//----------------------------------------------------------------
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter name of input file: ");
		String inputFileAppend = userInput.next();
		System.out.println("Please enter name of output file: ");
		String outputFileAppend = userInput.next();
		
		
		//----------------------------------------------------------------
		//Perform the File Input, Output Declarations
				
		File inFile = new File(inputFileAppend);
		
				
		File outFile = new File(outputFileAppend);
		

	
			
		//----------------------------------------------------------------
		// Ask the user if they would like to encrypt a file, or decrypt a file
		// and set the program state to appropriate conditions
		
		System.out.println("Would you like to encrypt or decrypt a text?");
		System.out.println("Please enter e or E for encrypt, and d or D for Decryption");
		
		String userChoice;
		userChoice = userInput.next();
		char modeSelection = userChoice.charAt(0);
		// Code block below let's user select what mode they want this program to be in
		// encryption state, or decryption
		// Acheive this by switching around the strings that contain the encoding scheme
		if(modeSelection == 'e' || modeSelection == 'E')
		{
			letters = "abcdefghijklmnopqrstuvwxyz";
			enc = "kngcadsxbvfhjtiumylzqropwe";
		}
		else if(modeSelection == 'd' || modeSelection == 'D')
		{
			letters = "kngcadsxbvfhjtiumylzqropwe";
			enc = "abcdefghijklmnopqrstuvwxyz";
			inFile = new File(inputFileAppend);
			outFile = new File(outputFileAppend);
		}
		else
		{
			System.out.println("Invalid selection. Program terminating. Goodbye");
			System.exit(0);
		}
		
		
		// Positioned the creation of these objects here since their arguments may be modified
		// by the preceding if else logic 
		Scanner input = new Scanner(inFile);
		PrintWriter output = new PrintWriter(outFile);
		
		//----------------------------------------------------------------
		// This algorithm provides the encryption mechanism
		// The key trick that this algorithm performs is that it uses the indexing of the two strings in the beggining of the program
		// to perform the proper conversions. The alternate hardcoded method involves using a lot of switch of if else statements
		// with a lot of conditions to check, and that is hard to maintain
		// This algorithm instead uses the outer while loop to traverse the whole span of input 
		// it then goes through and checks each char for its case sensitivity
		// and then uses an inner for loop to traverse the letters string until it finds a match and sets our char to the corresponding
		// char in the jth position in the enc string.
		while(input.hasNext())
		{
			String line = input.nextLine();
			for(int i = 0; i < line.length(); i++)
			{
				char temp = line.charAt(i);
				// want to perform the letter case checking here
				if(Character.isUpperCase(temp))
				{
					char lowerChar = Character.toLowerCase(temp);
					for(int j = 0; j < letters.length(); j++)
					{
						if(lowerChar == letters.charAt(j))	
						{
							lowerChar = enc.charAt(j);
							break;	
						}
					}
					temp = Character.toUpperCase(lowerChar);
				}
				else
				{
					for(int j = 0; j < letters.length(); j++)
					{
						if(temp == letters.charAt(j))	
						{
							temp = enc.charAt(j);
							break;	
						}
					}
				}
				//write temp to encrypted file here
				output.print(temp);
			}
		}
		
		System.out.println("Encrption/ Decryption Operations have been completed. Goodbye!");
		//----------------------------------------------------------------
		// Housekeeping Code
		input.close();
		output.close();
		userInput.close();
		System.exit(0);
	}


}

