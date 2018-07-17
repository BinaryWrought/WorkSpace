package mspractice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/phone-directory/0" target="_blank">GeeksForGeeks Phone Directory</a>
 * 
 * To summarize the challenge:
 * Given a string of space separated entries in a phone directory, run a search query listing all matches for each prefix from the query.
 * For example if the query is abcd then the results should be every entry that starts with 'a' then all entries that start with 'ab' then all with 'abc' and so on.
 * When nothing is found, print 0.
 * 
 * Admittedly I had no idea where to start with this. The first java solution I looked at (from GFG user Shankar Kshetry) had a bunch of techniques and methods that I've never even heard of.
 * So I blatantly copied it so I can study and learn these techniques. See the comments below, but I'll also elaborate on some of the niftier aspects right here.
 * 
 * First, take a look at how he turned a single string into a list of unique elements sorted with natural order. It was done in one line!
 * Basically he created a list and used the collections API to get the elements as a list.
 * But then the real magic happens. By taking that return value and calling .stream().distinct() he effectively turned the list into a set. (Why he didn't just use a set in the first place, I don't know.)
 * Next there is apparently a .sorted() method to return the elements in a sorted order.
 * Lastly there is a call to a .collect() method with a .toList() argument. 
 * I believe (from looking at the documentation) that this method allows all of the previous methods to be applied to the stream at once so that it can be interpreted as a list.
 * 
 * Second, and similar to the first point, is the method getResults.
 * In this case the method has a list of strings passed as an argument as well as a string that is the 'query' for the problem statement.
 * This creates a new list of strings by using a method called filter to only get the elements from the list that start with the specified query.
 * Again there is a call to collect as a list.
 * 
 * Having seen these techniques I'm tempted to go over a bunch of my old challenges to see if something can be improved upon.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class StringQuery 
{    
    
    /**
     * This method will return a list of strings that start with the specified query
     * @param data
     * @param query
     * @return 
     */
    private static List<String> queryResults( List<String> data, String query )
    {
        return data.stream().filter( s -> s.startsWith( query ) ).collect( Collectors.toList() );
    }
    
    /**
     * 
     * @param args 
     */
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );				//create a scanner object to get user input
        
        try									//this try block is to catch the inevitable exception caused by the user quitting 
        {
            int t = scanner.nextInt();                                          //get the number of test cases            
            
            while( t > 0 )							//So long as there are more test cases
            {        
                int n = scanner.nextInt();
                scanner.nextLine();
                
                //create a list of strings from the space-delimited input.
                //the list will only contain distinct elements sorted in natural order.
                List<String> input = Arrays.asList( scanner.nextLine().split( " " ) ).stream().distinct().sorted().collect( Collectors.toList() );
                String query  = scanner.nextLine();
                boolean found = true;
                for( int i = 0; i < query.length(); ++i )
                {
                    if( !found )
                        System.out.println( 0 );
                    else
                    {
                        List<String> results = queryResults( input, query.substring( 0, i+1 ) );
                        found = !results.isEmpty();
                        if( !found )
                            System.out.println( 0 );
                        else
                        {
                            results.forEach( s -> System.out.print( s + " " ) );
                            System.out.println();
                        }
                    }
                }
                
                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}