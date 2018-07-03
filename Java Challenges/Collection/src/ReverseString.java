/*
 * This is free to use as it was only made for practice.
 */

import java.util.Scanner;

/**
 * This is a solution to the <a href="http://practice.geeksforgeeks.org/problems/reverse-the-string/0" target="_blank">GeeksForGeeks School Reverse the String.</a>
 * 
 * To summarize the challenge:
 * Given a string print it in reverse.
 * 
 * I'm including this challenge because it has the syntax needed to build a string in reverse.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class ReverseString 
{

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) 
	{
		Scanner scanner = new Scanner( System.in );													//create a scanner object to get user input
		try																							//this try block is to catch the inevitable exception caused by the user quitting 
		{
			int t = scanner.nextInt();																//get number of test cases
			
			while( t > 0 )																			//So long as there are more test cases
			{	

				//Use string builder to simply reverse it automatically
				String reverse = new StringBuilder( scanner.next() ).reverse().toString();
				System.out.println( reverse );
					
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch the inevitable exception thrown by the user
		{
			
		}
    }
}