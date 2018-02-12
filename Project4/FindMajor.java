// Mark Arias
// Find Major Program
// CS 55
// Professor Dehkhoda
// Program Purpose:
// this program is designed to find a students major based on char input
// that is given to the console
// the main will call two methods that parse the string input
// and return the appropriate Strings indicating major and grade standing


import java.util.Scanner;


public class FindMajor
{

	public static void main(String [] args) 
	{
		Scanner input = new Scanner(System.in);
		String code = input.nextLine();			// code var stores the whole line typed in by the user			
		char major = code.charAt(0);				// these char variables us char at methods to grab the first two chars for use
		char status = code.charAt(1);			// in the called methods
		System.out.println(findMajor(major) + " : " + findStatus(status));
		
		input.close();							// I needed to include this code because eclipse kept complaining about a resource leak
		System.exit(0);							// if the input object was not closed
	}
	
	
	// findMajor method returns a string depending on what char value is given as a a parameter
	public static String findMajor(char m)
	{		
		if(m == 'm' || m == 'M')		// check whether lower or uppercase is used for the case conditions
		{
			return "Mathematics";	
		}
		else if(m == 'c' || m == 'C')
		{
			return "Computer Science";
		}
		else if(m == 'i' || m == 'I')
		{
			return "Information Technology";
		}
		
		return "error";				// if none of the above cases matched, then the defualt return is error
	}								// since user did not enter input in accordance to what this program is seeking as input
	
	
	// findStatus method also receives a char as input and returns the class standing to the terminal window
	public static String findStatus(char s)
	{
		if(s == '1')
		{
			return "Freshman";
		}
		else if(s == '2')
		{
			return "Sophmore";
		}
		else if(s == '3')
		{
			return "Junior";
		}
		else if(s == '4')
		{
			return "Senior";
		}
		
		return "error";		// I employ similar error catching here
	}

}
