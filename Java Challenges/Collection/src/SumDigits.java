
import java.util.Scanner;

/*
 * This is free to use as it was only made for practice.
 */

/**
 * This is a solution to the <a href="http://" target="_blank">GeeksForGeeks </a>
 * 
 * To summarize the challenge:
 * Given an integer, sum its digits and print the result.
 * 
 * I'm including this challenge because it shows how to use mod 10 to sum the digits of an integer.
 * I really need to remember this technique because I know I've converted an integer to a string
 * and iterated through its chars parsing as ints too many times. I should have used this technique all along.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class SumDigits 
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
                int n = scanner.nextInt();															//get integer input
                int sum = 0;
                while ( n > 10 )
                {
                    sum += n%10;
                    n /= 10;
                }
                sum += n;
                
                System.out.println( sum );
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}