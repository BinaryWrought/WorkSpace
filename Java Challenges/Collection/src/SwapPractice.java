/*
 * This is free to use as it was only made for practice.
 */
/**
 * This was made to show how to swap two objects in Java with a single method call.
 * The key to it is how to method is called in the first place.
 * I found this on stackoverflow.com.
 * A comment I felt was rather apt said:
 * "If this was for an interview, you'd be hired. If this was in a code review you'd be fired."
 * 
 * I'm including this just so I can refer to this method of swapping in Java.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 */
public class SwapPractice 
{	
    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) 
	{
		
		int temp1 = 5;
		int temp2 = 3;
		
        System.out.println( "Before swap: " );
        System.out.println("One: " + temp1 + " and Two: " + temp2 );
        
		//Must call swap like this to get it to work right
		temp1 = swap( temp2, temp2 = temp1 );
		
        System.out.println( "After swap: " );
		System.out.println("One: " + temp1 + " and Two: " + temp2 );

    }
	
	/**
	 * This method actually just returns the first parameter but can be used to sort of trick Java into making a swap.
	 * @param c1
	 * @param c2
	 * @return 
	 */
	public static int swap( int c1, int c2 )
	{
		return c1;
	}
		
}