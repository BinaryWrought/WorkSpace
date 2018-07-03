/*
 * This is free to use as it was only made for practice.
 */

import java.util.Scanner;

/**
 * This is a solution to the <a href="http://practice.geeksforgeeks.org/problems/key-pair/0" target="_blank">GeeksForGeeks Easy Key Pair</a>
 * 
 * To summarize the challenge:
 * Given an array of numbers, and another number X, determine if two numbers in the array sum to X.
 * This solution uses an array with a time complexity of O(n) if the range is known.
 * 
 * What is happening is an array of booleans is created with the same size as the range of the inputs (+1 because index starts at 0 )
 * When an integer is given for the array, that means that that integer is present - this is the key.
 * So use that element's value as the index to the boolean array and set that to true - because this element exists within the array.
 * 
 * Now, to find the actual pair...
 * 
 * Subtract the element from the given sum.
 * The remainder is the difference. This is the number we want to see if it is in the array.
 * If the DIFFERENCE exists within the boolean array this implies that the sum can be found.
 * So just check if booleanArray [ difference ] == true.
 * If so, then the pair is the element in the array: arr[ i ] and DIFFERENCE.
 * 
 * I'm including this because it is the most efficient solution to the challenge
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class KeyPairArrayRedux 
{

	private static final int MAX = 1001; // Max size of Hashmap
	
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
				int n = scanner.nextInt();															//get the size of the array
				int x = scanner.nextInt();															//get the sum to look for
				boolean[] binmap = new boolean[ MAX ];                                              //create an array with a size equal to the range of inputs
                boolean found = false;                                                              //flag to indicate if pair was found or not
                
				for( int i = 0; i < n; ++i )														//loop to populate array and look for pair
				{
                    int temp = scanner.nextInt();                                                   //the next element in the array
                    binmap[temp] = true;                                                            //set the flag for this element
                    int temp2 = x - temp;                                                           //find the difference between the sought after sum X and this array element
                    if( temp2 >=0 && temp2 <= MAX && binmap[temp2] )                                //check that the difference is within the range, then check if the difference already exists within the array
                        found = true;                                                               //if so, set the flag
				}
				
				System.out.println( ( found )? "Yes" : "No");                                       //print result
				
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}