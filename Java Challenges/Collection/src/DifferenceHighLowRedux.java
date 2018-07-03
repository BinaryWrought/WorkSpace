/*
 * This is free to use as it was only made for practice.
 */

import java.util.HashMap;
import java.util.Scanner;

/**
 * This is a solution to the <a href="http://practice.geeksforgeeks.org/problems/difference-between-highest-and-lowest-occurrence/0" target="_blank">GeeksForGeeks Basic Difference between highest and lowest</a>
 * 
 * To summarize the challenge:
 * Given an array with repeating integers, find the difference between the highest frequency of a number and lowest frequency of a number in the array.
 * Print the difference.
 * 
 * For the redux I did something a little fancy that may not actually benefit the code at all.
 * Basically, in the old one after populating the map I looped through every element to find the max and min frequencies to use for the difference.
 * This meant O(n) execution was a given because I needed to check all the elements.
 * 
 * For this redux what I did was after populating the map I get an ArrayList of just the values.
 * I then sorted the ArrayList (which hypothetically takes O( n log n) time)
 * Then it was a matter of subtracting the last element from the first to get the difference in frequency.
 * After I wrote the sort method to solve this problem is when I learned it takes O(n log n) time, which of course is  longer then O(n) time.
 * So really my original method was the best. Go figure.
 * 
 * To simplify that even further I instead made a TreeSet from the values which would be sorted automatically and would filter out any duplicate values.
 * Then its a matter of subtracting the first element from the last.
 * But according to GFG this method takes too long. I like how clean it looks though so I left it in but commented out.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class DifferenceHighLowRedux 
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
				int n = scanner.nextInt();															//get the size of the input array
                float load = 0.75f;
                int initial = (int)(n/load)+1;
				HashMap< Integer, Integer > map = new HashMap<>(initial, load);						//create a map
				for( int i = 0; i < n; ++i )														//loop to populate array
				{
					int key = scanner.nextInt();													//get the input
					if( map.containsKey( key ) )													//check if the map already has the key
					{
						int val = map.get( key ) + 1;												//if so, get the current value
						map.put( key, val );														//and update the key
					}
					else
						map.put( key, 1 );															//otherwise, add the new key with initial value 1
				}
                
                //This line below should work, but it takes too long according to GFG.
//              TreeSet<Integer> tree = new TreeSet<>(map.values());				
//				System.out.println( tree.last()- tree.first() );                                    //print the difference
                
                //This is the sort method mentioned above. It takes too long as well.
//              ArrayList<Integer> v = new ArrayList<>(map.values());
//              Collections.sort( v );							
//				System.out.println( v.get(v.size()-1) - v.get( 0 ) );                               //print the difference

                //This is the solution that takes O(n) time
				int max = Integer.MAX_VALUE;														//container for most frequent occurance
				int min = Integer.MIN_VALUE;														//container for least frequent occurance				
				for( Integer i : map.values() )														//iterate through the map
				{
					if( i > max )																	//look for the largest occurrance
						max = i;																	//set it to the container
					if( i < min )																	//look for the smallest occurrance
						min = i;																	//set it to the container
				}				
				System.out.println( ( max - min ) );												//print the difference
				
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}