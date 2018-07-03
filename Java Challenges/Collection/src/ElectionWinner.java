/*
 * This is free to use as it was only made for practice.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names/0" target="_blank">GeeksForGeeks Basic Winner of an election where votes are represented as candidate names</a>
 * 
 * To summarize the challenge:
 * Given an array of strings print the word that appears the most and its count, or if there is a tie, lexicographically first.
 * 
 * I'm including this one because it shows use of a tree map and I get the highest count AND lexicographically first value
 * by comparing elements where the count is STRICTLY greater than.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class ElectionWinner 
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
				int n = scanner.nextInt();                                                          //get the string to be converted for this test case
                scanner.nextLine();
                TreeMap< String, Integer > map = new TreeMap<>();
                
                for( int i = 0; i < n; ++i )
                {
                    String s = scanner.next();
                    if( map.containsKey( s ) )
                        map.put( s, map.get( s ) + 1 );
                    else
                        map.put( s, 1 );
                }
                
                String out = "";
                int count = 0;
                
                for( Map.Entry<String, Integer> m : map.entrySet() )
                {
                    if( m.getValue() > count )
                    {
                        out = m.getKey();
                        count = m.getValue();
                    }
                }
                
                System.out.println( out + " " + count );
                
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			System.out.println("Some exception was thrown.");
		}
	}
}