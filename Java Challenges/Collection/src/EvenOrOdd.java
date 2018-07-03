/*
 * This is free to use as it was only made for practice.
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/product-is-even-or-odd/0" target="_blank">GeeksForGeeks Basic Even or Odd</a>
 * 
 * To summarize the challenge:
 * Given two numbers, determine if their product is even or odd.
 * Print 1 for even 0 for odd.
 * 
 * I'm including this just because of its use of BigInteger. That class always trips me up.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class EvenOrOdd 
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
				BigInteger first = scanner.nextBigInteger();                                        //get the first number
                BigInteger second = scanner.nextBigInteger();                                       //get the second number
				
                BigInteger product = first.multiply( second );
                BigInteger mod = product.mod( new BigInteger( "2", 10 ) );
                
				System.out.println( ( mod.intValue() == 0 ) ? "1" : "0" );                          //print the result
				
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}