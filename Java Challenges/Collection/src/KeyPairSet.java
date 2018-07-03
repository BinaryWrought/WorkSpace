/*
 * This is free to use as it was only made for practice.
 */

import java.util.HashSet;
import java.util.Scanner;

/**
 * This is a solution to the <a href="http://practice.geeksforgeeks.org/problems/key-pair/0" target="_blank">GeeksForGeeks Easy Key Pair</a>
 * 
 * To summarize the challenge:
 * Given an array of numbers, and another number X, determine if two numbers in the array sum to X.
 * This solution uses a hash set where each element is added to the set.
 * As such it will not contain duplicate elements. But given the problem statement,
 * and my implementation of the solution, that won't be a problem.
 * This is because if the solution was two duplicate elements, I would detect that before not adding the element to the set.
 * For example, the sum we're looking for is 10, and the array contains two 5's.
 * When I get the first 5 its not in the set, so no solution is found and 5 is added to the set.
 * Upon reaching the second 5 I see 5 is already in the set and I see that 5 + 5 = 10 so the solution is found.
 * 
 * I'm including this because even though I cannot get the index, the data structure used here better suits the challenge.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class KeyPairSet 
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
				int n = scanner.nextInt();															//get the size of the array
				int x = scanner.nextInt();															//get the sum to look for
                int initialCapacity = (int)(n/0.75) + 1;
                float loadFactor = 0.75f;
				HashSet< Integer > set = new HashSet<>( initialCapacity, loadFactor );              //The key is the element from the array
				
                boolean found = false;
				for( int i = 0; i < n; ++i )                                                        //for each element in the array
				{
                    int e = scanner.nextInt();
					int temp = x - e;                                                               //find the difference between the sought after sum and this element
					if( set.contains( temp ) )                                                      //if the map has the difference and its not this element
                        found = true;

					set.add( e );                                                                   //put the value in the map
				}				
                System.out.println( (found)? "Yes" : "No" );
				t--;																				//get next test case
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}