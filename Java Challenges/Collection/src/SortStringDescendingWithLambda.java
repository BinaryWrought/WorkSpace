/*
 * This is free to use as it was only made for practice.
 */



import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * This is a solution to the <a href="https://practice.geeksforgeeks.org/problems/sort-the-string-in-descending-order/0" target="_blank">GeeksForGeeks Basic Sort the string in descending order</a>
 * 
 * To summarize the challenge:
 * Given a string sort the characters in descending order.
 * 
 * I'm including this challenge because of the neat lambda expression that converts a char[] array to a Character[] array.
 * See explanation below.
 * 
 * For this solution I used a fancy "1 liner" I found on stack overflow. Its the line commented with "convert the string to an array of Character objects"
 * I want to explain this here so I can remember in the future why I did this and what that line does.
 * 
 * Here is why:
 * First, I did this because I needed the given String to be an array of characters so that I can sort it.
 * The String method toCharArray() will return an array of char.
 * Java has a built in sort method that sorts in ascending order.
 * The Collections interface can be used to sort in descending (reverse) order.
 * However, reverse will NOT work with primitives. char is a primitive.
 * This means that if I wanted to actually sort in reverse order using Collections I needed an array of Character not char.
 * So, I could have used .toCharArray() and made another loop to populate a Character[] array.
 * But I found that one liner on stack overflow that automatically converted the char array to a Character array.
 * It used a lambda expression which I'm still not very familiar with so I will next explain what it does (the rant above is all the why I did it this way.)
 * 
 * Here is what the lambda expression does:
 * First, it gets an IntStream of the characters in the string (that's the string.chars() method )
 * Second, it maps each char to a Character - which must be explicitly cast to char so Java will autobox to Character (that's the mapToObj() part )
 * To elaborate the second step more, inside the mapToObj method c is declared as the char object from the IntStream and it is being type cast to char with (char)c.
 * Third, the resulting array is given by calling toArray()
 * To elaborate on the argument of the toArray() method call:
 * The argument is a stream containing the elements of the array.
 * The double colon (::) operator calls a method by name, in this case it is producing a new array of the desired type and length (Character).
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class SortStringDescendingWithLambda 
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
                Character[] arr = scanner.nextLine().chars().mapToObj( c -> ( char )c ).toArray( Character[]::new );    //convert the string to an array of Character objects
                Arrays.sort( arr, Collections.reverseOrder() );                                     //sort the array in descending order
                for( Character c: arr )                                                             //for each loop to print the chars in the array
                    System.out.print( c );                                                          //print the char
                                
                System.out.println();                                                               //add a line between test cases
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{

		}
	}
}