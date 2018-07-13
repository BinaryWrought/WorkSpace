import java.util.*;

/**
 * This was one of the challenge questions on an MS OTS. They said I technically got it wrong. I think their requirements were technically wrong.
 * They did give me credit for successfully solving it based on my "incorrect" interpretation of the challenge question.
 * 
 * The point of this class is to show how I solved the problem. And how they said my solution was incorrect.
 * Then hopefully I can work towards the solution that they actually wanted.
 * 
 * To summarize the challenge:
 * Given a string, determine if the string contains a palindrome (its not necessary that the entire thing is a palindrome.)
 * For the purpose of this challenge a palindrome is at least 2 characters that are the same forward and backward.
 * 
 * @author jhazelle
 */
public class ContainsPalindrome 
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
            scanner.nextLine();                                                 //clear the line from t

            while( t > 0 )							//So long as there are more test cases
            {
                boolean containsPalindrome = false;                             //flag for palindrome checking
                String p = scanner.nextLine();                                  //get the string to test
                String q = new StringBuilder( p ).reverse().toString();         //get a copy of the input string but in reverse
                
                //System.out.println( q );                                      //print the reversed string (for debugging test cases)
                
                if( p.equals( q ) )                                             //trivial case - input string is a palindrome so return true
                    containsPalindrome = true;
                if( p.length() < 2 )                                            //trivial case - input is less than two characters so by definition it cannot contain a palindrome
                    containsPalindrome = false;
                
                int i = 0;                                                      //index for character checking  
                while( !containsPalindrome && i < p.length() - 1 )              //check all the character pairs for a palindrome
                {
                    String temp = Character.toString( p.charAt( i ) ) + Character.toString( p.charAt( i + 1 ) );    //create a temporary string from two successive characters
                    if( q.contains( temp ) )                                    //if the reversed string contains the temp string then the input string contained a palindrome
                       containsPalindrome = true;                               //set the flag true to stop the loop as a result was found
                    else
                        i++;                                                    //otherwise increment the index
                }                
                
                System.out.println( containsPalindrome? "Yes" : "No" );         //print the result
                t--;								//get next test case		
            }
        }
        catch( Exception e )							//catch an exception thrown by incorrect input
        {

        }
    }
}
