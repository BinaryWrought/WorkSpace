/*
 * This is free to use as it was only made for practice.
 */

import java.util.Scanner;

/**
 * This is a solution to the <a href="http://practice.geeksforgeeks.org/problems/reversing-the-vowels/0" target="_blank">GeeksForGeeks School Reverse the Vowels.</a>
 * 
 * To summarize the challenge:
 * Given a string, print it with the vowels reversed.
 * 
 * I'm including this challenge because it is a good example of how to use a front and back index simultaneously.
 * It checks the front index for a vowel, if there isn't one then it increments,
 * then it checks the rear index for a vowel, if there isn't one then it decrements.
 * If both indices are at a vowel then they get swapped.
 * 
 * Note: This shorter solution executes consistently 0.01 seconds SLOWER than my other solution.
 * Which is confusing because this should handle both indices simultaneously and doesn't wait for a loop before swapping.
 * To make things more confusing, I found a "swap in one line" code using the ^ operator (bitwise XOR).
 * Using this technique this solution consistently executes another 0.01 seconds slower.
 * That line has been commented out but left for reference.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class ReverseVowelsRedux 
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
				char[] stringAsChar = scanner.next().toCharArray();
								
				int front = 0;																		//container for an index from the front of the array
				int back = stringAsChar.length - 1;													//container for an index from the back of the array
                
                boolean frontVowel = false, backVowel = false;
								
				//this loop is basically going to go from both ends of the array simultaneously
				while( front < back )																//so long as the front and back haven't crossed...
				{
                    if( !frontVowel )
                    {
                        if( !isVowel( stringAsChar[ front ] ) )                                     //check the front of the array for a vowel
                            front++;																//if it is not, increase the front index
                        else
                            frontVowel = true;
                    }
					
                    if( !backVowel )
                    {
                        if( !isVowel( stringAsChar[ back ] ) )                                      //check the back of the array for a vowel
                            back--;                                                                 //if it is not, decrease the back index
                        else
                            backVowel = true;
                    }

                    if( frontVowel && backVowel )
                    {
                        char temp = stringAsChar[ front ];											//container for a swap
						stringAsChar[ front ] = stringAsChar[ back ];								//set the front element to the back element
						stringAsChar[ back ] = temp;												//set the back element to the front element 
                        
                        //This line below is a swap in a single line use XOR ( that's the ^ operator )
                        //stringAsChar[ front ] = ( char ) ( stringAsChar[ front ] ^ stringAsChar[ back ] ^ ( stringAsChar[ back ] = stringAsChar[ front ] ) );
                        
                        frontVowel = false;
                        backVowel = false;
                        front++;																	//move the front index
						back--;																		//move the back index
                    }
				}
										
				System.out.println( stringAsChar );													//print the string with reversed vowels			
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch the inevitable exception thrown by the user
		{
			
		}
    }
	
	/**
	 * This method will check if a given char is a vowel (not including 'y' or 'Y')
	 * 
	 * @param c the char to check if it is a vowel
	 * @return a boolean indicating if the char is a vowel or not
	 */
	public static boolean isVowel( char c )
	{
		return c == 'a' || c == 'A' ||
			   c == 'e' || c == 'E' ||
			   c == 'i' || c == 'I' ||
			   c == 'o' || c == 'O' ||
			   c == 'u' || c == 'U';
	}
}