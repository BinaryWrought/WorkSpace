package mspractice;

import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/closest-number/0" target="_blank">GeeksForGeeks Closest Number</a>
 * 
 * To summarize the challenge:
 * Given two integers, N and M, find the number that is closest to N and divisible by M.
 * If there is more than one such number output the one having maximum absolute value.
 * O(1) is required.
 * 
 * The real challenge here is the time constraint. My initial thought was to just make a loop from N that incremented and decremented simultaneously - which would execute O(n) time.
 * So the actual solution requires so math.
 * 
 * It looks like the solution is to define Q as N/M. and P as Q*M.
 * Then if M*N > 0 a potential solution S is M*(Q+1)
 * Otherwise a potential solution S is M*(Q-1)
 * 
 * Then the actual answer is whatever is greater between the absolute value of N - P and N - S.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class ClosestNumber 
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
                int m = scanner.nextInt();
                
                int q = n/m;
                int p = q*m;
                int s = 0;
                
                if( m*n > 0 )
                    s = m * ( q + 1 );
                else
                    s = m * ( q - 1 );
                                
                System.out.println( ( Math.abs( n - p ) >= Math.abs( n - s ) )? s : p );
                
                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}