/*
 * This is free to use as it was only made for practice.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/extract-the-phone-number/0" target="_blank">GeeksForGeeks Basic Extract the Phone Number</a>
 * 
 * To summarize the challenge:
 * Given a string extract and print the phone number.
 * The phone number will be in the format: +dd-ddddddddddd ( that's 11 d's after the - )
 * There ought to be a regex solution. Time to test what I learned about regex.
 * 
 * I'm including this challenge because its a good use of regex.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class ExtractThePhoneNumber 
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
			
            Pattern p = Pattern.compile("\\+[0-9]{2}\\-[0-9]{11}");                                 //this regex will get the number with the given constraints
            scanner.nextLine();                                                                     //these is needed because of the line between the test case input and the actual test cases.
			
            while( t > 0 )																			//So long as there are more test cases
			{		                
				String s = scanner.nextLine();                                                      //get the next input string
                Matcher m = p.matcher(s);                                                           //match the given pattern on the input string

                if( m.find() )                                                                      //verify a match occurred
                    System.out.println( m.group() );                                                //print the matched string
                
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}