/*
 * This is free to use as it was only made for practice.
 */



import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/string-of-commons/0" target="_blank">GeeksForGeeks Basic String of Commons</a>
 * 
 * To summarize the challenge:
 * Given two strings S and R print the characters that appear most frequently.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class TreeSetUsage 
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
                TreeSet<Character> setS = new TreeSet<>();                                          //container for the set of characters in S
                TreeSet<Character> setR = new TreeSet<>();                                          //container for the set of characters in R
                
                char[] s = scanner.nextLine().toCharArray();                                        //get the input S as a char array
                char[] r = scanner.nextLine().toCharArray();                                        //get the input R as a char array               
                
                for( int i = 0; i < s.length; i++ )                                                 //loop to add characters in s to setS
                    setS.add( s[i] );
                for( int i = 0; i < r.length; i++ )                                                 //loop to add characters in r to setR
                    setR.add( r[i] );
                
                /**
                 * The commented out part below is a fancy way of doing what's above. But it takes a lot longer to execute.
                 */
//                Character[] s = scanner.nextLine().chars().mapToObj( c -> ( char )c ).toArray( Character[]::new );    //convert the string to an array of Character objects
//                Character[] r = scanner.nextLine().chars().mapToObj( c -> ( char )c ).toArray( Character[]::new );    //convert the string to an array of Character objects          
//                Collections.addAll( setS, s);
//                Collections.addAll( setR, r);

                /**
                 * This of course can be condensed even further like this:
                 */       
//                Collections.addAll( setS, scanner.nextLine().chars().mapToObj( c -> ( char )c ).toArray( Character[]::new ) );
//                Collections.addAll( setR, scanner.nextLine().chars().mapToObj( c -> ( char )c ).toArray( Character[]::new ) );
                
                setS.retainAll( setR );                                                             //intersection (retainAll) of two sets is the elements only found in both sets - which is the challenge
                
                if( setS.isEmpty() )                                                                //in case there is nothing common between the two strings
                    System.out.println( "nil" );                                                    //print "nil" as per the requirements
                else
                {
                    for( Character e: setS )                                                        //loop to print contents of result set
                    {
                        System.out.print( e );                                                      //print the results
                    }
                    System.out.println();                                                           //add a line between outputs
                }
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
}