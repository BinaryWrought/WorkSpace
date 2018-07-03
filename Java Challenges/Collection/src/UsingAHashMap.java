/*
 * This is free to use as it was only made for practice.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/ishaan-and-sticks/0" target="_blank">GeeksForGeeks Easy Ishaan andSticks</a>
 * 
 * To summarize the challenge:
 * Given a set of stick lengths, determine the largest area square that can be made.
 * Print the area, as well as the quantity of squares that can be made with this area.
 * 
 * I'm including this in my collection because of its use of a HashMap and it shows how to iterate through it concisely.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class UsingAHashMap 
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
                int n = scanner.nextInt();                                                          //get the number of sticks
                float loadFactor = 0.75f;                                                           //optimized load factor
                int initialCapacity = (int)( n / loadFactor ) + 1;                                  //initial capacity of hash map
                
                HashMap<Integer, Integer> sticks = new HashMap<>( initialCapacity , loadFactor );   //container for number of sticks (value) and their length (key)
                
                for( int i = 0; i < n; ++i )                                                        //loop to populate container
                {
                    int s = scanner.nextInt();                                                      //get the next length of stick (key)
                    if( !sticks.containsKey( s ) )                                                  //check if the container already has this length stick
                        sticks.put( s, 1 );                                                         //if not, add it with an initial count of 1
                    else
                       sticks.put( s, sticks.get( s ) + 1 );                                        //otherwise, increment the count for this key
                }
                
                int max = 0;                                                                        //container for largest size stick
                int count = 0;                                                                      //container for number of squares that can be made
                
                for( Map.Entry< Integer, Integer > me : sticks.entrySet() )                         //loop through container of stick lengths
                {
                    if( me.getValue() >= 4 && me.getKey() > max )                                   //if the quantity of sticks is greater than or equal to 4 (a square can be made) AND the length is greater than the current largest length
                    {
                        max = me.getKey();                                                          //save the max stick length
                        count = me.getValue() / 4;                                                  //save the count as the number of squares that can be made
                    }
                }
                
                System.out.println( ( max == 0 )? "-1" : (max * max ) + " " + count );              //print the result
    			t--;																				//get next test case
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}