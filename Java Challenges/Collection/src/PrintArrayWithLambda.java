
import java.util.Arrays;

/*
 * This is free to use as it was only made for practice.
 */

/**
 * This class is merely a reference to show how to print the contents of an array with a lambda expression.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class PrintArrayWithLambda 
{
    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) 
	{
		int[] arr = { 1, 3, 2, 5, 4 };
        Arrays.stream( arr ).forEach( num -> System.out.print( num + " " ) );
        System.out.println();
	}
}