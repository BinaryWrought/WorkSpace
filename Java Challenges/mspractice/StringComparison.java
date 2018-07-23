package mspractice;

import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/string-comparison/0" target="_blank">GeeksForGeeks String Comparison</a>
 * 
 * To summarize the challenge:
 * Given two strings, determine the difference between them. 1 -> string 1 is greater than string 2, -1 -> string 1 is less than string 2, and 0 -> the strings are equal.
 * There is one caveat - for the purpose of this challenge 'ng' is considered one character and it is between 'n' and 'o' in the alphabet.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class StringComparison 
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
                scanner.nextLine();

                
                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}