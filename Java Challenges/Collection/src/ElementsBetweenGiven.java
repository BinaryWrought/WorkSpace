/*
 * This is free to use as it was only made for practice.
 */

import java.util.Scanner;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/count-number-of-elements-between-two-given-elements-in-array/0" target="_blank">GeeksForGeeks Basic Count number of elements between two given elements in array</a>
 * 
 * To summarize the challenge:
 * Given an array of integers and two integers count the number of elements between the two given integers (excluding the given numbers.)
 * In the case where there is more than one of each given element, consider the leftmost occurrence for the first number and the rightmost occurrence for the second.
 * 
 * I'm including this challenge because I like how it made me think about ranges within an array.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class ElementsBetweenGiven 
{

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) 
	{
		Scanner scanner = new Scanner( System.in );													//create a scanner object to get user input
		try																							//this try block is to catch an exception caused by invalid input
		{
			int t = scanner.nextInt();																//get number of test cases
			
			while( t > 0 )																			//So long as there are more test cases
			{	
				int n = scanner.nextInt();                                                          //container for the size of array
                int[] arr = new int[n];                                                             //container for array of integers
                
                for( int i = 0; i < n; ++i )                                                        //loop to populate array
                    arr[i] = scanner.nextInt();                          
                
                int leftMost = scanner.nextInt();                                                   //given leftmost element
                int rightMost = scanner.nextInt();                                                  //given rightmost element
                
                int leftIdx = 0;                                                                    //container for left index
                int rightIdx = n - 1;                                                               //container for right index
                
                boolean foundLeft = false;                                                          //flag for found left element
                boolean foundRight = false;                                                         //flag for found right element
                
                for( int i = 0; i < n && ( !foundLeft || !foundRight ); ++i )                       //loop to find indices of given elements
                {
                    if( arr[ i ] == leftMost && !foundLeft )                                        //found the left element at i
                    {
                        leftIdx = i;                                                                //store the index
                        foundLeft = true;                                                           //set the flag
                    }
                    if( arr[ n - 1 - i ] == rightMost && !foundRight )                              //found the right element from the end of the array
                    {
                        foundRight = true;                                                          //set the flag
                        rightIdx = n - 1 - i;                                                       //store the index
                    }
                }
                
                System.out.println( ( rightIdx - leftIdx - 1 ) );                                   //print the result

				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}