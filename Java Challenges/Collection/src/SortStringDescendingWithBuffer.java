/*
 * This is free to use as it was only made for practice.
 */



import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/sort-the-string-in-descending-order/0" target="_blank">GeeksForGeeks Basic Sort the string in descending order</a>
 * 
 * To summarize the challenge:
 * Given a string sort the characters in descending order.
 * 
 * Since my other solution was too slow I found this solution on GFG and thought it looked elegant.
 * 
 * I'm including this challenge because it shows how to use a StringBuffer to print a char[] array in reverse.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class SortStringDescendingWithBuffer 
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
			scanner.nextLine();
            
			while( t > 0 )																			//So long as there are more test cases
			{            
                char[] arr = scanner.nextLine().toCharArray();
                Arrays.sort( arr );                                                                 //sort the array in ascending order                     
                System.out.println( new StringBuffer( new String( arr ) ).reverse().toString() );   //Create a string from the sorted char array in reverse and print it
                
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{

		}
	}
}