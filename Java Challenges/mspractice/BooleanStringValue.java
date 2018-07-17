package mspractice;

import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/boolean-string-value/0" target="_blank">GeeksForGeeks Boolean String Value</a>
 * 
 * To summarize the challenge:
 * Given a string containing only the characters 0, 1, A, B, C where A = AND, B = OR, C = XOR calculate the binary value of the string.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class BooleanStringValue 
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
            scanner.nextLine();
            
            while( t > 0 )							//So long as there are more test cases
            {         
                String input = scanner.nextLine();
                
                boolean value = input.charAt( 0 ) == '1';
                for( int i = 1; i < input.length()-1; i+=2 )
                {
                    boolean nextValue = input.charAt( i+1 ) == '1';
                    
                    switch( input.charAt( i ) )
                    {                        
                        case 'A':
                            value = value & nextValue;
                            break;
                        case 'B':
                            value = value | nextValue;
                            break;
                        case 'C':
                            value = value ^ nextValue;
                            break;
                    }
                }
                
                System.out.println( value? '1' : '0' );
                
                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}