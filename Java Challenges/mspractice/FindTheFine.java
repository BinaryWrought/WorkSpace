package mspractice;

import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/find-the-fine/0" target="_blank">GeeksForGeeks Find the fine</a>
 * 
 * To summarize the challenge:
 * Given an array of penalties, and array of car numbers and a date fine the total fine which will be collected on a given date.
 * The fine is collected from odd-numbered cars on even dates and vice versa
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class FindTheFine 
{    
    
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
                int date = scanner.nextInt();
                
                int[] cars = new int[n];
                int[] fines = new int[n];
                
                for( int i = 0; i < n; ++i )
                {
                    cars[i] = scanner.nextInt();
                }
                for( int i = 0; i < n; ++i )
                {
                    fines[i] = scanner.nextInt();
                }
                
                boolean evenDate = ( date % 2 == 0 );
                
                int totalFine = 0;
                for( int i = 0; i < n; ++i )
                {
                    if( evenDate && ( cars[i] % 2 != 0 ) )
                    {
                        totalFine += fines[i];
                    }
                    else if( !evenDate && ( cars[i] % 2 == 0 ) )
                        totalFine += fines[i];
                }
                
                System.out.println( totalFine );
                
                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}