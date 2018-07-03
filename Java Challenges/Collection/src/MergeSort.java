/*
 * This is free to use as it was only made for practice.
 */



import java.util.Scanner;

/**
 * This is a solution to the <a href="http://practice.geeksforgeeks.org/problems/sort-string/0" target="_blank">GeeksForGeeks Basic Sort String</a>
 * 
 * To summarize the challenge:
 * Given a string of lower-case characters, sort from 'a' to 'z'.
 * I'm assuming I can't just use the Arrays.sort() method...
 * 
 * I'm including this challenge because it has an implementation of merge sort.
 * I could and should just use the java Collections sort API method instead though.
 * 
 * @author <a href="mailto:jhazelle@asu.edu">Justin Hazelle</a>
 * <a href="https://github.com/BinaryWrought" target="_blank">GitHub</a>
 */
public class MergeSort 
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
				String s = scanner.next();															//get the string to be sorted
				char[] arr = s.toCharArray();														//convert the string to a char array in order to sort it
				
				//This might be considered cheating
//				Arrays.sort( arr );																	//use the built in sort method with is optimized
//				System.out.println( arr );															//print the result

				sortString( arr, 0, arr.length-1 );													//sort the string
				System.out.println( arr );															//print the result
				
				t--;																				//get next test case		
			}
		}
		catch( Exception e )																		//catch an exception thrown by incorrect input
		{
			
		}
	}
	
	/**
	 * A merge sort implementation for a string.
	 * Merge sort uses recursion to sort by splitting the given array in half each time it is called.
	 * After the array has been split into single elements it compares two at a time and inserts 
	 * them into the original array at their appropriate spot.
	 * 
	 * @param arr the array to be sorted
	 * @param left the left index of the sort point
	 * @param right the right index of the sort point
	 */
	public static void sortString( char[] arr, int left, int right )
	{
		if( left < right )
		{
			int mid = ( left + right ) / 2;		//used to find the mid point of the array
			sortString( arr, left, mid );		//sort left half
			sortString( arr, mid+1, right );	//sort right half
			
			merge( arr, left, mid, right );		//merge the two sorted halves
		}
	}
	
	/**
	 * This method merges two arrays and sorts by element size.
	 * 
	 * @param arr the array that is being sorted
	 * @param left the left index of the sort point
	 * @param mid the mid index of the sort point
	 * @param right the right index of the sort point
	 */
	public static void merge( char[] arr, int left, int mid, int right )
	{
		int leftSize = mid - left + 1;				//find size of left array
		int rightSize = right - mid;				//find size of right array
		
		char[] leftArray = new char[ leftSize ];	//temp container for left array
		char[] rightArray = new char[ rightSize ];	//temp container for right array
		
		for( int i = 0; i < leftSize; ++i )			//copy data to left array
		{
			leftArray[ i ] = arr[ left + i ];
		}
		for( int i = 0; i < rightSize; ++i )		//copy data to right array
		{
			rightArray[ i ] = arr[ mid + 1 + i ];
		}
		
		int leftIndex = 0;							//initial index of left sub array
		int rightIndex = 0;							//initial index of right sub array
		int mergeIndex = left;						//initial index of merged array
		
		//this loop will compare the elements in the sub arrays and place them into the main array
		while( leftIndex < leftSize && rightIndex < rightSize )
		{
			if( leftArray[ leftIndex ] <= rightArray[ rightIndex ] )	//sorting in ascending order, so if the element of the left array at the left index is less than what is in the right array at the right index...
			{
				arr[ mergeIndex ] = leftArray[ leftIndex ];				//set the element at the insertion point
				leftIndex++;											//increment the left index as this was already set in the array
			}
			else														//this implies the element in the right array is less than the one in the left array so this goes next in the original array
			{
				arr[ mergeIndex ] = rightArray[ rightIndex ];			//set the element at the insertion point
				rightIndex++;											//increment the right index as this was already set in the array
			}
			mergeIndex++;
		}
		
		while( leftIndex < leftSize )									//copy remaining elements of left array into original array
		{
			arr[ mergeIndex ] = leftArray[ leftIndex ];
			leftIndex++;
			mergeIndex++;
		}
		
		while( rightIndex < rightSize )									//copy remaining elements of right array into original array
		{
			arr[ mergeIndex ] = rightArray[ rightIndex ];
			rightIndex++;
			mergeIndex++;
		}		
	}
}