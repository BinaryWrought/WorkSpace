package mspractice;

import java.util.*;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/ease-the-array/0" target="_blank">GeeksForGeeks Ease the Array</a>
 * 
 * To summarize the challenge:
 * Given an array of integers modify the array such that if the next number is valid and the same as the current number double the current number
 * and replace the next number with a 0. After the modification rearrange the such that all 0's are shifted to the end.
 * 0's are considered invalid for this challenge.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class EaseTheArray 
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
                scanner.nextLine();

                String[] input = scanner.nextLine().split( " " );               //Getting the input one int at a time takes longer than this method.
                
                int z = 0;                                                      //count the zeros to print at the end
                if( input[n-1].equals( "0" ) )                                  //the last element won't be checked directly, so if it is a zero, add to the zero count
                    z++;
                
                for( int i = 0; i < n-1; ++i )                                  //loop to modify the array as per the requirements
                {
                    if( !input[i].equals( "0" ) )                               //non zero numbers are considered valid candidates for modification
                    {
                        if( input[i].equals( input[i+1] ) )                     //if this element and the next element are the same
                        {
                            
                            System.out.print( ( Integer.parseInt( input[i] ) * 2 ) + " ");  //change this element to two times the original - actually just print it to save a loop to print later
                            input[i+1] = "0";                                   //set the next element to zero
                            z++;                                                //we set an element to zero so increase the zero count
                            i++;                                                //move the index since we already checked this one
                        }
                        else
                            System.out.print( input[i] + " ");                  //the element was not zero but not the same as the next element so just print it
                    }
                    else
                        z++;                                                    //the element was zero so add to the zero count
                }
                
                if( !input[n-1].equals( "0" ) )                                 //after modifying the entire array the last element is skipped, so if it isn't a zero
                    System.out.print( input[n-1] + " ");                        //print the element
                
                for( int i = 0; i < z; ++i )                                    //loop to print all the necessary zeros
                {
                    System.out.print( ( i == z-1 )? "0\n" : "0 ");
                }

                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}