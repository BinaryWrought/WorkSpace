/*
 * This is free to use as it was only made for practice.
 */

import java.util.*;

/**
 * This is a solution to the <a href="http://practice.geeksforgeeks.org/problems/key-pair/0" target="_blank">GeeksForGeeks Easy Key Pair</a>
 * 
 * To summarize the challenge:
 * Given an array of numbers, and another number X, determine if two numbers in the array sum to X.
 * This solution uses a hash map where the elements from the input array are the keys and the index of the element from the array is the value.
 *
 * Using this method I can print both the index of the elements and the values and still execute in O(n).
 * 
 * I'm including this because I had a similar challenge during an interview (I failed at the time, only had a brute-force solution.)
 * But I also like this solution because it gives me both the index and the element.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class KeyPairHashRedux 
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
                float loadFactor = 0.75f;
                int initialCapacity = (int)(n/loadFactor) + 1;                
				HashMap< Integer, Integer > map = new HashMap<>( initialCapacity, loadFactor );		//The key is value in the original array, the value is the index from the array
				
                boolean found = false;
				for( int i = 0; i < n; ++i )                                                        //for each element in the array
				{
                    int e = scanner.nextInt();
					int temp = x - e;                                                               //find the difference between the sought after sum and this element
					if( map.containsKey( temp ) )													//if the map has the difference and its not this element
					{
                        found = true;
					}
					map.put( e, i );                                                                //put the value in the map
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