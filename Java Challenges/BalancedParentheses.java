/*
 * This is free to use as it was only made for practice.
 */

import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/parenthesis-checker/0" target="_blank">GeeksForGeeks Parenthesis checker</a>
 * 
 * To summarize the challenge:
 * Given a string of parentheses, check if it is balanced.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class BalancedParentheses 
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
                char[] exp = scanner.nextLine().toCharArray();                                      //get the expression as a char array

                Stack<Character> s = new Stack<>();                                                 //stack container to hold parentheses
                boolean balanced = true;                                                            //flag for a balanced expression

                for( int i = 0; i < exp.length && balanced; ++i )                                   //loop through the expression or until its shown to not be balanced
                {
                    if( exp[ i ] == '(' || exp[ i ] == '[' || exp[ i ] == '{' )                     //if the char is an opening parenthesis...
                    {
                        s.push( exp[ i ] );                                                         //add it to the stack
                    }
                    if( exp[ i ] == ')' || exp[ i ] == '}'|| exp[ i ] == ']' )                      //if the char is a closing parenthesis...
                    {
                        if( s.empty() )                                                             //first check if the stack is empty
                            balanced = false;                                                       //if so, this is not balanced
                        else                                                                        //otherwise, check if the last opening paren put on the stack matches this closing paren
                            balanced = matchingPair( exp[ i ], s.pop() );                           //set the flag based on the matching pair
                    }
                }

                if( !s.empty() )                                                                    //if after going through the whole loop there are still parens in the stack
                    balanced = false;                                                               //then the expression is not balanced

                System.out.println( balanced ? "balanced" : "not balanced" );                       //print the result

                t--;																				//get next test case
            }
        }
        catch( Exception e )																		//catch an exception thrown by incorrect input
        {

        }
    }
    
    /**
     * This method will determine if the given parentheses are a matching pair or not
     * @param one the first parenthesis
     * @param two the second parenthesis
     * @return true if the two parentheses are a matching pair, otherwise false.
     */
    public static boolean matchingPair( char one, char two )
    {
        if( one == ')' && two == '(' )
            return true;
        else if( one == '}' && two == '{' )
            return true;
        else if( one == ']' && two == '[' )
            return true;
        else
            return false;
    }
}