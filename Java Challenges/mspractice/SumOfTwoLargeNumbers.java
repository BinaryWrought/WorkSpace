package mspractice;

import java.math.BigInteger;
import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/sum-of-numbers-or-number/0" target="_blank">GeeksForGeeks Sum of two large numbers</a>
 * 
 * To summarize the challenge:
 * Given two many digit numbers X and Y, calculate the sum. If the number of digits in the sum is equal to the number of digits in X print the sum, otherwise print X.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class SumOfTwoLargeNumbers 
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
                BigInteger x = scanner.nextBigInteger();                        //get X
                BigInteger y = scanner.nextBigInteger();                        //get Y
                
                int xLength = x.toString().length();                            //for the solution the length of X is needed
                BigInteger sum = x.add( y );                                    //get the sum of X and y
                int sumLength = sum.toString().length();                        //for the solution the length of the sum is needed
                                
                System.out.println( ( xLength == sumLength )? sum.toString(): x.toString() );   //if the lengths are equal print the sum, else print X
                
                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}